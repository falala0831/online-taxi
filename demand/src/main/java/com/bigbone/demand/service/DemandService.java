package com.bigbone.demand.service;

import com.bigbone.common.entity.Demand;

import java.util.List;

public interface DemandService {
    List<Demand> findAll(String name, int start, int row);

    List<Demand> findAll1(String address, int start, int row);

    Integer count();

//    Demand findById(Integer id);

    void save(Demand demand);


    void deleteById(Integer id);
}
