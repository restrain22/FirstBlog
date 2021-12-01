package com.blog.spring.web.dto;

import com.blog.spring.domain.data.Reply;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ReplySaveRequestDto {

    private Long post_id;
    private String text;
    private String date;
    @Builder
    public ReplySaveRequestDto(Long post_id, String text, String date) {
        this.post_id = post_id;
        this.text = text;
        this.date = date;
    }

    public Reply toEntity() {
        return Reply.builder()
                .post_id(post_id)
                .text(text)
                .date(date)
                .build();
    }

}
