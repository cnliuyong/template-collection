# MyBatis CURD 模板

## 依赖

- Mybatis
- Google Guava
```
 <!-- Mybatis CURD Template -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>${mybatis.version}</version>
</dependency>
<!-- COMMON-->
<dependency>
    <groupId>com.google.guava</groupId>
    <artifactId>guava</artifactId>
    <version>${guava.version}</version>
</dependency>
```

## 使用方法
定义了@Mapper注解的接口继承CURDMapper，即拥有CURDMapper声明的所有方法.无需编写重复代码.

## 原理
使用了Mybatis提供的SQLProvider系列注解及反射获取泛型类的信息。
使用自定义注解存储表名信息和标明为主键属性