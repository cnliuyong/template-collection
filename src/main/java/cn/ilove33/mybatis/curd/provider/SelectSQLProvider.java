package cn.ilove33.mybatis.curd.provider;

import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;

/**
 * 查询语句构建器
 * @author Andy Chen
 * @date 10/1/19 2:44 PM
 */
public class SelectSQLProvider extends AbstractSQLProvider {
    private static final String ALL = "*";

    /**
     * 分页查询语句，返回List，根据传入的obj不为空的属性条件查询 若未提供分页值
     *
     * @param obj
     *            rowBounds 分页对象
     * @return
     */
    public static <T> String selectRowBounds(T obj) {
        try {
            return new SQL() {
                {
                    SELECT(ALL);
                    FROM(buildTableName(obj));
                    for (Field field : obj.getClass().getDeclaredFields()) {
                        if (!isNullField(field, obj)) {
                            WHERE(buildEqual(field));
                        }
                    }
                }
            }.toString();
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * 根据传入的obj不为空的属性条件查询 总条数 ,与分页连用
     *
     * @param obj
     * @return
     */
    public static <T> String selectCount(T obj) {
        try {
            return new SQL() {
                {
                    Field[] fields = obj.getClass().getDeclaredFields();
                    SELECT("COUNT(*)");
                    FROM(buildTableName(obj));
                    for (Field field : fields) {
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
     * 查询语句，返回第一条匹配数据，根据传入的obj不为空的属性条件查询
     *
     * @param obj
     * @return
     */
    public static <T> String selectPrimary(T obj) {
        try {
            return new SQL() {
                {
                    SELECT(ALL);
                    FROM(buildTableName(obj));
                    for (Field field : obj.getClass().getDeclaredFields()) {
                        if (!isNullField(field, obj) && hasIdAnnotion(field)) {
                            WHERE(buildEqual(field));
                        }
                    }

                }
            }.toString().concat(" LIMIT 0,1 ");
        } catch (Exception e) {
            return null;
        }
    }
}
