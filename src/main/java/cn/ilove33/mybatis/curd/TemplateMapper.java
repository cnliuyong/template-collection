package cn.ilove33.mybatis.curd;

import cn.ilove33.mybatis.curd.imapper.CURDMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * Mapper模板
 * <p>
 *     继承了{@link CURDMapper}接口，及其下的所有CURD方法.并且泛型指定为{@link TemplateEntity}
 * </p>
 * @author Andy Chen
 * @date 10/1/19 4:35 PM
 */
@Mapper
public interface TemplateMapper extends CURDMapper<TemplateEntity> {

}
