package com.bigbone.client.controller;

import com.bigbone.client.feign.DemandFeign;
import com.bigbone.common.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/client/demand")
public class DemandController {
    @Autowired
    DemandFeign demandFeign;

    @GetMapping("getPassengerDemand")
    @ResponseBody
    public Result getPassengerDemand(@RequestParam("page") int page, @RequestParam("limit") int limit,
                             HttpSession session){
        Passenger passenger = (Passenger) session.getAttribute("passenger");
        List<Demand> demands = demandFeign.getPassengerDemand(passenger.getUsername(),(page - 1) * limit, limit);
        System.out.println(demands);
        return new Result(0, "", demandFeign.getTotalCounts(), demands);
    }

    @GetMapping("getDriverDemand")
    @ResponseBody
    public Result getDriverDemand(@RequestParam("page") int page, @RequestParam("limit") int limit,
                                     HttpSession session){
        Driver driver = (Driver) session.getAttribute("driver");
        List<Demand> demands = demandFeign.getDriverDemand(driver.getAddress(),(page - 1) * limit, limit);
        return new Result(0, "", demandFeign.getTotalCounts(), demands);
    }

    @GetMapping("deleteById/{id}")
    public String deleteById(@PathVariable("id") int id){
        demandFeign.deleteById(id);
        return "redirect:/demand_add.html";
    }

    // 这里仅仅是测试服务降级，因为前台没用ajax提交，所以这里没法将消息响应给前端
    @PostMapping("save")
    public String save(Demand demand, HttpSession session){
        Passenger passenger = (Passenger) session.getAttribute("passenger");
        demand.setName(passenger.getUsername()).setDeparture(passenger.getAddress());
        Result vo = demandFeign.save(demand);
        return "redirect:/demand_manage.html";
    }

//    @GetMapping("findById/{id}")
//    @ResponseBody
//    public Msg findById(@PathVariable("id") int id){
//        Demand demand = demandFeign.findById(id);
//        return Msg.success().add("Demand",demand);
//    }

    /*修改菜品*/
//    @PostMapping("/update")
//    @ResponseBody
//    public Msg update(Demand demand){
//        Result vo = demandFeign.update(demand);
//        if(vo.getCode()==200){
//            return Msg.success().add("msg", vo.getMsg());
//        }else{
//            return Msg.fail().add("msg", vo.getMsg());
//        }
//    }
}
