# 速成SpringCloud

> **每一个微服务模块 = 一个完整的、可独立运行的 Spring Boot 应用程序。**

### **SpringCloud五大组件**

> https://www.bilibili.com/video/BV1FNvTzdEip/?spm_id_from=333.337.search-card.all.click&vd_source=d559e2f3879debf95e8059218e535c9a **邪修这一块**

- **注册中心** nacos

  ​	各个模块将自己<模块名，IP地址与端口>上报到注册中心，注册中心中以map的<key,value>类型保存。模块A调用模块B的接口时，模块A向注册中心提供模块B的模块名，从而获得模块B的IP地址端口等信息，从而实现调用。

- **负载均衡** Ribbon

​	事实上，注册中心<模块名，IP地址与端口>中的“IP地址与端口”是一个列表，包含对应模块各个节点的IP+port。存在多种负载均衡的策略：轮询、最小连接数等。

- **服务调用** Feign

​	实现[IP+port+接口名]的封装，方便调用。

- **熔断** Hytrix

​	保险丝，当A模块调用B模块服务时，若请求量过大，B服务可能直接宕机。熔断机制可以让B放行可接受的最大容量，剩余无法处理请求可以自定义返回告知A模块，从而使服务保持运行。

- **网关**

​	收口集成框架，实现 **用户 -- 网关 -- 模块（自行分发）**的结构，使调用流程更加简洁。

- **“第六大支柱” -- ConfigServer**

​	**Config Server（配置中心）** 是 Spring Cloud 提供的一个用于**集中管理所有微服务配置文件的服务**。在没有配置中心时，每个微服务都有自己的 `application.yml` 或 `application.properties`，难以统一控制与修改。

**❌ 无ConfigServer时存在的问题：**

| 问题           | 描述                                   |
| -------------- | -------------------------------------- |
| 🔧 配置分散     | 每个服务都有一份配置，难以统一管理     |
| 🔄 修改困难     | 改一个数据库密码，要改十几个服务的配置 |
| 🚫 环境混乱     | dev/test/prod 环境切换麻烦             |
| 📦 不支持热更新 | 修改配置必须重启服务（除非结合 Bus）   |

### **愚者-课堂**

- 主要是项目架构设计
- 注册中心：Eureka为springcloud自带，作为课设已经足够
- 课设中无需配置网关
- K8S、Docker 有机会一定要学习，主要针对大型项目

### **JWT**

​	JWT 是一种**开放标准（RFC 7519）**，用于在各方之间安全地传输信息，通常用于**身份验证（Authentication）\**和\**授权（Authorization）**。它是一个**字符串**，长得像下面这样，字符串由三部分组成，用 `.` 分隔：

```
xxxxx.yyyyy.zzzzz
```

#### 1️⃣ **Header（头部）**

- 包含令牌的类型（`JWT`）和所使用的签名算法（如 `HS256`）。

  ```
  {
    "alg": "HS256",
    "typ": "JWT"
  }
  ```

- 这部分会被 **Base64Url 编码**。

#### 2️⃣ **Payload（载荷 / 数据）**

- JWT 的核心，存放实际的信息，比如：

  用户ID（`sub`）、用户名（`name`）、角色（`role`）、过期时间（`exp`）、签发时间（`iat`）

  ```
  {
    "sub": "1234567890",
    "name": "张三",
    "role": "admin",
    "exp": 1600000000,
    "iat": 1599996400
  }
  ```

- 这部分也会被 **Base64Url 编码**。

- ⚠️ **注意**：Payload 是可以被解码查看的，所以**不要放密码、银行卡号等敏感信息**！

#### 3️⃣ **Signature（签名）**

- 这是 JWT 的“防伪标签”。
- 服务器用一个**密钥（secret）**，对 `Header + Payload` 进行加密（比如 HMAC SHA256 算法），生成一个签名。
- 这个签名确保了：
  - 令牌没有被篡改（如果有人改了 Payload 里的角色，签名就对不上了）。
  - 令牌是服务器签发的（只有服务器知道密钥）。

#### JWT工作流程

1. **用户登录**

   - 用户发送用户名和密码到服务器。
   - 服务器验证通过后，**生成一个 JWT**（包含用户信息 + 签名）。

2. **服务器返回 JWT**

   - 服务器把 JWT 返回给客户端（通常是浏览器或 App）。
   - 客户端把它存起来（比如放在 `localStorage` 或 `Cookie` 中）。

3. **后续请求**

   - 客户端每次请求 API 时，在请求头（

     ```
     Authorization
     ```

     ）中带上 JWT：

     ```
     Authorization: Bearer <你的JWT>
     ```

4. **服务器验证 JWT**

   - 服务器收到请求后，提取 JWT。
   - 用同样的密钥重新计算签名，和 JWT 中的签名对比。
   - 如果一致，说明令牌合法，且信息未被篡改。
   - 服务器从 Payload 中读取用户信息，处理请求。

### **Feign：服务间调用**

> **Feign 把“远程调用”伪装成了“本地调用”**

- **@FeignClient注解**：调用远程服务接口，**指定远程服务名（注册中心中注册的服务名）**

| 步骤 | 发生了什么                                                   |
| ---- | ------------------------------------------------------------ |
| 1️⃣    | 用户访问 `http://localhost:8081/test`（**本服务Controller层接口**） |
| 2️⃣    | `MyController` 调用 `helloService.hello()`（调用**本服务Service层对象所提供的方法（实际上是）**） |
| 3️⃣    | Feign 拦截这个调用，知道你要调用 `service-provider` 的 `/api/hello` |
| 4️⃣    | Feign 通过 **Ribbon**（负载均衡）从 **Nacos/Eureka** 查询 `service-provider` 的可用实例（IP:Port） |
| 5️⃣    | Feign 自动生成 HTTP 请求：`GET http://192.168.1.100:8082/api/hello` |
| 6️⃣    | 拿到响应，转成 `String`，返回给 `MyController`               |

```java
// Service层调用其他服务的接口
@FeignClient(name = "service-provider")
public interface HelloService {

    @GetMapping("api/hello")
    String hello();

    @GetMapping("/api/user/hello/{name}")
    String helloWithName(@PathVariable("name") String name);
}
```

| 情况             | 结果                                              |
| ---------------- | ------------------------------------------------- |
| ❌ 不加这个拦截器 | `service-provider` 收不到 JWT → 返回 401 未授权   |
| ✅ 加了这个拦截器 | `service-provider` 收到 JWT → 验证通过 → 返回数据 |