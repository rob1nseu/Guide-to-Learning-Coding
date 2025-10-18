# **JavaWeb学习笔记**

## **前后端分离结构**

<img src="Note_pic\image-20250926195729289.png" alt="image-20250926195729289" style="zoom: 50%;" />

## **前端**

> ***见《note-P》中 html/css/js 教程***

## **后端**

### **1. Maven**

> Maven是一款管理与与构建Java项目的工具，提供了**方便的依赖管理、统一的项目结构、跨平台的项目构建方式**

#### 1.1 Maven模型

![image-20251002204144617](Note_pic\image-20251002204144617.png)

1. **仓库分级**：
   - *本地仓库：计算机中的本地目录（mvn_repo）*
   - *中央仓库：Maven团队维护的全球统一的仓库地址*
   - *远程仓库（私服）：用机构搭建的私有仓库（阿里云等镜像jar包平台）*
2. **LifeCycle生命周期中的各个周期的视线，是多个可执行插件参与的！**



#### 1.2 Maven依赖配置

​	**在Maven中，通过“坐标”唯一地标识某资源的jar包**

<img src="Note_pic\image-20251002204630678.png" alt="image-20251002204630678" style="zoom: 50%;" />

​	**依赖配置时，需在pom.xml中编写`<dependencies></dependencies>`标签表示依赖项，并以`<dependency></dependency>`的方式逐个引入依赖项坐标，并定义坐标各组成。**



#### 1.3 Maven依赖传递

<img src="C:\Users\86157\Desktop\Guide-to-Learning-Coding\Guide-to-Learning-Coding\note-J\Note_pic\image-20251002205459063.png" alt="image-20251002205459063" style="zoom: 33%;" />

​	**依赖具有传递性。**在projectA的依赖中，存在projectB与JAR包，其中JAR包为直接依赖；projectB由于依赖其他资源，则projectA间接依赖projectC等B依赖的JAR包。

- **直接依赖**：当前项目中通过依赖配置建立的依赖关系；
- **间接依赖**：被依赖的资源如果依赖其他资源，当前项目间接依赖其他资源。
- *排除依赖：`<exclusion></exclusion>`关键字主动断开间接依赖的资源。*



#### 1.4 Maven依赖范围

<img src="Note_pic\image-20251002212934495.png" alt="image-20251002212934495" style="zoom: 67%;" />

- 依赖的jar包，可以通过**`<scope></scope>`设置其作用范围**：
  - **主程序范围（main目录内）**
  - **测试程序范围（test目录内）**
  - 是否参与打包运行（package范围内）

- `scope`值与范围对应表

![image-20251002213046106](Note_pic\image-20251002213046106.png)



#### 1.5 Maven生命周期

- **Maven中有三套独立的生命周期：**
  - clean：清理工作；
  - default：核心工作，包括compile、test、package、install......
  - site：生成报告工作。

- **在同一套生命周期中，运行后置阶段时，前面的阶段都会运行。**

![image-20251002213441900](Note_pic\image-20251002213441900.png)



### **2. SpringBoot**

> 当使用IDEA社区版时，本地不存在`spring initializer`，需要联网访问 https://start.spring.io/ 使用

<img src="Note_pic\image-20251003130927992.png" alt="image-20251003130927992" style="zoom:33%;" />

​	SpringbootWeb的pom.xml中存在起步依赖***spring-boot-starter-web***，其中内置了基础Web开发所需依赖。（Maven依赖传递）

### **3. http协议**

> 超文本传输协议，**基于TCP连接、无状态**（事务处理没有记忆能力，每次请求-响应独立）

#### 3.1 http报文格式

##### 3.1.1 请求报文格式

- **请求行**：**请求方式（GET/POST）、资源路径**、http版本
- **请求头**：控制信息（K-V格式，浏览器版本、报文长度、报文类型等）
- **请求体**
  - **POST请求时，存在请求体，存放请求参数；（如下图）**
  - **GET方式时，提交内容存在于“请求行.资源路径”处；（ GET /brand?name=Tom&age=18 ）**


