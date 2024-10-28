package com.ssafy.ssafybox.crud.controller;

import com.ssafy.ssafybox.crud.model.dto.RequestDto;
import com.ssafy.ssafybox.crud.model.dto.ResponseDto;
import com.ssafy.ssafybox.crud.model.dto.TodoDto;
import com.ssafy.ssafybox.crud.model.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class CRUDController {

    private final CRUDService CRUDService;

    @Autowired
    public CRUDController(CRUDService CRUDService) {
        this.CRUDService = CRUDService;
    }

    // GET 요청: 할 일 조회
    @GetMapping()
    public ResponseDto readAllTodo() {
        List<TodoDto> todos = CRUDService.readAllTodo(); // 할 일 목록 가져오기
        if(todos != null) return new ResponseDto("정상적으로 요청되었습니다.", todos);
        else return new ResponseDto("요청이 정상적으로 처리되지 않았습니다.");
    }

    // POST 요청: 새로운 할 일 생성
    @PostMapping()
    public ResponseDto createTodo(@RequestBody RequestDto requestDto) {
        boolean flag = CRUDService.createTodo(requestDto.getContent());
        Long todoId = CRUDService.recentTodoId();
        if(flag && todoId != null) return new ResponseDto(todoId + "의 todo가 생성되었습니다.");
        else return new ResponseDto("요청이 정상적으로 처리되지 않았습니다.");
    }

    // PATCH 요청: 할 일 수정
    @PatchMapping("/{todoId}")
    public ResponseDto updateTodo(@PathVariable Long todoId) {
        boolean flag = CRUDService.updateTodo(todoId);
        if(flag) return new ResponseDto(todoId + "의 completed가 정상적으로 토글되었습니다.");
        else return new ResponseDto("요청이 정상적으로 처리되지 않았습니다.");
    }

    // DELETE 요청: 할 일 삭제
    @DeleteMapping("/{todoId}")
    public ResponseDto deleteTodo(@PathVariable Long todoId) {
        boolean flag = CRUDService.deleteTodo(todoId);
        if(flag) return new ResponseDto(todoId + "의 todo가 삭제되었습니다.");
        else return new ResponseDto("요청이 정상적으로 처리되지 않았습니다.");
    }

}
