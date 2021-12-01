package com.blog.spring.service;

import com.blog.spring.domain.data.PostRepository;
import com.blog.spring.domain.data.Reply;
import com.blog.spring.domain.data.ReplyRepository;
import com.blog.spring.web.dto.ReplyResponseDto;
import com.blog.spring.web.dto.ReplySaveRequestDto;
import com.blog.spring.web.dto.ReplyUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final PostRepository postRepository;
    
    @Transactional
    public Long saveReply(ReplySaveRequestDto requestDto) {
        postRepository.findById(requestDto.getPost_id())
                .orElseThrow(()->new IllegalArgumentException("해당 게시물이 없습니다."));
        return replyRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long updateReply(Long id, ReplyUpdateRequestDto requestDto) {
        Reply entity = replyRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 댓글이 없습니다. id=" + id));
        entity.setDate(requestDto.getDate());
        entity.setText(requestDto.getText());
        return replyRepository.save(entity).getId();
    }

    @Transactional(readOnly = true)
    public ReplyResponseDto findReplyById(Long id) {
        Reply entity = replyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다."));
        return new ReplyResponseDto(entity);
    }

    @Transactional
    public Long deleteReply(Long id) {
        replyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id=" + id));
        replyRepository.deleteById(id);

        return id;
    }

    public List<Reply> findAllReply(Long postId) {
        return replyRepository.replyListAll(postId);
    }

}
