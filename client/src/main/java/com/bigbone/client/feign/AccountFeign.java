package com.bigbone.client.feign;

import com.bigbone.common.entity.Driver;
import com.bigbone.common.entity.Passenger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("account")
public interface AccountFeign {
    @GetMapping("/account/login/{username}/{password}/{type}")
    Object login(@PathVariable("username")String username, @PathVariable("password")String password, @PathVariable("type")String type);

    @GetMapping("/account/checkUsername/{name}")
    boolean checkUsername(@PathVariable("name") String name);

    @PostMapping("/account/saveDriver")
    void saveDriver(@RequestBody Driver driver);

    @PostMapping("/account/savePassenger")
    void savePassenger(@RequestBody Passenger passenger);

    @PostMapping("/account/updateDriver")
    void updateDriver(Driver driver);

    @PostMapping("/account/updatePassenger")
    void updatePassenger(Passenger passenger);
}
