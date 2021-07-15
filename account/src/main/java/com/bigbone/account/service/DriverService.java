package com.bigbone.account.service;

import com.bigbone.common.entity.Driver;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface DriverService {
    Driver login(String username, String password);
    void save(Driver driver);
    void update(Driver driver);
    Driver findByUsername(String name);
}
