package com.ssafy.ssafybox.paging.model.service;

import com.ssafy.ssafybox.paging.model.dto.ArticleDto;
import com.ssafy.ssafybox.paging.model.dto.CursorResponseDto;
import com.ssafy.ssafybox.paging.model.dto.OffsetResponseDto;
import com.ssafy.ssafybox.paging.model.dto.RequestDto;
import com.ssafy.ssafybox.paging.model.repositiory.PagingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PagingServiceImpl implements PagingService {

    private final PagingMapper pagingMapper;

    @Autowired
    public PagingServiceImpl(PagingMapper pagingMapper) {
        this.pagingMapper = pagingMapper;
    }

    // offset
    @Override
    public OffsetResponseDto<ArticleDto> getOffsetArticles(int offset, int size) {

        long totalArticles = pagingMapper.count();
        List<ArticleDto> articles = pagingMapper.offsetPaging(offset, size);

        // totalPage 계산 Math.ceil은 올림 함수
        int totalPage = (int) Math.ceil((double) totalArticles / size);

        // 응답 DTO 생성
        OffsetResponseDto<ArticleDto> responseDto = new OffsetResponseDto<>();
        responseDto.setTotalPage(totalPage);
        responseDto.setArticles(articles);

        System.out.println("offset:" + responseDto.getTotalPage());
        System.out.println("offset:" + responseDto.getArticles().size());
        return responseDto;
    }

    // cursor
    @Override
    public CursorResponseDto<ArticleDto> getCursorArticles(int size, int cursorId) {
        List<ArticleDto> articles = pagingMapper.cursorPaging(size, cursorId);
        CursorResponseDto<ArticleDto> responseDto = new CursorResponseDto<>();

        if (articles.isEmpty()) { // 리스트가 비어있을 경우 처리
            responseDto.setLastId(-1L); // 모든 데이터가 조회된 경우
            responseDto.setArticles(List.of()); // 빈 리스트
        } else {
            Long lastId = articles.get(articles.size() - 1).getId(); // 마지막 ID 설정
            responseDto.setLastId(lastId);
            responseDto.setArticles(articles);
        }
        return responseDto;
    }

    // make
    @Override
    public void insertArticles(RequestDto requestDto) {
        List<ArticleDto> articles = requestDto.getArticles();
        pagingMapper.insertArticles(articles);
    }
}