package com.blog.spring.web.dto;

import com.blog.spring.domain.data.Reply;
import lombok.Builder;
import lombok.Getter;

@Getter

public class ReplyUpdateRequestDto {

    private String text;
    private String date;

    @Builder
    public ReplyUpdateRequestDto(String text, String date) {
        this.text = text;
        this.date = date;
    }

    public Reply toEntity() {
        return Reply.builder()
                .text(text)
                .date(date)
                .build();
    }
    
    
    
}
