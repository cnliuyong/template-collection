package cn.ilove33.validation.domain.vo;

import cn.ilove33.validation.domain.valid.annotion.NotBlank;
import cn.ilove33.validation.domain.valid.group.InsertGroup;

/**
 * 封装后请求参数对象
 * 
 * @author Andy Chen
 * @date 10/1/19 9:05 PM
 */
public class RequestVo {
    /**
     * 使用{@link NotBlank}校验id非空
     */
    @NotBlank
    private String id;
    /**
     * 仅当{@link org.springframework.validation.annotation.Validated}注解中values
     * 中包含{@link InsertGroup}时，才会使用{@link NotBlank}校验name属性
     */
    @NotBlank(groups = {InsertGroup.class})
    private String name;

    public String getId() {
        return id;
    }

    public RequestVo setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RequestVo setName(String name) {
        this.name = name;
        return this;
    }
}
