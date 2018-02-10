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
import com.act.web.module.command.service.BaseDataCmdService;
import com.act.web.module.command.vo.BaseDataCmdVo;
import com.act.web.module.common.controller.BaseController;
import com.act.web.module.common.vo.SelectVo;

/**
 * 
 * <p>Title: BaseDataCmdController.java
 * <p>Description:基础数据查询指令控制层
 * <p>Modified History:
 * @author chenxin
 * @date 2018年1月30日 下午6:14:07
 */ 
@Controller
@RequestMapping("/command/baseDataCmd")
public class BaseDataCmdController extends BaseController {
    private final Logger log = LoggerFactory.getLogger(BaseDataCmdController.class);

    /** 
     * @Fields baseDataCmdService : 基础数据下发指令服务层
    */ 
    @Resource
    private BaseDataCmdService baseDataCmdService;

    /**
     * <p>Title: pagingList
     * <p>Description: 条件查询
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月30日 下午6:14:54
     * @param page 分页对象
     * @param baseDataCmdVo 基础数据展示对象
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/pagingList.do")
    public Object pagingList(PageResult<BaseDataCmdVo> page, BaseDataCmdVo baseDataCmdVo) {
        try {
            page = baseDataCmdService.findList(page, baseDataCmdVo);
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
     * @date 2018年1月30日 下午6:16:34
     * @return
     */
    @ResponseBody
    @RequestMapping("/init.do")
    public Object init() {
        Map<String, List<SelectVo<String>>> map = new HashMap<>(1);
        try{
            map = baseDataCmdService.init();
            return ajax(Status.success, map);
        } catch (Exception e) {
            log.error("获取下拉框数据失败！", e);
            return ajax(Status.error, "获取下拉框数据失败！");
        }
    }
}
