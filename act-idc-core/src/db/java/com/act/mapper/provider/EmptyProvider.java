package com.act.mapper.provider;

import com.act.mapper.mapperhelper.MapperHelper;
import com.act.mapper.mapperhelper.MapperTemplate;

/**
 * 空方法Mapper接口默认MapperTemplate
 * <p/>
 * 如BaseSelectMapper，接口纯继承，不包含任何方法
 */
public class EmptyProvider extends MapperTemplate {

    public EmptyProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    @Override
    public boolean supportMethod(String msId) {
        return false;
    }
}
