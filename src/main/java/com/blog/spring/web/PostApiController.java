package com.blog.spring.web;

import com.blog.spring.domain.data.Post;
import com.blog.spring.web.dto.PostResponseDto;
import com.blog.spring.web.dto.PostSaveRequestDto;
import com.blog.spring.service.PostService;
import com.blog.spring.web.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    @PostMapping("/post")
    public PostResponseDto savePost(@RequestBody PostSaveRequestDto requestDto) {
        Long id = postService.savePost(requestDto);
        return postService.findPostById(id);
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/post/{postId}")
    public PostResponseDto findPostById(@PathVariable Long postId) {
        return postService.findPostById(postId);
    }

    @GetMapping("/post/all")
    public List<Post> findAllPost() {
        return postService.findAllPost();
    }

    @PutMapping("/post/{postId}")
    public PostResponseDto updatePost(@PathVariable Long postId,@RequestBody PostUpdateRequestDto requestDto) {
        Long id = postService.updatePost(postId,requestDto);
        return postService.findPostById(postId);
    }

    @DeleteMapping("/post/{postId}")
    public Long deletePost(@PathVariable Long postId) {
        return postService.deletePost(postId);

    }
}
