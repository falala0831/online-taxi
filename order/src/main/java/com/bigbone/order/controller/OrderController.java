package com.bigbone.order.controller;

import com.bigbone.common.entity.Comment;
import com.bigbone.common.entity.Demand;
import com.bigbone.common.entity.Order;
import com.bigbone.common.entity.Result;
import com.bigbone.order.service.CommentService;
import com.bigbone.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    CommentService commentService;
    
    @Value("${server.port}")
    private String port;

    @GetMapping("/getPort")
    public String getPort(){
        return "port:"+this.port;
    }

    @GetMapping("findByDriver/{Driver}/{start}/{row}")
    public List<Order> findByDriver(@PathVariable("Driver") String Driver, @PathVariable("start") int start, @PathVariable("row") int row){
        return orderService.findByDriver(Driver, start, row);
    }

    @PostMapping("save")
    public void save(@RequestBody Order order){
        System.out.println(order);
        orderService.save(order);
    }

    @GetMapping("getTotalCountsByDriver/{Driver}")
    public int getTotalCountsByDriver(@PathVariable("Driver") String Driver){
        return orderService.getTotalCountsByDriver(Driver);
    }

    @GetMapping("findByPassenger/{name}/{start}/{row}")
    List<Order> findByPassenger(@PathVariable("name") String name, @PathVariable("start") int start, @PathVariable("row") int row){
        List<Order> orders = orderService.findByPassenger(name, start, row);
//        for (Order order : orders) {
//            System.out.println(order);
//        }
        return orders;
    }

    @GetMapping("getTotalCountsByPassenger/{name}")
    int getTotalCountsByPassenger(@PathVariable("name") String name){
        return orderService.getTotalCountsByPassenger(name);
    }

    @GetMapping("updateState/{id}")
    void updateState(@PathVariable("id") int id){
        orderService.updateState(id);
    }

    @GetMapping("getScore/{name}")
    int getScore(@PathVariable("name") String name){
        return orderService.getScore(name);
    }

    @PostMapping("addComment")
    public Result save(@RequestBody Comment comment){
        commentService.save(comment);
        return new Result().setCode(200).setMsg("添加成功");
    }

    @GetMapping("findComments/{name}")
    public List<Comment> findComments(@PathVariable("name") String name){
        return commentService.getCommentByName(name);
    }

}
