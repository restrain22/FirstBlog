package com.blog.spring.domain.data;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "reply")
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "post_id", nullable = false)
    private Long post_id;

    @Builder
    public Reply(Long id,Long post_id,String text, String date){
        this.id = id;
        this.post_id = post_id;
        this.text = text;
        this.date = date;
    }
    public Reply(String text, String date){
        this.post_id = post_id;
        this.text = text;
        this.date = date;
    }
}
