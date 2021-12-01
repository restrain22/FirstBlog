package com.blog.spring.domain.data;

import com.blog.spring.web.dto.PostUpdateRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    @Query(nativeQuery = true,value = "SELECT * FROM post a ORDER BY a.id ASC")
    List<Post> postListAll();

}
