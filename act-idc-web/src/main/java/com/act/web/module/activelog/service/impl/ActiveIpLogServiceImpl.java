package com.act.web.module.activelog.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.act.framework.util.PageResult;
import com.act.idc.model.TsQueryCmdLog;
import com.act.util.beanConvert.AnnotationParse;
import com.act.web.es.EsClientUtil;
import com.act.web.es.EsEntity;
import com.act.web.es.Hit;
import com.act.web.es.Hits;
import com.act.web.es.mapping.IpActivelogModelMapping;
import com.act.web.es.type.IpActivelogModel;
import com.act.web.module.activelog.service.ActiveIpLogService;
import com.act.web.module.activelog.vo.ActiveIpLogVo;
import com.act.web.module.sso.vo.SessionVo;
import com.fasterxml.jackson.core.type.TypeReference;
/**
 * 
 * 
 * <p>Title: ActiveDoaminLogServiceImpl.java
 * <p>Description:获取活跃域名日志——业务层实现
 * @author zhufj
 * @date 2018年2月5日 下午4:57:47
 */
@Service
@Transactional
public class ActiveIpLogServiceImpl implements ActiveIpLogService{
	@Autowired
	private EsClientUtil esEntityUtil;
	/**
	 * 
	  * <p>Title: findIPLogs
	  * <p>Description: 分页查询活跃Ip日志
	  * @param page
	  * @param activeDoaminLogVo
	  * @return
	  * @throws Exception 
	 */
	@Override
	public PageResult<ActiveIpLogVo> findIPLogs(SessionVo sessionoVo,PageResult<ActiveIpLogVo> page,
			ActiveIpLogVo activeIpLogVo) throws Exception {
		//1,获取机房列表
		String purService = "";
		//2,获取es查询的对象
		StringBuffer ip_activelog_sql = new StringBuffer("select * from ").append("ip_activelog");
		ip_activelog_sql.append(getWhereSql(activeIpLogVo));
		EsEntity esEntity = esEntityUtil.getEsEntity(activeIpLogVo.getPageIndex(), activeIpLogVo.getPageSize(), ip_activelog_sql.toString(),new TypeReference<EsEntity<Hit<List<Hits<IpActivelogModel>>>>>(){});
		//3,查询日志参数设置与保存
		Map<String, Object> map = getQueryParam(activeIpLogVo);
		saveTsQueryCmdLog(sessionoVo.getUserId(),"ip_activelog", map, 0);
		//4,生成分页对象
		return getPageList(activeIpLogVo.getPageIndex(),activeIpLogVo.getPageSize(),esEntity);
	}
	/**
	 * 
	 * <p>Title: saveTsQueryCmdLog
	 * <p>Description:保存日志参数
	 * <p>Modified History:  
	 * @author zhufj
	 * @date 2018年2月5日 下午7:38:41
	 * @param userid //用户名
	 * @param esType //表名
	 * @param map //参数map
	 * @param resultCode  结果编号
	 * @throws Exception
	 */
	private void saveTsQueryCmdLog(String userid,String esType, Map<String, Object> map,
			Integer resultCode) throws Exception {
		TsQueryCmdLog tsQueryCmdLog=new TsQueryCmdLog();
		tsQueryCmdLog.setUserName(userid);
		tsQueryCmdLog.setCmdType(esType);
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
		TsQueryCmdLog.getDao().insert(tsQueryCmdLog);
	}
	/**
	 * 
	 * <p>Title: getQueryParam
	 * <p>Description:查询日志参数设置
	 * @author zhufj
	 * @date 2018年2月5日 下午6:49:58
	 * @param activeIpLogVo 查询对象
	 * @return
	 */
	private Map<String,Object> getQueryParam(ActiveIpLogVo activeIpLogVo){
		Map<String, Object> map = new HashMap<String, Object>();
		if (!StringUtils.isEmpty(activeIpLogVo.getServiceCodeQuery())) {
			map.put("机房ID", activeIpLogVo.getServiceCodeQuery());
		} else {
			map.put("机房ID", "全部");
		}

		if (!StringUtils.isEmpty(activeIpLogVo.getIpQuery())) {
			map.put("网站IP", activeIpLogVo.getIpQuery());
		}

		if (!StringUtils.isEmpty(activeIpLogVo.getPortQuery())) {
			map.put("应用端口", activeIpLogVo.getPortQuery());
		} else 

			if (!StringUtils.isEmpty(activeIpLogVo.getProtocolQuery())) {
				map.put("传输层协议类型", activeIpLogVo.getProtocolQuery());
			} else {
				map.put("传输层协议类型", "全部");
			}

		if (activeIpLogVo.getStartTimeQuery()!=null) {
			map.put("开始日期", activeIpLogVo.getStartTimeQuery());
		} 			
		if (activeIpLogVo.getEndTimeQuery()!=null) {
			map.put("结束日期", activeIpLogVo.getEndTimeQuery());
		}

		if (activeIpLogVo.getFirstStartTimeQuery()!=null) {
			map.put("首次采集时间", activeIpLogVo.getFirstStartTimeQuery());
		}			
		if (activeIpLogVo.getFirstEndTimeQuery()!=null) {
			map.put("首次采集结束时间", activeIpLogVo.getFirstEndTimeQuery());
		} 

		if (activeIpLogVo.getLastStartTimeQuery()!=null) {
			map.put("最后活跃时间开始", activeIpLogVo.getLastStartTimeQuery());
		} 
		if (activeIpLogVo.getLastEndTimeQuery()!=null) {
			map.put("最后活跃结束时间", activeIpLogVo.getLastEndTimeQuery());
		}
		return map;
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
		List<ActiveIpLogVo> activeIpLogVos = new ArrayList<>();
		//获取的数据为空
		if(esEntity==null){
			return new PageResult(activeIpLogVos,pageIndex,pageSize,0,0);
		} 
		List<Hits> hits =(List<Hits>)((Hit)esEntity.getHits()).getHits();
		long total = ((Hit)esEntity.getHits()).getTotal();//总数
		int totalPageCount = (int)(total%pageSize==0?total/pageSize:total/pageSize+1);
		if(hits!=null&&!hits.isEmpty()){
			int size = hits.size();
			List<Object> isstopLst = new ArrayList<>();
			for(int i=0;i<size;i++){
				Hits hit = hits.get(i);
				IpActivelogModel ipModel = (IpActivelogModel)hit.get_source();
				//解析成请求对象
				activeIpLogVos.add((ActiveIpLogVo)AnnotationParse.MappingParse(IpActivelogModelMapping.class, "copyProperties", IpActivelogModel.class, ActiveIpLogVo.class, ipModel));
			}
		}
		//返回分页对象
		return new PageResult(activeIpLogVos,pageIndex,pageSize,totalPageCount,total);
	}
	/**
	 * 
	 * <p>Title: getWhereSql
	 * <p>Description:获取查询条件
	 * @author zhufj
	 * @date 2018年2月5日 下午6:04:52
	 * @param activeIpLogVo 活跃ip日志vo
	 * @return
	 */
	private String getWhereSql(ActiveIpLogVo activeIpLogVo){
		StringBuffer whereSql = new StringBuffer("where 1=1 ");
		if (!StringUtils.isEmpty(activeIpLogVo.getIpQuery())) {// ip查询
			whereSql.append(" and ip like '%").append(activeIpLogVo.getIpQuery()).append("%'");
		}
		if (!StringUtils.isEmpty(activeIpLogVo.getServiceCodeQuery())) {// 机房查询
			whereSql.append(" and service_code =").append(activeIpLogVo.getServiceCodeQuery());
		}

		if (!StringUtils.isEmpty(activeIpLogVo.getPortQuery())) {//端口
			whereSql.append(" and port =").append(activeIpLogVo.getPortQuery());
		}
		
		if (!StringUtils.isEmpty(activeIpLogVo.getProtocolQuery())) {//传输层协议
			whereSql.append(" and protocol =").append(activeIpLogVo.getProtocolQuery());
		}

		/* 首次查询默认查询当天时间
		 * 当用户输入时间后按用户输入时间查询
		 */
		if (activeIpLogVo.getStartTimeQuery()!=null) {
			whereSql.append(" and firsttime >=").append(activeIpLogVo.getStartTimeQuery());
		} 
		if (activeIpLogVo.getEndTimeQuery()!=null) {
			whereSql.append(" and lasttime <=").append(activeIpLogVo.getEndTimeQuery());
		} 
		if (activeIpLogVo.getFirstStartTimeQuery()!=null) {
			whereSql.append(" and firsttime >=").append(activeIpLogVo.getFirstStartTimeQuery());
		}
		if (activeIpLogVo.getFirstEndTimeQuery()!=null) {
			whereSql.append(" and firsttime <=").append(activeIpLogVo.getFirstEndTimeQuery());
		}
		if (activeIpLogVo.getLastStartTimeQuery()!=null) {
			whereSql.append(" and lasttime >=").append(activeIpLogVo.getLastStartTimeQuery());
		}
		
		if (activeIpLogVo.getLastEndTimeQuery()!=null) {
			whereSql.append(" and lasttime <=").append(activeIpLogVo.getLastEndTimeQuery());
		}
		whereSql.append(" order by lasttime desc,_id desc");
		return whereSql.toString();
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
