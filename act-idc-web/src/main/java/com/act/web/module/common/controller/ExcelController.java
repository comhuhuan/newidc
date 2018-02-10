/*
 * Copyright (c) 2017, www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.act.web.module.common.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.act.framework.util.DbUtil;
import com.act.util.excel.ExcelDataVo;
import com.act.util.excel.ExcelExportVo;
import com.act.util.excel.ExcelUtil;
import com.act.util.operation.ResultContant;
import com.act.web.module.common.vo.ExcelVo;
import com.act.web.util.ConfigLoadUtil;
import com.act.web.util.ExcelUploadUtil;
import com.act.web.util.SpringContextUtil;

/**
 * <p>
 * Title:ExcelController
 * <p>
 * Description:excel样例控制器
 *
 * @author FMJ
 * @date 2018/2/5 14:45
 */
@Controller
@RequestMapping("/common/excel")
public class ExcelController extends BaseController {

	private final Logger log = LoggerFactory.getLogger(ExcelController.class);

    /**
     * <p>
     * Title: download
     * <p>
     * Description: 附件下载
     *
     * @author FMJ
     * @date 2018/2/6 10:39
     * @param request
     *            请求导出附件
     * @return 导出附件
     */
    @ResponseBody
    @RequestMapping(value = "/downloadAttachment.do")
    public Object downloadAttachment(HttpServletRequest request) {
        try {
            return downloadAttachment(request, "download/excel.xls", "excel样例.xls");
        } catch (Exception e) {
            log.error("下载附件失败", e);
            return ajax(Status.error, "下载附件失败");
        }
    }


	/**
	 * <p>
	 * Title: upload
	 * <p>
	 * Description: 上传文件
	 * 
	 * @author FMJ
	 * @date 2018/2/6 10:26
	 * @param request 获取文件
	 * @return 上传状态
	 */
	@ResponseBody
	@RequestMapping(value = "/upload.do")
	public Object upload(HttpServletRequest request) {
		try {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			MultipartFile file = multiRequest.getFile("file");
			List<Map<String, Object>> data = ExcelUploadUtil.parseData(file);
			if (CollectionUtils.isNotEmpty(data)) {
			    // 解析初始化样例 正常逻辑应该是校验后然后初始化导入数据且逻辑写在service中,这里只是演示导入解析过程
				for (int i = 1; i < data.size(); i++) {
					Map<String, Object> map = data.get(i);
                    ExcelVo excelVo = initExcelVo(map);
                    log.info("导入数据：" + excelVo);
				}
				return ajax(Status.success, ResultContant.UPLOAD_SUCCESS);
			} else {
				// 导入的数据不能为空
				return ajax(Status.error, "导入数据不能为空");
			}
		} catch (Exception e) {
			log.error("导入excel文件失败", e);
			return ajax(Status.error, ResultContant.UPLOAD_ERROR);
		}
	}


    /**
     * <p>Title: export
     * <p>Description: 导出文件,返回生成的文件名称和路径
     * @author FMJ
     * @date 2018/2/7 9:29
     * @param request 获取文目录
     * @return {@link ExcelExportVo}文件名称和路径
     */
	@ResponseBody
	@RequestMapping(value = "/export.do")
	public Object export(HttpServletRequest request) {
		try {
			// 查询数据列表
			List<ExcelVo> dataList = DbUtil.queryForObjectList(
					" select domainid,service_code as servicecode,domain,servicecontent from alone_export_data ",
					ExcelVo.class);
			if (CollectionUtils.isNotEmpty(dataList)) {
				ExcelDataVo excelVo = new ExcelDataVo<>(dataList, "导出样例", initMappingRelation());
				// 最大导出数量
				ConfigLoadUtil conf = SpringContextUtil.getBean("configLoadUtil");
				Integer exportMaxRow = conf.getExportMaxRow();
				ExcelExportVo result = ExcelUtil.export(request, excelVo, exportMaxRow);
				return ajax(Status.success, result);
			} else {
				return ajax(Status.error, "导出excel不能为空");
			}
		} catch (Exception e) {
			log.error("导出alone_export_data失败", e);
		}
		return ajax(Status.error, "导出excel失败");
	}

	/**
	 * <p>Title: exportDownload
	 * <p>Description: 文件下载通用类 <em>下载完成后会删除文件目录</em>
	 * <p>Modified History:
	 * @author FMJ
	 * @date 2018/2/7 9:31
     * @param request
     *            获取项目路径
     * @param response
     *            输出流
     * @param filePath
     *            文件路径
     * @param fileName
     *            文件名称
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value = "/exportDownload.do")
	public void exportDownload(HttpServletRequest request, HttpServletResponse response, String filePath, String fileName) {
		try {
		    // 下载完后删除文件
            downloadResponse(request, response, filePath, fileName);
		} catch (Exception e) {
			log.error("导出失败", e);
		}
	}

	/**
	 * 导出文件字段
	 * 
	 * @return 表头映射关系
	 */
	private String initMappingRelation() {
		return "DomainId:域名编号|ServiceCode:机房编号|Domain:域名|ServiceContent:服务类型";
	}

    /**
     * <p>Title: initExcelVo
     * <p>Description: 导入文件解析样例
     * @author FMJ
     * @date 2018/2/7 8:45
     * @param map 导入excel行数据
     * @return 初始化后的excelVo
     */
    private ExcelVo initExcelVo(Map<String, Object> map) {
        return new ExcelVo(String.valueOf(map.get("C0") == null ? "" : map.get("C0")),
                String.valueOf(map.get("C1") == null ? "" : map.get("C1")),
                String.valueOf(map.get("C2") == null ? "" : map.get("C2")));
    }
}