<img src="Note_pic\image-20251003133316483.png" alt="image-20251003133316483" style="zoom:50%;" />

##### 3.1.2 响应报文格式

- **响应行：http版本、状态码、状态码描述**
  - 状态码分类
    - *2xx：成功；*
    - 3xx：要求重定向到其他地方，客户端需再发起一次请求完成整个处理。
    - *4xx：客户端错误（请求非法资源、禁止访问等）*
    - *5xx：服务端错误（服务端抛出异常等）*
- **响应头**：控制信息（K-V）

<img src="Note_pic\image-20251003135546212.png" alt="image-20251003135546212" style="zoom:50%;" />

- **响应体：存放响应数据**

<img src="Note_pic\image-20251003134603063.png" alt="image-20251003134603063" style="zoom:50%;" />



##### 3.2 解析http请求

> B-S架构中，由于Browser处已经内置解析http的功能，主要聚焦于服务端http报文的解析&响应后端开发

​	**如果要手动写http协议的解析与响应，将会非常复杂且冗余！（利用ServerSocket获取InputStream，经字符串处理读取信息并响应OutputStream给Browser！）** **因此，诞生了*Web服务器软件：Apache Tomcat、jetty......*程序员无需对http直接操作，进而更好地关注后端逻辑！**



### **4. Tomcat**

> Web服务器对http协议进行封装，简化web应用的开发，可对外提供网上信息服务；
>
> Tomcat是一个轻量级的web服务器，支持少量javaEE规范，也称为web容器、servlet容器

​	**Springboot中spring-boot-starter-web的起步依赖中，依赖了tomcat，springboot中，将自动启动tomcat服务器！**



### **5. 请求响应**

![image-20251009141802787](Note_pic\image-20251009141722327.png)

​	BS架构中，Tomcat服务器程序中存在一个继承自Servlet的DispatcherServlet类（核心/前端控制器），**将Browser传递的数据封装到`HttpServletRequest`类对象中，分发到`xxxController`，将Server传递的数据封装到`HttpServletResponse`类对象中**。

#### 5.1 接口测试工具

​	**Postman/Apifox等接口测试工具，可给后端发送GET/POST的http请求。**无需前端参与，即可测试功能！

![image-20251009143750276](Note_pic\image-20251009143750276.png)



#### 5.2 Web请求与响应

##### 5.2.1 Web前端请求数据的后端处理

​	此部分利用了Apifox的接口测试系统，学习并验证了下面各种参数的前后端参数传递。

<img src="Note_pic\image-20251010110346139.png" alt="image-20251010110346139" style="zoom: 50%;" />

###### 1. 简单参数

​	简单参数 ☞ GET方法：**`http://localhost:8080/simpleParam?name=Tom&age=18`** 中的 name 与 age（或Post方法中请求体中的JSON形式"name":"Tom"数据），即为简单参数。

<img src="Note_pic\image-20251010143902803.png" alt="image-20251010143902803" style="zoom: 67%;" />

- **以SpringBoot的简洁方式接收简单参数时，**

  - **请求参数名与方法形参变量名相同 （如上图） **（即http协议里的变量名与controller中的形参名相同），若方法形参与请求参数名不匹配，则需通过@RequestParameter完成映射

  <img src="Note_pic\image-20251010145714292.png" alt="image-20251010145714292" style="zoom: 67%;" />

  - **springboot自动给执行类型转换**（http中传递的为String类型，而可以将age转换为Integer类型）

- 若不使用此类方式，则需要在Controller方法的形参中声明HttpServiceRequest对象，并调用HttpServiceRequest对象的getParameter方法（具体见B-S架构图，不推荐！）



###### 2. 实体参数

​	即将http的请求参数名的各属性封装到一个POJO实体类中，**要求请求参数名与形参对象属性名相同，即可实体类封装！**

<img src="Note_pic\image-20251010150004141.png" alt="image-20251010150004141" style="zoom: 50%;" />



###### 3. 数组/集合参数

​	**情形**：多个请求参数名相同，可定义数组/集合类型形参。

​	e.g  `**http://localhost:8080/arrayParam/hobby=game&hobby=sleeping`**

