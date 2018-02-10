package com.act.web.module.securitylog.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.act.framework.util.DbUtil;
import com.act.framework.util.PageResult;
import com.act.idc.entity.TabInterfaceConfigEntity;
import com.act.idc.model.IsmscIdcCommand;
import com.act.idc.model.IsmscIdcCommandRule;
import com.act.idc.model.IsmsxIsstopsign;
import com.act.idc.model.ResDomainIpSchemeid;
import com.act.idc.model.TabInterfaceConfig;
import com.act.mapper.entity.Example;
import com.act.util.beanConvert.AnnotationParse;
import com.act.web.es.EsClientUtil;
import com.act.web.es.EsEntity;
import com.act.web.es.Hit;
import com.act.web.es.Hits;
import com.act.web.es.mapping.IsmsmHousemonitorModelMapping;
import com.act.web.es.mapping.IsmsxIsstopsignModelMapping;
import com.act.web.es.type.IsmsmHousemonitorModel;
import com.act.web.module.securitylog.model.IsmsxIsstopsignModel;
import com.act.web.module.securitylog.service.BaseDataMonitorService;
import com.act.web.module.securitylog.vo.BaseDataMonitorVo;
import com.act.web.module.securitylog.vo.IsmsxIsstopsignVo;
import com.act.web.module.sso.vo.SessionVo;
import com.fasterxml.jackson.core.type.TypeReference;
/**
 * 
 * @Description 基础数据监测-业务层实现
 * @author zhufj
 * @date 2018年1月27日 上午11:57:11
 *
 */
@Service
@Transactional
public class BaseDataMonitorServiceImpl implements BaseDataMonitorService{
	@Autowired
	private EsClientUtil esEntityUtil;
	@Override
	public PageResult<BaseDataMonitorVo> findList(PageResult<BaseDataMonitorVo> page, BaseDataMonitorVo baseDataMonitorVo) throws Exception{
		//获取查询sql
		String sql_query = getFindSql(page.getPageIndex(),page.getPageSize(),baseDataMonitorVo);
		//采用es服务进行搜索
		EsEntity esEntity =esEntityUtil.getEsEntity(page.getPageIndex(),page.getPageSize(),sql_query,new TypeReference<EsEntity<Hit<List<Hits<IsmsmHousemonitorModel>>>>>(){});
		//返回结果分页对象
		return getPageList(page.getPageIndex(),page.getPageSize(),esEntity);
	}

	@Override
	public Map<String, String> getServiceCode() throws Exception{
		
		return null;
	}
	/**
	 * 
	 * <p>Title: getFindSql
	 * <p>Description:获取查询es的sql
	 * @author zhufj
	 * @date 2018年2月2日 下午5:35:46
	 * @param pageIndex 当前页
	 * @param pageSize 页大小
	 * @param baseDataMonitorVo 基础数据监测vo
	 * @return
	 */
	private String getFindSql(int pageIndex,int pageSize, BaseDataMonitorVo baseDataMonitorVo){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * from ismsm_housemonitor where 1=1");
		if(baseDataMonitorVo.getIpQuery()!=null){
			sql.append(" AND ip LIKE '%"+baseDataMonitorVo.getIpQuery()+"%'");
		}
		if(baseDataMonitorVo.getDomainQuery()!=null){
			sql.append(" AND domain LIKE '%"+baseDataMonitorVo.getDomainQuery()+"%'");
		}
		if(baseDataMonitorVo.getCurrentStateQuery()!=null){
			sql.append(" AND currentState="+baseDataMonitorVo.getCurrentStateQuery());
		}
		if(baseDataMonitorVo.getErrorQuery()!=null){
			sql.append(" AND error="+baseDataMonitorVo.getErrorQuery());
		}
		if(!StringUtils.isEmpty(baseDataMonitorVo.getServiceCodeQuery())){//不为空
			sql.append(" AND service_code='"+baseDataMonitorVo.getServiceCodeQuery()).append("' ");
		}else{//为空
			/**
			//获取当前用户能看到的机房服务：待定
			if(vo.isNonAdmin()){ //判断用户权限
				sql.append(" AND service_code in ("+vo.getPurService()+") ");
			}
			*/
		}
		return sql.toString();
	}
	/**
	 * 
	 * @Description 获取分页对象
	 * @author zhufj
	 * @param pageIndex
	 * @param pageSize
	 * @param esEntity
	 * @return
	 */
	private PageResult getPageList(int pageIndex,int pageSize,EsEntity esEntity){
		List<BaseDataMonitorVo> lst = new ArrayList<>();
		//获取的数据为空
		if(esEntity==null){
			return new PageResult(lst,pageIndex,pageSize,0,0);
		} 
		List<Hits> hits =(List<Hits>)((Hit)esEntity.getHits()).getHits();
		long total = ((Hit)esEntity.getHits()).getTotal();//总数
		int totalPageCount = (int)(total%pageSize==0?total/pageSize:total/pageSize+1);
		if(hits!=null&&!hits.isEmpty()){
			int size = hits.size();
			for(int i=0;i<size;i++){
				Hits hit = hits.get(i);
				IsmsmHousemonitorModel ismsmHousemonitorModel = (IsmsmHousemonitorModel)hit.get_source();
				//转换为 BaseDataMonitorVo
				BaseDataMonitorVo baseDataMonitorVo = new  BaseDataMonitorVo();
				baseDataMonitorVo = (BaseDataMonitorVo)AnnotationParse.MappingParse(IsmsmHousemonitorModelMapping.class, "copyProperties",IsmsmHousemonitorModel.class, BaseDataMonitorVo.class, ismsmHousemonitorModel);
				lst.add(baseDataMonitorVo);
			}
		}
		return new PageResult(lst,pageIndex,pageSize,totalPageCount,total);
	}
	
