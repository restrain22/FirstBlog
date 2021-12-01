package com.blog.spring.web.dto;

import com.blog.spring.domain.data.Post;
import com.blog.spring.domain.user.Report;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.PostUpdate;

@NoArgsConstructor
@Getter
public class PostSaveRequestDto {

    private String title;
    private String text;
    private String date;
    @Builder
    public PostSaveRequestDto(String title, String text, String date) {
        this.title = title;
        this.text = text;
        this.date = date;
    }

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .text(text)
                .date(date)
                .build();
    }



}
