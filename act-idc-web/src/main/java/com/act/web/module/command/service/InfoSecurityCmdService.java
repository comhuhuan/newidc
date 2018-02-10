package com.act.web.module.command.service;

import java.util.List;
import java.util.Map;

import com.act.framework.util.PageResult;
import com.act.web.module.command.vo.InfoSecurityCmdVo;
import com.act.web.module.command.vo.ViewEuVo;
import com.act.web.module.common.vo.SelectVo;

/**
 * 
 * <p>Title: InfoSecurityCmdService.java
 * <p>Description: 信息安全管理指令服务层接口
 * <p>Modified History:
 * @author chenxin
 * @date 2018年1月31日 上午9:12:23
 */ 
public interface InfoSecurityCmdService {
   
    /**
     * <p>Title: findList
     * <p>Description: 信息安全管理指令查询指令分页查询
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月31日 上午9:12:35
     * @param curSystem 指令来源
     * @param page  分页数据
     * @param infoSecurityCmdVo 展示对象
     * @return 分页展示对象
     */
    PageResult<InfoSecurityCmdVo> findList(String curSystem, PageResult<InfoSecurityCmdVo> page, InfoSecurityCmdVo infoSecurityCmdVo);
    
    /**
     * <p>Title: init
     * <p>Description: 信息安全管理指令初始化方法 
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月31日 上午9:13:17
     * @return
     */
    Map<String, List<SelectVo<String>>> init();
  
    /**
     * <p>Title: euInit
     * <p>Description: 查看EU初始化方法 
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月31日 上午9:15:17
     * @return
     */
    Map<String, List<SelectVo<String>>> euInit();
   
    /**
     * <p>Title: viewDetail
     * <p>Description: 信息安全管理指令详情
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月31日 上午9:13:20
     * @param page 分页
     * @param infoSecurityCmdVo 展示对象
     * @return 分页的 展示对象
     */
    PageResult<InfoSecurityCmdVo> viewDetail(PageResult<InfoSecurityCmdVo> page,  InfoSecurityCmdVo infoSecurityCmdVo);
    
    /**
     * <p>Title: viewEu
     * <p>Description:  查看EU
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月31日 上午9:13:46
     * @param page 分页数据
     * @param viewEuVo 展示对象
     * @return 分页展示对象数据
     */
    PageResult<ViewEuVo> viewEu(PageResult<ViewEuVo> page, ViewEuVo viewEuVo);
    
    /**
     * <p>Title: sendOrCancel
     * <p>Description: 下发或者取消下发
     * <p>Modified History:  
     * @author chenxin
     * @date 2018年1月31日 上午9:13:23
     * @param commandId 指令id
     * @param idcCommandId 管理指令文件id
     */
    void sendOrCancel(Long commandId, Long idcCommandId);

}
