package com.albedo.java.common.persistence.injector.methods;

import com.albedo.java.common.persistence.injector.SqlInjectorUtil;
import com.albedo.java.util.StringUtil;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

public class LogicFindRelationList extends LogicAbstractCustomMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String tableNameAlias = StringUtil.toFirstLowerCase(modelClass.getSimpleName());
        String sql = SqlInjectorUtil.parseSql(configuration, builderAssistant, SqlCustomMethod.FIND_RELATION_LIST, modelClass, tableInfo,
            sqlWhereEntityWrapper(tableInfo, tableNameAlias));
        SqlSource sqlSource = this.languageDriver.createSqlSource(this.configuration, sql, modelClass);
        return this.addSelectMappedStatement(mapperClass, SqlCustomMethod.FIND_RELATION_LIST.getMethod(), sqlSource, modelClass, tableInfo);
    }



}