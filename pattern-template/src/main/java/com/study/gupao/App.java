package com.study.gupao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        List list = jdbcTemplate.executeSQL("select * from user", new RowMapper() {
            @Override
            public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                Map resultMap = new HashMap<>();
                resultMap.put("name",resultSet.getString("user"));
                return resultMap;
            }
        });
        System.out.println(list);
    }
}
