package com.act.web.module.command.service;

import java.util.List;
import java.util.Map;

import com.act.framework.util.PageResult;
import com.act.web.module.command.vo.NoFilterWebCmdVo;
import com.act.web.module.command.vo.NoFilterWebRuleVo;
import com.act.web.module.common.vo.SelectVo;

/**
 * 
 * <p>Title: NoFilterWebCmdServive.java
 * <p>Description: 免过滤网站指令服务层接口
 * <p>Modified History:
 * @author chenxin
 * @date 2018年1月31日 上午9:15:45
 */ 
public interface NoFilterWebCmdServive {
    
    /**
     * 免过滤网站指令初始化方法
     * @return Map<String,List<SelectVo<String>>>
     */
    Map<String, List<SelectVo<String>>> init();
    
    /**
     * <p>Title: findList
     * <p>Description: 条件查询免过滤网站指令
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月31日 上午9:16:09
     * @param curSystem
     * @param page 分页数据
     * @param noFilterWebCmdVo 免过滤网站指令展示对象
     * @return 分页结果集
     */
    PageResult<NoFilterWebCmdVo> findList(String curSystem, PageResult<NoFilterWebCmdVo> page, NoFilterWebCmdVo noFilterWebCmdVo);

    /**
     * <p>Title: viewDetail
     * <p>Description: 查看详情
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月31日 上午9:16:39
     * @param page 分页数据
     * @param noFilterWebRuleVo 展示对象
     * @return 分页展示对象
     */
    PageResult<NoFilterWebRuleVo> viewDetail(PageResult<NoFilterWebRuleVo> page,  NoFilterWebRuleVo noFilterWebRuleVo);
    
}
