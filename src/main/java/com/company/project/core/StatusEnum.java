package com.company.project.core;

/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum StatusEnum {

    SUCCESS(200, "操作成功"),
    BAD_REQ(400,"请求错误"),
    UN_AUTH(401,"未认证"),
    FORBIDDEN(403,"请求被拒绝"),
    NOT_FOUND(404,"数据不存在"),
    ERROR(500,"内部错误"),
    UNDEFINED(501, "未定义错误");

    private int state;

    private String status;

    StatusEnum(int state, String status) {
        this.state = state;
        this.status = status;
    }

    public int getState() {
        return state;
    }

    public String getStatus() {
        return status;
    }

    public static StatusEnum stateOf(int index) {
        for (StatusEnum statusEnum : values()) {
            if (statusEnum.getState() == index) {
                return statusEnum;
            }
        }
        return UNDEFINED;
    }
}
