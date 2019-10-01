package cn.ilove33.mybatis.curd.provider;

import cn.ilove33.mybatis.curd.annotion.ID;
import cn.ilove33.mybatis.curd.annotion.TableName;
import cn.ilove33.utils.ThrowableUtil;
import com.google.common.base.CaseFormat;
import com.google.common.base.Strings;

import java.lang.reflect.Field;
import java.util.Objects;

import static cn.ilove33.constant.ExceptionMessage.NEED_TABLE_NAME_ANNOTION;
import static cn.ilove33.constant.ExceptionMessage.TABLE_NAME_NOT_NULL;

/**
 * 抽象SQL语句构建器
 * 
 * @author Andy Chen
 * @date 10/1/19 3:52 PM
 */
public abstract class AbstractSQLProvider {
    static final String EQUAL_SQL = " %s = #{%s} ";

    /**
     * 构建表名
     * 
     * @param obj
     * @return
     */
    static <T> String buildTableName(T obj) {
        // 校验并获取注解上的表名，
        String fullPath = obj.getClass().getName();
        TableName tableAnnotation = obj.getClass().getAnnotation(TableName.class);
        ThrowableUtil.checkExpression(Objects.isNull(tableAnnotation), NEED_TABLE_NAME_ANNOTION, fullPath);
        ThrowableUtil.checkExpression(Strings.isNullOrEmpty(tableAnnotation.name()), TABLE_NAME_NOT_NULL, fullPath);
        return tableAnnotation.name();
    }

    /**
     * 构建WHERE语句的SQL
     * 
     * @param field
     * @return
     */
    static String buildEqual(Field field) {
        return String.format(EQUAL_SQL, buildColomn(field), buildValue(field));
    }

    /**
     * 构建列名
     * 
     * @param field
     * @return
     */
    static String buildColomn(Field field) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, field.getName());
    }

    /**
     * 构建Value的SQL
     * 
     * @param field
     * @return
     */
    static String buildValue(Field field) {
        return "#{" + field.getName() + "}";
    }

    /**
     * 属性是否为空
     * 
     * @param field
     * @param obj
     * @param <T>
     * @return
     * @throws IllegalAccessException
     */
    static <T> boolean isNullField(Field field, T obj) throws IllegalAccessException {
        field.setAccessible(true);
        // 读值非空
        return Objects.isNull(field.get(obj)) || "".equals(field.get(obj))
            || "serialVersionUID".equals(field.getName());
    }

    /**
     * 是否包含{@link ID}
     * 
     * @param field
     * @return
     */
    static boolean hasIdAnnotion(Field field) {
        // 若为ID存在，则不继续查询其他值
        return Objects.nonNull(field.getAnnotation(ID.class));
    }
}
