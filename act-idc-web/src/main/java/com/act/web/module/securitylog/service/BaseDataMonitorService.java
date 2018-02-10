package com.act.web.module.securitylog.service;

import java.util.Map;

import com.act.framework.util.PageResult;
import com.act.web.module.securitylog.vo.BaseDataMonitorVo;
import com.act.web.module.securitylog.vo.IsmsxIsstopsignVo;
import com.act.web.module.sso.vo.SessionVo;
/**
 * 
 * @Description 信安日志-基础数据监测-业务层接口
 * @author zhufj
 * @date 2018年1月27日 下午12:00:11
 *
 */
public interface BaseDataMonitorService {
	/**
	 * 
	 * @Description 基础数据监测-分页查询
	 * @author zhufj
	 * @param pageIndex
	 * @param pageSize
	 * @param baseDataMonitorVo
	 * @return
	 * @throws Exception
	 */
	public PageResult<BaseDataMonitorVo> findList(PageResult<BaseDataMonitorVo> page,BaseDataMonitorVo baseDataMonitorVo) throws Exception;
	/**
	 * 
	 * @Description 机房列表查询
	 * @author zhufj
	 * @return
	 * @throws Exception
	 */
	public Map<String,String> getServiceCode() throws Exception;
	/**
	 * 
	 * @Description 查询详情
	 * @author zhufj
	 * @param page
	 * @param baseDataMonitorVo
	 * @return
	 */
	public PageResult<IsmsxIsstopsignVo> getListDetail(PageResult<IsmsxIsstopsignVo> page,IsmsxIsstopsignVo baseDataMonitorVo);
	/**
	 * 
	 * @Description 封堵
	 * @author zhufj
	 * @return
	 * @throws Exception
	 */
	public void sendBlockCmd(String ipAddr,SessionVo sessionVo,BaseDataMonitorVo baseDataMonitorVo) throws Exception;
}
