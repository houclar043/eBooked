package com.ebook.common.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Cliffe
 * @Date: 2022-09-13 2:38 下午
 */
@Data
public class R {
    private boolean success;

    private Integer code;

    private String message;

    private Map<String, Object> data = new HashMap<>();

    private R() {
    }

    public static R ok(){
        R r = new R();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("SUCCESS");
        return r;
    }

    public static R error(){
        R r = new R();
        r.setSuccess(false);
        r.setCode(ResultCode.DEFAULT_GLOBAL_ERORRO);
        r.setMessage("ERROR");
        return r;
    }

    public static R error(int code){
        R r = new R();
        r.setSuccess(false);
        r.setCode(code);
        r.setMessage("ERROR");
        return r;
    }

    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }

    public R data(String key,Object value){
        this.data.put(key,value);
        return this;
    }

    public R data(Map<String,Object> map){
        this.setData(map);
        return this;
    }
}