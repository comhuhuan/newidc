package com.act.web.module.securitylog.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.act.idc.model.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.act.framework.util.DbUtil;
import com.act.framework.util.PageResult;
import com.act.idc.model.TabSysConfig;
import com.act.mapper.entity.Example;
import com.act.util.beanConvert.AnnotationParse;
import com.act.web.constant.CommonContant;
import com.act.web.es.EsClientUtil;
import com.act.web.es.EsEntity;
import com.act.web.es.Hit;
import com.act.web.es.Hits;
import com.act.web.es.mapping.FilterLogModelMapping;
import com.act.web.es.mapping.MonitorLogModelMapping;
import com.act.web.es.type.AlarmIsmsModel;
import com.act.web.es.type.BlockIsmsModel;
import com.act.web.module.securitylog.service.FilterLogService;
import com.act.web.module.securitylog.vo.FilterLogVo;
import com.act.web.module.securitylog.vo.MonitorLogVo;
import com.act.web.module.sso.vo.SessionVo;
import com.fasterxml.jackson.core.type.TypeReference;
@Service
@Transactional
public class FilterLogServiceImpl implements FilterLogService{
	@Autowired
	private EsClientUtil esEntityUtil;
	@Override
	public PageResult<FilterLogVo> findList(SessionVo sessionVo,PageResult<FilterLogVo> page,FilterLogVo filterLogVo)
			throws Exception {
		filterLogVo.setAccountId(sessionVo.getUserId());
		TabSysConfig tabSysconfig = TabSysConfig.getDao().selectByPrimaryKey("ipv4ToIpv6Set");
		filterLogVo.setIpv4ToIpv6Set(tabSysconfig.getConfigval());
		//获取选取的时间段并获取到时间段集合
		List<String> dateList = getDateList(filterLogVo.getStartTimeQuery(), filterLogVo.getEndTimeQuery());
		//调用查询指令保存日志公共方法
		//获取到数据库表名
		List<String> tableList = hasAlarmData(dateList,"block_isms");
		if (tableList.size() > 1) {
			Collections.sort(dateList);
			Collections.reverse(dateList);
		}
		//设置选中日期
		if(!filterLogVo.getHasSelectTime()){// 选中的日期
			if(dateList.size() > 0){
				filterLogVo.setSelectTimeQuery(dateList.get(0));
			}else{
				filterLogVo.setSelectTimeQuery(filterLogVo.getEndTimeQuery().replace("-", "_"));
			}
		}
		if (tableList == null || tableList.isEmpty()) {
            return page;
        }
		//获取机房服务  TODO
		String purService = "";
		//获取查询sql
		String sql_query = getFindSql(page.getPageIndex(),page.getPageSize(),filterLogVo,filterLogVo.getSelectTimeQuery(),purService);
		//采用es服务进行搜索并获取esEntity
		EsEntity esEntity =esEntityUtil.getEsEntity(page.getPageIndex(),page.getPageSize(),sql_query,new TypeReference<EsEntity<Hit<List<Hits<BlockIsmsModel>>>>>(){});
		//分页对象返回
		return getPageList(page.getPageIndex(),page.getPageSize(),esEntity);
	}
	/**
	 * 
	 * <p>Title: getPageList
	 * <p>Description:
	 * @author zhufj
	 * @date 2018年2月5日 上午9:19:33
	 * @param pageIndex 当前页
	 * @param pageSize 页大小
	 * @param esEntity es对象
	 * @return
	 */
	private PageResult getPageList(int pageIndex,int pageSize,EsEntity esEntity){
		List<MonitorLogVo> monitorLogVos = new ArrayList<>();
		//获取的数据为空
		if(esEntity==null){
			return new PageResult(monitorLogVos,pageIndex,pageSize,0,0);
		} 
		List<Hits> hits =(List<Hits>)((Hit)esEntity.getHits()).getHits();
		long total = ((Hit)esEntity.getHits()).getTotal();//总数
		int totalPageCount = (int)(total%pageSize==0?total/pageSize:total/pageSize+1);
		if(hits!=null&&!hits.isEmpty()){
			int size = hits.size();
			List<Object> isstopLst = new ArrayList<>();
			for(int i=0;i<size;i++){
				Hits hit = hits.get(i);
				AlarmIsmsModel alarmIsmsModel = (AlarmIsmsModel)hit.get_source();
				//将查询出来的数据alarmIsmsModel进行加工
				isstopLst.add(alarmIsmsModel.getUrl());
			}
			//获取到策略编号表中的url封堵状态内容并转换为 MonitorLogVo
			monitorLogVos = getMonitorLogVos(isstopLst,hits);
			//添加对应的属性 TODO
			
		}
		//返回分页对象
		return new PageResult(monitorLogVos,pageIndex,pageSize,totalPageCount,total);
	}
	/**
	 * 
	 * <p>Title: getMonitorLogVos
	 * <p>Description:获取到策略编号表中的url封堵状态内容并转换为 MonitorLogVo
	 * @author zhufj
	 * @date 2018年2月5日 上午9:07:34
	 * @param isstopLst 封堵列表
	 * @param hits es返回的数据
	 * @return
	 */
	private List<MonitorLogVo> getMonitorLogVos(List<Object> isstopLst,List<Hits> hits){
		//去重
		Set<Object> set = new HashSet<>();
		set.addAll(isstopLst);
		List<Object> schedualIds = new ArrayList<>();
		schedualIds.addAll(set);
		//查询策略编号表
		Example example = new Example(ResDomainIpSchemeid.class);
		example.createCriteria().andIn("content",schedualIds);
		List<ResDomainIpSchemeid> isstops =  ResDomainIpSchemeid.getDao().selectByExample(example);
		List<MonitorLogVo> monitorLogVos =  new ArrayList<>();
		if(!CollectionUtils.isEmpty(isstops)){
			for(int i = 0;i<hits.size();i++){
				for(int j=0;j<isstops.size();j++){
					AlarmIsmsModel alarmIsmsModel = (AlarmIsmsModel)hits.get(i).get_source();
					//解析成请求对象
					MonitorLogVo monitorLogVo = (MonitorLogVo)AnnotationParse.MappingParse(MonitorLogModelMapping.class, "copyProperties", AlarmIsmsModel.class, MonitorLogVo.class, alarmIsmsModel);
					//添加封堵状态字段
					if(alarmIsmsModel.getUrl().equals(isstops.get(j).getContent())){
						monitorLogVo.setIsstop(isstops.get(j).getIsstop());
						monitorLogVos.add(monitorLogVo);
						break;
					}
				}
			}
		}
		return monitorLogVos;
	}
	/**
	 * 
	 * <p>Title: getFindSql
	 * <p>Description:获取查询es的sql
	 * @author zhufj
	 * @date 2018年2月2日 下午5:38:57
	 * @param pageIndex 当前页
	 * @param pageSize 页大小
	 * @param monitorLogVo 监控日志vo
	 * @param selectDate 所选时间
	 * @return
	 */
	private String getFindSql(int pageIndex,int pageSize, FilterLogVo vo,String selectDate,String purService){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * from block_isms").append("_").append(selectDate).append("where 1=1");
		 //当前时间条件
		if(StringUtils.isEmpty(vo.getTimerangeValQuery())&& vo.getTimerangeValQuery().length()==17){
			String[] timerange = vo.getTimerangeValQuery().split("-");
			String selectTime = vo.getSelectTimeQuery().replace("_", "-");
			sql.append(" AND t1.cur_time >= '").append(selectTime).append(" ").append(timerange[0]).append("' ");
			sql.append(" AND t1.cur_time <= '").append(selectTime).append(" ").append(timerange[1]).append("' ");
		}
		//网址条件
		if(StringUtils.isEmpty(vo.getUrlQuery())){
			String url = vo.getUrlQuery().trim();
        	if (url.startsWith("http://")) {
        		url = url.substring("http://".length());
        	}
        	sql.append(" AND (`url` like CONVERT('%").append(url).append("%' USING UTF8)");
        	sql.append(" OR `url` like CONVERT('%").append(url).append("%' USING GBK)");
        	sql.append(" OR `url` like CONVERT('%").append(url).append("%' USING BIG5))");
		}
		//目的ip条件
		if(StringUtils.isEmpty(vo.getMidQuery())){
			if("Y".equals(vo.getIpv4ToIpv6Set())){
				sql.append(" AND (in_ip like '%").append(vo.getMidQuery().trim()).append("%'");//mid
				Example example = new Example(Ipv4Ipv6Info.class);
				example.createCriteria().andLike("ipv6", vo.getMidQuery());
				List<Ipv4Ipv6Info> list = Ipv4Ipv6Info.getDao().selectByExample(example);
				if(list != null && list.size() > 0){
        			StringBuffer outIpSf = new StringBuffer();
        			for (Ipv4Ipv6Info ipv4Ipv6Info : list) {
        				outIpSf.append(",'").append(ipv4Ipv6Info.getIpv4()).append("'");
					}
        			sql.append(" OR in_ip IN (").append(outIpSf.substring(1)).append(") ");
        		}
				sql.append(" )");
			}else{
				sql.append(" AND in_ip like '%").append(vo.getMidQuery().trim()).append("%'");//mid
			}
		}
		//源ip条件
		if(StringUtils.isEmpty(vo.getOutIpQuery())){
			if("Y".equals(vo.getIpv4ToIpv6Set())){
				sql.append(" AND (t1.out_ip like '%").append(vo.getOutIpQuery().trim()).append("%'");		
				Example example = new Example(Ipv4Ipv6Info.class);
				example.createCriteria().andLike("ipv6", vo.getMidQuery());
				List<Ipv4Ipv6Info> list = Ipv4Ipv6Info.getDao().selectByExample(example);
				if(list != null && list.size() > 0){
        			StringBuffer outIpSf = new StringBuffer();
        			for (Ipv4Ipv6Info ipv4Ipv6Info : list) {
        				outIpSf.append(",'").append(ipv4Ipv6Info.getIpv4()).append("'");
					}
        			sql.append(" OR out_ip IN (").append(outIpSf.substring(1)).append(") ");
        		}
				sql.append(" )");
			}else{
				sql.append(" AND out_ip like '%").append(vo.getOutIpQuery()).append("%' ");//关联的out_ip
			}
		}
		//服务编号条件
		if(StringUtils.isEmpty(vo.getServiceCodeQuery())){
			sql.append(" AND service_code='").append(vo.getServiceCodeQuery().trim()).append("' ");//关联的servicecode
		}
		//关键字条件
		if(StringUtils.isEmpty(vo.getKeyWordQuery())){
			sql.append(" AND (scheme_id IN ('' ");	
			String ctype = "1";
			StringBuffer schemeIdSql = new StringBuffer("SELECT DISTINCT rule.scheme_id FROM ismsc_idccommand c, ismsc_idccommandrule rule WHERE c.commandID = rule.commandID")
				.append(" AND ( IF (rule.valueEnd, CONCAT_WS( '-', rule.valueStart, rule.valueEnd ), rule.valueStart )) LIKE '%")
				.append(vo.getKeyWordQuery().trim()).append("%' AND c.ctype =").append(ctype);
			List<String> list = DbUtil.queryForObjectList(schemeIdSql.toString(),String.class);
			if(list != null && list.size() > 0){
				for (int i = 0; i < list.size(); i++) {
					sql.append(",'").append(list.get(i)).append("'");
				}
			}
			sql.append(" )");
			String[] keywords = vo.getKeyWordQuery().trim().split(",");
			if(keywords.length > 1){
				sql.append(" OR (1=1 ");
				for (String keyword : keywords) {
					schemeIdSql = new StringBuffer("SELECT DISTINCT rule.scheme_id FROM ismsc_idccommand c, ismsc_idccommandrule rule ")
						.append(" WHERE c.commandID = rule.commandID AND c.ctype =").append(ctype).append(" AND c.grouptype = 1 ")
						.append(" AND IF ( rule.valueEnd, CONCAT_WS( '-', rule.valueStart, rule.valueEnd ), rule.valueStart ) LIKE '%")
						.append(keyword).append("%' ");
					List<String> list_result = DbUtil.queryForObjectList(schemeIdSql.toString(),String.class);
					if(list_result != null && list_result.size() > 0){
						sql.append(" AND scheme_id IN ('' ");	
						for (int i = 0; i < list.size(); i++) {
							sql.append(",'").append(list.get(i)).append("'");
						}
						sql.append(" ) ");
					}
				}
				sql.append(" ) ");
			}
			sql.append(" ) ");
		}
		//主机条件
		if(StringUtils.isEmpty(vo.getHostQuery())){
			if("Y".equals(vo.getIpv4ToIpv6Set())){
				sql.append(" AND (host like '%").append(vo.getHostQuery().trim()).append("%'");		
				StringBuffer sb = new StringBuffer("SELECT DISTINCT INET_NTOA(ntohl(`ip`)) ip FROM dns_ip_domain_info WHERE domain LIKE '%")
					.append(vo.getHostQuery().trim()).append("%' UNION ALL SELECT DISTINCT INET_NTOA(ntohl(`ipv4`)) ip FROM ipv4_ipv6_info WHERE ipv6 LIKE '%").append(vo.getHostQuery().trim()).append("%'");
				List<String> list = DbUtil.queryForObjectList(sb.toString(),String.class);
				if(list != null && list.size() > 0){
					StringBuffer outIpSf = new StringBuffer();
					for (String string : list) {
						outIpSf.append(",'").append(string).append("'");
					}
					sql.append(" OR in_ip IN (").append(outIpSf.substring(1)).append(") ");
				}
				sql.append(" )");
			}else{
				sql.append(" AND host like '%").append(vo.getHostQuery().trim()).append("%' ");
			}
		}
		//策略条件
		if(StringUtils.isEmpty(vo.getRuleIdQuery())){
			sql.append(" AND scheme_id = '").append(vo.getRuleIdQuery()).append("' ");//关联的url
		}
		//获取机房编号
		sql.append(" AND scheme_id IN (0 ");	
		String ctype = "1";
		StringBuffer sb =  new StringBuffer("SELECT DISTINCT rule.scheme_id FROM ismsc_idccommand c, ismsc_idccommandrule rule WHERE c.commandID = rule.commandID AND visible = 1 ")
		.append(" AND c.ctype=").append(ctype);
		List<String> list = DbUtil.queryForObjectList(sb.toString(),String.class);
		if(list != null && list.size() > 0){
			for (int i = 0; i < list.size(); i++) {
				sql.append(",").append(list.get(i));
			}
		}
		sql.append(" )");
		sql.append(" AND service_code IN(").append(purService).append(")");
		//封堵情况条件
		if (StringUtils.isEmpty(vo.getIsStopQuery())) {
			 	String isstop=vo.getIsStopQuery();
			 	if(isstop.equals("1")){//已经封堵
			 		sql.append(" AND  isstop = '1' ");
			 	}else{//未封堵
			 		sql.append(" AND  (isstop != '1' or isstop is null) ");
			 	}
		}
		return sql.toString();
	}
	/**
	 * 
	 * <p>Title: getDateList
	 * <p>Description:获取日期时间段
	 * @author zhufj
	 * @date 2018年2月2日 下午3:44:11
	 * @param startTime 开始时间
	 * @param endTime 截至时间
	 * @return
	 * @throws ParseException
	 */
	private List<String> getDateList(String startTime,String endTime) throws ParseException{
		List<String> dateList = new ArrayList<String>();
		// 假如用户没有输入结束日期
		if(!StringUtils.isEmpty(startTime)||!StringUtils.isEmpty(endTime)){
			if (null == endTime || "".equals(endTime)) {
				endTime = startTime;
			}
			Calendar startCalendar = Calendar.getInstance();
			Calendar endCalendar = Calendar.getInstance();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd");
			startCalendar.setTime(sdf.parse(sdf.format(startTime)));
			endCalendar.setTime(sdf.parse(sdf.format(endTime)));
			while (true) {
				if (startCalendar.getTimeInMillis() <= endCalendar.getTimeInMillis()) {
					dateList.add(sdf.format(endCalendar.getTime()));// 将该日期添加到数组
					endCalendar.add(Calendar.DAY_OF_MONTH, -1);// 让日期自加
				} else {
					break;
				}
			}
		}
		return dateList;
	}
	/**
	 * 
	 * <p>Title: hasAlarmData
	 * <p>Description:是否存在监控数据表
	 * @author zhufj
	 * @date 2018年2月5日 上午9:17:33
	 * @param dateList 日期列表
	 * @param tableName 表名前缀
	 * @return
	 */
	public List<String> hasAlarmData(List<String> dateList, String tableName) {
		List<String> result = new ArrayList<String>();
		//获取存在的监控日志流水表
		if(!CollectionUtils.isEmpty(dateList)){
			String[] dateArr = (String[])dateList.toArray();
			//获取存在的表
			StringBuffer whereStr = new StringBuffer();
			for(int i=0;i<dateList.size();i++){
				whereStr.append(tableName + "_" + dateList.get(i)).append(",");
			}
			StringBuffer monitor_sql = new StringBuffer("select table_name from information_schema.tables where TABLE_NAME IN ('"
					+ whereStr.toString().substring(0, whereStr.toString().length()-1)
					+ "' and table_schema='"
					+ CommonContant.TABLE_SCHEMA + "'");
			result = DbUtil.queryForObjectList(monitor_sql.toString(), String.class);
		}
		return result;
	}
	/**
	 * 
	 * <p>Title: insertSearchParameter
	 * <p>Description:插入查询参数
	 * @author zhufj
	 * @date 2018年2月2日 下午2:25:48
	 * @param userId //用户id
	 * @param esType
	 * @param vo
	 * @param resultCode
	 * @throws Exception
	 */
	public void insertSearchParameter(String userId,String esType,MonitorLogVo vo,int resultCode) throws Exception{
		Map<String,Object> searchParameters=new HashMap<String, Object>();
		if (StringUtils.isNotEmpty(vo.getUrlQuery()) ) {
			searchParameters.put("url", vo.getUrlQuery());
		}
		if (StringUtils.isNotEmpty(vo.getMidQuery())) {
			searchParameters.put("目的ip", vo.getMidQuery());
		}
		if (StringUtils.isNotEmpty(vo.getOutIpQuery()) ) {
			searchParameters.put("源IP", vo.getOutIpQuery());
		}
		if (StringUtils.isNotEmpty(vo.getServiceCodeQuery()) ) {
			searchParameters.put("机房ID", vo.getServiceCodeQuery());
		}else{
			searchParameters.put("机房ID", "全部");
		}
		if(StringUtils.isNotEmpty(vo.getKeyWordQuery())){
			searchParameters.put("报警信息", vo.getKeyWordQuery());
		}

		if (StringUtils.isNotEmpty(vo.getHostQuery()) ) {
			searchParameters.put("域名", vo.getHostQuery());
		}
		if( StringUtils.isNotEmpty(vo.getStartTimeQuery().toString()) && StringUtils.isNotEmpty(vo.getEndTimeQuery().toString())){
			searchParameters.put("开始时间", vo.getStartTimeQuery());
			searchParameters.put("结束时间", vo.getEndTimeQuery());
		}
		saveTsQueryCmdLog(userId,esType, searchParameters, 0);
	}
	/**
	 * 
	 * <p>Title: saveTsQueryCmdLog
	 * <p>Description: 保存TsQueryCmdLog
	 * @author zhufj
	 * @date 2018年2月2日 下午2:21:02
	 * @param userId 用户ID
	 * @param esType//枚举类型-检测日志
	 * @param map //查询参数Map
	 * @param resultCode 返回码
	 * @throws Exception 
	 */
	public void saveTsQueryCmdLog(String userId,String esType, Map<String, Object> map,
			Integer resultCode) throws Exception {
		TsQueryCmdLog tsQueryCmdLog=new TsQueryCmdLog();
		tsQueryCmdLog.setUserName(userId);
		tsQueryCmdLog.setCmdType(esType);
		//生成cmdContent
		StringBuffer sb=new StringBuffer();
		for (String key : map.keySet()) {
			String value=null;
			if(map.get(key)!=null && map.get(key) instanceof Date){
				SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				value=format.format(map.get(key));
			}else if(map.get(key)!=null){
				value=map.get(key).toString();
			}
			if(value!=null){
				sb.append(key).append("=").append(value).append(";");
			}
		}
		tsQueryCmdLog.setCmdContent(sb.toString());
		tsQueryCmdLog.setResultCode(resultCode);
		tsQueryCmdLog.setQueryTime(new Timestamp(new Date().getTime()));
		//添加进ts_query_cmd_log表
		TsQueryCmdLog.getDao().insert(tsQueryCmdLog);
	}
	/**
	 * 
	  * <p>Title: urlContentViews
	  * <p>Description: 快照浏览
	  * @param filterLogVo 过滤日志请求对象
	  * @return
	  * @throws Exception 
	 */
	@Override
	public Map<String,Object> urlContentViews(FilterLogVo filterLogVo) throws Exception {
		Map<String,Object> map = new HashMap<>();
		if(StringUtils.isEmpty(filterLogVo.getEncodedQuery())){
			filterLogVo.setEncodedQuery("utf-8");
		}
		//查询快照sql
		StringBuffer urlContent_sql = new StringBuffer("SELECT content FROM  `"+filterLogVo.getTableNameQuery()+"`");
		urlContent_sql.append("key=").append(filterLogVo.getHostQuery());
		//es搜索引擎
		EsEntity esEntity = esEntityUtil.getEsEntity(urlContent_sql.toString(),new TypeReference<EsEntity<Hit<List<Hits<BlockIsmsModel>>>>>(){});
		List<Hits> hits =(List<Hits>)((Hit)esEntity.getHits()).getHits();
		//获取结果
		String content = "";
		if(!CollectionUtils.isEmpty(hits)){
			for(int i=0;i<hits.size();i++){
				BlockIsmsModel blockIsmsModel = (BlockIsmsModel)hits.get(i).get_source();
				content += blockIsmsModel.getContent();
			}
		}
		if(StringUtils.isEmpty(content)){
			map.put("encoded", filterLogVo.getEncodedQuery());
			map.put("info", "暂无匹配快照文件");
			return map;
		}
		String info=new String(content.getBytes(),filterLogVo.getEncodedQuery());
		//获取关键字根据策略
		StringBuffer keyWord_sql = new StringBuffer("SELECT DISTINCT GROUP_CONCAT(valueStart) FROM ismsc_idccommandrule WHERE scheme_id= ").append(filterLogVo.getRuleIdentifierQuery()).append(" AND subtype =3 GROUP BY scheme_id");
		List<String> keyList = DbUtil.queryForObjectList(keyWord_sql.toString(), String.class);
		
		List<String> inputs = new ArrayList<String>();
		StringBuffer resStr = new StringBuffer("");
		if(keyList != null && keyList.size() > 0){
			String[] keywords=keyList.get(0).toString().split(",");
			for (String keyword : keywords) {
				if(!inputs.contains(keyword)){
					inputs.add(keyword);
				}
			}
			addChild(info,inputs,resStr);
		}else{
			resStr.append(info);
		}
		map.put("encoded", filterLogVo.getEncodedQuery());
		map.put("info", resStr.toString());
		return map;
	}
	/**
	 * 
	 * <p>Title: addChild
	 * <p>Description:多关键字查询表红,避免后面的关键字成为特殊的HTML语言代码
	 * @author zhufj
	 * @date 2018年2月5日 上午11:58:00
	 * @param str 检索结果
	 * @param inputs 关键字集合
	 * @param resStr 表红后的结果
	 */
	public static void addChild(String str, List<String> inputs,
			StringBuffer resStr) {
		int index = str.length();// 用来做为标识,判断关键字的下标
		String next = "";// 保存str中最先找到的关键字
		for (int i = inputs.size() - 1; i >= 0; i--) {
			String theNext = inputs.get(i);
			int theIndex = str.indexOf(theNext);
			if (theIndex == -1) {// 过滤掉无效关键字
				inputs.remove(i);
			} else if (theIndex < index) {
				index = theIndex;// 替换下标
				next = theNext;
			}
		}

		// 如果条件成立,表示串中已经没有可以被替换的关键字,否则递归处理
		if (index == str.length()) {
			resStr.append(str);
		} else {
			resStr.append(str.substring(0, index));
			resStr.append("<font color='#FF000'>"
					+ str.substring(index, index + next.length()) + "</font>");
			String str1 = str.substring(index + next.length(), str.length());
			addChild(str1, inputs, resStr);// 剩余的字符串继续替换
		}
	}
	/**
	 * 
	  * <p>Title: findBySchemeId
	  * <p>Description:通过策略id获取过滤日志对象
	  * @param filterLogVo 请求分页对象
	  * @return
	  * @throws Exception 
	 */
	@Override
	public PageResult<FilterLogVo> findBySchemeId(PageResult<FilterLogVo> page,FilterLogVo filterLogVo) throws Exception {
		//获取用户对应的机房列表
		String purService = "";
		//根据策略id获取监控日志
		Example example = new Example(IsmsxIsstopsign.class);
		example.createCriteria().andEqualTo("service_code", filterLogVo.getServiceCodeQuery());
		example.createCriteria().andEqualTo("scheme_id", filterLogVo.getSchemeIdQuery());
		RowBounds rowBound = new RowBounds(filterLogVo.getPageIndex(),filterLogVo.getPageSize());
		List<IsmsxIsstopsign> ismsxIsstopsigns = IsmsxIsstopsign.getDao().selectByExampleAndRowBounds(example, rowBound);
		List<FilterLogVo> filterLogVos = new ArrayList<>();
		//根据机房编号获取到机房名称
		TabServiceInformation taInformation = TabServiceInformation.getDao().selectByPrimaryKey(filterLogVo.getServiceCodeQuery());
		//内容转换
		if(!CollectionUtils.isEmpty(ismsxIsstopsigns)){
			for(int i=0;i<ismsxIsstopsigns.size();i++){
				FilterLogVo fLogVo = (FilterLogVo)AnnotationParse.MappingParse(FilterLogModelMapping.class, "copyProperties", IsmsxIsstopsign.class, FilterLogVo.class, ismsxIsstopsigns.get(i));
				fLogVo.setServiceName(taInformation.getServiceName());
				filterLogVos.add(fLogVo);
			}
		}
		//生成分页对象
		long total = IsmsxIsstopsign.getDao().selectCountByExample(example);
		int totalPageCount = (int)(total%filterLogVo.getPageSize()==0?total/filterLogVo.getPageSize():total/filterLogVo.getPageSize()+1);
		page.setPageIndex(filterLogVo.getPageIndex());
		page.setPageSize(filterLogVo.getPageSize());
		page.setTotal(total);
		page.setTotalPageCount(totalPageCount);
		return page;
	}
	/**
	 * 
	  * <p>Title: getServiceCode
	  * <p>Description:获取机房列表
	  * @return
	  * @throws Exception 
	 */
	@Override
	public Map<String, String> getServiceCode() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
