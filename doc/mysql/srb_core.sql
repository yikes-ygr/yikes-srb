SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for borrow_info
-- ----------------------------
DROP TABLE IF EXISTS `borrow_info`;
CREATE TABLE `borrow_info`
(
    `id`               bigint(21)     NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id`          bigint(21)     NOT NULL DEFAULT 0 COMMENT '借款用户id',
    `amount`           decimal(10, 2) NULL     DEFAULT NULL COMMENT '借款金额',
    `period`           int            NULL     DEFAULT NULL COMMENT '借款期限',
    `borrow_year_rate` decimal(10, 2) NULL     DEFAULT NULL COMMENT '年化利率',
    `return_method`    tinyint(1)     NULL     DEFAULT NULL COMMENT '还款方式 1-等额本息 2-等额本金 3-每月还息一次还本 4-一次还本',
    `money_use`        tinyint(1)     NULL     DEFAULT NULL COMMENT '资金用途',
    `status`           tinyint(1)     NOT NULL DEFAULT 0 COMMENT '状态（0：未提交，1：审核中， 2：审核通过， -1：审核不通过）',

    `created_time`     timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_user`     varchar(32)    null     default null comment '创建人',
    `updated_time`     timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `updated_user`     varchar(32)    null     default null comment '更新人',
    `is_deleted`       tinyint(1)     NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_user_id` (`user_id`) USING BTREE
) COMMENT = '借款信息表';

-- ----------------------------
-- Table structure for borrower
-- ----------------------------
DROP TABLE IF EXISTS `borrower`;
CREATE TABLE `borrower`
(
    `id`                bigint(21)  NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id`           bigint(21)  NOT NULL DEFAULT 0 COMMENT '用户id',
    `name`              varchar(32) NULL     DEFAULT NULL COMMENT '姓名',
    `id_card`           varchar(19) NOT NULL DEFAULT '0' COMMENT '身份证号',
    `mobile`            varchar(11) NULL     DEFAULT NULL COMMENT '手机',
    `sex`               tinyint(1)  NULL     DEFAULT NULL COMMENT '性别（1：男 0：女）',
    `age`               tinyint(1)  NULL     DEFAULT NULL COMMENT '年龄',
    `education`         tinyint(1)  NULL     DEFAULT NULL COMMENT '学历',
    `is_marry`          tinyint(1)  NULL     DEFAULT NULL COMMENT '是否结婚（1：是 0：否）',
    `industry`          tinyint(1)  NULL     DEFAULT NULL COMMENT '行业',
    `income`            tinyint(1)  NULL     DEFAULT NULL COMMENT '月收入',
    `return_source`     tinyint(1)  NULL     DEFAULT NULL COMMENT '还款来源',
    `contacts_name`     varchar(30) NULL     DEFAULT NULL COMMENT '联系人名称',
    `contacts_mobile`   varchar(11) NULL     DEFAULT NULL COMMENT '联系人手机',
    `contacts_relation` tinyint(1)  NULL     DEFAULT NULL COMMENT '联系人关系',
    `status`            tinyint(1)  NOT NULL DEFAULT 0 COMMENT '状态（0：未认证，1：认证中， 2：认证通过， -1：认证失败）',

    `created_time`      timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_user`      varchar(32) null     default null comment '创建人',
    `updated_time`      timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `updated_user`      varchar(32) null     default null comment '更新人',
    `is_deleted`        tinyint(1)  NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `uk_user_id` (`user_id`) USING BTREE
) COMMENT = '借款人';

-- ----------------------------
-- Table structure for borrower_attach
-- ----------------------------
DROP TABLE IF EXISTS `borrower_attach`;
CREATE TABLE `borrower_attach`
(
    `id`           bigint(21)   NOT NULL AUTO_INCREMENT COMMENT '编号',
    `borrower_id`  bigint(21)   NOT NULL DEFAULT 0 COMMENT '借款人id',
    `image_type`   varchar(16)  NULL     DEFAULT NULL COMMENT '图片类型（idCard1：身份证正面，idCard2：身份证反面，house：房产证，car：车）',
    `image_url`    varchar(200) NULL     DEFAULT NULL COMMENT '图片路径',
    `image_name`   varchar(64)  NULL     DEFAULT NULL COMMENT '图片名称',

    `created_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_user` varchar(32)  null     default null comment '创建人',
    `updated_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `updated_user` varchar(32)  null     default null comment '更新人',
    `is_deleted`   tinyint(1)   NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_borrower_id` (`borrower_id`) USING BTREE
) COMMENT = '借款人上传资源表';

-- ----------------------------
-- Table structure for dict
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict`
(
    `id`           bigint(21)   NOT NULL AUTO_INCREMENT COMMENT 'id',
    `parent_id`    bigint(21)   NOT NULL DEFAULT 0 COMMENT '上级id',
    `name`         varchar(100) NOT NULL DEFAULT '' COMMENT '名称',
    `value`        int(11)      NULL     DEFAULT NULL COMMENT '值',
    `dict_code`    varchar(20)  NULL     DEFAULT NULL COMMENT '编码',

    `created_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_user` varchar(32)  null     default null comment '创建人',
    `updated_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `updated_user` varchar(32)  null     default null comment '更新人',
    `is_deleted`   tinyint(1)   NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `uk_parent_id_value` (`parent_id`, `value`) USING BTREE,
    INDEX `idx_parent_id` (`parent_id`) USING BTREE
) COMMENT = '数据字典';

-- ----------------------------
-- Table structure for integral_grade
-- ----------------------------
DROP TABLE IF EXISTS `integral_grade`;
CREATE TABLE `integral_grade`
(
    `id`             bigint(21)     NOT NULL AUTO_INCREMENT COMMENT '编号',
    `integral_start` int(11)        NULL     DEFAULT NULL COMMENT '积分区间开始',
    `integral_end`   int(11)        NULL     DEFAULT NULL COMMENT '积分区间结束',
    `borrow_amount`  decimal(10, 2) NULL     DEFAULT NULL COMMENT '借款额度',

    `created_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_user`   varchar(32)    null     default null comment '创建人',
    `updated_time`   timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `updated_user`   varchar(32)    null     default null comment '更新人',
    `is_deleted`     tinyint(1)     NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',
    PRIMARY KEY (`id`) USING BTREE
) COMMENT = '积分等级表';

-- ----------------------------
-- Table structure for lend
-- ----------------------------
DROP TABLE IF EXISTS `lend`;
CREATE TABLE `lend`
(
    `id`               bigint(21)     NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id`          bigint(21)     NULL     DEFAULT NULL COMMENT '借款用户id',
    `borrow_info_id`   bigint(21)     NULL     DEFAULT NULL COMMENT '借款信息id',
    `lend_no`          varchar(30)    NULL     DEFAULT NULL COMMENT '标的编号',
    `title`            varchar(200)   NULL     DEFAULT NULL COMMENT '标题',
    `amount`           decimal(10, 2) NULL     DEFAULT NULL COMMENT '标的金额',
    `period`           int(11)        NULL     DEFAULT NULL COMMENT '投资期数',
    `lend_year_rate`   decimal(10, 2) NULL     DEFAULT NULL COMMENT '年化利率',
    `service_rate`     decimal(10, 2) NULL     DEFAULT NULL COMMENT '平台服务费率',
    `return_method`    tinyint(1)     NULL     DEFAULT NULL COMMENT '还款方式',
    `lowest_amount`    decimal(10, 2) NULL     DEFAULT NULL COMMENT '最低投资金额',
    `invest_amount`    decimal(10, 2) NULL     DEFAULT NULL COMMENT '已投金额',
    `invest_num`       int(11)        NULL     DEFAULT NULL COMMENT '投资人数',
    `publish_date`     datetime       NULL     DEFAULT NULL COMMENT '发布日期',
    `lend_start_date`  date           NULL     DEFAULT NULL COMMENT '开始日期',
    `lend_end_date`    date           NULL     DEFAULT NULL COMMENT '结束日期',
    `lend_info`        text           NULL COMMENT '说明',
    `expect_amount`    decimal(10, 2) NULL     DEFAULT NULL COMMENT '平台预期收益',
    `real_amount`      decimal(10, 2) NULL     DEFAULT NULL COMMENT '实际收益',
    `status`           tinyint(1)     NOT NULL DEFAULT 0 COMMENT '状态',
    `check_time`       datetime       NULL     DEFAULT NULL COMMENT '审核时间',
    `check_admin_id`   bigint(21)     NULL     DEFAULT NULL COMMENT '审核用户id',
    `payment_time`     datetime       NULL     DEFAULT NULL COMMENT '放款时间',
    `payment_admin_id` datetime       NULL     DEFAULT NULL COMMENT '放款人id',

    `created_time`     timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_user`     varchar(32)    null     default null comment '创建人',
    `updated_time`     timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `updated_user`     varchar(32)    null     default null comment '更新人',
    `is_deleted`       tinyint(1)     NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `uk_lend_no` (`lend_no`) USING BTREE,
    INDEX `idx_user_id` (`user_id`) USING BTREE,
    INDEX `idx_borrow_info_id` (`borrow_info_id`) USING BTREE
) COMMENT = '标的准备表';

-- ----------------------------
-- Table structure for lend_item
-- ----------------------------
DROP TABLE IF EXISTS `lend_item`;
CREATE TABLE `lend_item`
(
    `id`              bigint(21)     NOT NULL AUTO_INCREMENT COMMENT '编号',
    `lend_item_no`    varchar(64)    NULL     DEFAULT NULL COMMENT '投资编号',
    `lend_id`         bigint(21)     NOT NULL DEFAULT 0 COMMENT '标的id',
    `invest_user_id`  bigint(21)     NULL     DEFAULT NULL COMMENT '投资用户id',
    `invest_name`     varchar(32)    NULL     DEFAULT NULL COMMENT '投资人名称',
    `invest_amount`   decimal(10, 2) NULL     DEFAULT NULL COMMENT '投资金额',
    `lend_year_rate`  decimal(10, 2) NULL     DEFAULT NULL COMMENT '年化利率',
    `invest_time`     datetime       NULL     DEFAULT NULL COMMENT '投资时间',
    `lend_start_date` date           NULL     DEFAULT NULL COMMENT '开始日期',
    `lend_end_date`   date           NULL     DEFAULT NULL COMMENT '结束日期',
    `expect_amount`   decimal(10, 2) NULL     DEFAULT NULL COMMENT '预期收益',
    `real_amount`     decimal(10, 2) NULL     DEFAULT NULL COMMENT '实际收益',
    `status`          tinyint(1)     NULL     DEFAULT NULL COMMENT '状态（0：默认 1：已支付 2：已还款）',

    `created_time`    timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_user`    varchar(32)    null     default null comment '创建人',
    `updated_time`    timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `updated_user`    varchar(32)    null     default null comment '更新人',
    `is_deleted`      tinyint(1)     NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `uk_lend_item_no` (`lend_item_no`) USING BTREE,
    INDEX `idx_lend_id` (`lend_id`) USING BTREE,
    INDEX `idx_invest_user_id` (`invest_user_id`) USING BTREE
) COMMENT = '标的出借记录表';

-- ----------------------------
-- Table structure for lend_item_return
-- ----------------------------
DROP TABLE IF EXISTS `lend_item_return`;
CREATE TABLE `lend_item_return`
(
    `id`               bigint(21)     NOT NULL AUTO_INCREMENT COMMENT '编号',
    `lend_return_id`   bigint(21)     NULL     DEFAULT NULL COMMENT '标的还款id',
    `lend_item_id`     bigint(21)     NULL     DEFAULT NULL COMMENT '标的项id',
    `lend_id`          bigint(21)     NOT NULL DEFAULT 0 COMMENT '标的id',
    `invest_user_id`   bigint(21)     NULL     DEFAULT NULL COMMENT '出借用户id',
    `invest_amount`    decimal(10, 2) NULL     DEFAULT NULL COMMENT '出借金额',
    `current_period`   int            NULL     DEFAULT NULL COMMENT '当前的期数',
    `lend_year_rate`   decimal(10, 2) NULL     DEFAULT NULL COMMENT '年化利率',
    `return_method`    tinyint(1)     NULL     DEFAULT NULL COMMENT '还款方式 1-等额本息 2-等额本金 3-每月还息一次还本 4-一次还本',
    `principal`        decimal(10, 2) NULL     DEFAULT NULL COMMENT '本金',
    `interest`         decimal(10, 2) NULL     DEFAULT NULL COMMENT '利息',
    `total`            decimal(10, 2) NULL     DEFAULT NULL COMMENT '本息',
    `fee`              decimal(10, 2) NULL     DEFAULT 0.00 COMMENT '手续费',
    `return_date`      date           NULL     DEFAULT NULL COMMENT '还款时指定的还款日期',
    `real_return_time` datetime       NULL     DEFAULT NULL COMMENT '实际发生的还款时间',
    `is_overdue`       tinyint(1)     NULL     DEFAULT NULL COMMENT '是否逾期',
    `overdue_total`    decimal(10, 2) NULL     DEFAULT NULL COMMENT '逾期金额',
    `status`           tinyint(1)     NULL     DEFAULT NULL COMMENT '状态（0-未归还 1-已归还）',

    `created_time`     timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_user`     varchar(32)    null     default null comment '创建人',
    `updated_time`     timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `updated_user`     varchar(32)    null     default null comment '更新人',
    `is_deleted`       tinyint(1)     NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',

    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_lend_return_id` (`lend_return_id`) USING BTREE,
    INDEX `idx_lend_item_id` (`lend_item_id`) USING BTREE,
    INDEX `idx_lend_id` (`lend_id`) USING BTREE,
    INDEX `idx_invest_user_id` (`invest_user_id`) USING BTREE
) COMMENT = '标的出借回款记录表';

-- ----------------------------
-- Table structure for lend_return
-- ----------------------------
DROP TABLE IF EXISTS `lend_return`;
CREATE TABLE `lend_return`
(
    `id`               bigint(21)     NOT NULL AUTO_INCREMENT COMMENT '编号',
    `lend_id`          bigint(21)     NULL     DEFAULT NULL COMMENT '标的id',
    `borrow_info_id`   bigint(21)     NOT NULL DEFAULT 0 COMMENT '借款信息id',
    `return_no`        varchar(32)    NULL     DEFAULT NULL COMMENT '还款批次号',
    `user_id`          bigint(21)     NULL     DEFAULT NULL COMMENT '借款人用户id',
    `amount`           decimal(10, 2) NULL     DEFAULT NULL COMMENT '借款金额',
    `base_amount`      decimal(10, 2) NULL     DEFAULT NULL COMMENT '计息本金额',
    `current_period`   int(11)        NULL     DEFAULT NULL COMMENT '当前的期数',
    `lend_year_rate`   decimal(10, 2) NULL     DEFAULT NULL COMMENT '年化利率',
    `return_method`    tinyint(1)     NULL     DEFAULT NULL COMMENT '还款方式 1-等额本息 2-等额本金 3-每月还息一次还本 4-一次还本',
    `principal`        decimal(10, 2) NULL     DEFAULT NULL COMMENT '本金',
    `interest`         decimal(10, 2) NULL     DEFAULT NULL COMMENT '利息',
    `total`            decimal(10, 2) NULL     DEFAULT NULL COMMENT '本息',
    `fee`              decimal(10, 2) NULL     DEFAULT 0.00 COMMENT '手续费',
    `return_date`      date           NULL     DEFAULT NULL COMMENT '还款时指定的还款日期',
    `real_return_time` datetime       NULL     DEFAULT NULL COMMENT '实际发生的还款时间',
    `is_overdue`       tinyint(1)     NULL     DEFAULT NULL COMMENT '是否逾期',
    `overdue_total`    decimal(10, 2) NULL     DEFAULT NULL COMMENT '逾期金额',
    `is_last`          tinyint(1)     NULL     DEFAULT NULL COMMENT '是否最后一次还款',
    `status`           tinyint(1)     NULL     DEFAULT NULL COMMENT '状态（0-未归还 1-已归还）',

    `created_time`     timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_user`     varchar(32)    null     default null comment '创建人',
    `updated_time`     timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `updated_user`     varchar(32)    null     default null comment '更新人',
    `is_deleted`       tinyint(1)     NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',

    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `uk_return_no` (`return_no`) USING BTREE,
    INDEX `idx_lend_id` (`lend_id`) USING BTREE,
    INDEX `idx_borrow_info_id` (`borrow_info_id`) USING BTREE,
    INDEX `idx_user_id` (`user_id`) USING BTREE
) COMMENT = '还款记录表';

-- ----------------------------
-- Table structure for srb_permit_file
-- ----------------------------
DROP TABLE IF EXISTS `srb_permit_file`;
CREATE TABLE `srb_permit_file`
(
    `id`           bigint(21)   NOT NULL AUTO_INCREMENT COMMENT 'PK',
    `relation_id`  bigint(21)   NOT NULL COMMENT '关联ID',
    `file_type`    varchar(255) NULL     DEFAULT NULL COMMENT '文件类型',
    `label_name`   varchar(255) NULL     DEFAULT NULL COMMENT '附件标签',
    `file_name`    varchar(255) NULL     DEFAULT NULL COMMENT '文件名称',
    `file_url`     varchar(255) NULL     DEFAULT NULL COMMENT '文件路径',
    `file_key`     varchar(255) NULL     DEFAULT NULL COMMENT '文件key',
    `type`         varchar(32)  NOT NULL COMMENT '类型',

    `created_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_user` varchar(32)  null     default null comment '创建人',
    `updated_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `updated_user` varchar(32)  null     default null comment '更新人',
    `is_deleted`   tinyint(1)   NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',

    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = 'yikes上传附件表';

-- ----------------------------
-- Table structure for trans_flow
-- ----------------------------
DROP TABLE IF EXISTS `trans_flow`;
CREATE TABLE `trans_flow`
(
    `id`              bigint(21)     NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id`         bigint(21)     NOT NULL DEFAULT 0 COMMENT '用户id',
    `user_name`       varchar(32)    NULL     DEFAULT NULL COMMENT '用户名称',
    `trans_no`        varchar(32)    NOT NULL DEFAULT '' COMMENT '交易单号',
    `trans_type`      tinyint(1)     NOT NULL DEFAULT 0 COMMENT '交易类型（1：充值 2：提现 3：投标 4：投资回款 ...）',
    `trans_type_name` varchar(100)   NULL     DEFAULT NULL COMMENT '交易类型名称',
    `trans_amount`    decimal(10, 2) NULL     DEFAULT NULL COMMENT '交易金额',
    `memo`            varchar(300)   NULL     DEFAULT NULL COMMENT '备注',

    `created_time`    timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_user`    varchar(32)    null     default null comment '创建人',
    `updated_time`    timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `updated_user`    varchar(32)    null     default null comment '更新人',
    `is_deleted`      tinyint(1)     NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',

    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `uk_trans_no` (`trans_no`) USING BTREE,
    INDEX `idx_user_id` (`user_id`) USING BTREE
) COMMENT = '交易流水表';

-- ----------------------------
-- Table structure for user_account
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account`
(
    `id`            bigint(21)     NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id`       bigint(21)     NOT NULL DEFAULT 0 COMMENT '用户id',
    `amount`        decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '帐户可用余额',
    `freeze_amount` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '冻结金额',

    `version`       int(11)        NOT NULL DEFAULT 0 COMMENT '版本号',

    `created_time`  timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_user`  varchar(32)    null     default null comment '创建人',
    `updated_time`  timestamp      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `updated_user`  varchar(32)    null     default null comment '更新人',
    `is_deleted`    tinyint(1)     NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `uk_user_id` (`user_id`) USING BTREE
) COMMENT = '用户账户';

-- ----------------------------
-- Table structure for user_bind
-- ----------------------------
DROP TABLE IF EXISTS `user_bind`;
CREATE TABLE `user_bind`
(
    `id`           bigint(21)  NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id`      bigint(21)  NOT NULL DEFAULT 0 COMMENT '用户id',
    `name`         varchar(20) NOT NULL DEFAULT '' COMMENT '用户姓名',
    `id_card`      varchar(19) NOT NULL DEFAULT '' COMMENT '身份证号',
    `bank_no`      varchar(50) NULL     DEFAULT NULL COMMENT '银行卡号',
    `bank_type`    varchar(20) NULL     DEFAULT NULL COMMENT '银行类型',
    `mobile`       varchar(11) NOT NULL DEFAULT '' COMMENT '手机号',
    `bind_code`    varchar(50) NULL     DEFAULT NULL COMMENT '绑定账户协议号',
    `status`       tinyint(1)  NULL     DEFAULT NULL COMMENT '状态',

    `created_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_user` varchar(32) null     default null comment '创建人',
    `updated_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `updated_user` varchar(32) null     default null comment '更新人',
    `is_deleted`   tinyint(1)  NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',

    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `uk_user_id` (`user_id`) USING BTREE
) COMMENT = '用户绑定表';

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`
(
    `id`                 bigint(21)   NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_type`          tinyint(1)   NOT NULL DEFAULT 0 COMMENT '1：出借人 2：借款人',
    `mobile`             varchar(11)  NOT NULL DEFAULT '' COMMENT '手机号',
    `password`           varchar(50)  NOT NULL DEFAULT '' COMMENT '用户密码',
    `nick_name`          varchar(20)  NULL     DEFAULT NULL COMMENT '用户昵称',
    `name`               varchar(20)  NULL     DEFAULT NULL COMMENT '用户姓名',
    `id_card`            varchar(20)  NULL     DEFAULT NULL COMMENT '身份证号',
    `email`              varchar(100) NULL     DEFAULT NULL COMMENT '邮箱',
    `openid`             varchar(40)  NULL     DEFAULT NULL COMMENT '微信用户标识openid',
    `head_img`           varchar(200) NULL     DEFAULT NULL COMMENT '头像',
    `bind_status`        tinyint(1)   NOT NULL DEFAULT 0 COMMENT '绑定状态（0：未绑定，1：绑定成功 -1：绑定失败）',
    `borrow_auth_status` tinyint(1)   NOT NULL DEFAULT 0 COMMENT '借款人认证状态（0：未认证 1：认证中 2：认证通过 -1：认证失败）',
    `bind_code`          varchar(50)  NULL     DEFAULT NULL COMMENT '绑定账户协议号',
    `integral`           int(11)      NOT NULL DEFAULT 0 COMMENT '用户积分',
    `status`             tinyint(1)   NOT NULL DEFAULT 1 COMMENT '状态（0：锁定 1：正常）',

    `created_time`       timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_user`       varchar(32)  null     default null comment '创建人',
    `updated_time`       timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `updated_user`       varchar(32)  null     default null comment '更新人',
    `is_deleted`         tinyint(1)   NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',

    PRIMARY KEY (`id`) USING BTREE,
    INDEX `uk_mobile` (`mobile`) USING BTREE
) COMMENT = '用户基本信息';

-- ----------------------------
-- Table structure for user_integral
-- ----------------------------
DROP TABLE IF EXISTS `user_integral`;
CREATE TABLE `user_integral`
(
    `id`           bigint(21)   NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id`      bigint(21)   NULL     DEFAULT NULL COMMENT '用户id',
    `integral`     int(11)      NULL     DEFAULT NULL COMMENT '积分',
    `content`      varchar(100) NULL     DEFAULT NULL COMMENT '获取积分说明',

    `created_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_user` varchar(32)  null     default null comment '创建人',
    `updated_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `updated_user` varchar(32)  null     default null comment '更新人',
    `is_deleted`   tinyint(1)   NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',

    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_user_id` (`user_id`) USING BTREE
) COMMENT = '用户积分记录表';

-- ----------------------------
-- Table structure for user_login_record
-- ----------------------------
DROP TABLE IF EXISTS `user_login_record`;
CREATE TABLE `user_login_record`
(
    `id`           bigint(21)  NOT NULL AUTO_INCREMENT COMMENT '编号',
    `user_id`      bigint(21)  NULL     DEFAULT NULL COMMENT '用户id',
    `ip`           varchar(32) NULL     DEFAULT NULL COMMENT 'ip',

    `created_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `created_user` varchar(32) null     default null comment '创建人',
    `updated_time` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `updated_user` varchar(32) null     default null comment '更新人',
    `is_deleted`   tinyint(1)  NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',

    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_user_id` (`user_id`) USING BTREE
) COMMENT = '用户登录记录表';
