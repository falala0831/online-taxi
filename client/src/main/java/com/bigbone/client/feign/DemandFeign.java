package com.bigbone.client.feign;

import com.bigbone.client.hystrix.DemandHystrix;
import com.bigbone.common.entity.Demand;
import com.bigbone.common.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "demand", fallbackFactory = DemandHystrix.class) // yaml要配置feign.hystrix.feign=true
public interface DemandFeign {
    @GetMapping("/demand/getPassengerDemand/{name}/{start}/{row}")
    List<Demand> getPassengerDemand(@PathVariable("name") String name, @PathVariable("start") int start, @PathVariable("row") int row);

    @GetMapping("/demand/getDriverDemand/{address}/{start}/{row}")
    List<Demand> getDriverDemand(@PathVariable("address") String address, @PathVariable("start") int start, @PathVariable("row") int row);

    @GetMapping("/demand/getTotalCounts")
    Integer getTotalCounts();


    @GetMapping("/demand/deleteById/{id}")
    void deleteById(@PathVariable("id") int id);



    @PostMapping("/demand/save")
    Result save(Demand demand);

//    @PostMapping("/demand/update")
//    Result update(Demand demand);

//    @GetMapping("/demand/findById/{id}")
//    Demand findById(@PathVariable("id") int id);
}
