package com.bigbone.client.controller;

import com.bigbone.client.feign.DemandFeign;
import com.bigbone.client.feign.OrderFeign;
import com.bigbone.common.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/client/order")
public class OrderController {
    @Autowired
    OrderFeign orderFeign;
    @Autowired
    DemandFeign demandFeign;

    /*根据司机id查询订单*/
    @GetMapping("/findByDriver")
    @ResponseBody
    public Result findByDriver(@RequestParam("page")int page, @RequestParam("limit")int limit, HttpSession session){
        System.out.println("进入该后端");
        Driver driver = (Driver) session.getAttribute("driver");
        List<Order> orders = orderFeign.findByDriver(driver.getUsername(), (page - 1) * limit, limit);
        System.out.println(orders);
        return new Result(0,"",orderFeign.getTotalCountsByDriver(driver.getUsername()), orders);
    }

    @PostMapping("save/{deid}/{departure}/{destination}/{name}")
    @ResponseBody
    public Msg save(@PathVariable("deid")int deid, @PathVariable("departure") String departure,
                    @PathVariable("destination") String destination,
                    @PathVariable("name") String name, HttpSession session){
        Driver driver = (Driver) session.getAttribute("driver");
//        Demand demand = new Demand(deid, departure, destination, name);
        Order order = new Order();
        order.setDeparture(departure).setDestination(destination)
                .setPassenger(name).setDriver(driver.getUsername())
        .setPrice(Integer.parseInt(destination,16) - Integer.parseInt(departure,16));
//        System.out.println(order);
        orderFeign.save(order);
        demandFeign.deleteById(deid);
        return Msg.success();
    }

    @GetMapping("findByPassenger")
    @ResponseBody
    public Result findByPassenger(HttpSession session,
                              @RequestParam("page")int page, @RequestParam("limit")int limit){
        Passenger passenger = (Passenger) session.getAttribute("passenger");
        List<Order> orders = orderFeign.findByPassenger(passenger.getUsername(),(page-1)*limit, limit);
        return new Result(0, "", orderFeign.getTotalCountsByPassenger(passenger.getUsername()), orders);
    }

    @GetMapping("updateState/{id}")
    @ResponseBody
    public Msg updateState(@PathVariable("id") int id){
        orderFeign.updateState(id);
        return Msg.success();
    }

    @PostMapping("/addComment")
    public String addComment(@RequestParam("name")String name, @RequestParam("content")String content){
        Comment comment = new Comment().setName(name).setContent(content);
        orderFeign.save(comment);
        return "redirect:/demand_add.html";
    }

    private List<Comment> comments = null;

    @PostMapping("/findComments")
    public String findComments(@RequestParam("name") String name){
        if (comments == null){
            comments = orderFeign.findComments(name);
        }
//        System.out.println(comments);
        return "redirect:/comment_show.html";
    }

    @GetMapping("/getComments")
    @ResponseBody
    public Result getComments(@RequestParam("page")int page, @RequestParam("limit")int limit, HttpSession session){
        List<Comment> comment = comments;
        comments = null;
//        System.out.println(comment);
        return new Result(0,"",10, comment);
    }
}
