/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : zb-shiro

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 24/09/2022 10:38:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `salt` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加密盐值',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `sex` int NULL DEFAULT NULL COMMENT '年龄：1男2女',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `status` int NOT NULL COMMENT '用户状态：1有效; 2删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `last_login_time` datetime NULL DEFAULT NULL COMMENT '最后登录时间',
  `permission_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限id',
  `permission_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名',
  `permission_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限地址',
  `permission_perms` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '限定名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '1', 'admin', '872359cc44c637cc73b7cd55c06d95e4', '8cd50474d2a3c1e88298e91df8bf6f1c', '523179414@qq.com', '187888899991', 1, 22, 1, '2018-05-23 21:22:06', '2018-07-17 23:04:46', '2022-09-22 09:28:54', '1', '用户管理', '/user', '');
INSERT INTO `user` VALUES (2, '1', 'admin', '872359cc44c637cc73b7cd55c06d95e4', '8cd50474d2a3c1e88298e91df8bf6f1c', '523179414@qq.com', '187888899991', 1, 22, 1, '2018-05-23 21:22:06', '2018-07-17 23:04:46', '2022-09-22 09:28:54', '1-1', '添加用户', '/user/add', 'user:add');
INSERT INTO `user` VALUES (3, '1', 'admin', '872359cc44c637cc73b7cd55c06d95e4', '8cd50474d2a3c1e88298e91df8bf6f1c', '523179414@qq.com', '187888899991', 1, 22, 1, '2018-05-23 21:22:06', '2018-07-17 23:04:46', '2022-09-22 09:28:54', '1-2', '删除用户', '/user/move', 'user:move');
INSERT INTO `user` VALUES (4, '1', 'admin', '872359cc44c637cc73b7cd55c06d95e4', '8cd50474d2a3c1e88298e91df8bf6f1c', '523179414@qq.com', '187888899991', 1, 22, 1, '2018-05-23 21:22:06', '2018-07-17 23:04:46', '2022-09-22 09:28:54', '1-3', '更改用户信息', '/user/modify', 'user:modify');
INSERT INTO `user` VALUES (5, '1', 'admin', '872359cc44c637cc73b7cd55c06d95e4', '8cd50474d2a3c1e88298e91df8bf6f1c', '523179414@qq.com', '187888899991', 1, 22, 1, '2018-05-23 21:22:06', '2018-07-17 23:04:46', '2022-09-22 09:28:54', '2', '文件管理', '/file', '');
INSERT INTO `user` VALUES (6, '1', 'admin', '872359cc44c637cc73b7cd55c06d95e4', '8cd50474d2a3c1e88298e91df8bf6f1c', '523179414@qq.com', '187888899991', 1, 22, 1, '2018-05-23 21:22:06', '2018-07-17 23:04:46', '2022-09-22 09:28:54', '2-1', '添加文件', '/file/add', 'file:add');
INSERT INTO `user` VALUES (7, '1', 'admin', '872359cc44c637cc73b7cd55c06d95e4', '8cd50474d2a3c1e88298e91df8bf6f1c', '523179414@qq.com', '187888899991', 1, 22, 1, '2018-05-23 21:22:06', '2018-07-17 23:04:46', '2022-09-22 09:28:54', '2-2', '删除文件', '/file/delete', 'file:delete');
INSERT INTO `user` VALUES (8, '1', 'root', '123', '8cd50474d2a3c1e88298e91df8bf6f1c', '523179414@qq.com', '187888899991', 1, 22, 1, '2018-05-23 21:22:06', '2018-07-17 23:04:46', '2022-09-22 09:28:54', '2-2', '删除文件', '/file/delete', 'file:delete');

SET FOREIGN_KEY_CHECKS = 1;
