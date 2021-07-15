package com.bigbone.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
public class Order{
    private Integer id;
    private String departure;
    private String destination;
    private String passenger;
    private String driver;
    private Integer price;
//    private Demand demand;
//    private Driver driver;
    private String state;
}
