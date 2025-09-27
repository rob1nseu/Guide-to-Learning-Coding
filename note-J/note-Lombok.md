# Lombok浅学

> LomBok可以通过注解，帮助开发人员消除JAVA中尤其是[POJO类](https://so.csdn.net/so/search?q=POJO类&spm=1001.2101.3001.7020)中的冗长代码
>
> Lombok超详解：https://blog.csdn.net/qq_53317005/article/details/134431160?ops_request_misc=elastic_search_misc&request_id=9f3f91b58ace28e6e914ae8e3ceb546b&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_click~default-2-134431160-null-null.142

## @Setter & @Getter 

- 为类中的属性提供setter与getter方法，
- **存在位置为：（1）类的上方（为类中所有属性生成setter/getter）或（2）属性上方（为对应属性生成setter/getter）**
- 注解参数：设置setter与getter的访问权限

```java
//给类下的所有属性添加Setter/Getter
@Setter
@Getter
public class User {
  //给id属性添加Setter
  @Setter
  private Integer id;
  //给username的setter方法设置私有权限
  @Setter(AccessLevel.PRIVATE)
  private String username;
  //取消password的Getter方法
  @Getter(AccessLevel.NONE)
  private String password;
  private static int age;
  private final String address = null;
}
```

**注：**

- static修饰的变量不生成getter和setter方法
- final修饰的变量只生成getter方法 



## @ToString

To be continue...