	@Override
	public PageResult<IsmsxIsstopsignVo> getListDetail(PageResult<IsmsxIsstopsignVo> page,
			IsmsxIsstopsignVo ismsxIsstopsignVo) {
			//定义参数
			String domain = "";
			//获取查询sql
			StringBuffer sql = new StringBuffer("SELECT service.service_name,model.userid,")
					.append(" CASE model.utype WHEN 1 THEN '域名操作' WHEN 2 THEN '域名操作' WHEN 3 THEN 'IP(ip段)操作' ")
					.append(" WHEN 4 THEN 'URL地址' WHEN 5 THEN '协议'  WHEN 6 THEN '端口(段)' ")
					.append(" WHEN 7 THEN 'ip+port' WHEN 8 THEN 'domain+ip'  WHEN 9 THEN 'domain+port' ")
					.append(" WHEN 10 THEN '关键字' WHEN 11 THEN 'URL+IP'  WHEN 12 THEN 'ip+关键词' ")
					.append(" WHEN 13 THEN 'ip+关键词' WHEN 14 THEN '域名+关键词'  WHEN 15 THEN '域名+URL' ")
					.append(" WHEN 16 THEN 'IP+域名+URL' WHEN 17 THEN 'IP+域名+关键词'  WHEN 18 THEN '域名+URL+关键词' ")
					.append(" WHEN 19 THEN 'IP+域名+URL+关键词' WHEN 20 THEN 'URL+关键词'  WHEN 21 THEN 'IP+URL+关键词' ")
					.append(" ELSE '其他' END utype, ")
					.append(" model.content,CASE model.stopsign WHEN 0 THEN '过滤->未过滤(取消封堵)' WHEN 1 THEN '未过滤->过滤(封堵)'  ")
					.append(" WHEN 2 THEN '操作失败' END stopsign, ")
					.append(" model.userip,model.cur_time, model.local_ip, model.local_mac,model.local_machine ");		
			sql.append("  FROM ismsx_isstopsign model, tab_service_information service ");
			sql.append(" WHERE model.service_code = service.service_code AND model.content = ").append(ismsxIsstopsignVo.getDomainQuery());
			if(ismsxIsstopsignVo.getServiceCodeQuery()!=0){
				sql.append(" AND model.service_code = ").append(ismsxIsstopsignVo.getServiceCodeQuery());
			}else{
				//获取机房列表 TODO
				sql.append(" AND model.service_code IN (").append("").append(")");
			}
			if("1".equals(ismsxIsstopsignVo.getSubType())){//处置记录res_domain.domain关联表ismsx_isstopsign.content条件utype   IN ( 1,2)
				sql.append(" AND utype IN (1,2) ");
			}else if("5".equals(ismsxIsstopsignVo.getSubType())){//处置记录ismsm_housemonitor.ip/res_ips.ip关联表ismsx_isstopsign.content条件utype=3 
				domain += "-"+ismsxIsstopsignVo.getDomainQuery();
				sql.append(" AND utype=3 ");
			}
			sql.append(" ORDER BY id DESC");
			//调用持久层对象获取数据
			PageResult<IsmsxIsstopsignModel> rtnPage = DbUtil.queryPageForObjectPageResult(sql.toString(), IsmsxIsstopsignModel.class, ismsxIsstopsignVo.getPageIndex(), ismsxIsstopsignVo.getPageSize());
			//对象转换
			List<IsmsxIsstopsignVo> ismsxIsstopsignVos = new ArrayList<>();
			List<IsmsxIsstopsignModel> ismsxIsstopsignModels = rtnPage.getRows();
			for(int i =0;i<ismsxIsstopsignModels.size();i++){
				IsmsxIsstopsignVo isstopsignVo=(IsmsxIsstopsignVo)AnnotationParse.MappingParse(IsmsxIsstopsignModelMapping.class, "copyProperties", IsmsxIsstopsignModel.class, IsmsxIsstopsignVo.class, ismsxIsstopsignModels.get(i));
				ismsxIsstopsignVos.add(isstopsignVo);
			}
			page.setRows(ismsxIsstopsignVos);
			page.setPageIndex(rtnPage.getPageIndex());
			page.setPageSize(rtnPage.getPageSize());
			page.setTotal(rtnPage.getTotal());
			page.setTotalPageCount(rtnPage.getTotalPageCount());
			return page;
	}
	
