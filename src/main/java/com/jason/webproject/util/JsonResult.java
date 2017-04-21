package com.jason.webproject.util;

/**
 * Created by Jason on 4/12/17.
 */
public class JsonResult<T> {

    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public JsonResult(T data) {
        this.code = 200;
        this.msg = "OK";
        this.data = data;
    }
}