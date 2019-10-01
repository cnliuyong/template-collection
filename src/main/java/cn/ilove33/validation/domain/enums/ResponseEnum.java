package cn.ilove33.validation.domain.enums;

/**
 * 响应类型枚举
 * 
 * @author Andy Chen
 * @date 10/1/19 9:21 PM
 */
public enum ResponseEnum {
    /**
     * 服务器异常
     */
    SERVER_ERROR(500, "Server Internal Error"),
    /**
     * 参数异常
     */
    PARAMTER_ERROR(400, "PARAMTER ERROR"),;

    private int code;

    private String message;

    public int getCode() {
        return code;
    }

    public ResponseEnum setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseEnum setMessage(String message) {
        this.message = message;
        return this;
    }

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
