package com.act.web.module.command.service;

import java.util.List;
import java.util.Map;

import com.act.framework.util.PageResult;
import com.act.web.module.command.vo.ReturnBackDataVo;
import com.act.web.module.common.vo.SelectVo;

/**
 * 
 * <p>Title: ReturnBackDataService.java
 * <p>Description: 回退数据内容查询服务层接口
 * <p>Modified History:
 * @author chenxin
 * @date 2018年1月31日 上午9:18:51
 */ 
public interface ReturnBackDataService {
   
    /**
     * <p>Title: findList
     * <p>Description: 回退数据查询指令分页查询
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月31日 上午9:19:03
     * @param page 分页对象
     * @param returnBackDataVo 展示对象
     * @return 分页列表数据 
     */
    PageResult<ReturnBackDataVo> findList(PageResult<ReturnBackDataVo> page, ReturnBackDataVo returnBackDataVo);

    /**
     * <p>Title: init
     * <p>Description: 回退数据的初始化方法
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月31日 上午9:19:31
     * @return
     */
    Map<String, List<SelectVo<String>>> init();
    
    /**
     * <p>Title: viewDetail
     * <p>Description: 回退数据详情
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月31日 上午9:19:43
     * @param id 主键
     * @return 详情展示对象
     */
    ReturnBackDataVo viewDetail(Integer id);
}
