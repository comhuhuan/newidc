package com.act.web.module.command.service;

import java.util.List;
import java.util.Map;

import com.act.framework.util.PageResult;
import com.act.web.module.command.vo.BaseDataCmdVo;
import com.act.web.module.common.vo.SelectVo;

/**
 * 
 * <p>Title: BaseDataCmdService.java
 * <p>Description: 基础数据服务层接口
 * <p>Modified History:
 * @author chenxin
 * @date 2018年1月31日 上午9:10:27
 */ 
public interface BaseDataCmdService {
    
    /**
     * <p>Title: findList
     * <p>Description: 基础数据查询指令分页查询
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月31日 上午9:10:52
     * @param page 分页对象
     * @param baseDataCmdVo 展示对象
     * @return 分页列表数据 
     */
    PageResult<BaseDataCmdVo> findList(PageResult<BaseDataCmdVo> page, BaseDataCmdVo baseDataCmdVo);
    
    /**
     * <p>Title: init
     * <p>Description:  回退数据的初始化方法
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月31日 上午9:10:58
     * @return
     */
    Map<String, List<SelectVo<String>>> init();


}
