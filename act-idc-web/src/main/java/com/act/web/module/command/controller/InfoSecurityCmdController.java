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
import com.act.web.module.command.vo.InfoSecurityCmdVo;
import com.act.web.module.command.vo.ViewEuVo;
import com.act.web.module.common.controller.BaseController;
import com.act.web.module.common.vo.SelectVo;

/**
 * 
 * <p>Title: InfoSecurityCmdController.java
 * <p>Description: 信息安全管理指令控制层
 * <p>Modified History:
 * @author chenxin
 * @date 2018年1月30日 下午6:19:26
 */ 
@Controller
@RequestMapping("/command/infoSecurityCmd")
public class InfoSecurityCmdController extends BaseController {
    private final Logger log = LoggerFactory.getLogger(BaseDataCmdController.class);

    /** 
     * @Fields infoSecurityCmdService : 信息安全管理指令服务层
    */ 
    @Resource
    private InfoSecurityCmdService infoSecurityCmdService;

    /**
     * <p>Title: pagingList
     * <p>Description: 信息安全管理指令查询接口
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月30日 下午6:20:09
     * @param page 分页对象
     * @param infoSecurityCmdVo 展示对象
     * @param httpSession
     * @return AJAX对象
     */
    @ResponseBody
    @RequestMapping(value = "/pagingList.do")
    public Object pagingList(PageResult<InfoSecurityCmdVo> page, InfoSecurityCmdVo infoSecurityCmdVo,
            HttpSession httpSession) {
        try {
            // 1-cu 2-eu 3-du
            String curSystem = (String) httpSession.getAttribute(SessionContant.CUR_SYSTEM);
            page = infoSecurityCmdService.findList(curSystem, page, infoSecurityCmdVo);
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
     * @date 2018年1月30日 下午6:20:42
     * @return
     */
    @ResponseBody
    @RequestMapping("/init.do")
    public Object init() {
        Map<String, List<SelectVo<String>>> map = new HashMap<>(1);
        try {
            map = infoSecurityCmdService.init();
            return ajax(Status.success, map);
        } catch (Exception e) {
            log.error("获取下拉框数据失败！", e);
            return ajax(Status.success, "获取下拉框数据失败！");
        }
    }

    /**
     * <p>Title: viewEu
     * <p>Description: 点击查看EU
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月30日 下午6:20:57
     * @param page 分页
     * @param viewEuVo 展示对象
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
            return ajax(Status.success, "分页查询EU失败");
        }
    }
    
    /**
     * <p>Title: view
     * <p>Description: 详情
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月30日 下午6:21:46
     * @param page 分页
     * @param infoSecurityCmdVo 展示对象
     * @return 
     */
    @ResponseBody
    @RequestMapping("/view.do")
    public Object viewDetail(PageResult<InfoSecurityCmdVo> page, InfoSecurityCmdVo infoSecurityCmdVo) {
        try {
            page = infoSecurityCmdService.viewDetail(page, infoSecurityCmdVo);
            return ajax(Status.success, page);
        } catch (Exception e) {
            log.error("查看详情失败！", e);
            return ajax(Status.success, "查看详情失败！");
        }
    }
   
    /**
     * <p>Title: euInit
     * <p>Description: 查看EU初始化
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月30日 下午6:22:07
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
            return ajax(Status.success, "获取下拉框数据失败！");
        }
    }
}
