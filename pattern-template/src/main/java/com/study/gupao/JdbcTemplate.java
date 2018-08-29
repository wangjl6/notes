package com.study.gupao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 访问数据库模版
 *
 * @author 善变时光
 * @since 2018/5/7
 **/
public class JdbcTemplate {

    /**
     * 获取数据库链接
     * @return Connection
     */
    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return  DriverManager.getConnection
                ("jdbc:mysql://127.0.0.1:3306/mysql","root","root");
    }

    /**
     *  获取preparedstatment
     * @param connection 数据库连接对象
     * @param sql   SQL语句
     * @return PreparedStatement
     */
    private PreparedStatement createPreparedStatement(Connection connection,String sql) throws Exception{
        return connection.prepareStatement(sql);
    }

    private ResultSet createResultSet(PreparedStatement preparedStatement) throws Exception{
        return preparedStatement.executeQuery();
    }

    /**
     * 处理返回结果
     * @param rs ResultSet
     * @param rowMapper 映射接口
     * @return 结果集合
     * @throws Exception
     */
    private List<?> processResult(ResultSet rs,RowMapper rowMapper) throws Exception {
        int rowNum = 1;
        List<Object> resultList = new ArrayList<>();
        while(rs.next()){
            resultList.add(rowMapper.mapRow(rs,rowNum++));
        }
        return resultList;
    }

    /**
     * 执行SQL获取结果集
     * @param sql SQL语句字符串
     * @param rowMapper 映射接口实现
     * @return List 结果集合
     * @throws Exception
     */
    List<?> executeSQL(String sql,RowMapper rowMapper) throws Exception {
        Connection connection = this.getConnection();
        PreparedStatement preparedStatement = this.createPreparedStatement(connection,sql);
        ResultSet resultSet = this.createResultSet(preparedStatement);
        List<?> resultList = this.processResult(resultSet,rowMapper);
        connection.close();
        preparedStatement.close();
        resultSet.close();
        return resultList;
    }


}
