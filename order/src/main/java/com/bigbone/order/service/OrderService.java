package com.bigbone.order.service;

import com.bigbone.common.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {
    void save(Order order);

    List<Order> findByDriver(String name, int start, int row);

    int getTotalCountsByDriver(String name);

    List<Order> findByPassenger(String name, int start, int row);

    int getTotalCountsByPassenger(String name);

    void updateState(int id);

    int getScore(String name);
}
