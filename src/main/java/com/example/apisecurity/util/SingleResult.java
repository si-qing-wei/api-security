package com.example.apisecurity.util;

/**
 * @description:
 * @author: siqingwei
 * @create: 2019-08-01 15:44
 **/
public class SingleResult<T> {
    private Integer code;
    private String message;
    private T data;

    public SingleResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> SingleResult<T> buildSuccess(T data) {
        return new SingleResult(0, "成功", data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SingleResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
