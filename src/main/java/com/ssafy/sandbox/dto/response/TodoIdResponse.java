package com.ssafy.sandbox.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
public class TodoIdResponse {
    private Long id;

    @Builder
    public TodoIdResponse(Long id) {
        this.id = id;
    }
}