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
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "date", nullable = false)
    private String date;

    @Builder
    public Post(Long id,String title, String text, String date){
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
    }
    public Post(String title, String text, String date){
        this.title = title;
        this.text = text;
        this.date = date;
    }
    public Post(String text, String date){
        this.text = text;
        this.date = date;
    }
}
