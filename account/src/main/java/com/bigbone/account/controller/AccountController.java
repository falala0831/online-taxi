package com.bigbone.account.controller;

import com.bigbone.account.service.DriverService;
import com.bigbone.account.service.PassengerService;
import com.bigbone.common.entity.Driver;
import com.bigbone.common.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    DriverService driverService;

    @Autowired
    PassengerService passengerService;

    @GetMapping("login/{username}/{password}/{type}")
    public Object login(@PathVariable("username")String username, @PathVariable("password")String password, @PathVariable("type")String type){
        Object obj = null;
        if("driver".equals(type)){
            obj = driverService.login(username, password);
        }else if("passenger".equals(type)){
            obj = passengerService.login(username, password);
        }
        return obj;
    }

    @GetMapping("checkUsername/{name}")
    public boolean checkUsername(@PathVariable("name") String name){
        Driver driver = driverService.findByUsername(name);
        Passenger passenger = passengerService.findByUsername(name);
        if (driver == null && passenger == null)
            return true;
        else
            return false;
    }

    @PostMapping("saveDriver")
    public void saveDriver(@RequestBody Driver driver){
        driverService.save(driver);
    }

    @PostMapping("savePassenger")
    public void savePassenger(@RequestBody Passenger passenger){
        passengerService.save(passenger);
    }

    @PostMapping("updateDriver")
    public void updateDriver(@RequestBody Driver driver){
        driverService.save(driver);
    }

    @PostMapping("updatePassenger")
    public void updatePassenger(@RequestBody Passenger passenger){
        passengerService.update(passenger);
    }
}
