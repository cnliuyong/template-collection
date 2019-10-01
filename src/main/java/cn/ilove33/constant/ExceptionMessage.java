package cn.ilove33.constant;

/**
 * 异常信息模板
 * @author Andy Chen
 * @date 10/1/19 3:02 PM
 */
public interface ExceptionMessage {
    String TABLE_NAME_NOT_NULL="Mybatis Entity @TableName name can not be null:{%s}";
    String NEED_TABLE_NAME_ANNOTION="Mybatis Entity needed @TableName annotion:{%s}";
    String MUST_HAS_PRIMARY_FIELD="must has primary field:{%s}";

}
