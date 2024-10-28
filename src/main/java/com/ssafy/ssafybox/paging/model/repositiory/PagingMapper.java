package com.ssafy.ssafybox.paging.model.repositiory;

import com.ssafy.ssafybox.paging.model.dto.ArticleDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PagingMapper {

    @Select("SELECT COUNT(*) FROM articles")
    long count();

    // offset
    @Select("SELECT id, title, createdAt " +
            "FROM articles " +
            "ORDER BY id LIMIT #{size} OFFSET #{offset}")
    List<ArticleDto> offsetPaging(@Param("offset") int offset, @Param("size") int size);

    // cursor
    @Select("SELECT id, title, createdAt " +
            "FROM articles " +
            "WHERE id > #{cursorId} " +
            "ORDER BY id LIMIT #{size}")
    List<ArticleDto> cursorPaging(@Param("size") int size, @Param("cursorId") int cursorId);

    //make
    @Insert({
            "<script>",
            "INSERT INTO articles (id, title, createdAt) VALUES ",
            "<foreach collection='articles' item='article' separator=','>",
            "(#{article.id}, #{article.title}, #{article.createdAt})",
            "</foreach>",
            "</script>"
    })
    void insertArticles(@Param("articles") List<ArticleDto> articles);

}