​	请求参数封装为数组：**请求参数名与形参数组名相同，可以直接使用数组封装**

<img src="Note_pic\image-20251010150921813.png" alt="image-20251010150921813" style="zoom: 67%;" />

​	请求参数封装成集合：**请求参数名与形参数组名相同，且通过@RequestParam绑定**

<img src="Note_pic\image-20251010151307587.png" alt="image-20251010151307587" style="zoom:50%;" />

###### 4. JSON参数

​	JSON数据的传递位于**请求体内**，

​	**a) JSON*数据键名*与POJO形参*对象的属性名*相同**

​	**b) 需@RequestBody标识**

<img src="Note_pic\image-20251010152529942.png" alt="image-20251010152529942" style="zoom: 50%;" />

###### 5. 路径参数

​	利用 `@PathVariable` 注解，绑定标识路径参数！

![image-20251010152650296](Note_pic\image-20251010152650296.png)

##### 5.2.2 响应数据

###### 1. ResponseBody注解

​	Controller方法/类注解。**将方法的返回值直接进行响应，如果返回值是实体对象/集合，则将转换为JSON格式响应。**实际操作过程中，@ResponseBody注解集成到了@RestController中。

​					**@RestController = @Controller + @ResponseBody**

<img src="Note_pic\image-20251010170604299.png" alt="image-20251010170604299" style="zoom: 67%;" />

###### 2. 响应数据

​	由于各方法中返回值大相径庭，不适合前后端协作开发。将返回值封装为Result类型，从而很好地

<img src="Note_pic\image-20251010171407366.png" alt="image-20251010171407366" style="zoom: 33%;" />

​	Result中，一般存在`success(Object)、error(Object)`等静态方法，`return new Result(...)` 返回Result对象，从而方便地创建Result对象！



#### 5.3 Web分层解耦

​	以“单一职责”为原则，引出了三层架构，使之方便维护，易于扩展。

- **Controller层**：接收请求，响应数据
- **Service层**：业务逻辑的处理
- **DAO层**：数据访问操作

​	**数据流向：Browser向服务端发起请求，通过@RequestMapping注解，访问Controller层，再依次到Service层、DAO层，DAO访问到数据后，再由DAO到Service到Controller，响应给Browser！**

![image-20251010190235682](Note_pic\image-20251010190235682.png)

##### 5.3.1 违规的分层解耦

​	下面这样的耦合方式就**不太合适**：*Controller调用Service的方式是直接new，若service层名称修改，则controller处也需要改动——耦合紧密导致的！*

<img src="Note_pic\image-20251010192353713.png" alt="image-20251010192353713" style="zoom:67%;" />



#### 5.3 控制反转IOC & 依赖注入DI

> **Inversion Of Control**，对象的创建控制权由程序自身转移到IOC容器
>
> **Dependency Injection**，容器为应用程序提供运行时，所依赖的资源
>
> **Bean对象**：IOC容器中创建、管理的对象

![image-20251010204005438](Note_pic\image-20251010204005438.png)

```java
@Component // 将当前类对象交给IOC容器管理，成为IOC容器中的bean 
public class EmpDaoA implements EmpDao{
	@Autowired // 运行时，IOC容器将会提供该类型的bean对象，并赋值给该变量 -- 依赖注入
	private EmpService empService;
	...
}
```

#####  5.3.1 IOC

类中Bean对象的四大注解:

<img src="Note_pic\image-20251010204441664.png" alt="image-20251010204441664" style="zoom:50%;" />

- 由于 `@RestController = @Controller + @ResponseBody` ，则在` Controller `层中，用`RestController` 即可1
- IOC容器中的对象，存在名字，默认为**“ 类名（首字母小写）”**，也可以在注解处修改：`@Service(value="serviceA")`，其中"value="可以省略
- 上述注解要想生效，需被@ComponentScan扫描（@Component注解包含在了启动类声明注解@SpringBootApplication中），因此，默认扫描范围为启动类所在包及其子包。（当然可以修改配置，但不推荐）



##### 5.3.2 DI

