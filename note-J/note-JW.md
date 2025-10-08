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



### **3. http协议**

> 超文本传输协议，**基于TCP连接、无状态**（事务处理没有记忆能力，每次请求-响应独立）

#### 3.1 http报文格式

##### 3.1.1 请求报文格式

- **请求行**：**请求方式（GET/POST）、资源路径**、http版本
- **请求头**：控制信息（K-V格式，浏览器版本、报文长度、报文类型等）
- **请求体：仅POST请求时存在，存放请求参数；GET方式时，提交内容存在于“请求行.资源路径”处**

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
