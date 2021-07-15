package com.bigbone.demand.dao;

import com.bigbone.common.entity.Demand;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandDao {
    @Select("select * from t_demand where name = #{name} limit #{start}, #{row}")
    List<Demand> findAll(@Param("name") String name, @Param("start") int start, @Param("row") int row);

    @Select("select * from t_demand where departure = #{address} limit #{start}, #{row}")
    List<Demand> findAll1(@Param("address") String address, @Param("start") int start, @Param("row") int row);

    @Select("select count(1) from t_demand")
    Integer count();

//    @Select("select * from t_demand where id=#{id}")
//    Demand findById(Integer id);

    @Insert("insert into t_demand(departure, destination, name) values(#{departure}, #{destination}, #{name})")
    void save(Demand demand);

//    @Update("update t_demand set departure=#{departure}, destination=#{destination}, name=#{name} where id=#{id}")
//    void update(Demand demand);

    @Delete("delete from t_demand where id=#{id}")
    void deleteById(Integer id);
}
