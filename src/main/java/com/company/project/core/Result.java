package com.company.project.core;

import com.alibaba.fastjson.JSON;

/**
 * 统一API响应结果封装
 */
public class Result {

    /**
     * 错误代码
     */
    private int code;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 信息实体
     */
    private Object data;

    /**
     * 成功
     */
    public static final Result SUCCESS = new Result(StatusEnum.SUCCESS);

    /**
     * 请求错误
     */
    public static final Result BAD_REQ = new Result(StatusEnum.BAD_REQ);

    /**
     * 未认证
     */
    public static final Result UN_AUTH = new Result(StatusEnum.UN_AUTH);

    /**
     * 请求被拒绝
     */
    public static final Result FORBIDDEN = new Result(StatusEnum.FORBIDDEN);

    /**
     * 内部错误
     */
    public static final Result ERROR = new Result(StatusEnum.ERROR);

    public Result() {
    }

    public Result(StatusEnum statusEnum) {
        this(statusEnum, null);
    }

    public Result(StatusEnum statusEnum, Object data) {
        this.code = statusEnum.getState();
        this.message = statusEnum.getStatus();
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result success(Object data){
        return new Result(StatusEnum.SUCCESS, data);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
