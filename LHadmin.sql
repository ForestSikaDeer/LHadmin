/*
 Navicat Premium Data Transfer

 Source Server         : LOCAL_MYSQL
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : localhost:3306
 Source Schema         : jizaadmin

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 28/09/2021 15:30:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `orderId` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tableNumber` int(5) NULL DEFAULT NULL,
  `orderName` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `price` int(20) NULL DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 75 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, '20210927120433', 2, '兔头', 88, '已完成');
INSERT INTO `order` VALUES (2, '20210927110826', 3, '耗儿鱼', 120, '未完成');
INSERT INTO `order` VALUES (35, '20210927092953', 5, '菜品', 198, '未完成');
INSERT INTO `order` VALUES (36, '20210927092953', 5, '菜品', 198, '未完成');
INSERT INTO `order` VALUES (37, '20210927092953', 5, '菜品', 198, '未完成');
INSERT INTO `order` VALUES (38, '20210927092953', 5, '菜品', 198, '未完成');
INSERT INTO `order` VALUES (43, '20210927092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (44, '20210927092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (45, '20210927092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (46, '20210927092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (47, '20210927092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (48, '20210927092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (49, '20210927092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (50, '20210927092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (51, '20210927092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (52, '20210927092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (53, '20210927092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (54, '20210927092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (55, '20210927092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (56, '20210927092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (57, '20210926092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (58, '20210926092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (59, '20210926092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (60, '20210926092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (61, '20210926092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (62, '20210926092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (63, '20210926092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (64, '20210926092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (65, '20210926092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (66, '20210926092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (67, '20210926092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (68, '20210926092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (69, '20210926092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (70, '20210926092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (71, '20210926092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (72, '20210926092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (73, '20210926092953', 5, '菜品', 198, '已完成');
INSERT INTO `order` VALUES (74, '20210926092953', 5, '菜品', 198, '已完成');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `userPassword` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `userAddress` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'qjjz@jiza.cq', 'qjjz', '重庆市渝北区');

-- ----------------------------
-- View structure for detail_order
-- ----------------------------
DROP VIEW IF EXISTS `detail_order`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `detail_order` AS select `orders`.`together_id` AS `together_id`,`orders`.`campus_id` AS `campus_id`,`food`.`name` AS `food_name`,`food`.`price` AS `price`,`food`.`discount_price` AS `discount_price`,`food`.`is_discount` AS `is_discount`,`orders`.`order_count` AS `order_count`,`orders`.`status` AS `status` from (`orders` join `food`) where ((`orders`.`food_id` = `food`.`food_id`) and (`orders`.`status` <> 0) and (`food`.`campus_id` = `orders`.`campus_id`) and (`orders`.`tag` = 1));

-- ----------------------------
-- View structure for order_food_receiver
-- ----------------------------
DROP VIEW IF EXISTS `order_food_receiver`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `order_food_receiver` AS select `orders`.`phone` AS `phone`,`orders`.`campus_id` AS `campus_id`,`orders`.`together_id` AS `together_id`,`orders`.`order_count` AS `order_count`,`orders`.`food_id` AS `food_id`,`orders`.`rank` AS `rank`,`orders`.`together_date` AS `together_date`,`orders`.`admin_phone` AS `admin_phone`,`orders`.`reserve_time` AS `reserve_time`,`orders`.`tag` AS `tag`,`food`.`name` AS `foodName`,`food`.`price` AS `price`,`food`.`discount_price` AS `discount_price`,`food`.`img_url` AS `img_url`,`food`.`status` AS `status`,`food`.`is_discount` AS `is_discount`,`food`.`message` AS `message`,`receiver`.`phone_id` AS `customer_phone`,`receiver`.`name` AS `receiverName`,`receiver`.`address` AS `address`,`receiver`.`is_out` AS `is_out` from ((`orders` join `food`) join `receiver`) where ((`orders`.`food_id` = `food`.`food_id`) and (`orders`.`phone` = `receiver`.`phone`));

-- ----------------------------
-- View structure for together_order
-- ----------------------------
DROP VIEW IF EXISTS `together_order`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `together_order` AS select `orders`.`phone` AS `phone`,`orders`.`together_id` AS `together_id`,`orders`.`campus_id` AS `campus_id`,`receiver`.`name` AS `nickname`,`receiver`.`phone` AS `custome_phone`,`orders`.`together_date` AS `together_date`,`users`.`nickname` AS `admin_name`,`orders`.`reserve_time` AS `reserve_time`,`orders`.`message` AS `message`,`orders`.`status` AS `STATUS`,`orders`.`tag` AS `tag`,`orders`.`admin_phone` AS `admin_phone`,`orders`.`total_price` AS `total_price`,`receiver`.`address` AS `address`,`orders`.`charge_id` AS `charge_id`,`orders`.`pay_way` AS `pay_way` from ((`orders` left join `receiver` on(((`orders`.`phone` = `receiver`.`phone_id`) and (`orders`.`rank` = `receiver`.`rank`)))) left join `users` on((`users`.`phone` = `orders`.`admin_phone`))) group by `orders`.`together_id` having (`orders`.`status` <> 0);

SET FOREIGN_KEY_CHECKS = 1;
