package com.bigbone.order.service;

import com.bigbone.common.entity.Comment;
import com.bigbone.order.dao.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentDao commentDao;

    @Override
    public void save(Comment comment) {
        commentDao.save(comment);
    }

    @Override
    public List<Comment> getCommentByName(String name) {
        return commentDao.getCommentByName(name);
    }
}
