package com.blog.spring.web.dto;

import com.blog.spring.domain.data.Post;
import com.blog.spring.domain.user.Report;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.PostUpdate;

@NoArgsConstructor
@Getter
public class PostUpdateRequestDto {
    private String text;
    private String date;

    @Builder
    public PostUpdateRequestDto(String text, String date) {
        this.text = text;
        this.date = date;
    }

    public Post toEntity() {
        return Post.builder()
                .text(text)
                .date(date)
                .build();
    }
}

