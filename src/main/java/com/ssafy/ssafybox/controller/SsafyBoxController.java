package com.ssafy.ssafybox.controller;

import com.ssafy.ssafybox.model.dto.RequestDto;
import com.ssafy.ssafybox.model.dto.ResponseDto;
import com.ssafy.ssafybox.model.dto.TodoDto;
import com.ssafy.ssafybox.model.service.SsafyboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@RestController
//@RequestMapping("/todos")
public class SsafyBoxController {

    private final SsafyboxService ssafyboxService;

    @Autowired
    public SsafyBoxController(SsafyboxService ssafyboxService) {
        this.ssafyboxService = ssafyboxService;
    }

    // GET 요청: 할 일 조회
    @GetMapping("/todos")
    public ResponseDto readAllTodo() throws SQLException {
        HashMap<String, List<TodoDto>> hm = new HashMap<>();
        List<TodoDto> todos = ssafyboxService.readAllTodo(); // 할 일 목록 가져오기
        hm.put("todos", todos);
        return new ResponseDto("정상적으로 요청되었습니다.", todos);
    }

    // POST 요청: 새로운 할 일 생성
    @PostMapping("/todos")
    public ResponseDto createTodo(@RequestBody RequestDto requestDto) throws SQLException {
        ssafyboxService.createTodo(requestDto.getContent());
        Long todoId = ssafyboxService.readTodo(requestDto.getContent());
        return new ResponseDto(todoId + "의 todo가 생성되었습니다.");
    }

    // PATCH 요청: 할 일 수정
    @PatchMapping("/todos/{todoId}")
    public ResponseDto updateTodo(@PathVariable long todoId) throws SQLException {
        ssafyboxService.updateTodo(todoId);
        return new ResponseDto(todoId + "의 completed가 정상적으로 토글되었습니다.");
    }

    // DELETE 요청: 할 일 삭제
    @DeleteMapping("/todos/{todoId}")
    public ResponseDto deleteTodo(@PathVariable long todoId) throws SQLException {
        ssafyboxService.deleteTodo(todoId);
        return new ResponseDto(todoId + "의 todo가 삭제되었습니다.");
    }

}
