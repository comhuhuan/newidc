/*
 * Copyright (c) www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.act.web.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.ListOrderedMap;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>Title:ExcelUploadUtil
 * <p>Description:excel导入工具类
 * @author FMJ
 * @date 2018/2/6 9:28
 */
public class ExcelUploadUtil {

    /**
     * <p>Title: parseData
     * <p>Description: 解析文件捕获到异常时或返回为空时前端需提示,通过文件后缀 使用不用的解析方法
     * @author FMJ
     * @date 2018/2/7 8:54
     * @param file 上传文件
     * @return 解析后的map list对象
     * @throws Exception
     */
    public static List<Map<String, Object>> parseData(MultipartFile file) throws Exception {
        String sheetType = file.getOriginalFilename().substring((file.getOriginalFilename()).lastIndexOf('.') + 1);
        if ("xlsx".equalsIgnoreCase(sheetType)) {
            // 解析xlsx 文件
            return parseExcelByXlsx(file);
        } else if ("xls".equalsIgnoreCase(sheetType) || "et".equalsIgnoreCase(sheetType)) {
            //解析xls 和 et 文件
            return parseExcelByXlsAndEt(file);
        }
        return null;
    }

    /**
     * <p>Title: parseExcelByXlsx
     * <p>Description: 解析 MultipartFile 为 .xlsx 后缀的文件
     * @author FMJ
     * @date 2018/2/7 8:53
     * @param file 上传文件
     * @return 解析后的map list对象
     * @throws Exception
     */
    private static List<Map<String, Object>> parseExcelByXlsx(MultipartFile file) throws Exception {
        List<Map<String, Object>> result = new ArrayList<>();
        if (null != file) {
            XSSFWorkbook workbook = initFileXlsx(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            for (int row = 0; row < sheet.getLastRowNum() + 1; ++row) {
                int rowContent = 0;
                Map<String, Object> map = new ListOrderedMap();
                try {
                    int i = 0;
                    XSSFCell timeCell;
                    XSSFRow aRow = sheet.getRow(row);
                    for (int j = 0; j < aRow.getLastCellNum(); j++) {
                        timeCell = aRow.getCell(j);
                        String temp = "";
                        if (timeCell != null) {
                            temp = timeCell.toString();
                            if (null != temp) {
                                int cellType = timeCell.getCellType();
                                if (cellType == 0) {
                                    if (temp.indexOf("月") > 0) {
                                        dateFormat.setLenient(false);
                                        temp = dateFormat.format(timeCell
                                                .getDateCellValue());
                                    } else {
                                        temp = timeCell.getRawValue().trim();
                                    }
                                }
                            }
                        }
                        map.put("C" + i, temp);
                        i++;
                        // 目前最多支持导入60栏
                        if (60 < i) {
                            break;
                        }
                        if (temp != null && !"".equalsIgnoreCase(temp)) {
                            rowContent++;
                        }
                    }
                    if (rowContent == 0) {
                        break;
                    }

                } finally {
                    if (rowContent != 0) {
                        result.add(map);
                    }
                }
            }
        }
        return result;
    }


    /**
     * <p>Title: parseExcelByXlsAndEt
     * <p>Description: 解析 MultipartFile 为 .xls 和 .et 后缀的文件
     * @author FMJ
     * @date 2018/2/7 8:53
     * @param file 上传文件
     * @return 解析后的map list对象
     * @throws Exception
     */
    private static List<Map<String, Object>> parseExcelByXlsAndEt(MultipartFile file) throws Exception {
        List<Map<String, Object>> result = new ArrayList<>();
        if (null != file) {
            HSSFWorkbook workbook = initFileXlsAndEt(file);
            HSSFSheet sheet = workbook.getSheetAt(0);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            DecimalFormat df = new DecimalFormat("#");
            for (int row = 0; row < sheet.getLastRowNum() + 1; ++row) {
                int rowContent = 0;
                Map<String, Object> map = new ListOrderedMap();
                try {
                    int i = 0;
                    HSSFCell timeCell;
                    HSSFRow aRow = sheet.getRow(row);
                    for (int j = 0; j < aRow.getLastCellNum(); j++) {
                        timeCell = aRow.getCell(j);
                        String temp = "";
                        if (timeCell != null) {
                            temp = timeCell.toString();
                            if (null != temp) {
                                int cellType = timeCell.getCellType();
                                if (cellType == 0) {
                                    if (temp.indexOf("月") > 0) {
                                        dateFormat.setLenient(false);
                                        temp = dateFormat.format(timeCell
                                                .getDateCellValue());
                                    } else {
                                        temp = df.format(timeCell
                                                .getNumericCellValue());
                                    }
                                }
                            }
                        }
                        map.put("C" + i, temp);

                        i++;
                        //目前只支持60栏导入
                        if (60 < i) {
                            break;
                        }
                        if (temp != null && !"".equalsIgnoreCase(temp)) {
                            rowContent++;
                        }
                    }
                    if (rowContent == 0) {
                        break;
                    }
                } finally {
                    if (rowContent != 0) {
                        result.add(map);
                    }
                }
            }
        }
        return result;
    }


    /**
     * <p>Title: initFileXlsAndEt
     * <p>Description: MultipartFile 写入流 返回工作空间 处理xls 或者 et 结尾的文件
     * @author FMJ
     * @date 2018/2/7 8:55
     * @param  file 解析的文件
     * @return 返回 {@link org.apache.poi.hssf.usermodel.HSSFWorkbook} 实例
     * @throws IOException
     */
    private static HSSFWorkbook initFileXlsAndEt(MultipartFile file) throws IOException {
        InputStream is = null;
        try {
            is = file.getInputStream();
            return new HSSFWorkbook(is);
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    /**
     * <p>Title: initFileXlsx
     * <p>Description: MultipartFile 写入流 返回工作空间 处理xlsx后缀的文件
     * @author FMJ
     * @date 2018/2/7 8:55
     * @param  file 解析的文件
     * @return 返回 {@link org.apache.poi.xssf.usermodel.XSSFWorkbook} 实例
     * @throws IOException
     */
    private static XSSFWorkbook initFileXlsx(MultipartFile file) throws IOException {
        InputStream is = null;
        try {
            is = file.getInputStream();
            return new XSSFWorkbook(is);
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

}
