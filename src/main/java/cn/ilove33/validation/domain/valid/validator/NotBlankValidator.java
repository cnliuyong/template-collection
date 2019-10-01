package cn.ilove33.validation.domain.valid.validator;

import cn.ilove33.validation.domain.valid.annotion.NotBlank;
import com.google.common.base.Strings;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 非空校验器
 * 
 * @author Andy Chen
 * @date 10/1/19 9:37 PM
 */
public class NotBlankValidator implements ConstraintValidator<NotBlank, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !Strings.isNullOrEmpty(value);
    }
}
