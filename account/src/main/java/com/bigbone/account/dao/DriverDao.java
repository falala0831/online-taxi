package com.bigbone.account.dao;

import com.bigbone.common.entity.Driver;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverDao {
    @Select("select * from t_driver where username=#{username} and password=#{password}")
    Driver login(@Param("username") String username, @Param("password") String password);

    @Insert("insert into t_driver(username, password, address)"+
            "values(#{username}, #{password}, #{address})")
    void save(Driver driver);

    @Update("update t_driver set username=#{username}, password=#{password}, address=#{address} where id=#{id}")
    void update(Driver driver);

    @Select("select * from t_driver where username = #{username}")
    Driver findByUsername(@Param("username") String name);
}
