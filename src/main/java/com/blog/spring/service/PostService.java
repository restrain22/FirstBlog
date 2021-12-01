package com.blog.spring.service;


import com.blog.spring.web.dto.PostResponseDto;
import com.blog.spring.web.dto.PostSaveRequestDto;
import com.blog.spring.domain.data.Post;
import com.blog.spring.domain.data.PostRepository;
import com.blog.spring.web.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    @Transactional
    public Long savePost(PostSaveRequestDto requestDto) {
        return postRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long updatePost(Long id, PostUpdateRequestDto requestDto) {
        Post entity = postRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));
        entity.setDate(requestDto.getDate());
        entity.setText(requestDto.getText());
        return postRepository.save(entity).getId();
    }

    @Transactional(readOnly = true)
    public PostResponseDto findPostById(Long id) {
        Post entity = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다."));
        return new PostResponseDto(entity);
    }

    @Transactional
    public Long deletePost(Long id) {
        postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));
        postRepository.deleteById(id);

        return id;
    }

    public List<Post> findAllPost() {
        return postRepository.postListAll();
    }
}
