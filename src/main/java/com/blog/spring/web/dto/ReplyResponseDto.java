package com.blog.spring.web.dto;

import com.blog.spring.domain.data.Post;
import com.blog.spring.domain.data.Reply;
import lombok.Getter;

@Getter
public class ReplyResponseDto {

    private Long id;
    private Long post_id;
    private String text;
    private String date;

    public ReplyResponseDto(Reply entity) {
        this.id = entity.getId();
        this.post_id = entity.getPost_id();
        this.text = entity.getText();
        this.date = entity.getDate();
    }

}
