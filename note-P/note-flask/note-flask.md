# Flask框架学习

> **Flask没有固定框架，主要由路由route、SQLALchemy、蓝图等机制组成，重点是掌握其编码思想.**

## **HTML中的各页面连接方式：**

| 触发者 | 代码 / 动作                                          | 浏览器行为                      | 地址栏会变？ | 是否整页刷新 |
| ------ | ---------------------------------------------------- | ------------------------------- | ------------ | ------------ |
| 用户   | 点击 `<a href="/about">`                             | 发 GET `/about`                 | ✅            | ✅            |
| 表单   | `<form action="/login" method="post">` 提交          | 发 POST → 服务器回 302/301      | ✅            | ✅            |
| 服务器 | Flask `redirect('/dashboard')` 返回 302/301          | 浏览器自动再发 GET `/dashboard` | ✅            | ✅            |
| JS     | `location.href = '/home'` 或 `<Link>` (React-Router) | 发 GET 或仅前端路由             | ✅ / ❌        | ✅ / ❌        |

## **Flask基础**

1. #### 基本概念：

   - **路由**：路由是 URL 到 Python 函数的映射。Flask 允许你定义路由，这样当特定的 URL 被访问时，就会调用相应的函数。

   ```python
   @app.route('/') # 将根 URL / 映射到 home 函数
   def home():
     return 'Welcome to the Home Page!'
   ```

   - **视图函数**：
     - 视图函数是**处理请求并返回响应**的 Python 函数，即在路由中指定参数，可以将URL中的部分数据传递给视图函数。
     - 通常与路由配合使用，通过装饰器将 URL 映射到视图函数。

   ```python
   from flask import request
   
   @app.route('/greet/<name>')
   def greet(name):
       return f'Hello, {name}!' # greet 函数接收 URL 中的 name 参数，并返回一个字符串响应
   ```

   - **请求对象**：请求对象包含了客户端发送的请求信息，Flask提供了request对象来访问这些信息。**对不同的请求参数`methods`，支持不同的HTTP请求方法（此处为POST）。**

   ```python
   from flask import request
   
   @app.route('/submit', methods=['POST'])
   def submit():
       username = request.form.get('username') # 获取 POST 请求中表单数据的 username 字段
       return f'Hello, {username}!' 
   ```

   - **模板**：Flask 使用 Jinja2 模板引擎来渲染 HTML 模板。

   ```python
   from flask import render_template
   
   @app.route('/hello/<name>')
   def hello(name):
       return render_template('hello.html', name=name) 
   # GET'/hello/<name>'目录时，render_template()方法可以渲染'hello.html'
   ```

   - **配置对象**：配置各种配置选项，如数据库连接字符串，秘钥等。`class Config`

     > 其他还有会话session模块、蓝图blueprints模块、响应对象模块等...



2. #### **一个 Flask 应用可以简单到只有一个文件，结构可以自己设计！**





## **Flask模板渲染**

> Flask 使用 Jinja2 模板引擎来渲染这些模板，将 Python 数据插入到 HTML 中，从而生成最终的网页。

1. #### **创建模板文件**

   > 在项目目录下创建 templates 文件夹，并在其中创建一个 HTML 文件，如 index.html。

   ```python
   # 模板.html，{{ title }} 和 {{ name }} 是模板占位符，将在渲染时被替换成实际的值
   <!DOCTYPE html>
   <html>
   <head>
       <title>Welcome</title>
   </head>
   <body>
       <h1>{{ title }}</h1>
       <p>Hello, {{ name }}!</p>
   </body>
   </html>
   
   # app.py
   @app.route('/')
   def home():
   	# 渲染 index.html 模板，并将 title 和 name 变量传递给模板。
       return render_template('index.html', title='Welcome Page', name='John Doe')
   ```

2. #### **创建子模板**：

   > 在 templates 文件夹中创建一个子模板 index.html，继承 base.html。

   ```html
   {% extends "base.html" %}
   
   {% block title %}Home Page{% endblock %}
   
   {% block content %}
   <h2>Welcome to the Home Page!</h2>
   <p>Content goes here.</p>
   {% endblock %}
   ```




## **Flask数据库--SQLAlchemy**

1. #### **配置SQLALchemy**

   ```python
   from flask import Flask
   from flask_sqlalchemy import SQLAlchemy
   
   app = Flask(
       __name__,
       template_folder='../frontend/templates',
       static_folder='../frontend/static'
   )
   
    # 本地MySQL服务器密码为123456
   app.config['SQLALCHEMY_DATABASE_URI'] = 'mysql+pymysql://root:123456@localhost/deeptrip?charset=utf8mb4' 
   app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
   
   # 绑定 SQLAlchemy 实例到 Flask app
   db.init_app(app)
   ```

2. #### **定义模型**

   ```python
   # 模型是数据库表的 Python 类，每个模型类代表数据库中的一张表
   class User(db.Model):
       id = db.Column(db.Integer, primary_key=True)
       username = db.Column(db.String(80), unique=True, nullable=False)
       email = db.Column(db.String(120), unique=True, nullable=False)
   
       def __repr__(self):
           return f'<User {self.username}>'
       
   # db.Model：所有模型类需要继承自 db.Model。
   # db.Column：定义模型的字段，指定字段的类型、是否为主键、是否唯一、是否可以为空等属性。
   ```

3. #### **基本的CRUD操作**

   ```python
   @app.route('/add_user')
   def add_user():
       new_user = User(username='john_doe', email='john@example.com')
       db.session.add(new_user)
       db.session.commit()
       return 'User added!'
   
   # db.session.add(new_user)：将新用户对象添加到会话中。
   # db.session.commit()：提交事务，将更改保存到数据库。
   ```



- ## **Flask蓝图**

  > 允许你将 Flask 应用分解成多个模块，可以有自己的路由、视图函数、模板和静态文件......

  #### **创建蓝图涉及到以下两个步骤：**

  1. ##### **定义蓝图：**

     > 在一个独立的模块（文件）中定义蓝图。
  
  - ```python
    # 创建一个名为 auth 的蓝图
    admin_bp = Blueprint('admin', __name__)
    
    // 定义的蓝图可以用来处理请求.
    @auth_bp.route('/admin/login')
    def login():
        return render_template('auth/login.html')
    ```

  2. ##### **注册蓝图：**
  
     > 在主应用中注册蓝图，使其生效。
  
  - ```python
    # app.py
    
    import ......
    app = Flask(
        __name__,
        template_folder='../frontend/templates',
        static_folder='../frontend/static'
    )
    ......
    # 注册名为"admin"的蓝图
    app.register_blueprint(admin_bp)
    
    # 注册蓝图（完整参数版）
    app.register_blueprint(
        admin_bp,
        url_prefix='/admin', # 将admin蓝图的路由前缀设置为'/admin'
        static_folder='static', 
        template_folder='templates'
    )
    ```
  
    