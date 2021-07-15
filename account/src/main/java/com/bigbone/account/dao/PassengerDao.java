package com.bigbone.account.dao;

import com.bigbone.common.entity.Driver;
import com.bigbone.common.entity.Passenger;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerDao {
    @Select("select * from t_passenger where username=#{username} and password=#{password}")
    Passenger login(@Param("username") String username, @Param("password") String password);

    @Insert("insert into t_passenger(username, password, address)"+
            "values(#{username}, #{password}, #{address})")
    void save(Passenger passenger);

    @Update("update t_passenger set username=#{username}, password=#{password}, address=#{address} where id=#{id}")
    void update(Passenger passenger);

    @Select("select * from t_passenger where username = #{username}")
    Passenger findByUsername(@Param("username") String name);
}
