package com.act.web.module.command.service;

import java.util.List;
import java.util.Map;

import com.act.framework.util.PageResult;
import com.act.web.module.command.vo.ReceiveCmdVerifyVo;
import com.act.web.module.common.vo.SelectVo;

/**
 * 
 * <p>Title: ReceiveCmdVerifyService.java
 * <p>Description: 接收指令校验服务层接口
 * <p>Modified History:
 * @author chenxin
 * @date 2018年1月31日 上午9:17:23
 */ 
public interface ReceiveCmdVerifyService {
    
    /**
     * <p>Title: findList
     * <p>Description: 条件查询接收指令校验信息
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月31日 上午9:17:37
     * @param curSystem 指令类型
     * @param page 分页对象
     * @param receiveCmdVerifyVo 展示对象
     * @return 分页列表数据 
     */
    PageResult<ReceiveCmdVerifyVo> findList(String curSystem, PageResult<ReceiveCmdVerifyVo> page, ReceiveCmdVerifyVo receiveCmdVerifyVo);
    
    /**
     * <p>Title: init
     * <p>Description: 接收指令校验的初始化方法
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月31日 上午9:18:23
     * @return
     */
    Map<String, List<SelectVo<String>>> init();
}
