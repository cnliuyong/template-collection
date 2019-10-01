package cn.ilove33.mybatis.curd.provider;

import cn.ilove33.constant.ExceptionMessage;
import cn.ilove33.utils.ThrowableUtil;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;

/**
 * 更新SQL语句构建器
 * @author Andy Chen
 * @date 10/1/19 2:43 PM
 */
public class UpdateSQLProvider extends AbstractSQLProvider {
    /**
     * 更新语句，对传入的obj不为空的属性进行设置，以属性第一位做条件
     *
     * @param obj
     * @return
     */
    public static <T> String update(T obj) {
        try {
            return new SQL() {
                {
                    UPDATE(buildTableName(obj));
                    Field primary = null;
                    for (Field field : obj.getClass().getDeclaredFields()) {
                        if (isNullField(field, obj)) {
                            continue;
                        }
                        SET(buildEqual(field));
                        if (hasIdAnnotion(field)) {
                            primary = field;
                        }
                    }
                    ThrowableUtil.checkExpression(primary == null, ExceptionMessage.MUST_HAS_PRIMARY_FIELD,
                        obj.getClass().getName());
                    WHERE(buildEqual(primary));
                }
            }.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
