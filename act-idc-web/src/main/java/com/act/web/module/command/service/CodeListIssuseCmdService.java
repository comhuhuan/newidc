package com.act.web.module.command.service;

import java.util.List;
import java.util.Map;

import com.act.framework.util.PageResult;
import com.act.web.module.command.vo.CodeListIssuseCmdVo;
import com.act.web.module.common.vo.SelectVo;

/**
 * 
 * <p>Title: CodeListIssuseCmdService.java
 * <p>Description: 代码表发布指令服务层接口
 * <p>Modified History:
 * @author chenxin
 * @date 2018年1月31日 上午9:11:33
 */ 
public interface CodeListIssuseCmdService {
    
    /**
     * <p>Title: findList
     * <p>Description: 条件查询代码表下发指令信息
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月31日 上午9:11:46
     * @param page 分页对象
     * @param codeListIssuseCmdVo 展示对象
     * @return 分页列表数据 
     */
    PageResult<CodeListIssuseCmdVo> findList(PageResult<CodeListIssuseCmdVo> page, CodeListIssuseCmdVo codeListIssuseCmdVo);
    
    /**
     * <p>Title: init
     * <p>Description:  回退数据的初始化方法
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月31日 上午9:11:49
     * @return
     */
    Map<String, List<SelectVo<String>>> init();

}
