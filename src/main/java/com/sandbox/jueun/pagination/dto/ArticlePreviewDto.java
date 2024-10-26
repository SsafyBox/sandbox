package com.sandbox.jueun.pagination.dto;

import java.time.LocalDateTime;

public record ArticlePreviewDto(Long id, String title, LocalDateTime createdAt) {
}
