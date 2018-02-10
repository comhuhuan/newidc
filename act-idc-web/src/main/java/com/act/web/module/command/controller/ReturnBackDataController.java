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
import com.act.web.module.command.service.ReturnBackDataService;
import com.act.web.module.command.vo.ReturnBackDataVo;
import com.act.web.module.common.controller.BaseController;
import com.act.web.module.common.vo.SelectVo;

/**
 * 
 * <p>Title: ReturnBackDataController.java
 * <p>Description:回退数据控制层
 * <p>Modified History:
 * @author chenxin
 * @date 2018年1月31日 上午9:04:31
 */ 
@Controller
@RequestMapping("/command/returnBackData")
public class ReturnBackDataController extends BaseController {
    private final Logger log = LoggerFactory.getLogger(ReturnBackDataController.class);

    /**
     * 回退数据服务层接口
     */
    @Resource
    private ReturnBackDataService returnBackDataService;

    /**
     * <p>Title: pagingList
     * <p>Description:条件查询回退数据
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月31日 上午9:04:48
     * @param page 分页对象
     * @param returnBackDataVo 展示对象
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/pagingList.do")
    public Object pagingList(PageResult<ReturnBackDataVo> page, ReturnBackDataVo returnBackDataVo) {
        try {
            page = returnBackDataService.findList(page, returnBackDataVo);
            return ajax(Status.success, page);
        } catch (Exception e) {
            log.error("分页查询失败!", e);
            return ajax(Status.error, "查询失败!");
        }
    }

    /**
     * <p>Title: init
     * <p>Description: 初始化初始化
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月31日 上午9:06:12
     * @return  AJAX对象
     */
    @ResponseBody
    @RequestMapping("/init.do")
    public Object init() {
        Map<String, List<SelectVo<String>>> map = new HashMap<>(1);
        try {
            map = returnBackDataService.init();
            return ajax(Status.success, map);
        } catch (Exception e) {
            log.error("获取下拉框数据失败！", e);
            return ajax(Status.error, "获取下拉框数据失败！");

        }
    }
    
    /**
     * <p>Title: view
     * <p>Description:回退数据详情
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月31日 上午9:06:30
     * @param id 主键
     * @return AJAX对象
     */
    @ResponseBody
    @RequestMapping("/view.do")
    public Object view(Integer id) {
        ReturnBackDataVo returnBackDataVo = new ReturnBackDataVo();
        try {
            returnBackDataVo = returnBackDataService.viewDetail(id);
        } catch (Exception e) {
            log.error("详情查询失败!", e);
            return ajax(Status.error, "查询失败!");
        }
        return ajax(Status.success, returnBackDataVo);
    }

}
