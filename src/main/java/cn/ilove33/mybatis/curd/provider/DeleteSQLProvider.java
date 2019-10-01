package cn.ilove33.mybatis.curd.provider;

import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;

/**
 * 删除语句构建器
 * 
 * @author Andy Chen
 * @date 10/1/19 2:43 PM
 */
public class DeleteSQLProvider extends AbstractSQLProvider {
    /**
     * 删除语句，传入不为空的属性将作为条件
     * 
     * @param obj
     * @return
     */
    public static <T> String delete(final T obj) {
        try {
            return new SQL() {
                {
                    DELETE_FROM(buildTableName(obj));
                    for (Field field : obj.getClass().getDeclaredFields()) {
                        if (isNullField(field, obj)) {
                            continue;
                        }
                        WHERE(buildEqual(field));
                        if (hasIdAnnotion(field)) {
                            break;
                        }
                    }
                }
            }.toString();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 删除语句，主键属性作为唯一条件
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String deletePrimary(final T obj) {
        try {
            return new SQL() {
                {
                    DELETE_FROM(buildTableName(obj));
                    for (Field field : obj.getClass().getDeclaredFields()) {
                        if (!isNullField(field, obj) && hasIdAnnotion(field)) {
                            WHERE(buildEqual(field));
                        }
                    }
                }
            }.toString();
        } catch (Exception e) {
            return null;
        }
    }

}
