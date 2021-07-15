package com.bigbone.client.hystrix;

import com.bigbone.client.feign.DemandFeign;
import com.bigbone.common.entity.Demand;
import com.bigbone.common.entity.Result;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DemandHystrix implements FallbackFactory {

    @Override
    public Object create(Throwable throwable) {
        return new DemandFeign() {
            @Override
            public List<Demand> getPassengerDemand(String name, int start, int row) {
                return null;
            }

            @Override
            public List<Demand> getDriverDemand(String address, int start, int row) {
                return null;
            }

            @Override
            public Integer getTotalCounts() {
                return null;
            }

            @Override
            public void deleteById(int id) {

            }

            @Override
            public Result save(Demand demand) {
                return new Result().setCode(499).setMsg("服务降级，现在不允许添加打车需求，请稍后再试！");
            }

//            @Override
//            public Result update(Demand demand) {
//                return null;
//            }
//
//            @Override
//            public Demand findById(int id) {
//                return null;
//            }
        };
    }
}
