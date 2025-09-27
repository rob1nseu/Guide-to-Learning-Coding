# **HTML/CSS基础**

> Web开发中，
>
> **HTML 定义了网页的元素与内容；**
>
> **CSS 描述了网页的表现与样式；**
>
> **JavaScript** 控制了网页的行为与交互

## **1. HTML**

- HTML不是编程语言，而是标记语言，**用于描述网页（又称Web页面）**
- HTML标签**成对出现**的，比如 **<标签>**（起始）**和 </标签>**（闭合）
- HTML标签不区分大小写，语法结构不算严格，较为松散

### **1.1 HTML结构**

```html
<html>
	<!--HTML头部-->
	<head>
		<meta charset="utf-8"> 
		<title>文档标题</title>  <!--文档标题即浏览器上部的标题名称-->
	</head>
    <!--HTML体-->
    <body>
        <!--填写HTML内容-->
        <h1> 你好，我是rob1n！</h1> <!--一级标题-->
        <img src=avatar.jpg/> <!--图片-->
    </body>
</html>
```

- 标签`<base>`描述基本的链接地址与连接目标
- 标签`<link>`定义了文档与外部资源的关系，常用于链接到样式表.
- 标签`<meta>`描述基本原数据（如author、keyword、description等）

### **1.2 HTML实例与其常用属性**

1. **`<html>`用于定义HTML文档；`<head>`用于定义文件头；`<body>`用于定义文档的主体.**
2. 标题（Heading）是通过`<h1> - <h6>` 标签来定义的
3. 段落是通过标签 `<p>` 来定义的.
4. **超链接是通过标签 `<a>` 来定义的.**

   

   1. <img src="note-html-pic\image-20250927105700128.png" alt="image-20250926213225521" style="zoom: 50%;" />

   2. ```html
      <!--超链接anchor-->
      <!---->
      <!--href：定义链接目的地（当为“#”时，导航到页面顶部）-->
      <!--target：定义链接的打开方式（_self为在当前页面打开；_blank为在空白页面打开）-->
      <!--链接类型不一定是文本链接，还可以是img等元素-->
      <a href="URL">链接文本</a>,点击后，浏览器将导航到此URL
      
      <!--id：用于锚点链接，通常在同一页面中跳转到某个特定位置-->
      <a href="#section1">跳转到第1部分</a>
      <div id="section1">这是第1部分</div>
      ```
5. 图像是通过标签 `<img>` 来定义的.
   - src：指定图像的url（绝对磁盘/网络路径 或 相对路径）
   - height/width 以像素为单位的高度与宽度 e.g 300px，只需限定一个，另一属性将等比例缩放
6. 注释是通过`<!-- 注释 -->`来定义的.
7. **`<span>`标签：无语义的布局标签，用于组合行内元素为一个标签（方便设置CSS样式等）**
8. `<b></b>`标签用于文本加粗
9. 视频标签`<video></video>`，音频标签`<audio></audio>`
10. 表格标签`<table>`，`<th>`表示首行（用于定义属性名），其余每行需一个`<tr>`
11. **`<br></br>`表示换行**

```html
<!--标题-->
<h1>这是一个标题</h1> <!-- 起始与闭合加上中间部分即为HTML元素.-->
<!--段落-->
<p>这是一个段落。</p>
<!--链接-->
<a href="https://www.runoob.com">这是一个链接</a>
<!--图片-->
<img src="/images/logo.png" width="258" height="39" />
```

### **1.3 HTML属性**

- 属性一般描述于开始标签，以name="value"的形式出现**（属性K-V中单引号/双引号均可）**
- 向元素中添加附加信息
  - **id--为元素指定唯一的标识**； 
  - class--为元素指定类名，用于CSS或Javascript选择；
  - **href--指定链接的目标URL；onclick、onchange、checked等**
  - **style--用于直接在元素上应用CSS样式**
  - type--用于`<input>`与`<button>`元素，指定控件类型（如text）

```html
<a href="https://www.runoob.com">这是一个链接使用了 href 属性</a>
```

![image-20250912214320164](C:\Users\86157\Desktop\Guide-to-Learning-Coding\Guide-to-Learning-Coding\note-P\note-html-basic\note-html-pic\image-20250912214320164.png)