- **@Autowired -- 从IOC容器中寻找到指定类型的Bean对象**

- **若同类型bean存在多个：**
  - @Primary  --  在希望使用的bean类前添加该注解
  - @Autowired + @Qualifier("bean的名称") -- 希望使用的bean的名称
  - @Resource("name='bean的名称'") -- **与@Autowired的区别为@Resource注解为JDK提供**



### **6. MySQL**

> **术语**：
>
> DBMS（数据库管理系统）；
>
> SQL（操作关系型数据库的**统一标准编程语言**）；

#### 6.1 SQL概述

##### 6.1.1 通用语法

- SQL语句可以单行或多行书写，以分号结尾
- SQL语句不区分大小写
- 单行注释“ --（MySQL中也可 # ）”；多行注释“ /* 注释内容 */”

##### 6.1.2 SQL特殊语法

1. 流程控制函数
   - case expr when value1 then result1 [when value2 then result2 ...] [else result] end
   - if (表达式, true_value)

##### 6.1.3 SQL分类

- DDL（Data Definition Language），数据定义语言，定义数据库对象
- DML（Data Manipulate Language），负责数据的增删改
- DQL（Data Query Language），负责数据查询



#### 6.2 DDL语句 （一般使用图形化界面操作）

##### 6.2.1 数据库操作

```sql
show databases;  -- 展示所有数据库
select database();  -- 查询当前数据库名

use [数据库名]; -- 切换使用数据库
create database [if not exists] 数据库名; -- 创建数据库
drop database [if exists] 数据库名; -- 删除数据库
```

##### 6.2.2 表结构操作

```sql
-- 创建表
create table 表名{
	字段1 字段类型 [约束] [comment '字段注解'],
	......
}[comment '表注解']

show tables; -- 查看当前database中的表
desc 表名; -- 查看指定表结构
show create table 表名; -- 查看建表语句

-- 修改表结构 (此处一般在图形化界面1操作)
alter table [表名] add [列名] [类型] [comment 注解];
```

- **DDL中的常用约束**
  -  `primary key` 后可添加 `auto increment`， 表示自增

![image-20251011143245914](Note_pic\image-20251011143245914.png)

##### 6.2.3 类型

- **数值类型**
  - int
  - decimal(a,b) -- 总共a位，其中小数部分b位
  - tinyint -- 如age、score等数值值域较小的属性，可以使用tinyint
  - **【修饰】unsigned -- 无符号，可扩大值域范围（无负数方向）**

- **字符串类型**
  - char(n) -- 定长字符串，至多n个字符，不足n个字符，占用n个字符空间
  
  - varchar(n) -- 变长字符串，至多n个字符，不足n个字符时，按照实际长度存储
  
- **日期类型**
  - **date**  `YYYY-MM-DD`
  - **time**  `HH:MM:SS`
  - **year**  `YYYY`
  - **datetime**  `YYYY-MM-DD HH:MM:SS` **（最常用）**

##### 6.2.4 数据库设计

​	数据库设计： **“原型设计”（即针对情景的设计）+  “基础字段”（记录编号id，创建时间，更新时间等）**

<img src="Note_pic\image-20251011152933285.png" alt="image-20251011152933285" style="zoom:67%;" />

#### 6.3 DML语句 -- 数据的增删改

```sql
-- Insert
-- 注：a. sql中的now()函数可表示datetime类型的当前时间
-- 注：b. 字符串与datetime等类型需要包含在单引号内
insert into tableName (字段名1,字段名2) values (值1,值2),(值1,值2)...; -- 批量添加指定字段数据
insert into tableName values (值1,值2,,...),(值1,值2,...),...; -- 批量添加全部字段数据

-- Update
-- 注：没有where条件时，将对整张表进行操作
update tableName set 字段名1=值1, 字段名2=值2, ... [where condition];

-- Delete
-- 注：没有where条件时，将对整张表进行操作
delete from tableName [where condition];
```

#### 6.4 DQL 语句 -- 数据的查询  

