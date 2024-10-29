package com.ssafy.sandbox.paging.service;

import com.ssafy.sandbox.paging.domain.ArticleEntity;
import com.ssafy.sandbox.paging.dto.request.RequestDto;
import com.ssafy.sandbox.paging.dto.response.CursorResponseDto;
import com.ssafy.sandbox.paging.dto.response.OffsetResponseDto;
import com.ssafy.sandbox.paging.repository.PagingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PagingService {
    private final PagingRepository pagingRepository;

    public OffsetResponseDto offsetPagination(Pageable pageable) {
        OffsetResponseDto offsetResponseDto = new OffsetResponseDto();
        Page<ArticleEntity> page = pagingRepository.findAllByOrderByIdDesc(pageable);
        offsetResponseDto.setTotalPage(page.getTotalPages());
        offsetResponseDto.setArticles(page.getContent());
        return offsetResponseDto;
    }

    public CursorResponseDto cursorPagination(Pageable pageable, Long cursorId) {
        CursorResponseDto cursorResponseDto = new CursorResponseDto();
        Page<ArticleEntity> page;
        if (cursorId == 0) {
            page = pagingRepository.findAllByOrderByIdDesc(pageable);
        } else {
            page = pagingRepository.findByIdLessThanOrderByIdDesc(cursorId, pageable);
        }
        List<ArticleEntity> articles = page.getContent();

        if (articles.isEmpty()) {
            cursorResponseDto.setArticles(new ArrayList<>());
            cursorResponseDto.setLastId(null);
        } else {
            cursorResponseDto.setArticles(articles);
            cursorResponseDto.setLastId(articles.get(articles.size()-1).getId());
        }
        return cursorResponseDto;
    }

    public void addData(RequestDto requestDto) {
        pagingRepository.saveAll(requestDto.getArticles());
    }
}
