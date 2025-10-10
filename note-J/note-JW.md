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

<img src="C:\Users\86157\Desktop\Guide-to-Learning-Coding\Guide-to-Learning-Coding\note-J\Note_pic\image-20251010204441664.png" alt="image-20251010204441664" style="zoom:50%;" />

- 由于 `@RestController = @Controller + @ResponseBody` ，则在` Controller `层中，用`RestController` 即可1
- IOC容器中的对象，存在名字，默认为**“ 类名（首字母小写）”**，也可以在注解处修改：`@Service(value="serviceA")`，其中"value="可以省略
- 上述注解要想生效，需被@ComponentScan扫描（@Component注解包含在了启动类声明注解@SpringBootApplication中），因此，默认扫描范围为启动类所在包及其子包。（当然可以修改配置，但不推荐）



##### 5.3.2 DI

- **@Autowired -- 从IOC容器中寻找到指定类型的Bean对象**

- **若同类型bean存在多个：**
  - @Primary  --  在希望使用的bean类前添加该注解
  - @Autowired + @Qualifier("bean的名称") -- 希望使用的bean的名称
  - @Resource("name='bean的名称'") -- **与@Autowired的区别为@Resource注解为JDK提供**