```sql
-- DQL语法
SELECT 字段列表
FROM 表名列表
WHERE 条件列表
GORUP BY 分组字段列表
HAVING 分组后条件列表
ORDER BY 排序字段列表
LIMIT 分页参数
```

##### 6.4.1 基本查询

```sql
-- 查询多个字段
select 字段1,字段2,... from tableName;
-- 设置别名
select 字段1[as 别名1],... from tableName;
-- 去除重复记录(distinct关键字)
select distinct 字段列表 from tableName;
```

##### 6.4.2 条件查询

<img src="Note_pic\image-20251016101635618.png" alt="image-20251016101635618" style="zoom:67%;" />

- DQL语句的条件列表中，比较运算符（>,=,<,!=）、逻辑运算符（and(&&),or(||),not(!)）与C++/Java等编程语言相同
- **datetime等日期类型的数据可以使用>=<进行时间的比较，也可以利用between and来进行时间区间的规定。**

```sql
-- between...and （区间范围）
select * from tb_emp where entrydate between '2025-10-01' and '2025-10-08';
-- in （列表中的值）
select * from tb_emp where age in (18,19,20,21,22);
-- like (模糊查询)
select * from tb_emp where name like '__';

```

##### 6.4.3 分组查询

1. **聚合函数** 

> Attention! **聚合函数仅不对null值进行计算！**

<img src="Note_pic\image-20251016102921931.png" alt="image-20251016102921931" style="zoom:67%;" />

​						**`SELECT 聚合函数(字段列表) FROM 表名;`**

```sql
-- count
select count(0) from tb_emp; -- 29
select count(*) from tb_emp; -- 29 (括号内不为null即可统计数量，一般推荐使用*)
-- min
select max(birthdate) from tb_emp; -- tb_emp中的最年轻记录
-- avg
select avg(age) from tb_emp; -- 平均年龄
```

2. **分组查询**

- `select 字段列表 from 表名 [where 条件] group by 分组字段名 [having 分组后过滤条件]`
  - where 是**分组前的过滤**，不满足where条件，不参与分组
  - having 是**分组之后**对各分组进行过滤
  - ***执行顺序：where - 分组/聚合 - having***
- **分组查询后，select可以返回字段为 a. 分组字段 b.聚合函数**

##### 6.4.4 排序查询

- `select 字段列表 from 表名 [ where 条件列表 ] [ group by 分组字段 ] order by 字段1 排序方式1, 字段2 排序方式2, ... ;`
- 升序`ASC`（默认）；降序`DESC`

##### 6.4.5 分页查询 

- `select 字段列表 from 表名 [...] limit 起始索引, 查询记录数;`
  - **起始索引**：从0开始（与数组下标相同），`起始索引=(页码-1)*每页记录数`
  - **查询记录数**：分页中每页展示记录数

- 分页查询是数据库的“方言”，**不同的数据库有不同的实现，MySQL中为Limit。**



#### 6.5 多表数据库

##### 6.5.1 多表设计

- **多表数据的一致性与完整性约束 -- 外键，建议使用逻辑外键而非物理外键。**

```sql
-- 创建表时指定物理外键
-- 实际操作时，利用图形化界面操作更佳！
create table 表名{
	字段名 数据类型 [];
	...
	[constrait] [外键名称] foreign key (外键字段名) references 主表 (字段名)；
}
```

![image-20251016152547019](Note_pic\image-20251016152547019.png)

- **多表关系**
  - **一对一关系**：一般为单表拆分。**在任意一方加入外键，关联另一方主键即可**。
  - **一对多关系**：在“多”对应的表中添加外键，关联到“一”对应的表中主键。
  - **多对多关系**：**建立*关系表*，至少包含两个外键，分别关联两方主键**。

##### 6.5.2 多表查询

1. **笛卡尔积**：两个集合间的所有组合，需要去除无效的笛卡尔积数据。

```sql
select * from tb_emp,tb_dept;
```

