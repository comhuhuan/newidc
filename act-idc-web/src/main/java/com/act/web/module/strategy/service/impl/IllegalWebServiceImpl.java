/*
 * Copyright (c) www.act-telecom.com and/or its affiliates. All rights reserved.
 * ACT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.act.web.module.strategy.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.act.framework.util.DbUtil;
import com.act.framework.util.PageResult;
import com.act.idc.model.NofilterBlackRule;
import com.act.idc.model.TabSysConfig;
import com.act.mapper.entity.Example;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.act.web.module.common.vo.SelectVo;
import com.act.web.module.strategy.enums.IllegalTypeEnum;
import com.act.web.module.strategy.enums.MatchModelEnum;
import com.act.web.module.strategy.service.IllegalWebService;
import com.act.web.module.strategy.vo.IllegalWebVo;
import com.act.web.util.EhcacheUtil;
import com.act.web.util.StrategyUtil;

/**
 * <p>
 * Title:IllegalWebServiceImpl
 * <p>
 * Description: 违法网站service,ismsc_nofilterblack,ismsc_nofilterblackrule
 * 
 * @author FMJ
 * @date 2018/2/7 17:37
 */
@Service
public class IllegalWebServiceImpl implements IllegalWebService {

	/**
	 * <p>
	 * Title: init
	 * <p>
	 * Description: 初始化免过滤网站
	 * 
	 * @return 指令来源/匹配模式列表/机房列表
	 * @param userId
	 *            用户ID
	 * @param isAdmin
	 *            是否为管理员
	 * @throws Exception
	 * @author FMJ
	 * @date 2018/2/2 10:39
	 */
	@Override
	public IllegalWebVo init(String userId, boolean isAdmin) throws Exception {
		// 指令来源列表
		List<SelectVo> cmdFlagList = StrategyUtil.getCmdFlagList();
		// 匹配模式列表
		List<SelectVo> matchModelList = StrategyUtil.getSelectListByEnum(MatchModelEnum.values(), "Value", "Label");
		// 违法违规情况
		List<SelectVo> illegalTypeList = StrategyUtil.getSelectListByEnum(IllegalTypeEnum.values(), "Value", "Label");
		// 机房列表
		List<SelectVo> serviceCodeList = EhcacheUtil.getServiceCodeList(userId, isAdmin);
		return new IllegalWebVo(cmdFlagList, illegalTypeList, matchModelList, serviceCodeList);

	}

