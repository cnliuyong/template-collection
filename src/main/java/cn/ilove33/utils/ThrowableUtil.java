package cn.ilove33.utils;

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
}
