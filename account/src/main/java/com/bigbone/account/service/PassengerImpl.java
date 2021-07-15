package com.bigbone.account.service;

import com.bigbone.account.dao.PassengerDao;
import com.bigbone.common.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PassengerImpl implements PassengerService{

    @Autowired
    PassengerDao passengerDao;

    @Override
    public Passenger login(String username, String password) {
        return passengerDao.login(username, password);
    }

    @Override
    public void save(Passenger passenger) {
        passengerDao.save(passenger);
    }

    @Override
    public void update(Passenger passenger) {
        passengerDao.update(passenger);
    }

    @Override
    public Passenger findByUsername(String name) {
        return passengerDao.findByUsername(name);
    }
}
