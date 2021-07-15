package com.bigbone.order.dao;

import com.bigbone.common.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    @Insert("insert into t_order(departure,destination,state,passenger,driver,price) " +
            "values(#{departure}, #{destination}, 0, #{passenger}, #{driver}, #{price})")
    void save(Order order);

    @Select("select id, departure, destination, state, passenger, driver, price from t_order" +
            "  where driver = #{driver} order by id desc" +
            "  limit #{start}, #{row}")
    List<Order> findByDriver(@Param("driver") String driver, @Param("start") int start, @Param("row") int row);

    @Select("select count(1) from t_order where driver=#{driver}")
    int getTotalCountsByDriver(@Param("driver") String driver);

    @Select("select id, departure, destination, state, passenger, driver, price FROM t_order\n" +
            "  WHERE state = 0 and passenger = #{passenger}\n" +
            "  LIMIT #{start}, #{row}")
    List<Order> findByPassenger(@Param("passenger") String passenger, @Param("start") int start, @Param("row") int row);

    @Select("select count(1) from t_order where state = 0 and passenger = #{passenger}")
    int getTotalCountsByPassenger(@Param("passenger") String passenger);

    @Update("update t_order set state=1 where id=#{id}")
    void updateState(int id);

    @Select("select IFNULL(SUM(price),0) from t_order where state = 1 and passenger = #{passenger}")
    int getScore(@Param("passenger") String passenger);
}
