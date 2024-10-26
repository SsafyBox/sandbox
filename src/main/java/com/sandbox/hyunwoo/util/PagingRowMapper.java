package com.sandbox.hyunwoo.util;

import com.sandbox.hyunwoo.paging.dto.Paging;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PagingRowMapper implements RowMapper<Paging> {
    @Override
    public Paging mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Paging(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getTimestamp("createdAt")
        );
    }
}