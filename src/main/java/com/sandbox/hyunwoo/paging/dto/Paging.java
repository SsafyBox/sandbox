package com.sandbox.hyunwoo.paging.dto;

import java.sql.Timestamp;

public record Paging (Long id, String title, Timestamp createdAt) {
}
