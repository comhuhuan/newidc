/*
 * Copyright (c) www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.common.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.act.web.module.sso.vo.SessionVo;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.act.framework.util.DbUtil;
import com.act.idc.model.TabServiceInformation;
import com.act.web.constant.SessionContant;
import com.act.web.module.common.vo.SelectVo;

/**
 *
 * <p>Title: BaseController
 * <p>Description:所有控制器的父类,提供返回前端数据格式化公用方法{@link #ajax(Status, Object)}
 * @author FMJ
 * @date 2018/2/2 10:39
 */
public class BaseController extends MultiActionController {

    private final Logger log = LoggerFactory
            .getLogger(BaseController.class);

    /**
     * 操作状态（错误、成功）
     */
    protected enum Status {
        /**
         * 错误标识
         */
        error,
        /**
         * 正确标识
         */
        success
    }


    /**
     * <p>Title: ajax
     * <p>Description: 根据操作状态、消息内容输出AJAX
     * @author FMJ
     * @date 2018/2/7 10:39
     */
    protected Map<String, Object> ajax(Status status, Object message) {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("status",status.toString());
        jsonMap.put("message",message);
        return jsonMap;
    }

    /**
     * 解决mvc，前台提交时间无法访问的问题，需要统一格式
     *
     * @param binder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"), true));
    }

    /**
     * <p>Title: downloadAttachment
     * <p>Description:下载文件
     * @author FMJ
     * @date 2018/2/2 10:39
     * @param request      获取项目根目录
     * @param downFilePath 下载文件路径
     * @param downFileName 下载文件名 必须包含后缀
     * @return 下载文件
     * @throws IOException
     */
    protected ResponseEntity<byte[]> downloadAttachment(HttpServletRequest request, String downFilePath, String downFileName) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        String webPath = request.getSession().getServletContext()
                .getRealPath("/");
        String filePath = webPath + downFilePath;
        // 解决文件中文乱码
        String agent = request.getHeader("User-Agent").toLowerCase();
        if (agent.contains("msie") || (agent.contains("rv") && agent.contains("firefox"))) {
            downFileName = URLEncoder.encode(downFileName, "UTF-8");
        } else {
            downFileName = new String(downFileName.getBytes("UTF-8"), "ISO-8859-1");
        }
        headers.setContentDispositionFormData("attachment", downFileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        File file = new File(filePath);
        byte[] bytes = FileUtils.readFileToByteArray(file);
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);

    }

    /**
     * <p>Title: downloadResponse
     * <p>Description: 用于前端模拟请求 下载导出文件  <em>写入流后会删除文件</em>
     * @author FMJ
     * @date 2018/2/2 10:39
     * @param request      获取项目
     * @param response     下载输出流
     * @param downFilePath 下载文件路径
     * @param downFileName 下载文件名称
     * @throws Exception
     */
    protected void downloadResponse(HttpServletRequest request, HttpServletResponse response, String downFilePath, String downFileName) throws Exception {
        // 以流的形式下载文件。
        String webPath = request.getSession().getServletContext().getRealPath("/");
        String filePath = webPath + downFilePath;
        InputStream fis = new BufferedInputStream(new FileInputStream(filePath));
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        fis.close();
        // 清空response
        response.reset();
        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(downFileName, "UTF-8"));
        toClient.write(buffer);
        toClient.flush();
        toClient.close();
        try{
            File deleteDir = new File(filePath).getParentFile();
            FileUtils.deleteDirectory(deleteDir);
        }catch (Exception e){
            log.error("删除下载附件失败",e);
        }
    }


    /**
     * <p>Title: sessionInfo
     * <p>Description: 从session中得到当前系统用户信息
     * @param httpSession 存放session
     * @return SessionVo 当前用户信息
     */
    protected SessionVo sessionInfo(HttpSession httpSession) {
        return(SessionVo) httpSession.getAttribute(SessionContant.SESSION_INFO);
    }

    /**
     * <p>Title: serviceCodeSelect
     * <p>Description: 加载机房下拉框
     * @param httpSession 存放session
     * @return 机房下拉框
     */
	protected List<SelectVo> serviceCodeSelect(HttpSession httpSession) {
		return DbUtil.queryForObjectList(
				"SELECT DISTINCT a.service_code as value,a.service_name as label FROM tab_service_information a LEFT JOIN tab_servicepurview b "
						+ "ON a.service_code = b.servicecode where b.user_id = ?",
				SelectVo.class, (sessionInfo(httpSession)).getUserId());
	}
   
}
