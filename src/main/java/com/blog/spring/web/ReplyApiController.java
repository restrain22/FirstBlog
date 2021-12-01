package com.blog.spring.web;

import com.blog.spring.domain.data.Post;
import com.blog.spring.domain.data.Reply;
import com.blog.spring.service.PostService;
import com.blog.spring.service.ReplyService;
import com.blog.spring.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ReplyApiController {

    private final ReplyService replyService;
    @PostMapping("/reply")
    public ReplyResponseDto saveReply(@RequestBody ReplySaveRequestDto requestDto) {
        Long id = replyService.saveReply(requestDto);
        return replyService.findReplyById(id);
    }

    @GetMapping("/reply/test")
    public String test() {
        return "test";
    }

    @GetMapping("/reply/{replyId}")
    public ReplyResponseDto findReplyById(@PathVariable Long replyId) {
        return replyService.findReplyById(replyId);
    }

    @GetMapping("/reply/all/{postId}")
    public List<Reply> findAllPost(@PathVariable Long postId) {
        return replyService.findAllReply(postId);
    }

    @PutMapping("/reply/{replyId}")
    public ReplyResponseDto updateReply(@PathVariable Long replyId,@RequestBody ReplyUpdateRequestDto requestDto) {
        Long id = replyService.updateReply(replyId,requestDto);
        return replyService.findReplyById(replyId);
    }

    @DeleteMapping("/reply/{replyId}")
    public Long deleteReply(@PathVariable Long replyId) {
        return replyService.deleteReply(replyId);

    }
    
}
