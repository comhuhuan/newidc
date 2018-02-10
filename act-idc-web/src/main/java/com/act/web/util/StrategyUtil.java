/*
 * Copyright (c) www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.act.web.util;

import com.act.web.constant.CommonContant;
import com.act.web.module.common.vo.SelectVo;
import com.act.web.module.strategy.enums.CuCmdFlagEnum;
import com.act.web.module.strategy.enums.EuCmdFlagEnum;
import com.act.web.module.strategy.enums.MatchModelEnum;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Title:StrategyUtil
 * <p>
 * Description:策略相关工具类
 *
 * @author FMJ
 * @date 2018/2/8 8:15
 */
public class StrategyUtil {

    /**
     * <p>
     * Title: validateCu
     * <p>
     * Description: 判断系统是否为cu
     *
     * @author FMJ
     * @date 2018/2/8 8:17
     */
    public static boolean validateCu() throws Exception {
        String curSystem = EhcacheUtil.getConfigByConfigId(CommonContant.CUR_SYSTEM);
        // cu系统
        return "1".equals(curSystem);
    }

    
	/**
	 * <p>
	 * Title: getCmdFlagList
	 * <p>
	 * Description: 得到指令来源列表
	 * 
	 * @author FMJ
	 * @date 2018/2/8 8:17
	 */
	public static List<SelectVo> getCmdFlagList() throws Exception {
		String curSystem = EhcacheUtil.getConfigByConfigId(CommonContant.CUR_SYSTEM);
		List<SelectVo> cmdFlagList;
        // cu系统
		String cuSystem = "1";
		if (cuSystem.equals(curSystem)) {
            cmdFlagList = getSelectListByEnum(CuCmdFlagEnum.values(),"Value","Label");
		} else {
			// eu系统
            cmdFlagList = getSelectListByEnum(EuCmdFlagEnum.values(),"Value","Label");
		}
		return cmdFlagList;
	}

    /**
     * <p>Title: getSelectListByEnum
     * <p>Description: 根据枚举列表得到键值对list
     * @author FMJ
     * @date 2018/2/8 10:56
     * @param items 枚举列表
     * @param value 枚举值属性 首字母大写
     * @param label 枚举显示属性 首字母大写
     * @return 键值对list
     * @throws Exception
     */
    public static List<SelectVo> getSelectListByEnum(Enum[] items, String value, String label) throws Exception {
        List<SelectVo> resultList = new ArrayList<>();
        for (Enum item : items) {
            Class<?> cls = item.getClass();
            Method valueMethod = cls.getMethod("get" + value);
            Method labelMethod = cls.getMethod("get" + label);
            resultList.add(new SelectVo<>(valueMethod.invoke(item), labelMethod.invoke(item).toString()));
        }
        return resultList;
    }
}