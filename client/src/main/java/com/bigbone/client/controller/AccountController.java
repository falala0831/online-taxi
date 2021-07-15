package com.bigbone.client.controller;

import com.bigbone.client.feign.AccountFeign;
import com.bigbone.client.feign.OrderFeign;
import com.bigbone.common.entity.Driver;
import com.bigbone.common.entity.Msg;
import com.bigbone.common.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/client/account")
public class AccountController{
    @Autowired
    AccountFeign accountFeign;

    @Autowired
    OrderFeign orderFeign;

    @PostMapping("login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
            @RequestParam("type")String type, HttpSession session){
        Object login = accountFeign.login(username, password, type);  // login这里是LinkedHashMap，不是Object类型了
        Map<String, Object> map = (LinkedHashMap)login;
        if(login!=null){
            if("passenger".equals(type)){
                Passenger passenger = new Passenger();
                passenger.setId((Integer) map.get("id")).setUsername((String)map.get("username")).setPassword((String)map.get("password")).setAddress((String)map.get("address"));
                session.setAttribute("passenger", passenger);
                return "redirect:/main.html";
            }else if("driver".equals(type)){
                Driver driver = new Driver();
                driver.setId((Integer) map.get("id")).setUsername((String)map.get("username")).setPassword((String)map.get("password")).setAddress((String)map.get("address"));
                session.setAttribute("driver", driver);
                return "redirect:/index.html";
            }
        }
        return "redirect:/login.html";
    }


    @GetMapping("getUsername")
    @ResponseBody
    public Msg getUsername(HttpSession session){
        Passenger passenger = (Passenger) session.getAttribute("passenger");
        Driver driver = (Driver) session.getAttribute("driver");
        String level = "青铜会员";
        Msg result = new Msg();
        result.setCode(100);
        result.setMsg("处理成功");
        result.add("level", level);
        if (passenger != null){
            String name = passenger.getUsername();
            int score = orderFeign.getScore(name);
            if (score <= 10)
                level = "青铜会员";
            else if (score <=100)
                level = "白银会员";
            else if (score <= 1000)
                level = "黄金会员";
            else
                level = "钻石会员";
        }
        return result.add("passenger",passenger).add("driver",driver).add("level", level);
    }

    @GetMapping("/register")
    public String register(){
        return "redirect:/register.html";
    }

    @GetMapping("/logout/{type}")
    public String logout(@PathVariable("type")String type,HttpSession session){
        switch (type){
            case "passenger":
                session.removeAttribute("passenger");
                break;
            case "driver":
                session.removeAttribute("driver");
                break;
        }
        return "redirect:/login.html";
    }

    @PostMapping("save")
    public String save(@RequestParam("username")String username, @RequestParam("password")String password,
                       @RequestParam("address") String address, @RequestParam("type")String type){
        if (accountFeign.checkUsername(username)){
            switch (type){
                case "passenger":
                    Passenger passenger = new Passenger();
                    passenger.setUsername(username).setPassword(password).setAddress(address);
                    accountFeign.savePassenger(passenger);
                    break;
                case "driver":
                    Driver driver = new Driver();
                    driver.setUsername(username).setPassword(password).setAddress(address);
                    accountFeign.saveDriver(driver);
                    break;
            }
            return "redirect:/login.html";
        }
        else
            return "redirect:/name_repeated.html";
    }

    @GetMapping("/account/checkUsername/{name}")
    public boolean toVerifyUsername(@PathVariable("name") String name) {
        System.out.println(name);
        return accountFeign.checkUsername(name);
    }

    @PostMapping("/account/saveDriver")
    public String saveDriver(Driver driver){
        accountFeign.saveDriver(driver);
        return "redirect:/user_manage.html";
    }


    @PostMapping("/account/savePassenger")
    public String savePassenger(Passenger passenger){
        accountFeign.savePassenger(passenger);
        return "redirect:/user_manage.html";
    }

    @PostMapping("updateDriver")
    public void update(Driver driver){
        accountFeign.updateDriver(driver);
    }

    @PostMapping("updatePassenger")
    public void update(Passenger passenger){
        accountFeign.updatePassenger(passenger);
    }
}