2. **连接查询**

   1. **内连接**

      ​	**内连接即A与B表中的交集部分（笛卡尔积交集）**

   <img src="Note_pic\image-20251017105858536.png" alt="image-20251017105858536" style="zoom: 50%;" />

   ```sql
   -- 隐式内连接（常用，利用[连接条件]消除）
   select 字段列表 from 表1,表2 where 连接条件...;
   -- 显式内连接
   select 字段列表 from 表1 [inner] join 表2 on 连接条件...;
   -- 显式内连接示例
   select tb_emp.name,tb_dept.name from tb_emp join tb_dept on tb_dept.id=tb_emp.dept__id;
   ```

   2. **外连接**

      ​	**左外连接/右外连接**，事实上语义完全相同。**A与B进行左外连接，即取A与B表中的交集部分+A的部分**。体现在数据上，**即包含笛卡尔积中左表的所有数据（若连接条件连接不上，则左表数据中对应右表属性为Null）**

   <img src="Note_pic\image-20251017110832642.png" alt="image-20251017110832642" style="zoom: 50%;" />          

   ```sql
   -- "on"后，可接"where"来增添筛选条件
   select 字段列表 
   from 
   	表1 left join 表2 on 连接条件 
   where ...
   ```

   ![image-20251017111333505](Note_pic\image-20251017111333505.png)

3. **子查询（嵌套查询）**

> *多次查询表中数据，尽量使用连接查询*

```sql
-- 标量子查询（子查询返回结果为单个值）
select * from tb_emp where dept_id = (select id from tb_dept where name = '教务处');

-- 列子查询（子查询返回结果为一列，可以是多行）
-- 常用 in , not in 等
select * from b_emp where dept_id in (select id from tb_dept where name='教务处' or name = '生活处');

-- 行子查询（子查询返回结果为一行，可以是多列）
-- 利用“组合属性”，使得仅需一次子查询即可
select * from tb_emp where (entrydate,job) = (select entrydate,job from tb_emp where name='罗宾');

-- 表子查询（子查询返回结果为一个临时子表）
select * 
from  (select * from tb_emp where entrydate > '2025-09-25') as e, tb__dept as d
where e.dept.id = d.id;
```



#### 6.6 事务

##### 6.6.1 概念&操作

事务是一组操作的集合，这些操作**要么同时成功，要么同时失败**，是**不可分割的工作单位**。（默认MySQL的事务自动提交，每执行一条DML语句，则隐式提交一次事务）

```sql
-- 开启事务
start transaction; / begin;
-- 提交事务（若执行但未提交，不会影响数据库中的数据，仅会影响当前事务处的数据（隔离性））
-- 事务中所有操作执行均成功后，则可提交事务
commit;
-- 回滚事务
-- 事务中存在操作未成功，则rollback回滚事务
rollback;
```

##### 6.6.2 ACID 特性

- **A** -- Atomicity **原子性**。事务是不可分割的最小单元。

- **C** - Consistency **一致性**。事务完成时，必须使所有数据保持一致。

- **I** - Isolation **隔离性**。事务不收外部并发操作影响。

- **D** - Durability **持久性**。**事务一旦提交或回滚，其对数据库中的改变是永久的**。



#### 6.7 索引

> **索引**是数据库**高效获取数据**的数据结构

##### 6.7.1 原理

​	当没有“索引”时，进行**全表扫描**；当对某字段建立索引时，在底层利用***B+树、Hash表***等数据结构，减少了搜索次数。

- **建立索引 -- 优缺点**

  - **优点**：提高查询效率，降低数据排序成本；

  - **缺点**：索引占用存储空间，降低了增删改的效率（数据改变，需要维护索引有序）

- **B+树（多路平衡搜索树）--  默认数据结构**

  - 非叶节点*仅用于索引/查找*节点；
  - *叶子节点保存所有数据*、包含所有的键值，形成了双向链表



##### 6.7.2 语法

```sql
-- 创建索引
-- unique - 唯一索引
create [unique] index 索引名 on 表名 {字段名...};
-- 查看索引
show index from 表名;
-- 删除索引
drop index 索引名 on 表名;
```

- **主键索引**：最优性能，*数据库默认创建索引*；
- **唯一索引**：*属性设置为“唯一约束” （即在属性定义处设置为unique 约束时），数据库默认将设置唯一索引*
