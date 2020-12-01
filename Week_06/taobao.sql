/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : taobao

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2020-12-02 22:17:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `shop_id` bigint DEFAULT NULL,
  `good_name` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) unsigned zerofill DEFAULT NULL,
  `area` varchar(20) DEFAULT NULL,
  `stock` bigint NOT NULL COMMENT '库存',
  `create_by` bigint NOT NULL,
  `update_by` bigint NOT NULL,
  `create_date` timestamp NOT NULL,
  `update_date` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `reamrks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品表';

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '1', 'Iphone11', '00005000.20', '浙江', '1000', '1', '1', '2020-12-02 20:30:08', '2020-12-02 20:30:16', null);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `good_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '订单状态',
  `create_by` bigint NOT NULL,
  `update_by` bigint NOT NULL,
  `create_date` timestamp NOT NULL,
  `update_date` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `reamrks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '1', '3', 'PAYED', '1', '1', '2020-12-02 20:30:39', '2020-12-02 20:30:41', null);

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `id` int NOT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `create_by` bigint NOT NULL,
  `update_by` bigint NOT NULL,
  `create_date` timestamp NOT NULL,
  `update_date` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `reamrks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='店铺表';

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('1', '天猫旗舰店', '2', '1', '1', '2020-12-02 20:26:14', '2020-12-02 20:29:14', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `birth` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '出生日期',
  `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '0管理人员 1普通用户 2商家',
  `create_by` bigint NOT NULL,
  `update_by` bigint NOT NULL,
  `create_date` timestamp NOT NULL,
  `update_date` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '15658831631', '超级管理员', '2011-12', '1', '1', '1', '2020-12-02 20:26:14', '2020-12-02 20:27:36', null);
INSERT INTO `user` VALUES ('2', 'zhangsan', '15658831632', '张三', '2011-12', '2', '1', '1', '2020-12-02 20:26:14', '2020-12-02 20:27:36', '');
INSERT INTO `user` VALUES ('3', 'lisi', '15658831632', '李四', '2011-12', '2', '1', '1', '2020-12-02 20:32:10', '2020-12-02 20:32:17', null);
