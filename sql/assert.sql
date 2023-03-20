/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : assert

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 19/03/2023 21:16:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for aca
-- ----------------------------
DROP TABLE IF EXISTS `aca`;
CREATE TABLE `aca`  (
  `adid` int NOT NULL AUTO_INCREMENT COMMENT '盘点id',
  `adorder` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '盘点单号',
  `adexalpain` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '盘点说明',
  `is_valid` int NOT NULL COMMENT '盘点状态',
  `begindate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌开始日期',
  `enddate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盘点结束日期',
  PRIMARY KEY (`adid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资产盘点：新增盘点单>“添加盘点资产”窗口。表名：aca' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of aca
-- ----------------------------
INSERT INTO `aca` VALUES (1, 'PD20200304221', '2020下半年大盘点', 0, NULL, NULL);

-- ----------------------------
-- Table structure for achieve
-- ----------------------------
DROP TABLE IF EXISTS `achieve`;
CREATE TABLE `achieve`  (
  `acid` int NOT NULL AUTO_INCREMENT,
  `acnub` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '取得方式编码',
  `acname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '取得方式名称',
  `is_valid` int NULL DEFAULT NULL COMMENT '状态',
  `actime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`acid`) USING BTREE,
  UNIQUE INDEX `weiy`(`acnub` ASC) USING BTREE COMMENT '唯一',
  UNIQUE INDEX `weyyy`(`acname` ASC) USING BTREE COMMENT '唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '4.8	取得方式 表名：achieve' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of achieve
-- ----------------------------
INSERT INTO `achieve` VALUES (8, 'QG1137', '采购', 1, '2022-04-28 11:10:27');
INSERT INTO `achieve` VALUES (9, 'SG9912', '申购', 1, '2022-04-28 11:11:05');
INSERT INTO `achieve` VALUES (11, 'test1', '我的屋顶', 1, '2022-05-07 15:39:18');

-- ----------------------------
-- Table structure for approval
-- ----------------------------
DROP TABLE IF EXISTS `approval`;
CREATE TABLE `approval`  (
  `suid` int NOT NULL AUTO_INCREMENT,
  `suorder` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '申购单号',
  `suass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '申购资产',
  `asname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资产类别(asscat)表',
  `sunub` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '申购数量',
  `suprice` decimal(10, 2) NOT NULL COMMENT '预计价格',
  `suaplct` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '申请人',
  `dename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属部门（部门名称）',
  `sudate` datetime NOT NULL COMMENT '申请日期',
  PRIMARY KEY (`suid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '4.14	资产申购审批（未审核） 表名：approval' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of approval
-- ----------------------------

-- ----------------------------
-- Table structure for ara
-- ----------------------------
DROP TABLE IF EXISTS `ara`;
CREATE TABLE `ara`  (
  `araid` int NOT NULL AUTO_INCREMENT,
  `ara_appno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审批编号',
  `wacoding` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产编码',
  `waname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产名称',
  `asname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产类别（4.6资产类别 表名：asscat)',
  `reappl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请人',
  `redate` datetime NULL DEFAULT NULL COMMENT '报废日期',
  `scname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报废方式  4.12报废方式 表名：scrap',
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报废原因',
  `wastate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产状态(资产入库表）',
  `roeaa` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审批结果',
  PRIMARY KEY (`araid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '4.21	资产报废审批 表名：ara' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of ara
-- ----------------------------

-- ----------------------------
-- Table structure for asscat
-- ----------------------------
DROP TABLE IF EXISTS `asscat`;
CREATE TABLE `asscat`  (
  `asid` int NOT NULL AUTO_INCREMENT,
  `ascoding` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类别编码',
  `asname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类别名称',
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态',
  `astime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`asid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '4.6	资产类别 表名：asscat' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of asscat
-- ----------------------------
INSERT INTO `asscat` VALUES (1, 'zclb001', '计算机设备', '1', '2022-04-05 11:30:42');
INSERT INTO `asscat` VALUES (2, 'zclb002', '办公设备', '1', '2022-04-25 11:31:11');
INSERT INTO `asscat` VALUES (3, 'zclb003', '通信设备', '1', '2022-03-31 17:44:19');
INSERT INTO `asscat` VALUES (4, 'zclb004', '仪器仪表', '1', '2022-04-24 11:32:35');
INSERT INTO `asscat` VALUES (5, 'zclb005', '基础用品', '1', '2022-04-25 18:24:10');
INSERT INTO `asscat` VALUES (6, 'zclb006', '办公用品', '1', '2022-04-27 16:27:05');

-- ----------------------------
-- Table structure for borrowed
-- ----------------------------
DROP TABLE IF EXISTS `borrowed`;
CREATE TABLE `borrowed`  (
  `boid` int NOT NULL AUTO_INCREMENT,
  `waid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '入库id',
  `boorder` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借用单号',
  `bodate` datetime NOT NULL COMMENT '借用日期',
  `peid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '使用人id',
  `bocause` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '借用原因',
  `returndate` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '归还日期',
  `is_valid` int NULL DEFAULT NULL COMMENT '归还状态',
  `bz` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'bz',
  PRIMARY KEY (`boid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '4.17	资产借还   borrowed' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of borrowed
-- ----------------------------
INSERT INTO `borrowed` VALUES (1, '22', 'BO20200304221', '2022-04-12 16:32:00', '1', '工作需要', '2022-05-02', 1, '事实上');
INSERT INTO `borrowed` VALUES (8, '18', 'BO2022050420328', '2022-05-02 00:00:00', '5', '工作', NULL, 1, NULL);
INSERT INTO `borrowed` VALUES (9, '20', 'BO2022050476483', '2022-05-01 00:00:00', '6', '工程是的是的', '20220504', 1, NULL);
INSERT INTO `borrowed` VALUES (10, '20', 'BO2022050470243', '2022-05-04 00:00:00', '7', '可以的', NULL, 1, NULL);
INSERT INTO `borrowed` VALUES (13, '20', 'BO2022050728165', '2022-05-02 00:00:00', '13', '13131', '20220508', 1, NULL);
INSERT INTO `borrowed` VALUES (14, '29', 'JY2022050873584', '2022-05-03 00:00:00', '5', ' 我需要小金毛！', '2022-05-06', 1, '可以的');
INSERT INTO `borrowed` VALUES (16, '20', 'JY2022050891374', '2022-05-08 00:00:00', '4', '123112', '20220516', 1, NULL);
INSERT INTO `borrowed` VALUES (17, '20', 'JY2022050866142', '2022-05-08 00:00:00', '7', '我的', NULL, 0, NULL);
INSERT INTO `borrowed` VALUES (20, '20', 'JY2022051638682', '2022-05-16 00:00:00', '2', 'ryj', NULL, 0, NULL);
INSERT INTO `borrowed` VALUES (21, '22', 'JY2022051698287', '2022-05-16 00:00:00', '1', '123gfdfgfdhgfjgdjgfxjdgfjgdhkghcjkd', NULL, 0, NULL);

-- ----------------------------
-- Table structure for brand
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand`  (
  `brid` int NOT NULL AUTO_INCREMENT,
  `brnub` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌编码',
  `brname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌名称',
  `is_valid` int NULL DEFAULT NULL COMMENT '状态',
  `brtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`brid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '品牌表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of brand
-- ----------------------------
INSERT INTO `brand` VALUES (1, 'pp011的功夫', '三星单独发给', 1, '2022-04-25 22:26:25');
INSERT INTO `brand` VALUES (2, 'pp02的发挥', '飞利浦的风格 ', 1, '2022-05-16 08:49:53');
INSERT INTO `brand` VALUES (12, '52461362321', '三星', 1, '2022-04-25 11:42:28');
INSERT INTO `brand` VALUES (14, 'pp04', '三星', 0, '2022-04-25 16:22:58');
INSERT INTO `brand` VALUES (15, 's17981', 'rog败家之眼', 1, '2022-04-25 12:26:05');
INSERT INTO `brand` VALUES (16, 'pp011', '三星', 0, '2022-05-16 08:21:18');
INSERT INTO `brand` VALUES (17, 'pp04', '三星', NULL, '2022-05-16 08:27:42');
INSERT INTO `brand` VALUES (18, 'pp08', '但考虑到反馈给还可了解到法国韩国烧烤的欧蕾咖啡结果v法国', NULL, '2022-05-16 08:28:32');
INSERT INTO `brand` VALUES (19, '163241654535', '肌肤光滑', 1, '2022-05-16 08:36:36');
INSERT INTO `brand` VALUES (20, 'pp011', '三星', NULL, '2022-05-16 09:25:15');
INSERT INTO `brand` VALUES (21, '64632464', '尽快发给后', 0, '2022-05-16 10:26:09');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `deid` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `denub` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门编码',
  `dename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `uptime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_valid` int NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`deid`) USING BTREE,
  UNIQUE INDEX `denub`(`denub` ASC) USING BTREE COMMENT '唯一约束',
  UNIQUE INDEX `dename`(`dename` ASC) USING BTREE COMMENT '唯一约束'
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '部门管理表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, 'bm01', '总经理办公室', '2022-04-26 10:33:38', 1);
INSERT INTO `department` VALUES (18, '266l', '看了大家风范', '2022-05-16 10:57:24', NULL);

-- ----------------------------
-- Table structure for eqipment
-- ----------------------------
DROP TABLE IF EXISTS `eqipment`;
CREATE TABLE `eqipment`  (
  `eqid` int NOT NULL AUTO_INCREMENT,
  `eqnub` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '设备用途编码',
  `eqname` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '设备用途名称',
  `eqstate` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '状态',
  `eqtime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`eqid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '设备用途表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of eqipment
-- ----------------------------
INSERT INTO `eqipment` VALUES (1, 'yt01', '?????', '???', '2022-04-05 11:25:32');
INSERT INTO `eqipment` VALUES (2, 'yt02', '????', '???', '2022-04-05 11:26:12');

-- ----------------------------
-- Table structure for genre
-- ----------------------------
DROP TABLE IF EXISTS `genre`;
CREATE TABLE `genre`  (
  `gid` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `genrecode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别编码',
  `gname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别名称',
  `is_valid` int NULL DEFAULT NULL COMMENT '状态',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`gid`) USING BTREE,
  UNIQUE INDEX `weiyi`(`genrecode` ASC) USING BTREE COMMENT '唯一约束',
  UNIQUE INDEX `weiyi2`(`gname` ASC) USING BTREE COMMENT '唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 69 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of genre
-- ----------------------------
INSERT INTO `genre` VALUES (47, 'zc00002', '计算机以及硬件设备', 1, '2022-04-18 20:47:06');
INSERT INTO `genre` VALUES (48, 'zc0002', '电子产品', 1, '2022-04-25 09:00:14');
INSERT INTO `genre` VALUES (52, 'zc0003', '水果类', 1, '2022-04-28 13:52:50');
INSERT INTO `genre` VALUES (61, 'zc1111', '测试赛', 1, '2022-05-07 12:29:26');
INSERT INTO `genre` VALUES (63, '11111', '我的test', 1, '2022-05-07 12:39:48');
INSERT INTO `genre` VALUES (66, 'zc00111', '屋顶的', 1, '2022-05-07 16:40:01');
INSERT INTO `genre` VALUES (68, 'ffs4434', '第三方', 0, '2022-05-09 11:43:09');

-- ----------------------------
-- Table structure for maintain
-- ----------------------------
DROP TABLE IF EXISTS `maintain`;
CREATE TABLE `maintain`  (
  `maid` int NOT NULL AUTO_INCREMENT,
  `maorder` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修单号',
  `waid` int NULL DEFAULT NULL COMMENT '资产编码',
  `repairerpeid` int NULL DEFAULT NULL COMMENT '报修人id',
  `cause` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报修原因',
  `unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修单位',
  `repair` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修复日期',
  `expense` decimal(10, 2) NULL DEFAULT NULL COMMENT '维修费用',
  `bdate` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报修日期',
  `faultde` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '故障说明',
  PRIMARY KEY (`maid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '4.19	资产维修 表名：maintain' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of maintain
-- ----------------------------
INSERT INTO `maintain` VALUES (1, 'wx202020322321', 1, 1, '右键坏了', '罗技官网', '2020-03-04', 60.10, '2020-04-05', '该鼠标右键有些失灵');
INSERT INTO `maintain` VALUES (3, 'WX2022050436134', 18, 7, '这个有问题', '嗯嗯嗯', '2022-05-03', 60.00, '20220504', '是的');
INSERT INTO `maintain` VALUES (4, 'WX2022050457105', 18, 1, '123', '123', '2022-05-02', 123.00, '20220504', '123123');
INSERT INTO `maintain` VALUES (5, 'WX2022050462550', 1, 2, '1231', '12312', '2022-05-03', 3213213.00, '20220504', '123213');
INSERT INTO `maintain` VALUES (7, 'WX2022050849890', 29, 9, '11223', '1我', '2022-05-04', 88.00, '20220508', '1312');
INSERT INTO `maintain` VALUES (8, 'WX2022050810591', 29, 4, '123', '123', '2022-05-03', 12.00, '20220508', '1231');
INSERT INTO `maintain` VALUES (9, 'WX2022050892341', 20, 3, '21', '121', '2022-05-03', 11.00, '20220508', '2112');
INSERT INTO `maintain` VALUES (10, 'WX2022050814905', 29, 6, '131', '1321', '2022-05-04', 88.00, '20220508', '1231');
INSERT INTO `maintain` VALUES (12, 'WX2022050854889', 18, 2, '211', '11', '2022-05-03', 111.00, '20220508', '123123');
INSERT INTO `maintain` VALUES (13, 'WX2022050801480', 29, 2, '1231', '131', '2022-05-03', 1231.00, '20220508', '1312');
INSERT INTO `maintain` VALUES (14, 'WX2022050803630', 2, 2, '123', '1231', '2022-05-04', 1231.00, '20220508', '12312');

-- ----------------------------
-- Table structure for maintainwx
-- ----------------------------
DROP TABLE IF EXISTS `maintainwx`;
CREATE TABLE `maintainwx`  (
  `reid` int NOT NULL AUTO_INCREMENT,
  `waid` int NULL DEFAULT NULL,
  `ref` int NULL DEFAULT NULL COMMENT '维修次数',
  `repr` decimal(10, 2) NULL DEFAULT NULL COMMENT '维修价格',
  PRIMARY KEY (`reid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of maintainwx
-- ----------------------------
INSERT INTO `maintainwx` VALUES (1, 1, 1, 60.00);
INSERT INTO `maintainwx` VALUES (10, 29, 2, 1242.00);
INSERT INTO `maintainwx` VALUES (11, 22, 1, 45.00);

-- ----------------------------
-- Table structure for personnel
-- ----------------------------
DROP TABLE IF EXISTS `personnel`;
CREATE TABLE `personnel`  (
  `peid` int NOT NULL AUTO_INCREMENT,
  `pename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `jobnub` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工号',
  `dename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属部门',
  PRIMARY KEY (`peid`) USING BTREE,
  UNIQUE INDEX `jobnub`(`jobnub` ASC) USING BTREE COMMENT 'bss'
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '人员管理表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of personnel
-- ----------------------------
INSERT INTO `personnel` VALUES (1, '张三', '1100', '财务部');
INSERT INTO `personnel` VALUES (2, '李四', '002', '软件部');
INSERT INTO `personnel` VALUES (3, '王五', '003', '软件部');
INSERT INTO `personnel` VALUES (4, '老刘', '004', '财务部');
INSERT INTO `personnel` VALUES (5, '马六', '005', '总经理办公室');
INSERT INTO `personnel` VALUES (6, '铮七', '006', '秘书部');
INSERT INTO `personnel` VALUES (7, '王小帅', '007', '技术部');
INSERT INTO `personnel` VALUES (8, '马冬梅', '008', '技术部');
INSERT INTO `personnel` VALUES (9, '王海军', '009', '后勤部');
INSERT INTO `personnel` VALUES (13, '黄花生', '1101', '软件部');
INSERT INTO `personnel` VALUES (14, 'fgnhuiguj', '2026', '总经理办公室');
INSERT INTO `personnel` VALUES (15, '从科技成果', '0001', '总经理办公室');
INSERT INTO `personnel` VALUES (16, 'dczdvvd', '2001', '总经理办公室');
INSERT INTO `personnel` VALUES (18, '蜡笔小新', '0203', '总经理办公室');

-- ----------------------------
-- Table structure for retirement
-- ----------------------------
DROP TABLE IF EXISTS `retirement`;
CREATE TABLE `retirement`  (
  `reid` int NOT NULL AUTO_INCREMENT,
  `waid` int NULL DEFAULT NULL COMMENT '资产编码',
  `peid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请人',
  `redate` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报废日期',
  `scid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报废方式  4.12报废方式 表名：scrap',
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报废原因',
  `approvalre` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审批结果',
  PRIMARY KEY (`reid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '\r\n4.20	资产报废 表名：retirement' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of retirement
-- ----------------------------
INSERT INTO `retirement` VALUES (11, 18, '4', '2022-05-02', '4', '我的数据', '通过！');
INSERT INTO `retirement` VALUES (12, 22, '1', '2022-05-02', '4', '123131', '通过！');
INSERT INTO `retirement` VALUES (13, 14, '3', '2022-05-04', '5', '1234', '通过！');
INSERT INTO `retirement` VALUES (14, 2, '2', '2022-05-04', '1', '1112', NULL);
INSERT INTO `retirement` VALUES (16, 20, '7', '2022-05-03', '5', '没有用的', NULL);
INSERT INTO `retirement` VALUES (17, 29, '5', '2022-05-09', '6', 'gsdfg', NULL);
INSERT INTO `retirement` VALUES (18, 22, '1', '2022-05-09', '4', 'wrt', NULL);

-- ----------------------------
-- Table structure for scrap
-- ----------------------------
DROP TABLE IF EXISTS `scrap`;
CREATE TABLE `scrap`  (
  `scid` int NOT NULL AUTO_INCREMENT,
  `scnubs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报废方式编码',
  `scnames` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报废方式名称',
  `is_valid` int NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`scid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '报废方式表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of scrap
-- ----------------------------
INSERT INTO `scrap` VALUES (1, 'bf007', '上交', 1);
INSERT INTO `scrap` VALUES (4, 'bf002', '捐赠', 1);
INSERT INTO `scrap` VALUES (5, 'bf004', '变卖', 1);
INSERT INTO `scrap` VALUES (6, 'bf001', '转出', 1);
INSERT INTO `scrap` VALUES (10, '1232131bf', '123213', 0);

-- ----------------------------
-- Table structure for sst
-- ----------------------------
DROP TABLE IF EXISTS `sst`;
CREATE TABLE `sst`  (
  `id` int NOT NULL,
  `genrecode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_valid` int NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of sst
-- ----------------------------

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store`  (
  `stid` int NOT NULL AUTO_INCREMENT,
  `stname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '存放地点名称',
  `sttype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `is_valid` int NULL DEFAULT NULL COMMENT '状态',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`stid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES (1, '电脑耗材库', '耗材物品', 1, '1号楼地下1层', '2022-03-29 11:52:22');
INSERT INTO `store` VALUES (2, '电脑耗材库', '耗材物品', 0, '1号楼地下1层左', '2022-04-14 11:53:25');
INSERT INTO `store` VALUES (3, '财务办公室', '耗材物品', 1, '2号楼101房', '2022-04-20 11:54:30');
INSERT INTO `store` VALUES (4, '总经理办公室', '固定资产', 0, '2号楼703房', '2022-04-25 11:55:07');
INSERT INTO `store` VALUES (5, '办公耗材库', '耗材物品', 1, '1号楼1层', '2022-04-06 17:41:55');
INSERT INTO `store` VALUES (6, '基础用品库', '固定资产', 1, '2号楼203旁边的货架102上', '2022-04-25 21:08:39');
INSERT INTO `store` VALUES (7, '员工宿舍', '固定资产', NULL, 'www', '2022-05-07 17:16:25');
INSERT INTO `store` VALUES (9, '电脑房', '固定资产', NULL, NULL, '2022-05-16 10:22:22');
INSERT INTO `store` VALUES (10, '刚回来科技经费和管理费开个会裂缝的结果', '耗材物品', NULL, NULL, '2022-05-16 10:23:09');
INSERT INTO `store` VALUES (12, '电脑设备库', '固定资产', NULL, NULL, '2022-05-16 10:28:38');
INSERT INTO `store` VALUES (13, '规范化股份计划内', '其他', NULL, NULL, '2022-05-16 10:33:06');

-- ----------------------------
-- Table structure for subscribe
-- ----------------------------
DROP TABLE IF EXISTS `subscribe`;
CREATE TABLE `subscribe`  (
  `suid` int NOT NULL AUTO_INCREMENT,
  `suorder` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申购单号',
  `suass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申购资产',
  `gid` int NULL DEFAULT NULL COMMENT '资产类别表id',
  `sunub` int NULL DEFAULT NULL COMMENT '申购数量',
  `suprice` decimal(10, 2) NULL DEFAULT NULL COMMENT '预计价格',
  `peid` int NULL DEFAULT NULL COMMENT '申请人',
  `sudate` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请日期',
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请理由',
  `suggest` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请建议',
  `is_valid` int NULL DEFAULT NULL COMMENT '审批状态',
  `auditres` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核意见',
  PRIMARY KEY (`suid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '资产申购表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of subscribe
-- ----------------------------
INSERT INTO `subscribe` VALUES (9, 'SG2022042732635', '123', 48, 5, 500.00, 2, '2022-04-25 11:00:00', '123', '123', 1, NULL);
INSERT INTO `subscribe` VALUES (10, 'SG2022042754241', '幻16', 47, 2, 12345.00, 3, '2022-04-27 19:00:00', '必备', '可以麻将', 1, NULL);
INSERT INTO `subscribe` VALUES (12, 'SG2022050116902', '123', 47, 3, 30000.00, 4, '2022-05-01', '12321312', '123', 1, NULL);
INSERT INTO `subscribe` VALUES (15, 'SG2022050565651', 'rog新锐5', 47, 2, 20000.00, 2, '2022-05-02', '不要错过', '可以买', 0, '123213');
INSERT INTO `subscribe` VALUES (16, 'SG2022050756760', '1223', 48, 11, 2231.00, 2, '2022-05-03', '1231312', '1321', 1, NULL);
INSERT INTO `subscribe` VALUES (18, 'SG2022050728692', '123', 48, 123, 12312.00, 7, '2022-05-03', '123213', '123123', 0, '1123');
INSERT INTO `subscribe` VALUES (19, 'SG2022050789617', '12312', 47, 123, 123123.00, 2, '2022-04-27', '132123', '12312', 1, '');
INSERT INTO `subscribe` VALUES (20, NULL, '小米平板5', 47, 2, 9978.00, 6, '2022-05-03', '需要用来工作学习！', '没有建议', 2, NULL);

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `supid` int NOT NULL AUTO_INCREMENT,
  `supname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商名称',
  `suptype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商类型',
  `is_valid` int NOT NULL COMMENT '状态（禁用、启用）',
  `contacts` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系人',
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话号码',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`supid`) USING BTREE,
  UNIQUE INDEX `weiy`(`supname` ASC) USING BTREE COMMENT '唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES (2, '小米科技有限公司', '代理商', 1, '雷先生', '19911210637', '大学东路101号广西机电', '2022-04-22 17:38:07');
INSERT INTO `supplier` VALUES (4, '北京资源无限公司', '生产商', 1, '梦先生', '1778295102', '北京二环路106号', '2022-01-17 17:40:41');
INSERT INTO `supplier` VALUES (5, '深圳绿巨人科技有限公司', '代理商', 1, '美女士', '122421313', '深圳华强北', '2022-04-18 17:42:03');
INSERT INTO `supplier` VALUES (6, '南宁粤康软件有限公司', '代理商', 1, '张先生', '177594075', '南宁相思湖', '2020-03-04 15:30:00');
INSERT INTO `supplier` VALUES (12, '机械工程师文具批发店', '批发商', 1, '李女士', '122222222', '容城现代街122号', '2022-04-25 18:04:50');
INSERT INTO `supplier` VALUES (13, '测试测试', '其他', 1, '测试', '13911210637', '大学大学大学', '2022-05-07 16:20:48');
INSERT INTO `supplier` VALUES (22, '华为有限公司1', '供应商', 0, '赵女士', '18779843216', '广西机电', '2022-05-09 10:07:36');
INSERT INTO `supplier` VALUES (23, '华为小米红米有限公司', '销售商', 0, '黄女士', '18777743216', '广西机电', '2022-05-09 10:15:50');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `details` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, 'sys', '系统管理员');
INSERT INTO `t_role` VALUES (2, 'admin', '资产管理员');
INSERT INTO `t_role` VALUES (3, 'BOOS', '老板');
INSERT INTO `t_role` VALUES (4, 'user', '普通用户');
INSERT INTO `t_role` VALUES (5, 'developer', '开发者');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户的id',
  `roleid` int NULL DEFAULT NULL COMMENT '角色的id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (2, 'el3759', 1);
INSERT INTO `t_user_role` VALUES (3, 'el1850', 1);
INSERT INTO `t_user_role` VALUES (4, 'el3048', 1);
INSERT INTO `t_user_role` VALUES (5, 'el5426', 1);

-- ----------------------------
-- Table structure for transfer
-- ----------------------------
DROP TABLE IF EXISTS `transfer`;
CREATE TABLE `transfer`  (
  `trid` int NOT NULL AUTO_INCREMENT,
  `trorder` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '转移单号',
  `wornpeid` int NOT NULL COMMENT ' 原使用人',
  `newpeid` int NOT NULL COMMENT '新使用人',
  `trdate` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '转移日期',
  `cause` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`trid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of transfer
-- ----------------------------
INSERT INTO `transfer` VALUES (4, 'TR2022050421140', 7, 3, '2022-05-03', '可以的');
INSERT INTO `transfer` VALUES (5, 'TR2022050417343', 9, 7, '2022-05-03', '可以的');
INSERT INTO `transfer` VALUES (6, 'TR2022050493249', 7, 4, '2022-04-08', '12345');
INSERT INTO `transfer` VALUES (7, 'TR2022050485118', 11, 12, '2022-05-02', '小阳台');
INSERT INTO `transfer` VALUES (8, 'TR2022050803848', 13, 4, '2022-05-07', '123112');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `jobid` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户工号',
  `username` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `salt` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐',
  `gender` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '男或女',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `address` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `is_valid` int NULL DEFAULT NULL COMMENT '状态',
  `activation_time` datetime NULL DEFAULT NULL COMMENT '激活时间',
  `salary` double(10, 2) NULL DEFAULT NULL COMMENT '工资',
  `deid` int NULL DEFAULT NULL COMMENT '部门id',
  `confirm_code` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '确认码',
  `rid` int NULL DEFAULT NULL COMMENT '角色id',
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`jobid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1518832767079657474', '我的我的', NULL, NULL, NULL, NULL, 0, NULL, NULL, 1, NULL, 0.00, 1, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('el1437', '啧啧啧', '0febf8256e1f33a52134b876e6de6ce3', '2558716531@qq.com', 's2rmzjj5', NULL, NULL, NULL, NULL, 1, '2022-04-25 22:19:42', NULL, NULL, '1518429518266765312', NULL, NULL);
INSERT INTO `user` VALUES ('el1850', '彭于晏', '7df4b31df0d3b749e4bb7fbd436a0430', '2260562115@qq.com', 'rulendz3', NULL, NULL, NULL, NULL, 1, '2022-04-25 19:46:52', NULL, NULL, '1518391055244988416', NULL, NULL);
INSERT INTO `user` VALUES ('el3048', '赵然后', '3094a4494cc4992fa7d614e1b903cfc4', '2558716531@qq.com', 'tlta4uz5', NULL, 0, '', '', 0, '2022-04-25 22:08:13', 0.00, 3, '1518426625992167424', NULL, NULL);
INSERT INTO `user` VALUES ('el3759', '黎小帅', 'a6d103411cb46b25d7f50090b6359a7d', '1601434500@qq.com', 'mls75e3z', '男', 0, '19911210637', '大学东路101号风华园！', 1, '2022-04-25 19:38:28', 0.00, 1, '1518388941491933184', NULL, '20220509110157085.jpg');
INSERT INTO `user` VALUES ('el5136', '赵', '2d89929f45223760d03368be52914017', '2558716531@qq.com', 'ymysnltt', NULL, NULL, NULL, NULL, 0, '2022-04-25 22:07:38', NULL, NULL, '1518426479459962880', NULL, NULL);
INSERT INTO `user` VALUES ('el5426', '姜家瑞', 'dc5249fcc3f5d396723aaf92e0205f3f', '1937700245@qq.com', '95oy12n2', NULL, NULL, NULL, NULL, 1, '2022-04-25 22:08:50', NULL, NULL, '1518426780636155904', NULL, NULL);
INSERT INTO `user` VALUES ('el5755', '吉他他', 'f65f7dbfc2919ab170ac87dcc3a35a5f', '484952928@qq.com', 'sh1o1btn', NULL, NULL, NULL, NULL, 1, '2022-04-25 22:33:35', NULL, NULL, '1518433012096831488', NULL, NULL);
INSERT INTO `user` VALUES ('el7565', 'zjs', 'e96904b7c68e6d4766ca9c787d902b8c', '2897935600@qq.com', 'vrt1u1zu', NULL, NULL, NULL, NULL, NULL, '2023-03-20 12:49:53', NULL, NULL, '1637436227345059840', NULL, NULL);
INSERT INTO `user` VALUES ('el8096', '丽丽', '079d9efb6438c8daa0ee032c1d723daa', '2687586974@qq.com', 'erc6qnxr', NULL, NULL, NULL, NULL, NULL, '2022-05-09 20:26:46', NULL, NULL, '1523474527424745472', NULL, NULL);
INSERT INTO `user` VALUES ('el9750', '里的的', '86b502158d6100663be18be2e3950fd5', '917907099@qq.com', '3kg90v1l', NULL, NULL, NULL, NULL, NULL, '2022-05-09 22:03:55', NULL, NULL, '1523498972801536000', NULL, NULL);

-- ----------------------------
-- Table structure for warehous
-- ----------------------------
DROP TABLE IF EXISTS `warehous`;
CREATE TABLE `warehous`  (
  `waid` int NOT NULL AUTO_INCREMENT,
  `gid` int NULL DEFAULT NULL COMMENT 'zcid',
  `supid` int NULL DEFAULT NULL COMMENT '供应商id',
  `brid` int NULL DEFAULT NULL COMMENT '品牌id',
  `acid` int NULL DEFAULT NULL COMMENT '取得id',
  `wadate` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入库日期',
  `stid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '存放地点',
  `waimg` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产图片',
  `waname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产名称',
  `is_valid` int NULL DEFAULT NULL COMMENT 'zt',
  PRIMARY KEY (`waid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '4.15	资产入库 表名：warehous' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of warehous
-- ----------------------------
INSERT INTO `warehous` VALUES (1, 47, 2, 2, 9, '', '0', '', '鼠标g703', 0);
INSERT INTO `warehous` VALUES (2, 0, 0, 0, 0, '', '', '', '1', 2);
INSERT INTO `warehous` VALUES (22, 47, 5, 1, 8, '2022-05-01', '3', '20220501144552109.PNG', '吞吞吐吐', 2);
INSERT INTO `warehous` VALUES (30, 52, 5, 2, 9, '2022-05-01', '5', '20220508170536333.jpg', '测试', 0);
INSERT INTO `warehous` VALUES (33, 48, 5, 12, 8, '2022-05-03', '3', NULL, '在此次', 0);
INSERT INTO `warehous` VALUES (34, 52, 4, 2, 9, '2022-05-05', '3', NULL, '测试111', 2);

SET FOREIGN_KEY_CHECKS = 1;
