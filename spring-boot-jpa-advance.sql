/*
Navicat MySQL Data Transfer

Source Server         : 本地测试数据库
Source Server Version : 50505
Source Host           : 127.0.0.1:3306
Source Database       : spring-boot-jpa-advance

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-07-03 22:49:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(255) DEFAULT NULL,
  `t_age` int(255) DEFAULT NULL,
  `t_school` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('3', 'zhangsan', '16', '胜利中学');
INSERT INTO `t_student` VALUES ('4', 'lisi2', '16', '胜利中学');
INSERT INTO `t_student` VALUES ('5', 'lisi3', '16', '胜利中学');
INSERT INTO `t_student` VALUES ('6', 'lisi4', '16', '胜利中学');
INSERT INTO `t_student` VALUES ('7', 'lisi5', '16', '胜利中学');
INSERT INTO `t_student` VALUES ('8', 'lisi6', '16', '胜利中学');
INSERT INTO `t_student` VALUES ('9', 'lisi7', '16', '胜利中学');
