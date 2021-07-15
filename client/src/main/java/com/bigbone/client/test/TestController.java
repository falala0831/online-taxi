package com.bigbone.client.test;

import com.bigbone.client.feign.OrderFeign;
import com.bigbone.common.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    OrderFeign orderFeign;

    @GetMapping("/findComments/{name}")
    public Result findComments(@PathVariable("name") String name){
        List<Comment> comments = orderFeign.findComments(name);
        if (comments != null){
            return Result.ok(comments);
        }
        else{
            return Result.error("该用户评论不存在");
        }
    }
}
