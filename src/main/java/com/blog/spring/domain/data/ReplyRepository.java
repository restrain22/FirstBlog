package com.blog.spring.domain.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply,Long> {
    @Query(nativeQuery = true,value = "SELECT * FROM reply a WHERE a.post_id=?1 ORDER BY a.id ASC")
    List<Reply> replyListAll(Long postId);

}
