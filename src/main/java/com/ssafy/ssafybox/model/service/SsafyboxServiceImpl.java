package com.ssafy.ssafybox.model.service;

import com.ssafy.ssafybox.model.dao.SsafyboxDao;
import com.ssafy.ssafybox.model.dto.TodoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class SsafyboxServiceImpl implements SsafyboxService {

    private final SsafyboxDao ssafyboxDao;

    @Autowired
    public SsafyboxServiceImpl(SsafyboxDao ssafyboxDao) {
        this.ssafyboxDao = ssafyboxDao;
    }

    @Override
    public boolean createTodo(String content) throws SQLException {
        return ssafyboxDao.createTodo(content);
    }

    @Override
    public List<TodoDto> readAllTodo() throws SQLException {
        return ssafyboxDao.readAllTodo();
    }

    @Override
    public boolean updateTodo(Long id) throws SQLException {
        return ssafyboxDao.updateTodo(id);
    }

    @Override
    public boolean deleteTodo(Long id) throws SQLException {
        ssafyboxDao.deleteTodo(id);
        return true;
    }

    @Override
    public Long readTodo(String content) throws SQLException{
        return ssafyboxDao.readTodo(content);
    }
}
