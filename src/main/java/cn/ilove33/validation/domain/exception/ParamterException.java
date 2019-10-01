package cn.ilove33.validation.domain.exception;

/**
 * 参数错误异常
 * 
 * @author Andy Chen
 * @date 10/1/19 9:25 PM
 */
public class ParamterException extends RuntimeException {
    public ParamterException(String message) {
        super(message);
    }
}
