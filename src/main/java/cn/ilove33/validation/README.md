# 参数校验模板

## 依赖
- Spring MVC
- Javax Validation

## 介绍
- 在Controller层代码执行前,使用参数校验框架进行参数校验.
- 使用了注解方式，避免了重复代码
- 将参数的校验放在Controller层，甚至之前,实现单一职责原则.
- 若是使用了Spring全家桶.在实现了{@link ConstraintValidator}接口的Validator中可使用@Autowired来用IOC注入数据访问对象.检查数据库字段的存在性
- 在Validator中应只做参数的校验,避免任何密集型逻辑.