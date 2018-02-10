package com.act.web.module.command.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.act.framework.util.PageResult;
import com.act.web.module.command.service.CodeListIssuseCmdService;
import com.act.web.module.command.vo.CodeListIssuseCmdVo;
import com.act.web.module.common.controller.BaseController;
import com.act.web.module.common.vo.SelectVo;

/**
 * <p>Title: CodeListIssuseCmdController.java
 * <p>Description: 代码表发布指令控制层
 * <p>Modified History:
 * @author chenxin
 * @date 2018年1月30日 下午6:17:01
 */ 
@Controller
@RequestMapping("/command/codeListIssuseCmd")
public class CodeListIssuseCmdController extends BaseController {
    private final Logger log = LoggerFactory.getLogger(CodeListIssuseCmdController.class);
   
    /** 
     * @Fields codeListIssuseCmdService : 代码表发布指令服务层
    */ 
    @Resource
    private CodeListIssuseCmdService codeListIssuseCmdService;
    
    /**
     * <p>Title: pagingList
     * <p>Description: 条件查询
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月30日 下午6:17:51
     * @param page 代码表发布指令分页对象
     * @param codeListIssuseCmdVo 代码表发布指令展示对象
     * @return AJAX对象
     */
    @ResponseBody
    @RequestMapping(value = "/pagingList.do")
    public Object pagingList(PageResult<CodeListIssuseCmdVo> page, CodeListIssuseCmdVo codeListIssuseCmdVo) {
        try {
            page = codeListIssuseCmdService.findList(page, codeListIssuseCmdVo);
            return ajax(Status.success, page);
        } catch (Exception e) {
            log.error("分页查询失败!", e);
            return ajax(Status.error, "查询失败!");
        }
    }

    /**
     * <p>Title: init
     * <p>Description: 初始化
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月30日 下午6:19:02
     * @return
     */
    @ResponseBody
    @RequestMapping("/init.do")
    public Object init() {
        Map<String, List<SelectVo<String>>> map = new HashMap<>(1);
        try {
            map = codeListIssuseCmdService.init();
            return ajax(Status.success, map);
        } catch (Exception e) {
            log.error("获取下拉框数据失败！", e);
            return ajax(Status.error, "获取下拉框数据失败！");
        }
    }
}
