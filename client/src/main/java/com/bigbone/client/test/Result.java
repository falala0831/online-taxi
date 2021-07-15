package com.bigbone.client.test;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;


@Data
@Schema(name = "接口返回对象", description = "接口返回对象")
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Integer SC_INTERNAL_SERVER_ERROR_500 = 500;

    public static final Integer SC_OK_200 = 200;

    @Schema(name = "成功标志")
    private boolean success = true;

    @Schema(name = "返回处理消息")
    private String message = "操作成功！";

    @Schema(name = "返回代码")
    private Integer code = 0;

    @Schema(name = "返回数据对象")
    private T result;

    @Schema(name = "时间戳")
    private long timestamp = System.currentTimeMillis();

    public Result() {

    }

    public Result<T> success(String message) {
        this.message = message;
        this.code = SC_OK_200;
        this.success = true;
        return this;
    }

    public static Result<Object> ok() {
        Result<Object> r = new Result<Object>();
        r.setSuccess(true);
        r.setCode(SC_OK_200);
        r.setMessage("成功");
        return r;
    }

    public static Result<Object> ok(String msg) {
        Result<Object> r = new Result<Object>();
        r.setSuccess(true);
        r.setCode(SC_OK_200);
        r.setMessage(msg);
        return r;
    }

    public static Result<Object> ok(Object data) {
        Result<Object> r = new Result<Object>();
        r.setSuccess(true);
        r.setCode(SC_OK_200);
        r.setResult(data);
        return r;
    }

    public static Result<Object> error(String msg) {
        return error(SC_INTERNAL_SERVER_ERROR_500, msg);
    }

    public static Result<Object> error(int code, String msg) {
        Result<Object> r = new Result<Object>();
        r.setCode(code);
        r.setMessage(msg);
        r.setSuccess(false);
        return r;
    }

    public Result<T> error500(String message) {
        this.message = message;
        this.code = SC_INTERNAL_SERVER_ERROR_500;
        this.success = false;
        return this;
    }

}
