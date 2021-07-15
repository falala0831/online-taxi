package com.bigbone.account.service;

import com.bigbone.common.entity.Driver;
import com.bigbone.common.entity.Passenger;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PassengerService {
    Passenger login(String username, String password);
    void save(Passenger passenger);
    void update(Passenger passenger);
    Passenger findByUsername(String name);
}
