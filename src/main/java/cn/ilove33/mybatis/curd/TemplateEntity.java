package cn.ilove33.mybatis.curd;

import cn.ilove33.mybatis.curd.annotion.ID;
import cn.ilove33.mybatis.curd.annotion.TableName;

/**
 * 实体案例
 * <p>
 *     使用了{@link TableName} 注解，用来声明数据库表名
 *     使用{@link ID}注解，声明为主键id.
 * </p>
 *
 * @author Andy Chen
 * @date 10/1/19 2:51 PM
 */
@TableName(name = "template_table")
public class TemplateEntity {
    @ID
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public TemplateEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TemplateEntity setName(String name) {
        this.name = name;
        return this;
    }

}
