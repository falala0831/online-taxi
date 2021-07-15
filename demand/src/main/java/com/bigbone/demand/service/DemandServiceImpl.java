package com.bigbone.demand.service;

import com.bigbone.common.entity.Demand;
import com.bigbone.demand.dao.DemandDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DemandServiceImpl implements DemandService{
    @Autowired
    DemandDao demandDao;

    @Override
    public List<Demand> findAll(String name, int start, int row) {
        return demandDao.findAll(name, start, row);
    }

    @Override
    public List<Demand> findAll1(String address, int start, int row) {
        return demandDao.findAll1(address, start, row);
    }

    @Override
    public Integer count() {
        return demandDao.count();
    }

//    @Override
//    public Demand findById(Integer id) {
//        return demandDao.findById(id);
//    }

    @Override
    public void save(Demand demand) {
        demandDao.save(demand);
    }

    @Override
    public void deleteById(Integer id) {
        demandDao.deleteById(id);
    }
}
