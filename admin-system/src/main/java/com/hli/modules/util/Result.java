package com.hli.modules.util;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 封装返回参数
 * @Author MARS
 */
@Data
public class Result<T> {

    /** 成功标志 */
    @ApiModelProperty(value = "成功标志")
    private boolean success = true;

    /** 返回处理消息 */
    @ApiModelProperty(value = "返回处理消息")
    private String message = "操作成功！";

    /** 返回代码 */
    @ApiModelProperty(value = "返回代码")
    private Integer code = 200;

    /** 返回数据对象 data */
    @ApiModelProperty(value = "返回数据对象")
    private T result;

    public static Result<Object> ok() {
        Result<Object> r = new Result<Object>();
        return r;
    }
    public static Result<Object> ok(String msg) {
        Result<Object> r = new Result<Object>();
        r.setMessage(msg);
        return r;
    }

    public static Result<Object> ok(Object data) {
        Result<Object> r = new Result<Object>();
        r.setResult(data);
        return r;
    }
    public static Result<Object> ok(String msg,Object data) {
        Result<Object> r = new Result<Object>();
        r.setMessage(msg);
        r.setResult(data);
        return r;
    }
    public static Result<Object> error(String msg) {
        Result<Object> r = new Result<Object>();
        r.setSuccess(false);
        r.setCode(500);
        r.setMessage(msg);
        return r;
    }
    public static Result<Object> error() {
        Result<Object> r = new Result<Object>();
        r.setSuccess(false);
        r.setCode(500);
        r.setMessage("操作失败");
        return r;
    }

    public static Result<Object> error(Integer code,String msg) {
        Result<Object> r = new Result<Object>();
        r.setSuccess(false);
        r.setCode(code);
        r.setMessage(msg);
        return r;
    }
}