### **1.4 HTML表单标签**

> HTML表单表示文档的一个区域，收集用户输入并将其发送到Web服务器

```html
<form action="/" method="post">
    <!-- input输入框 type为text -->
    <label for="name">用户名:</label>
    <input type="text" id="name" name="name" required>

    <br>

    <!-- input输入框 type为password(输入为隐藏状态) -->
    <label for="password">密码:</label>
    <input type="password" id="password" name="password" required>

    <br>

    <!-- select下拉列表  -->
    <label for="country">国家:</label>
    <select id="country" name="country">
        <option value="cn">CN</option>
        <option value="usa">USA</option>
        <option value="uk">UK</option>
    </select>

    <br>

    <!-- 提交按钮 type为submit -->
    <input type="submit" value="提交">
</form> 
```

- **`<form>` 元素用于创建表单**

  - **`action` 属性定义了表单数据提交的目标 URL（默认为当前页面URL，一般为服务端URL地址）**

  - **`method` 属性定义了提交数据的 HTTP 方法（默认为GET）**
    - *GET：在URL后面拼接表单数据，存在URL长度限制，如下图*
    - *POST：在http消息体中传递，大小无限制（可F12看到报文）*

  <img src="note-html-pic\image-20250927121350450.png" alt="image-20250927121350450" style="zoom: 67%;" />

#### 表单项

- `<label>` 元素用于为表单元素添加标签
- **`<input>` 元素可以创建文本输入框，通过 type` 属性控制输入形式**
  - type="text" -- 文本域
  - type="password" -- 密码域
  - type="submit" -- 提交按钮

<img src="note-html-pic\image-20250927122537636.png" alt="image-20250927122537636" style="zoom: 50%;" />

- `<select>` 元素用于创建下拉列表，而 `<option>` 元素用于定义下拉列表中的选项
- `<textarea>`文本域



**注：**表单项中**必须有标识表单字段的"name"字段才可能提交**！





## **2. CSS**

> **CSS** *(Cascading Style Sheets，层叠样式表），是一种用来为结构化文档添加样式的计算机语言*
>
> 进行CSS编写时，需要经常性地查看CSS官方文档

### **2.1 将CSS引入HTML**

将CSS样式表引入.html文件主要有三种方式：
- 行内样式：在单个html元素内，进行style属性的K-V键值设置 （不建议）
- **内嵌样式：一般在`<head></head>`中进行`<style>`的定义，图片中的"h1"为选择器，针对当前页面标签为"h1"的页面渲染表现**
- **外联样式：.css文件中，从而支持样式复用**；`<link></link>`声明一般在`<head></head>`中

<img src="note-html-pic\image-20250926213225521.png" alt="image-20250926213225521" style="zoom: 50%;" />



### **2.2 CSS选择器**

**如何给指定的某标签元素设置样式？**存在以下三种样式设置方法：

- 元素选择器：写法与上述“内嵌样式”相同，`<style></style>`内使用`标签名称 {...}`的形式
- id选择器：页面中"id"属性不能重复，`<style></style>`中使用`#id名 {...}`的形式 （**id是什么？见 1.3 HTML属性**）
- 类选择器：为选定标签设置"class"属性，`<style></style>`中使用`.class名称 {...}`的形式

<img src="note-html-pic\image-20250926222617582.png" alt="image-20250926222617582" style="zoom: 50%;" />



### **2.3 CSS盒子模型**

<img src="note-html-pic\image-20250927115407073.png" alt="image-20250927115407073" style="zoom: 67%;" />

​	页面中的所有元素（标签）可以看做是一个盒子，由盒子将页面内的元素包含在一个矩形区域内，**包含内容区域（content）、内边距区域（padding）、边框区域（border）、外边距区域（margin）**

- **实际开发中，经常使用没有语义的 `div` 与 `span` 布局标签：**

  - **`<div></div>` 常用于CSS盒子布局模型中，在`<style></style>`内，利用`<div>`标签/id的方式引入CSS样式**
  - <img src="note-html-pic\image-20250927120407935.png" alt="image-20250927120407935" style="zoom: 50%;" />
  - `<span></span>` 即HTML中用于行内组合的标签

  ![image-20250927115932026](note-html-pic\image-20250927115932026.png)