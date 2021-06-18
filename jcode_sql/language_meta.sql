/*
 Navicat Premium Data Transfer

 Source Server         : 海外数据库
 Source Server Type    : MySQL
 Source Server Version : 50634
 Source Host           : localhost:30001
 Source Schema         : wgdb

 Target Server Type    : MySQL
 Target Server Version : 50634
 File Encoding         : 65001

 Date: 17/06/2021 16:15:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for language_meta
-- ----------------------------
DROP TABLE IF EXISTS `language_meta`;
CREATE TABLE `language_meta`  (
  `languageMetaId` int(10) NOT NULL AUTO_INCREMENT,
  `language_id` int(10) NOT NULL,
  `language_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `language_id2` int(10) NOT NULL,
  `language_seq` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`languageMetaId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 106 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of language_meta
-- ----------------------------
INSERT INTO `language_meta` VALUES (1, 2, '阿拉伯语', 0, 0);
INSERT INTO `language_meta` VALUES (2, 3, '希伯来语', 0, 0);
INSERT INTO `language_meta` VALUES (3, 1, '英语', 0, 0);
INSERT INTO `language_meta` VALUES (4, 5, '俄语', 0, 0);
INSERT INTO `language_meta` VALUES (5, 6, '法语', 0, 0);
INSERT INTO `language_meta` VALUES (6, 7, '西班牙语', 0, 0);
INSERT INTO `language_meta` VALUES (7, 8, '葡萄牙语', 0, 0);
INSERT INTO `language_meta` VALUES (8, 9, '意大利语', 0, 0);
INSERT INTO `language_meta` VALUES (9, 10, '荷兰语', 0, 0);
INSERT INTO `language_meta` VALUES (10, 11, '德语', 0, 0);
INSERT INTO `language_meta` VALUES (11, 0, '中文', 0, 0);
INSERT INTO `language_meta` VALUES (12, 12, '波兰语', 0, 0);
INSERT INTO `language_meta` VALUES (13, 13, '日语', 0, 0);
INSERT INTO `language_meta` VALUES (14, 14, '韩语', 0, 0);
INSERT INTO `language_meta` VALUES (15, 15, '美式英语', 0, 0);
INSERT INTO `language_meta` VALUES (16, 16, '英式英语', 0, 0);
INSERT INTO `language_meta` VALUES (17, 17, '澳式英语', 0, 0);
INSERT INTO `language_meta` VALUES (18, 18, '挪威语', 0, 0);
INSERT INTO `language_meta` VALUES (19, 19, '瑞典语', 0, 0);
INSERT INTO `language_meta` VALUES (20, 20, '芬兰语', 0, 0);
INSERT INTO `language_meta` VALUES (21, 21, '丹麦语', 0, 0);
INSERT INTO `language_meta` VALUES (22, 22, '爱沙尼亚语', 0, 0);
INSERT INTO `language_meta` VALUES (23, 23, '拉脱维亚语', 0, 0);
INSERT INTO `language_meta` VALUES (24, 24, '立陶宛语', 0, 0);
INSERT INTO `language_meta` VALUES (25, 25, '斯洛文尼亚语', 0, 0);
INSERT INTO `language_meta` VALUES (26, 26, '克罗地亚语', 0, 0);
INSERT INTO `language_meta` VALUES (27, 27, '繁体中文', 0, 0);
INSERT INTO `language_meta` VALUES (28, 28, '塞尔维亚语', 0, 0);
INSERT INTO `language_meta` VALUES (29, 29, '马来语', 0, 0);
INSERT INTO `language_meta` VALUES (30, 30, '印地语', 0, 0);
INSERT INTO `language_meta` VALUES (31, 31, '捷克语', 0, 0);
INSERT INTO `language_meta` VALUES (32, 32, '印度尼西亚语', 0, 0);
INSERT INTO `language_meta` VALUES (33, 33, '泰语', 0, 0);
INSERT INTO `language_meta` VALUES (34, 34, '乌克兰语', 0, 0);
INSERT INTO `language_meta` VALUES (35, 35, '斯洛伐克语', 0, 0);
INSERT INTO `language_meta` VALUES (36, 36, '哈萨克语', 0, 0);
INSERT INTO `language_meta` VALUES (37, 37, '罗马尼亚', 0, 0);
INSERT INTO `language_meta` VALUES (38, 38, '保加利亚', 0, 0);
INSERT INTO `language_meta` VALUES (39, 39, '匈牙利语', 0, 0);
INSERT INTO `language_meta` VALUES (67, 2, 'Arabic', 1, 0);
INSERT INTO `language_meta` VALUES (68, 3, 'Hebrew', 1, 0);
INSERT INTO `language_meta` VALUES (69, 1, 'English', 1, 0);
INSERT INTO `language_meta` VALUES (70, 5, 'Russian', 1, 0);
INSERT INTO `language_meta` VALUES (71, 6, 'French', 1, 0);
INSERT INTO `language_meta` VALUES (72, 7, 'Spanish', 1, 0);
INSERT INTO `language_meta` VALUES (73, 8, 'Portuguese', 1, 0);
INSERT INTO `language_meta` VALUES (74, 9, 'Italian', 1, 0);
INSERT INTO `language_meta` VALUES (75, 10, 'Dutch', 1, 0);
INSERT INTO `language_meta` VALUES (76, 11, 'German', 1, 0);
INSERT INTO `language_meta` VALUES (77, 0, 'Chinese', 1, 0);
INSERT INTO `language_meta` VALUES (78, 12, 'Polish', 1, 0);
INSERT INTO `language_meta` VALUES (79, 13, 'Japanese', 1, 0);
INSERT INTO `language_meta` VALUES (80, 14, 'Korean', 1, 0);
INSERT INTO `language_meta` VALUES (81, 15, 'US english', 1, 0);
INSERT INTO `language_meta` VALUES (82, 16, 'GB english', 1, 0);
INSERT INTO `language_meta` VALUES (83, 17, 'AU english', 1, 0);
INSERT INTO `language_meta` VALUES (84, 18, 'Norwegian', 1, 0);
INSERT INTO `language_meta` VALUES (85, 19, 'Swedish', 1, 0);
INSERT INTO `language_meta` VALUES (86, 20, 'Finnish', 1, 0);
INSERT INTO `language_meta` VALUES (87, 21, 'Danish', 1, 0);
INSERT INTO `language_meta` VALUES (88, 22, 'Estonian', 1, 0);
INSERT INTO `language_meta` VALUES (89, 23, 'Latvian', 1, 0);
INSERT INTO `language_meta` VALUES (90, 24, 'Lithuanian', 1, 0);
INSERT INTO `language_meta` VALUES (91, 25, 'Slovenian', 1, 0);
INSERT INTO `language_meta` VALUES (92, 26, 'Croatian', 1, 0);
INSERT INTO `language_meta` VALUES (93, 27, 'Traditional Chinese', 1, 0);
INSERT INTO `language_meta` VALUES (94, 28, 'Serbian', 1, 0);
INSERT INTO `language_meta` VALUES (95, 29, 'Malaysian', 1, 0);
INSERT INTO `language_meta` VALUES (96, 30, 'Hindi', 1, 0);
INSERT INTO `language_meta` VALUES (97, 31, 'Czech', 1, 0);
INSERT INTO `language_meta` VALUES (98, 32, 'Indonesian', 1, 0);
INSERT INTO `language_meta` VALUES (99, 33, 'Thai', 1, 0);
INSERT INTO `language_meta` VALUES (100, 34, 'Ukraine', 1, 0);
INSERT INTO `language_meta` VALUES (101, 35, 'Slovak', 1, 0);
INSERT INTO `language_meta` VALUES (102, 36, 'Kazakh', 1, 0);
INSERT INTO `language_meta` VALUES (103, 37, 'Romanian', 1, 0);
INSERT INTO `language_meta` VALUES (104, 38, 'Bulgarian', 1, 0);
INSERT INTO `language_meta` VALUES (105, 39, 'Hungarian', 1, 0);

SET FOREIGN_KEY_CHECKS = 1;
