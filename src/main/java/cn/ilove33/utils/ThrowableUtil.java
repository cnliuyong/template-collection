package cn.ilove33.utils;

import cn.ilove33.constant.Constants;
import cn.ilove33.validation.domain.exception.ParamterException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Objects;

/**
 * 异常处理工具类
 * 
 * @author Andy Chen
 * @date 10/1/19 2:58 PM
 */
public class ThrowableUtil {
    /**
     * 表达式为true时抛出异常
     * @param expression
     * @param errorMessageTemplate
     * @param errorMessageArgs
     */
    public static void checkExpression(boolean expression, String errorMessageTemplate, Object... errorMessageArgs) {
        if (expression) {
            throw new RuntimeException(String.format(errorMessageTemplate, errorMessageArgs));
        }
    }

    /**
     * 检查{@link org.springframework.validation.annotation.Validated}参数校验结果.
     * 校验失败时，抛出参数错误异常，让统一异常处理器捕获。
     * 
     * @param result
     */
    public static void checkRequestArgument(BindingResult result) {
        if (result != null && result.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            List<FieldError> errors = result.getFieldErrors();
            if (!errors.isEmpty()) {
                FieldError error = errors.get(0);
                String rejectedValue = Objects.toString(error.getRejectedValue(), "");
                String defMsg = error.getDefaultMessage();
                // 排除类上面的注解提示
                if (rejectedValue.contains(Constants.DELIMITER_TO)) {
                    sb.append(defMsg);
                } else {
                    if (defMsg.contains(Constants.DELIMITER_COLON)) {
                        sb.append(error.getField()).append(" ").append(defMsg);
                    } else {
                        sb.append(error.getField()).append(" ").append(defMsg).append(":").append(rejectedValue);
                    }
                }
            } else {
                String msg = result.getAllErrors().get(0).getDefaultMessage();
                sb.append(msg);
            }
            throw new ParamterException(sb.toString());
        }
    }
}
