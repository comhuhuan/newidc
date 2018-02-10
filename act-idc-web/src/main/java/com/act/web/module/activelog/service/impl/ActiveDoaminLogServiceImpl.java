package com.act.web.module.activelog.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.act.framework.util.PageResult;
import com.act.idc.model.TabServiceInformation;
import com.act.util.beanConvert.AnnotationParse;
import com.act.web.es.EsClientUtil;
import com.act.web.es.EsEntity;
import com.act.web.es.Hit;
import com.act.web.es.Hits;
import com.act.web.es.mapping.DomainActivelogModelMapping;
import com.act.web.es.type.DomainActivelogModel;
import com.act.web.module.activelog.service.ActiveDoaminLogService;
import com.act.web.module.activelog.vo.ActiveDoaminLogVo;
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
public class ActiveDoaminLogServiceImpl implements ActiveDoaminLogService{
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
	public PageResult<ActiveDoaminLogVo> findChildDomainLogs(PageResult<ActiveDoaminLogVo> page,
			ActiveDoaminLogVo activeDoaminLogVo) throws Exception {
		//1,获取机房列表
		String purService = "";
		//2,获取es查询的对象
		StringBuffer ip_activelog_sql = new StringBuffer("select * from ").append("ip_activelog");
		ip_activelog_sql.append(getWhereSql(activeDoaminLogVo));
		EsEntity esEntity = esEntityUtil.getEsEntity(activeDoaminLogVo.getPageIndex(), activeDoaminLogVo.getPageSize(), ip_activelog_sql.toString(),new TypeReference<EsEntity<Hit<List<Hits<DomainActivelogModel>>>>>(){});
		//4,生成分页对象
		return getPageList(activeDoaminLogVo.getPageIndex(),activeDoaminLogVo.getPageSize(),esEntity,activeDoaminLogVo);
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
	private PageResult getPageList(int pageIndex,int pageSize,EsEntity esEntity,ActiveDoaminLogVo activeDoaminLogVo){
		List<ActiveDoaminLogVo> activeDoaminLogVos = new ArrayList<>();
		//获取的数据为空
		if(esEntity==null){
			return new PageResult(activeDoaminLogVos,pageIndex,pageSize,0,0);
		} 
		TabServiceInformation tInformation = TabServiceInformation.getDao().selectByPrimaryKey(activeDoaminLogVo.getServiceCodeQuery());
		List<Hits> hits =(List<Hits>)((Hit)esEntity.getHits()).getHits();
		long total = ((Hit)esEntity.getHits()).getTotal();//总数
		int totalPageCount = (int)(total%pageSize==0?total/pageSize:total/pageSize+1);
		if(hits!=null&&!hits.isEmpty()){
			int size = hits.size();
			List<Object> isstopLst = new ArrayList<>();
			for(int i=0;i<size;i++){
				Hits hit = hits.get(i);
				DomainActivelogModel dModel = (DomainActivelogModel)hit.get_source();
				//解析成请求对象
				ActiveDoaminLogVo aDoaminLogVo = (ActiveDoaminLogVo)AnnotationParse.MappingParse(DomainActivelogModelMapping.class, "copyProperties", DomainActivelogModel.class, ActiveDoaminLogVo.class, dModel);
				aDoaminLogVo.setServiceName(tInformation.getServiceName());
				activeDoaminLogVos.add(aDoaminLogVo);
			}
		}
		//返回分页对象
		return new PageResult(activeDoaminLogVos,pageIndex,pageSize,totalPageCount,total);
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
	private String getWhereSql(ActiveDoaminLogVo activeDoaminLogVo){
		StringBuffer whereSql = new StringBuffer("where 1=1 ");
		if (StringUtils.isEmpty(activeDoaminLogVo.getIpQuery())) {// ip查询
			whereSql.append(" and ip like '%").append(activeDoaminLogVo.getIpQuery()).append("%'");
		}
		if (StringUtils.isEmpty(activeDoaminLogVo.getServiceCodeQuery())) {// 机房查询
			whereSql.append(" and service_code =").append(activeDoaminLogVo.getServiceCodeQuery());
		}
		if (StringUtils.isEmpty(activeDoaminLogVo.getHostQuery())) {// 域名查询
			whereSql.append(" and domain like '%").append(activeDoaminLogVo.getHostQuery()).append("%'");
		}
		if (StringUtils.isEmpty(activeDoaminLogVo.getTopDomainFlagQuery())) {//是否顶级域名标识
			whereSql.append(" and topdomainflag =").append(activeDoaminLogVo.getTopDomainFlagQuery());
		}
		if (activeDoaminLogVo.getStartTimeQuery()!=null) {//开始时间
			whereSql.append(" and firsttime >=").append(activeDoaminLogVo.getStartTimeQuery());
		} 
		if (activeDoaminLogVo.getEndTimeQuery()!=null) {//结束时间
			whereSql.append(" and lasttime >=").append(activeDoaminLogVo.getEndTimeQuery());
		} 
		if (activeDoaminLogVo.getFirstStartTimeQuery()!=null) {//首次开始时间
			whereSql.append(" and firsttime >=").append(activeDoaminLogVo.getFirstStartTimeQuery());
		}
		if (activeDoaminLogVo.getFirstEndTimeQuery()!=null) {//首次结束时间
			whereSql.append(" and firsttime <=").append(activeDoaminLogVo.getFirstEndTimeQuery());
		}
		if (activeDoaminLogVo.getLastStartTimeQuery()!=null) {//最近开始时间
			whereSql.append(" and lasttime >=").append(activeDoaminLogVo.getLastStartTimeQuery());
		}
		if (activeDoaminLogVo.getLastEndTimeQuery()!=null) {//最近结束时间
			whereSql.append(" and lasttime <=").append(activeDoaminLogVo.getLastEndTimeQuery());
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
