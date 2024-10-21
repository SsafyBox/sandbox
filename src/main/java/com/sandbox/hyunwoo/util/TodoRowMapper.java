package com.sandbox.hyunwoo.util;


import com.sandbox.hyunwoo.crud.dto.Todo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoRowMapper implements RowMapper<Todo> {
    @Override
    public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Todo(
                rs.getLong("id"),
                rs.getString("content"),
                rs.getBoolean("completed")
        );
    }

}
