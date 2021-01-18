package com.endwas.dao;

import com.endwas.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：endwas
 * @description：博客评论持久层
 * @date ：Created in 2021/1/10 15:52
 * @url ：https://endwas.cn
 * @version： 1.0
 */
@Mapper
@Repository
public interface CommentDao {
    List<Comment> findByBlogIdParentIdNull(Long blogId, long blogParentId);

    List<Comment> findByBlogIdParentIdNotNull(Long blogId, Long id);

    List<Comment> findByBlogIdAndReplayId(Long blogId, Long childId);

    int saveComment(Comment comment);

    void deleteComment(Long id);
}
