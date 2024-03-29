package com.act.mapper.common.base.select;

import org.apache.ibatis.annotations.SelectProvider;

import com.act.mapper.provider.base.BaseSelectProvider;

import java.util.List;

/**
 * @author liuzh
 */
public interface SelectAllMapper<T> {

    /**
     * 查询全部结果
     *
     * @return
     */
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    List<T> selectAll();
}
