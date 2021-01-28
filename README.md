###

> **博客地址：https://endwas.cn**

> **博客的前端代码地址：https://github.com/Endwas/myblog-web**

> **博客的mybatis持久层代码地址：https://github.com/Endwas/myblog-mybatis**

### 如果喜欢感谢stars~
博客的图片展示：[https://blog.csdn.net/qq_40922616/article/details/112621739](https://blog.csdn.net/qq_40922616/article/details/112621739)


### 个人博客系统使用技术（springboot + mybatis + mysql）
### 声明：源码仅供学习，请勿用于商业途径，否则责任自负
#### 一、技术栈

##### 1.前端

- JS框架：[JQuery](https://jquery.com/)
- CSS框架：[Semantic UI官网](https://semantic-ui.com/)
- Markdown编辑器：[编辑器 Markdown](https://pandao.github.io/editor.md/)
- 代码高亮：[代码高亮 prism](https://github.com/PrismJS/prism)
- 动画效果：[动画 animate.css](https://daneden.github.io/animate.css/)
- 文章目录：[目录生成 Tocbot](https://tscanlin.github.io/tocbot/)
- 音乐盒：[zplayer](https://gitee.com/supperzh/zplayer)
- 照片墙：[lightbox插件](https://github.com/JavaScript-Kit/jkresponsivegallery)  

##### 2.后端

- 核心框架：SpringBoot
- 项目构建：jdk1.8、Maven
- 持久层框架：Mybatis
- 模板框架：Thymeleaf
- 分页插件：PageHelper
- 加密：MD5加密
- 运行环境：腾讯云Centos7

#####  3.数据库

- mysql-5.7.32

#### 二、功能介绍

因为是个人博客，所以用户权限做的特别简单！只是简单的session来解决登录权限后台问题，而且因为登录页是公开的所以会有安全问题，如果只是想学习可以使用，但是想要部署到网站，需要注意使用更好的登录技术，或者将代码中不安全代码进行修改！warn！

##### 1.普通用户

- 查看文章信息：文章列表、推荐文章、文章标题、文章内容、发布时间、访问量以及评论等信息
- 查看分类文章：分类列表、分类文章信息
- 查看时间轴：按照文章时间发布顺序查看文章
- 搜索文章：导航栏右边搜索框根据关键字搜索
- 音乐盒：上一曲、下一曲、音量控制、播放顺序控制、查看歌词等
- 留言版：留言并回复
- 友人帐：查看并访问博主在友链页面添加的友链连接
- 查看相册信息：相册列表、照片名称、照片拍摄地点、时间、照片描述

##### 2.管理员用户（博主）

- 拥有普通用户所有功能权限
- 登录：在主页路径下加“/admin”，可进入登录页面，根据数据库的用户名和密码进行登录
- 文章管理：查询文章列表、新增文章、编辑文章、删除文章、搜索文章
- 分类管理：查询分类列表、新增分类、编辑分类、删除分类
- 友链管理：查询友链列表、新增友链、编辑友链、删除友链
- 相册管理：查询相册列表、新增照片、编辑照片、删除照片
- 消息管理：（在文章下的留言或留言板的留言）登录后回复评论留言会显示栈主博主的头像信息，并能显示删除消息按键，可以对消息进行删除，需注意安全校验

#### 三、数据库设计

下面的POJO类包括属性和get、set、tostring方法

##### 1、实体表
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210120152132939.png#pic_center)


##### 2、数据库表
![在这里插入图片描述](https://img-blog.csdnimg.cn/2021012015214172.png#pic_center)


#### 四、建表语句sql脚本（将语句保存为.sql文件在数据库内执行）
```
/*
 Navicat MySQL Data Transfer

 Source Server         : myblog-localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : myblog

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 30/04/2020 17:02:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_blog
-- ----------------------------
DROP TABLE IF EXISTS `t_blog`;
CREATE TABLE `t_blog`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `appreciation` bit(1) NOT NULL,
  `commentabled` bit(1) NOT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `first_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `published` bit(1) NOT NULL,
  `recommend` bit(1) NOT NULL,
  `share_statement` bit(1) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `views` int(11) NULL DEFAULT NULL,
  `type_id` bigint(20) NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  `comment_count` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK292449gwg5yf7ocdlmswv9w4j`(`type_id`) USING BTREE,
  INDEX `FK8ky5rrsxh01nkhctmo7d48p82`(`user_id`) USING BTREE,
  CONSTRAINT `FK292449gwg5yf7ocdlmswv9w4j` FOREIGN KEY (`type_id`) REFERENCES `t_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK8ky5rrsxh01nkhctmo7d48p82` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 62 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `blog_id` bigint(20) NULL DEFAULT NULL,
  `parent_comment_id` bigint(20) NULL DEFAULT NULL,
  `admin_comment` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_friend
-- ----------------------------
DROP TABLE IF EXISTS `t_friend`;
CREATE TABLE `t_friend`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `blogaddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `blogname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `pictureaddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `parent_message_id` bigint(20) NULL DEFAULT NULL,
  `admin_message` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_picture
-- ----------------------------
DROP TABLE IF EXISTS `t_picture`;
CREATE TABLE `t_picture`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pictureaddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `picturedescription` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `picturename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `picturetime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
```
