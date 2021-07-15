package com.bigbone.common.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

@Data
@Accessors(chain = true)
public class Msg {
    //状态码
    private Integer code;
    //提示信息
    private String msg;
    //用户要返回浏览器的数据
    private Map<String,Object> extend = new HashMap<String,Object>();

    /*成功方法*/
    public static Msg success(){
        Msg result = new Msg();
        result.setCode(100);
        result.setMsg("处理成功");
        return result;
    }
    /*失败方法*/
    public static Msg fail(){
        Msg result = new Msg();
        result.setCode(200);
        result.setMsg("处理失败");
        return result;
    }

    public Msg add(String key,Object value){
        this.getExtend().put(key,value);
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map < String, Object > getExtend() {
        return extend;
    }

    public void setExtend(Map < String, Object > extend) {
        this.extend = extend;
    }
}