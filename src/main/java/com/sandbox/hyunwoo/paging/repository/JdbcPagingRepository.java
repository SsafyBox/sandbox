package com.sandbox.hyunwoo.paging.repository;


import com.sandbox.hyunwoo.paging.dto.Paging;
import com.sandbox.hyunwoo.util.PagingRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcPagingRepository {

    private final JdbcTemplate jdbcTemplate;
    private final PagingRowMapper pagingRowMapper;

    public List<Paging> cursorPaging(Long cursorId, int count) {
        String sql = "select * from paging where id > ? limit ?"; // 0부터 시작
        return jdbcTemplate.query(sql, pagingRowMapper, cursorId, count);
    }

    public List<Paging> offsetPaging(int size, int offset) {
        String sql = "SELECT * FROM paging limit ? OFFSET ?";
        return jdbcTemplate.query(sql, pagingRowMapper, size, offset);
    }

    public int getTotalCount() {
        String sql = "select count(*) from paging";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}