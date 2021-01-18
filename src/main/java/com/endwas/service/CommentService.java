package com.endwas.service;

import com.endwas.entity.Comment;

import java.util.List;

/**
 * @author ：endwas
 * @description：博客评论业务层接口
 * @date ：Created in 2021/1/10 15:44
 * @url ：https://endwas.cn
 * @version：1.0
 */
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    int saveComment(Comment comment);

//    查询子评论
//    List<Comment> getChildComment(Long blogId,Long id);

    //删除评论
    void deleteComment(Comment comment,Long id);

}
