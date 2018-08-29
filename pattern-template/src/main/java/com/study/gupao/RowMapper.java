package com.study.gupao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 映射结果接口
 *
 * @author 善变时光
 * @since 2018/5/7
 **/
public interface RowMapper {

    /**
     * 映射行接口方法
     * @param resultSet 结果集合
     * @param rowNum 行号
     * @return T
     * @exception SQLException
     */
    public <T> T mapRow(ResultSet resultSet,int rowNum) throws SQLException;
}
