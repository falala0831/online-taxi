package com.bigbone.account.service;

import com.bigbone.account.dao.DriverDao;
import com.bigbone.common.entity.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DriverServiceImpl implements DriverService{

    @Autowired
    DriverDao driverDao;

    @Override
    public Driver login(String username, String password) {
        return driverDao.login(username, password);
    }

    @Override
    public void save(Driver driver) {
        driverDao.save(driver);
    }

    @Override
    public void update(Driver driver) {
        driverDao.update(driver);
    }

    @Override
    public Driver findByUsername(String name) {
        return driverDao.findByUsername(name);
    }
}
