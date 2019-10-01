package cn.ilove33.validation;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.ilove33.utils.ThrowableUtil;
import cn.ilove33.validation.domain.valid.group.InsertGroup;
import cn.ilove33.validation.domain.vo.RequestVo;

/**
 * 控制器案例
 * 
 * @author Andy Chen
 * @date 10/1/19 9:03 PM
 */
@RestController
public class TemplateController {
    /**
     * 参数校验案例
     * 
     * @param requestVo
     * @param bindingResult
     * @return
     */
    @PostMapping("/template")
    public ResponseEntity template(@Validated @RequestBody RequestVo requestVo, BindingResult bindingResult) {
        ThrowableUtil.checkRequestArgument(bindingResult);
        return ResponseEntity.ok(requestVo);
    }

    /**
     * 参数组案例
     * 
     * @param requestVo
     * @param bindingResult
     * @return
     */
    @PostMapping("/template/group")
    public ResponseEntity templateGroup(@Validated(value = {InsertGroup.class}) @RequestBody RequestVo requestVo,
        BindingResult bindingResult) {
        ThrowableUtil.checkRequestArgument(bindingResult);
        return ResponseEntity.ok(requestVo);
    }

    /**
     * 对RESTful风格的参数进行校验
     * @param id
     * @param bindingResult
     * @return
     */
    @GetMapping("/template/{id}")
    public ResponseEntity templateParamter(@Validated @PathVariable(value = "id") String id,
        BindingResult bindingResult) {
        ThrowableUtil.checkRequestArgument(bindingResult);
        return ResponseEntity.ok(id);
    }
}
