package com.bigbone.order.service;

import com.bigbone.common.entity.Order;
import com.bigbone.order.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderDao orderDao;

    @Override
    public void save(Order order) {
        orderDao.save(order);
    }

    @Override
    public List<Order> findByDriver(String name, int start, int row) {
        System.out.println(name);
        return orderDao.findByDriver(name, start, row);
    }

    @Override
    public int getTotalCountsByDriver(String name) {
        System.out.println(name);
        return orderDao.getTotalCountsByDriver(name);
    }

    @Override
    public List<Order> findByPassenger(String name, int start, int row) {
        System.out.println(name);
        return orderDao.findByPassenger(name, start, row);
    }

    @Override
    public int getTotalCountsByPassenger(String name) {
        System.out.println(name);
        return orderDao.getTotalCountsByPassenger(name);
    }

    @Override
    public void updateState(int id) {
        orderDao.updateState(id);
    }

    @Override
    public int getScore(String name) {
        int num = orderDao.getScore(name);
        System.out.println(num);
        return num;
    }
}
