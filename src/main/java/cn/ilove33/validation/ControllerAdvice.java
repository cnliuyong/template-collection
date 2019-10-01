package cn.ilove33.validation;

import cn.ilove33.validation.domain.enums.ResponseEnum;
import cn.ilove33.validation.domain.exception.ParamterException;
import com.google.common.collect.Maps;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一异常处理类
 * 
 * @author Andy Chen
 * @date 10/1/19 9:15 PM
 */
@RestControllerAdvice
public class ControllerAdvice {
    /**
     * 处理未捕获异常
     * 
     * @param request
     * @param respones
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(HttpServletRequest request, HttpServletResponse respones, Exception ex) {
        int code = ResponseEnum.SERVER_ERROR.getCode();
        String message = ResponseEnum.SERVER_ERROR.getMessage();
        if (ex instanceof ParamterException) {
            code = ResponseEnum.PARAMTER_ERROR.getCode();
            message = ex.getMessage();
        }
        return ResponseEntity.ok(getErrorMap(request, code, message));
    }

    /**
     * 构建异常响应
     * 
     * @param request
     * @param code
     * @param errorMessage
     * @return
     */
    private Map<String, Object> getErrorMap(HttpServletRequest request, int code, String errorMessage) {
        String requestUri = request.getRequestURI();
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("message", errorMessage);
        map.put("code", code);
        map.put("path", requestUri);
        return map;
    }
}
