# **JavaScript浅学**

> JavaScript是一门跨平台、面向对象的脚本语言（无需编译，浏览器解释即可运行），可用于网页行为控制
>
> JS与Java是完全不同的两门语言，仅基础语法类似

## **1. HTML中JS的引入**

​	JS在HTML页面中，主要有两种引入方式：

​	**（1）内部脚本：JS代码定义在.html文件中**

​		`<script></script>`代码段可以位于.html文件的*任何地方*（一般置于`<body></body>`后）

<img src="note-js-pic\image-20250927161248089.png" alt="image-20250927161248089" style="zoom: 33%;" />

​	**（2）外部脚本：JS代码写在外部的.js文件中，引入到.html文件中**

<img src="note-js-pic\image-20250927161338152.png" alt="image-20250927161338152" style="zoom: 33%;" />

## **2. JS基本语法**

#### 2.1 输出语句

- 使用window.alert()写入警告框，在弹出模态框中展示；
- 使用document.write()将内容写到页面.html中展示；
- 使用console.log()写入浏览器控制台，F12后于浏览器Console处输出。

<img src="note-js-pic\image-20250927162006186.png" alt="image-20250927162006186" style="zoom: 50%;" />

#### 2.2 变量

​	**JS是一门弱类型语言，类似Python，但仍然存在类型！**

<img src="note-js-pic\image-20250927163125167.png" alt="image-20250927163125167" style="zoom: 50%;" />

​	利用`var`声明的语言**作用域为全局变量，在{}的作用域外同样可以访问，且可以重复定义（var a; var a;）**，*So* 存在`let`的的变量声明方法，其仅在对应的代码块内有效，且不允许重复定义！

<img src="note-js-pic\image-20250927163613541.png" alt="image-20250927163613541" style="zoom: 50%;" />



#### 2.3 数据类型&类型转换

<img src="note-js-pic\image-20250927164009389.png" alt="image-20250927164009389" style="zoom:50%;" />

- **`typeof(variable)`方法**，可以打印对应`variable`变量的类型

- 类型转换：

  - 字符串类型转换为数字，若字面值不是数字，则转为NaN -- **`parseInt()`方法**

  ```javascript
  ...
  window.alert(parseInt("12")); // 浏览器弹出警告框
  ...
  ```

<img src="note-js-pic\image-20250927210921791.png" alt="image-20250927210921791" style="zoom: 50%;" />



#### 2.4 函数

```javascript
// 形参与返回值均不需类型，类似python
// 定义方式一
function functionName(参数1, 参数2,...){
	// 需执行的代码
}

// 定义方式二
var functionName = function(参数1, 参数2,...){
    ...
}
```

**其他未涉及到的基本语法，包括流程控制、运算符等与Java完全一致！**



## **3. JS对象**

#### 3.1 数组

> JavaScript中，Array对象用于定义数组

```javascript
// 数组定义
var variableName = new Array(元素列表);
var variableName = [元素列表];

// 访问
arr[10] = 12;

// foreach()
arr.foreach(function(e){
    console.log(e); // 在浏览器控制台打印输出arr中的所有元素.
})

// push()
arr.push(7,8,9); // 可以一次push多个元素

// slice()
arr.slice(2,2); // 从索引为2处，连续删除2个元素
```

<img src="note-js-pic\image-20250927220226484.png" alt="image-20250927220226484" style="zoom: 50%;" />



#### 3.2 字符串

```javascript
// trim()
var s = str.trim();
console.log(s);

// substring()
str.substring(start,end) // 子串为[)形式
```

![image-20250927220724364](note-js-pic\image-20250927220724364.png)



#### 3.3 JSON对象

​	在聊JSON前，不妨先聊聊JavaScript中的*自定义对象*（类似于“类”），自定义对象与JSON格式有千丝万缕、密不可分的关系！

<img src="note-js-pic\image-20250927222801467.png" alt="image-20250927222801467" style="zoom: 33%;" />

​	下图中，未进行`JSON.parse()`前，`userStr` 仅是一个字符串；JavaScript中提供了JSON.parse()方法用于将之转化为JSON对象。

<img src="note-js-pic\image-20250927222407886.png" alt="image-20250927222407886" style="zoom: 33%;" />

#### 3.4 BOM对象

​	Browser Object Model 浏览器对象模型，JavaScript将浏览器的各个部分封装为对象，主要包含：

- **Window，浏览器窗口对象**
- **Location，地址栏对象**
- Navigator，浏览器对象
- History，历史记录对象
- Screen，屏幕对象

##### 3.4.1 Window对象

<img src="note-js-pic\image-20250928124819962.png" alt="image-20250928124819962" style="zoom:50%;" />

```javascript
// Window对象常用方法（直接写window即可获取到window对象）
// alert()方法
window.alert("Hello BOM");

// confirm()方法 -- “确认取消”对话框
var flag = confirm("确认删除记录吗？") // 将用户输入记录到flag变量中
alert(flag);

// setInterval()方法 -- 定时器，周期性地执行某一个函数
setInterval(function(e){
	console.log("执行一次function");
},2000)

// setTimeout()方法 -- 倒计时，倒计时执行某一函数
setTimeout(function(e){
	console.log("倒计时时间到");
},3000)
```

##### 3.4.2 Location对象

<img src="note-js-pic\image-20250928130422657.png" alt="image-20250928130422657" style="zoom: 33%;" />

- **用途：Location对象实现页面的切换**

```javascript
// 利用location.href属性，实现页面切换
// 应为window.location.href，但"window."可以省略
location.href = "http://www.bilibili.com"; 
```



#### 3.5 DOM对象

​	**Document Object Model 文档对象模型，将标记语言的各个部分封装成对应的对象**，包含：

- Document：整个文档对象（整体）
- Element：元素对象（每标签都会被封装成对象）
- Attribute：属性对象
- Text：文本对象
- Comment：注释对象

​	一段.html代码的DOM树如下：

<img src="note-js-pic\image-20250928131440830.png" alt="image-20250928131440830" style="zoom: 50%;" />

​	**JS通过DOM，可以对HTML进行修改内容、样式等操作**，下面展示的是对元素对象的获取。在获取到对象之后，需要利用对象中的属性/方法，来修改内容/样式。（查找JS文档）

- 由于`window.`可省略，因此，仅需要`document`即可完成调用

<img src="note-js-pic\image-20250928132057240.png" alt="image-20250928132057240" style="zoom: 50%;" />



## **4. JS事件监听**

- JS在将页面元素与事件进行绑定时，存在以下两种绑定方式：
  - 在HTML语言定义标签处进行事件绑定：`onclick="funcName()"`
  - **获取DOM对象，利用"."的方式进行绑定**

<img src="note-js-pic\image-20250928155437730.png" alt="image-20250928155437730" style="zoom: 50%;" />

​	

​	**常见事件如下：**

<img src="note-js-pic\image-20250928160202604.png" alt="image-20250928160202604" style="zoom:50%;" />
