package com.blog.spring.web.dto;

import com.blog.spring.domain.data.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {

    private Long id;
    private String title;
    private String text;
    private String date;

    public PostResponseDto(Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.text = entity.getText();
        this.date = entity.getDate();
    }
}
