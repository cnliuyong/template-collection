package cn.ilove33.utils;

import cn.ilove33.constant.ExceptionMessage;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Andy Chen
 * @date 10/1/19 4:51 PM
 */
public class ThrowableUtilTest {
    @Test
    public void test() {
        assertNull(throwableMessage(false, ExceptionMessage.MUST_HAS_PRIMARY_FIELD, "cn"));
        assertEquals("must has primary field:{cn.ilove33}",
            throwableMessage(true, ExceptionMessage.MUST_HAS_PRIMARY_FIELD, "cn.ilove33"));
        assertEquals("must has primary field:{null}",
                throwableMessage(true, ExceptionMessage.MUST_HAS_PRIMARY_FIELD, "null"));
    }

    static String throwableMessage(boolean express, String errMsg, Object... args) {
        String message = null;
        try {
            ThrowableUtil.checkExpression(express, errMsg, args);
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }
}