	/**
	 * <p>
	 * Title: pagingList
	 * <p>
	 * Description: 分页查询 违法网站列表 ismsc_nofilterblack.datatype
	 * =2/ismsc_nofilterblackrule 列表展示：违法网站名称/违法网站指令ID/违法网站类型/违法违规情况/
	 * 操作人员/创建时间/过期时间/监测状态/封堵状态/操作/处置
	 * 
	 * @param page
	 *            分页属性
	 * @param illegalWebVo
	 *            查询条件
	 * @return 分页结果集
	 * @throws Exception
	 * @author FMJ
	 * @date 2018/2/2 10:39
	 *
	 */
	@Override
	public PageResult<IllegalWebVo> pagingList(PageResult<IllegalWebVo> page, IllegalWebVo illegalWebVo)
			throws Exception {
		StringBuilder sql = new StringBuilder(
				" select info.idccommandid,nofilterblack_name as name,info.commandid,info.type,info.illegaltype, "
                        + " info.owner,info.timestamp,TIMESTAMPDIFF(year, info. timestamp, info.expiredtime) as iswu,info.expiredtime,info.cmdflag,info.operationtype,info.status,info.isstop "
                        + " case info.cmdflag when 1 then case info.`status` when 1 then '待下发' when 2 then '下发成功' when 3 then '取消成功' end else '' end as statusLable "
                        + " from (select SUBSTRING_INDEX(group_concat(distinct b.idccommandid order by b.timestamp desc), ',', 1) as idccommandid "
						+ " from ismsc_nofilterblack b inner join ismsc_nofilterblackrule rule on b.idccommandid = rule.idccommandid "
						// datatype = 2 标识违法网站 根据当前系统过滤指令来源
						+ " where 1 = 1 and b.datatype = 2 and b.cmdflag in ("
						+ (StrategyUtil.validateCu() ? "0,1" : "1,2") + ") group by b.commandid) tmp "
						+ " inner join ismsc_nofilterblack info on tmp.idccommandid = info.idccommandid order by info. timestamp desc ");

        List<Object> params = new ArrayList<>();
		if (illegalWebVo != null) {
			// 违法网站名称
			String nameQuery = illegalWebVo.getNameQuery();
			if (StringUtils.isNotEmpty(nameQuery)) {
				sql.append(" and info.nofilterblack_name like ? ");
				params.add("%" + nameQuery + "%");
			}
			// 违法网站指令ID
			Long commandIdQuery = illegalWebVo.getCommandIdQuery();
			if (commandIdQuery != null) {
				sql.append(" info info.commandId = ? ");
				params.add(commandIdQuery);
			}
			// 下发类型 1=待下发,2=下发,3=取消
			String statusQuery = illegalWebVo.getStatusQuery();
			if (StringUtils.isNotEmpty(statusQuery)) {
				sql.append(" and info.status = ? ");
				params.add(statusQuery);
			}
			// 违法网站类型 1=域名,2=IP
			Integer typeQuery = illegalWebVo.getTypeQuery();
			if (typeQuery != null) {
				sql.append(" and info.type = ? ");
				params.add(typeQuery);
			}
			// 机房名称
			String serviceCodeQuery = illegalWebVo.getServiceCodeQuery();
			if (StringUtils.isNotEmpty(serviceCodeQuery)) {
				sql.append(" and rule.service_code = ? ");
				params.add(serviceCodeQuery);
			}
			// 策略内容
			String contentQuery = illegalWebVo.getContentQuery();
			if (StringUtils.isNotEmpty(contentQuery)) {
				sql.append(
						" and if (rule.valueend, concat_ws('-', rule.valuestart, rule.valueend), rule.valuestart) like ? ");
				params.add("%" + contentQuery + "%");
			}
			// 开始时间 yyyy-MM-dd
			String dateStartQuery = illegalWebVo.getDateStartQuery();
			if (StringUtils.isNotEmpty(dateStartQuery)) {
				sql.append(" and SUBSTR(info.timeStamp,1,10) >= ? ");
				params.add(dateStartQuery);
			}
			// 结束时间 yyyy-MM-dd
			String dateEndQuery = illegalWebVo.getDateEndQuery();
			if (StringUtils.isNotEmpty(dateEndQuery)) {
				sql.append(" and SUBSTR(info.timeStamp,1,10) <= ? ");
				params.add(dateEndQuery);
			}
			// 指令来源
			Integer cmdFlagQuery = illegalWebVo.getCmdFlagQuery();
			if (cmdFlagQuery != null) {
				sql.append(" and info.cmdflag = ? ");
				params.add(cmdFlagQuery);
			}
		}
		Object[] param = new Object[params.size()];
		for (int i = 0; i < params.size(); i++) {
			param[i] = params.get(i);
		}
		PageResult<IllegalWebVo> result = DbUtil.queryPageForObjectPageResult(sql.toString(), IllegalWebVo.class,
				page.getPageIndex(), page.getPageSize(), param);

		// 加载  封堵状态 操作
		if (CollectionUtils.isNotEmpty(result.getRows())) {
			deassignPageRows(result.getRows());
		}
		return result;
	}
    
	/**
	 * <p>Title: deassignPageRows
	 * <p>Description: 加载 封堵状态 操作
	 * @author FMJ
	 * @date 2018/2/8 17:23
	 * @param illegalWebVos 查询结果list
	 */
    private void deassignPageRows(List<IllegalWebVo> illegalWebVos) {
       List<Object> idcCommandIds = new ArrayList<>();
        for(IllegalWebVo illegalWebVo : illegalWebVos){
            // 下发状态不是待下发
            if(!"1".equals(illegalWebVo.getStatus())){
                idcCommandIds.add(illegalWebVo.getIdcCommandId());
            }
        }
        if(CollectionUtils.isNotEmpty(idcCommandIds)){
            Example example = new Example(NofilterBlackRule.class);
            example.createCriteria().andIn("idccommandid",idcCommandIds);
            List excsList = NofilterBlackRule.getDao().selectByExample(example);
        }
    }
}
