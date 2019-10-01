package cn.ilove33.mybatis.curd.provider;

import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;

/**
 * 插入语句构建器
 * 
 * @author Andy Chen
 * @date 10/1/19 2:42 PM
 */
public class InsertSQLProvider extends AbstractSQLProvider {
    /**
     * 插入语句，新增所有非空的属性
     *
     * @param obj
     * @return
     */
    public static <T> String insert(T obj) {
        try {
            return new SQL() {
                {
                    INSERT_INTO(buildTableName(obj));
                    for (Field field : obj.getClass().getDeclaredFields()) {
                        if (isNullField(field, obj)) {
                            continue;
                        }
                        VALUES(buildColomn(field), buildValue(field));
                    }
                }
            }.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
