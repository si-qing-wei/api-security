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
        return new SingleResult(Code.SUCCESS, "成功", data);
    }

    public static <T> SingleResult<T> buildFailure() {
        return new SingleResult<>(Code.ERROR, "服务端出错", null);
    }

    public static <T> SingleResult<T> buildFailure(Integer code, String message) {
        return new SingleResult<>(code, message, null);
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
