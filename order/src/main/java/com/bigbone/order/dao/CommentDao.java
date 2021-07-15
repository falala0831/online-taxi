package com.bigbone.order.dao;

import com.bigbone.common.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {
    @Insert("insert into t_comment(name, content) values(#{name}, #{content})")
    void save(Comment comment);

    @Select("select id, name, content from t_comment where name = #{name}")
    List<Comment> getCommentByName(@Param("name") String name);
}
