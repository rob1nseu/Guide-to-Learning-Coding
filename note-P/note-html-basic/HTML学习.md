# **HTML基础**

> 在Web开发中，**HTML** 定义了网页的内容；**CSS** 描述了网页的布局；**JavaScript** 控制了网页的行为

## **HTML简介**

- HTML不是编程语言，而是标记语言，**用于描述网页（又称Web页面）.**
- HTML 标签**成对出现**的，比如 **<标签>**（起始）**和 </标签>**（闭合）

## **HTML基础 -- 多个实例.**

1. 标题（Heading）是通过`<h1> - <h6>` 标签来定义的
2. 段落是通过标签 `<p>` 来定义的.
3. 链接是通过标签 `<a>` 来定义的.
4. 图像是通过标签 `<img>` 来定义的.
5. 注释是通过`<!-- 注释 -->`来定义的.
6. **`<html>`用于定义HTML文档；`<body>`用于定义文档的主体.**

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

## **HTML属性**

- 属性一般描述于开始标签，以name="value"的形式出现
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



## **HTML超链接**

> **HTML 链接（Anchor）是网页之间跳转的核心部分**

```html
<!--超链接anchor-->
<!--href：定义链接目的地（当为“#”时，导航到页面顶部）-->
<!--target：定义链接的打开方式-->
<!--链接类型不一定是文本链接，还可以是img等元素-->
<a href="URL">链接文本</a>,点击后，浏览器将导航到此URL

<!--id：用于锚点链接，通常在同一页面中跳转到某个特定位置-->
<a href="#section1">跳转到第1部分</a>
<div id="section1">这是第1部分</div>
```

## **HTML头部**

```html
<!--HTML头部-->
<head> 
<meta charset="utf-8"> 
<title>文档标题</title>
</head>
```

- 标签`<base>`描述基本的链接地址与连接目标
- 标签`<link>`定义了文档与外部资源的关系，常用于链接到样式表.
- 标签`<meta>`描述基本原数据（如author、keyword、description等）



## **HTML表单**

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

- **`<form>` 元素用于创建表单**，`action` 属性定义了表单数据提交的目标 URL（method默认为GET），`method` 属性定义了提交数据的 HTTP 方法
- `<label>` 元素用于为表单元素添加标签
- `<input>` 元素可以创建文本输入框。`type` 属性定义了输入框的类型，`id` 属性用于关联 `<label>` 元素，`name` 属性用于标识表单字段
  - type="text" -- 文本域
  - type="password" -- 密码域
  - type="submit" -- 提交按钮
- `<select>` 元素用于创建下拉列表，而 `<option>` 元素用于定义下拉列表中的选项