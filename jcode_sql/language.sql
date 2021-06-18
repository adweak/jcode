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

 Date: 17/06/2021 16:15:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for language
-- ----------------------------
DROP TABLE IF EXISTS `language`;
CREATE TABLE `language`  (
  `languageMetaId` int(10) NOT NULL,
  `languageDesc` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `iso_code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ISO编码',
  `native_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '本语言名称，该名称目前不使用',
  `seq_no` int(10) NOT NULL DEFAULT 1 COMMENT '显示顺序',
  `status` tinyint(2) NOT NULL DEFAULT 1 COMMENT '状态， 0：禁用， 1：启用',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最近更新时间',
  `isdefault` int(1) NOT NULL COMMENT '0否1是（是否是预置数据）'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of language
-- ----------------------------
INSERT INTO `language` VALUES (0, 'Chinese', 'zh', '中文', 1, 1, '2019-11-11 05:48:42', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (1, 'English', 'en', 'English', 1, 1, '2019-11-11 05:48:42', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (2, 'Arabic', 'ar', 'العربية', 1, 1, '2019-11-11 05:48:42', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (3, 'Hebrew', 'iw', 'עברית', 1, 1, '2019-11-11 05:48:42', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (5, 'Russian', 'ru', 'русский', 1, 1, '2019-11-11 05:48:42', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (6, 'French', 'fr', 'français', 1, 1, '2019-11-11 05:48:42', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (7, 'Spanish', 'es', 'español', 1, 1, '2019-11-11 05:48:42', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (8, 'Portuguese', 'pt', 'português', 1, 1, '2019-11-11 05:48:42', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (9, 'Italian', 'it', 'italiano', 1, 1, '2019-11-11 05:48:42', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (10, 'Dutch', 'nl', 'Nederlands', 1, 1, '2019-11-11 05:48:42', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (11, 'German', 'de', 'Deutsch', 1, 1, '2019-11-11 05:48:42', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (12, 'Polish', 'pl', 'polski', 1, 1, '2019-11-11 05:48:42', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (13, 'Japanese', 'ja', '日本語', 1, 1, '2019-11-11 05:48:42', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (14, 'Korean', 'ko', '한국어', 1, 1, '2019-11-11 05:48:42', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (15, 'US english', 'en-US', 'US english', 1, 1, '2020-05-11 11:30:11', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (16, 'GB english', 'en-GB', 'GB english', 1, 1, '2020-05-11 11:30:11', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (17, 'AU english', 'en-AU', 'AU english', 1, 1, '2020-05-11 11:30:11', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (18, 'Norwegian', 'nb', 'Norsk', 1, 1, '2020-05-11 11:30:11', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (19, 'Swedish', 'sv', 'Svenska', 1, 1, '2020-05-11 11:30:11', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (20, 'Finnish', 'fi', 'Suomalaine', 1, 1, '2020-05-11 11:30:11', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (21, 'Danish', 'da', 'Dansk', 1, 1, '2020-05-11 11:30:11', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (22, 'Estonian', 'et', 'Eestlane', 1, 1, '2020-05-11 11:30:11', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (23, 'Latvian', 'lv', 'Latvietis', 1, 1, '2020-05-11 11:30:11', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (24, 'Lithuanian', 'lt', 'Lietuvis', 1, 1, '2020-05-11 11:30:11', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (25, 'Slovenian', 'sl', 'Slovenščin', 1, 1, '2020-05-11 11:30:11', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (26, 'Croatian', 'hr', 'Hrvatski', 1, 1, '2020-05-11 11:30:11', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (27, 'Traditional Chinese', 'zh-TW', '繁體中文', 1, 1, '2020-05-11 11:30:11', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (28, 'Serbian', 'sr-BA', 'Српски', 1, 1, '2020-05-11 11:30:11', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (29, 'Malaysian', 'ms', 'Malaysia', 1, 1, '2020-05-11 11:30:11', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (30, 'Hindi', 'hi', 'हिन्दी', 1, 1, '2020-05-11 11:30:11', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (31, 'Czech', 'cs', 'čeština', 1, 1, '2020-05-11 11:30:11', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (32, 'Indonesian', 'languageMetaId', 'Indonesia', 1, 1, '2020-05-11 11:30:11', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (33, 'Thai', 'th', 'ไทย', 1, 1, '2020-05-11 11:30:11', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (34, 'Ukraine', 'ua', 'Україна', 1, 1, '2020-06-23 09:45:29', '2020-07-21 01:45:35', 1);
INSERT INTO `language` VALUES (35, 'Slovak', 'sk', 'Slovenská', 1, 1, '2020-11-06 09:32:26', '2020-11-06 09:32:26', 1);
INSERT INTO `language` VALUES (36, 'Kazakh', 'kz', 'kazakh', 1, 1, '2020-11-06 09:35:58', '2020-11-06 09:35:58', 1);
INSERT INTO `language` VALUES (37, 'Romanian', 'ro', 'roman', 1, 1, '2020-11-06 09:36:13', '2020-11-06 09:36:13', 1);
INSERT INTO `language` VALUES (38, 'Bulgarian', 'bg', 'Български', 1, 1, '2020-11-06 09:36:28', '2020-11-06 09:36:28', 1);
INSERT INTO `language` VALUES (39, 'Hungarian', 'hu', 'Magyar', 1, 1, '2020-11-06 09:36:41', '2021-04-20 01:52:09', 1);

SET FOREIGN_KEY_CHECKS = 1;
