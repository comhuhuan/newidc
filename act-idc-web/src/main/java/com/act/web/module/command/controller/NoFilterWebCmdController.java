package com.act.web.module.command.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.act.framework.util.PageResult;
import com.act.web.constant.SessionContant;
import com.act.web.module.command.service.InfoSecurityCmdService;
import com.act.web.module.command.service.NoFilterWebCmdServive;
import com.act.web.module.command.vo.NoFilterWebCmdVo;
import com.act.web.module.command.vo.NoFilterWebRuleVo;
import com.act.web.module.command.vo.ViewEuVo;
import com.act.web.module.common.controller.BaseController;
import com.act.web.module.common.vo.SelectVo;

/**
 * 
 * <p>Title: NoFilterWebCmdController.java
 * <p>Description: 免过滤网站指令控制层
 * <p>Modified History:
 * @author chenxin
 * @date 2018年1月31日 上午9:24:43
 */ 
@Controller
@RequestMapping("/command/noFilterWebCmd")
public class NoFilterWebCmdController extends BaseController {
    private final Logger log = LoggerFactory.getLogger(NoFilterWebCmdController.class);

    /**
     * @Fields infoSecurityCmdService : 信息安全管理指令服务层
     */
    @Resource
    private InfoSecurityCmdService infoSecurityCmdService;
    /**
     * @Fields noFilterWebCmdServive : 免过滤网站指令服务层
     */
    @Resource
    private NoFilterWebCmdServive noFilterWebCmdServive;

    /**
     * <p>Title: init
     * <p>Description: 初始化
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月30日 下午6:24:49
     * @return
     */
    @ResponseBody
    @RequestMapping("/init.do")
    public Object init() {
        Map<String, List<SelectVo<String>>> map = new HashMap<>(1);
        try {
            map = noFilterWebCmdServive.init();
            return ajax(Status.success, map);
        } catch (Exception e) {
            log.error("获取下拉框数据失败！", e);
            return ajax(Status.error, "获取下拉框数据失败！");
        }
    }

    /**
     * <p>Title: pagingList
     * <p>Description: 免过滤网站查询接口
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月30日 下午6:25:03
     * @param page 分页对象
     * @param noFilterWebCmdVo  展示对象
     * @param httpSession
     * @return AJAX对象
     */
    @ResponseBody
    @RequestMapping(value = "/pagingList.do")
    public Object pagingList(PageResult<NoFilterWebCmdVo> page, NoFilterWebCmdVo noFilterWebCmdVo,
            HttpSession httpSession) {
        try {
            // 1-cu 2-eu 3-du
            String curSystem = (String) httpSession.getAttribute(SessionContant.CUR_SYSTEM);
            page = noFilterWebCmdServive.findList(curSystem, page, noFilterWebCmdVo);
            return ajax(Status.success, page);
        } catch (Exception e) {
            log.error("分页查询失败!", e);
            return ajax(Status.error, "查询失败!");
        }
    }

    /**
     * <p>Title: view
     * <p>Description: 详情
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月30日 下午6:25:34
     * @param page
     * @param noFilterWebRuleVo
     * @return
     */
    @ResponseBody
    @RequestMapping("/view.do")
    public Object view(PageResult<NoFilterWebRuleVo> page, NoFilterWebRuleVo noFilterWebRuleVo) {
        try {
            page = noFilterWebCmdServive.viewDetail(page, noFilterWebRuleVo);
            return ajax(Status.success, page);
        } catch (Exception e) {
            log.error("查询详情失败！", e);
            return ajax(Status.error, "查询详情失败！");
        }
    }

    /**
     * <p>Title: viewEu
     * <p>Description: 点击查看EU
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月30日 下午6:25:48
     * @param page
     * @param viewEuVo
     * @return
     */
    @ResponseBody
    @RequestMapping("/viewEu.do")
    public Object viewEu(PageResult<ViewEuVo> page, ViewEuVo viewEuVo) {
        try {
            page = infoSecurityCmdService.viewEu(page, viewEuVo);
            return ajax(Status.success, page);
        } catch (Exception e) {
            log.error("分页查询EU失败",e);
            return ajax(Status.error, "分页查询EU失败");
        }
    }
    
    /**
     * <p>Title: euInit
     * <p>Description:查看EU初始化
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月30日 下午6:26:01
     * @return
     */
    @ResponseBody
    @RequestMapping("/euInit.do")
    public Object euInit() {
        Map<String, List<SelectVo<String>>> map = new HashMap<>(1);
        try {
            map = infoSecurityCmdService.euInit();
            return ajax(Status.success, map);
        } catch (Exception e) {
            log.error("获取下拉框数据失败！", e);
            return ajax(Status.error, "获取下拉框数据失败！");
        }
    }

}