	@Override
	public void sendBlockCmd(String ipAddr, SessionVo sessionVo,BaseDataMonitorVo baseDataMonitorVo) throws Exception {
		//获取请求参数
		String isstopKey = baseDataMonitorVo.getIpQuery();//过滤内容
		String serviceCode = baseDataMonitorVo.getServiceCodeQuery()+"";
		String state = baseDataMonitorVo.getCurrentStateQuery();
		//查看是否有EU  TODO
		List<TabInterfaceConfig> euSystemList = new ArrayList<>();
		TabInterfaceConfig tabInterfaceConfig = new TabInterfaceConfig();
		tabInterfaceConfig.setShowMk("Y");
		tabInterfaceConfig.setInterfaceType(new Byte("1"));
		euSystemList =  TabInterfaceConfig.getDao().select(tabInterfaceConfig);// 1-EU
		if(!CollectionUtils.isEmpty(euSystemList)){
			//根据内容等条件查找封堵中间表是否已存在此记录
			ResDomainIpSchemeid record = new ResDomainIpSchemeid();
			record.setServiceCode(serviceCode);
			record.setContent(isstopKey.getBytes());
			record.setSchemeType(2);
			List<ResDomainIpSchemeid> schemeIds =ResDomainIpSchemeid.getDao().select(record);
			String schemeId = null;
			if(!CollectionUtils.isEmpty(schemeIds)){
				schemeId = schemeIds.get(0).getIsstopSchemeId();
			}
			if(schemeId != null){//中间表已存在记录
				//通过schemeId查找策略明细
				IsmscIdcCommandRule idcCommandRule= new IsmscIdcCommandRule();
				idcCommandRule.setSchemeId(Long.valueOf(schemeId));
				List<IsmscIdcCommandRule> ruleList = IsmscIdcCommandRule.getDao().select(idcCommandRule);
				IsmscIdcCommandRule rule = ruleList.get(0);//域名或ip在策略明细表中只存在一条数据，所以取第一条
				Long commandId = rule.getCommandid();
				//修改策略执行状态
				if("0".equals(state)){//idcipno
					Calendar now =Calendar.getInstance();
					now.add(Calendar.DATE,365);
					Timestamp expiredTime = Timestamp.valueOf(new Timestamp(now.getTimeInMillis()).toString().substring(0, 10)+" 23:59:59");
					//更新信息安全管理指令表
					IsmscIdcCommand idcCommand = IsmscIdcCommand.getDao().selectByPrimaryKey(commandId);
					idcCommand.setExpiredtime(expiredTime);
					idcCommand.setStatus("2");
					idcCommand.setStatustime(new Timestamp(new Date().getTime()));
					idcCommand.setOperationtype("0");
					IsmscIdcCommand.getDao().updateByPrimaryKey(idcCommand);
					//更新信息安全管理指令明细表
					Example example = new Example(IsmscIdcCommandRule.class);
			        example.createCriteria().andEqualTo("commandid",commandId);
			        example.createCriteria().andNotEqualTo("excstate", "3");
			        List<IsmscIdcCommandRule> ismscIdcCommandRules = IsmscIdcCommandRule.getDao().selectByExample(example);
			        if(!CollectionUtils.isEmpty(ismscIdcCommandRules)){
			        	IsmscIdcCommandRule ismscIdcCommandRule = ismscIdcCommandRules.get(0);
			        	ismscIdcCommandRule.setExcstate("2");
			        	ismscIdcCommandRule.setExctime(new Timestamp(new Date().getTime()));
			        	ismscIdcCommandRule.setOperationtype("0");
			        	IsmscIdcCommandRule.getDao().updateByExample(ismscIdcCommandRule, example);
			        }
				}else{//rbidcipno
					//更新信息安全管理指令表
					IsmscIdcCommand idcCommand = new IsmscIdcCommand();
					idcCommand.setCommandid(commandId);
					idcCommand = IsmscIdcCommand.getDao().selectOne(idcCommand);
					idcCommand.setStatus("3");
					idcCommand.setOperationtype("1");
					idcCommand.setStatustime(new Timestamp(new Date().getTime()));
					IsmscIdcCommand.getDao().updateByPrimaryKey(idcCommand);
					//更新信息安全管理指令明细表
					Example example = new Example(IsmscIdcCommandRule.class);
			        example.createCriteria().andEqualTo("commandid",commandId);
			        example.createCriteria().andNotEqualTo("excstate", "3");
					List<IsmscIdcCommandRule> ismscIdcCommandRules = IsmscIdcCommandRule.getDao().selectByExample(example);
			        if(!CollectionUtils.isEmpty(ismscIdcCommandRules)){
			        	IsmscIdcCommandRule ismscIdcCommandRule = ismscIdcCommandRules.get(0);
			        	ismscIdcCommandRule.setUnexcstate("2");
			        	ismscIdcCommandRule.setUnexctime(new Timestamp(new Date().getTime()));
			        	ismscIdcCommandRule.setOperationtype("1");
			        	IsmscIdcCommandRule.getDao().updateByExample(ismscIdcCommandRule, example);
			        }
				}
				//写入封堵日志表ismsx_isstopsign
				Example example = new Example(IsmscIdcCommandRule.class);
				example.createCriteria().andEqualTo("commandID", commandId);
				List<IsmscIdcCommandRule> ismscIdcCommandRules = IsmscIdcCommandRule.getDao().selectByExample(example);
				//生成封堵日志表需要插入的数据
				IsmsxIsstopsign ismsxIsstopsign = getIsmscIdcCommandRule(ismscIdcCommandRules,new Comparator<IsmscIdcCommandRule>(){

					@Override
					public int compare(IsmscIdcCommandRule o1, IsmscIdcCommandRule o2) {
						// TODO Auto-generated method stub
						return 0;
					}});
				ismsxIsstopsign.setUserid(sessionVo.getUserId());
				ismsxIsstopsign.setUserip(ipAddr);
				ismsxIsstopsign.setCurTime(new Date());
				ismsxIsstopsign.setLocalIp(sessionVo.getLocalIp());
				ismsxIsstopsign.setLocalMac(sessionVo.getLocalMac());
				ismsxIsstopsign.setLocalMachine(sessionVo.getLocalMachine());
				IsmsxIsstopsign.getDao().insert(ismsxIsstopsign);
			}
		}
	}
	/**
	 * 
	 * @Description 生成封堵日志表需要插入的数据
	 * @author zhufj
	 * @return
	 */
	private IsmsxIsstopsign getIsmscIdcCommandRule(List<IsmscIdcCommandRule> ismscIdcCommandRules,Comparator<IsmscIdcCommandRule> comparator){
		IsmsxIsstopsign isstopsign = new IsmsxIsstopsign();
		//比较组内数据
		List<List<IsmscIdcCommandRule>> result = new ArrayList<List<IsmscIdcCommandRule>>();
        for (IsmscIdcCommandRule t : ismscIdcCommandRules) {
            boolean isSameGroup = false;
            for (int j = 0; j < result.size(); j++) {
                if (comparator.compare(t, result.get(j).get(0)) == 0) {
                    isSameGroup = true;
                    result.get(j).add(t);
                    break;
                }
            }
            if (!isSameGroup) {
                // 创建
                List<IsmscIdcCommandRule> innerList = new ArrayList<IsmscIdcCommandRule>();
                result.add(innerList);
                innerList.add(t);
            }
        }
        //生成封堵日志表需要插入的数据
        if(!CollectionUtils.isEmpty(result)){
        	for(int i = 0;i<result.size();i++){
        		List<IsmscIdcCommandRule> isIdcCommandRules = result.get(i);
        		if(!CollectionUtils.isEmpty(isIdcCommandRules)){
        			StringBuffer utype = new StringBuffer();
        			StringBuffer valueEnd = new StringBuffer();
        			StringBuffer valueStart = new StringBuffer();
        			String operationTypeParam = "";
        			for(int j=0;j<isIdcCommandRules.size();j++){
        				IsmscIdcCommandRule idcCommandRule = isIdcCommandRules.get(j);
        				utype.append(idcCommandRule.getSubtype());
        				valueEnd.append(idcCommandRule.getValueend());
        				valueStart.append(idcCommandRule.getValuestart());
        				operationTypeParam = idcCommandRule.getOperationtype();
        			}
        			//判断并拼接utype
        			String utypeParam = StringUtils.replace(utype.toString(), ",", "");
        			if(utypeParam.startsWith("33")){
    					utype.append("10");
    				}else{
    					switch(utypeParam){
    					case "2":
    						utypeParam ="4";
    						break;
    					case "4":
    						utypeParam="3";
    						break;
    					case "5":
    						utypeParam="3";
    						break;
    					case "7":
    						utypeParam= "6";
    						break;
    					case "14":
    						utypeParam= "8";
    						break;
    					case "15":
    						utypeParam= "8";
    						break;
    					case "34":
    						utypeParam = "12";
    						break;
    					case "35":
    						utypeParam ="13";
    						break;
    					case "13":
    						utypeParam ="14";
    						break;
    					case "24":
    						utypeParam ="11";
    						break;
    					case "25":
    						utypeParam ="11";
    						break;
    					case "12":
    						utypeParam ="15";
    						break;
    					case "124":
    						utypeParam ="16";
    						break;
    					case "125":
    						utypeParam ="16";
    						break;
    					case "134":
    						utypeParam ="17";
    						break;
    					case "135":
    						utypeParam ="17";
    						break;
    					case "123":
    						utypeParam ="18";
    						break;
    					case "1234":
    						utypeParam ="19";
    						break;
    					case "1235":
    						utypeParam ="19";
    						break;
    					case "23":
    						utypeParam ="20";
    						break;
    					case "234":
    						utypeParam ="21";
    						break;
    					case "235":
    						utypeParam ="21";
    						break;
    					case "46":
    						utypeParam ="7";
    						break;
    					case "57":
    						utypeParam ="7";
    						break;
    					case "16":
    						utypeParam ="9";
    						break;
    					case "17":
    						utypeParam ="9";
    						break;
    					default:
    						break;
    					}
    				}
        			//判断并拼接结束值
    				String content = "";
    				if(!valueEnd.toString().isEmpty()){
    					content = valueStart.append("-").append(valueEnd).toString();
    				}else{
    					content = valueStart.toString();
    				}
    				//判断并拼接类型
    				if("0".equals(operationTypeParam)){
    					operationTypeParam = "1";
    				}else{
    					operationTypeParam = "0";
    				}
    				//生成封堵日志表值
    				isstopsign.setUtype(StringUtils.isEmpty(utypeParam)?true:false);
    				isstopsign.setContent(StringUtils.replace(content, ",", ""));
    				isstopsign.setStopsign("1".equals(operationTypeParam)?true:false);
        		}
        		
            }
        }
        return isstopsign;        
	}

}
