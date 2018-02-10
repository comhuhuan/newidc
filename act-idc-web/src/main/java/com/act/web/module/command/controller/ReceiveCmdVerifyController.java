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
import com.act.web.module.command.service.ReceiveCmdVerifyService;
import com.act.web.module.command.vo.ReceiveCmdVerifyVo;
import com.act.web.module.common.controller.BaseController;
import com.act.web.module.common.vo.SelectVo;

/**
 * 
 * <p>Title: ReceiveCmdVerifyController.java
 * <p>Description: 接收指令校验控制层
 * <p>Modified History:
 * @author chenxin
 * @date 2018年1月31日 上午9:08:14
 */ 
@Controller
@RequestMapping("/command/receiveCmdVerify")
public class ReceiveCmdVerifyController extends BaseController {
    private final Logger log = LoggerFactory.getLogger(ReceiveCmdVerifyController.class);

    /**
     * 接收指令指令校验服务层接口
     */
    @Resource
    private ReceiveCmdVerifyService receiveCmdVerifyService;

    /**
     * <p>Title: pagingList
     * <p>Description: 接收指令校验条件查询
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月31日 上午9:08:31
     * @param page  接收指令校验分页对象
     * @param receiveCmdVerifyVo 接收指令校验展示对象
     * @param httpSession 
     * @return AJAX对象
     */
    @ResponseBody
    @RequestMapping(value = "/pagingList.do")
    public Object pagingList(PageResult<ReceiveCmdVerifyVo> page, ReceiveCmdVerifyVo receiveCmdVerifyVo,
            HttpSession httpSession) {
        try {
            // 1-smms 2-cu 3-eu
            String curSystem = (String) httpSession.getAttribute(SessionContant.CUR_SYSTEM);
            page = receiveCmdVerifyService.findList(curSystem, page, receiveCmdVerifyVo);
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
     * @date 2018年1月31日 上午9:09:41
     * @return
     */
    @ResponseBody
    @RequestMapping("/init.do")
    public Object init() {
        Map<String, List<SelectVo<String>>> map = new HashMap<>(1);
        try {
            map = receiveCmdVerifyService.init();
            return ajax(Status.success, map);
        } catch (Exception e) {
            log.error("获取下拉框数据失败！", e);
            return ajax(Status.error, "获取下拉框数据失败！");
        }
    }

}
