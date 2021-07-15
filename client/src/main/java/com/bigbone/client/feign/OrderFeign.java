package com.bigbone.client.feign;

import com.bigbone.common.entity.Comment;
import com.bigbone.common.entity.Order;
import com.bigbone.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("order")
public interface OrderFeign {
    @PostMapping("/order/save")
    void save(@RequestBody Order order);

    @GetMapping("/order/findByDriver/{Driver}/{start}/{row}")
    List<Order> findByDriver(@PathVariable("Driver") String Driver, @PathVariable("start") int start, @PathVariable("row") int row);


    @GetMapping("/order/getTotalCountsByDriver/{Driver}")
    int getTotalCountsByDriver(@PathVariable("Driver") String Driver);

    @GetMapping("/order/findByPassenger/{name}/{start}/{row}")
    List<Order> findByPassenger(@PathVariable("name") String name,@PathVariable("start") int start, @PathVariable("row") int row);

    @GetMapping("/order/getTotalCountsByPassenger/{name}")
    int getTotalCountsByPassenger(@PathVariable("name") String name);

    @GetMapping("/order/updateState/{id}")
    void updateState(@PathVariable("id") int id);

    @GetMapping("/order/getScore/{name}")
    int getScore(@PathVariable("name") String name);

    @PostMapping("/order/addComment")
    Result save(@RequestBody Comment comment);

    @GetMapping("/order/findComments/{name}")
    List<Comment> findComments(@PathVariable("name") String name);
}
