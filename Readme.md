## JAVA web 期中作业(后台)

### 项目结构(暂时)：
```
.
├── bookstore.iml
├── build.gradle 
├── gradle
├── gradlew
├── gradlew.bat
├── out
├── Readme.md
├── settings.gradle
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── expr
    │   │           └── bookstore
    │   │               ├── BookstoreApplication.java
    │   │               ├── controllers //控制层
    │   │               ├── dao         //数据层，使用JPA
    │   │               ├── services    //编写相对复杂的一些业务逻辑，避免扰乱数据层
    │   │               └── util
    │   └── resources
    │       └── application.properties
    └── test
        ├── java
        └── resources
```
### 项目构建与开发(推荐使用IDEA)
1. fork 仓库 `https://github.com/Stan1812/book_store.git`
2. `git clone https://${your address}`
3. IDEA导入本地项目（使用gradle，本项目依赖源已更改为阿里云镜像，无须担心速度）
4. 分模块开发(如果你认为项目结构有问题，请尽早提出，因为我也觉得怪怪的)。完成模块，push代码，提交`pull request`

### 文档格式及要求
后端构建RESTFul API，应提供详尽的API文档供前端使用。
JAVA文档用哪个（不了解。。）？

暂时就这些。。希望补充。。