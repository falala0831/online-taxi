package com.bigbone.order.service;

import com.bigbone.common.entity.Comment;

import java.util.List;

public interface CommentService {
    void save(Comment comment);

    List<Comment> getCommentByName(String name);
}
