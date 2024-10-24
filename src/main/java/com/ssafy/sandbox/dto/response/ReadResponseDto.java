package com.ssafy.sandbox.dto.response;

import com.ssafy.sandbox.domain.TodoEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ReadResponseDto {

    private List<TodoEntity> todos;

}
