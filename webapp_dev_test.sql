DROP TABLE IF EXISTS f_role;

/*==============================================================*/
/* Table: f_role                                                */
/*==============================================================*/
CREATE TABLE `f_role` (
  `id`              INT(11)   NOT NULL AUTO_INCREMENT
  COMMENT '主签ID',
  `role_code`       VARCHAR(50)        DEFAULT NULL
  COMMENT '角色编码',
  `role_name`       VARCHAR(100)       DEFAULT NULL
  COMMENT '角色名称',
  `description`     VARCHAR(200)       DEFAULT NULL
  COMMENT '描述',
  `pid`             INT(11)            DEFAULT NULL
  COMMENT '父ID',
  `role_type`       INT(11)            DEFAULT NULL
  COMMENT '角色类型：1-管理角色；2-业务角色',
  `create_by`       INT(11)            DEFAULT NULL,
  `create_datetime` TIMESTAMP NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_by`       INT(11)            DEFAULT NULL,
  `update_datetime` DATETIME           DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 42
  DEFAULT CHARSET = utf8;


ALTER TABLE f_role
  COMMENT '角色表';


DROP TABLE IF EXISTS f_group;

/*==============================================================*/
/* Table: f_group                                               */
/*==============================================================*/
CREATE TABLE `f_group` (
  `id`              INT(11)   NOT NULL AUTO_INCREMENT
  COMMENT '主键，组ID',
  `group_name`      VARCHAR(100)       DEFAULT NULL
  COMMENT '组名称',
  `group_type`      INT(11)            DEFAULT NULL
  COMMENT '组类型:1-用户组',
  `description`     VARCHAR(200)       DEFAULT NULL
  COMMENT '描述',
  `create_by`       INT(11)            DEFAULT NULL,
  `create_datetime` TIMESTAMP NULL     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_by`       INT(11)            DEFAULT NULL,
  `update_datetime` DATETIME           DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 13
  DEFAULT CHARSET = utf8;

ALTER TABLE f_group
  COMMENT '组表';


DROP TABLE IF EXISTS f_role_resources;

/*==============================================================*/
/* Table: f_role_resources                                      */
/*==============================================================*/
CREATE TABLE `f_role_resources` (
  `id`              INT(11)   NOT NULL AUTO_INCREMENT
  COMMENT '主键ID',
  `role_id`         INT(11)            DEFAULT NULL
  COMMENT '角色ID',
  `resource_id`     INT(11)            DEFAULT NULL
  COMMENT '权限(资源)ID',
  `create_by`       INT(11)            DEFAULT NULL,
  `create_datetime` TIMESTAMP NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 8165
  DEFAULT CHARSET = utf8;


ALTER TABLE f_role_resources
  COMMENT '角色权限(资源)表';


DROP TABLE IF EXISTS f_group_resources;

/*==============================================================*/
/* Table: f_group_resources                                     */
/*==============================================================*/
CREATE TABLE `f_group_resources` (
  `id`          INT(11)   NOT NULL AUTO_INCREMENT,
  `group_id`    INT(11)            DEFAULT NULL
  COMMENT '组ID',
  `resource_id` INT(11)            DEFAULT NULL
  COMMENT '权限(资源)ID',
  `create_by`   INT(11)            DEFAULT NULL,
  `create_date` TIMESTAMP NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 59
  DEFAULT CHARSET = utf8;

ALTER TABLE f_group_resources
  COMMENT '组权限（资源）关系表';


DROP TABLE IF EXISTS f_group_role;

/*==============================================================*/
/* Table: f_group_role                                          */
/*==============================================================*/
CREATE TABLE `f_group_role` (
  `id`              INT(11)   NOT NULL AUTO_INCREMENT,
  `group_id`        INT(11)            DEFAULT NULL
  COMMENT '组ID',
  `role_id`         INT(11)            DEFAULT NULL
  COMMENT '角色ID',
  `create_by`       INT(11)            DEFAULT NULL,
  `create_datetime` TIMESTAMP NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 26
  DEFAULT CHARSET = utf8;

ALTER TABLE f_group_role
  COMMENT '组角色关系表';


DROP TABLE IF EXISTS f_user_role;

/*==============================================================*/
/* Table: f_user_role                                           */
/*==============================================================*/
CREATE TABLE `f_user_role` (
  `id`              INT(11)   NOT NULL AUTO_INCREMENT,
  `user_id`         INT(11)            DEFAULT NULL
  COMMENT '用户ID',
  `role_id`         INT(11)            DEFAULT NULL
  COMMENT '角色ID',
  `create_by`       INT(11)            DEFAULT NULL,
  `create_datetime` TIMESTAMP NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

ALTER TABLE f_user_role
  COMMENT '用户组角色关系表';


DROP TABLE IF EXISTS f_user_group;

/*==============================================================*/
/* Table: f_user_group                                          */
/*==============================================================*/
CREATE TABLE `f_user_group` (
  `id`              INT(11)   NOT NULL AUTO_INCREMENT,
  `user_id`         INT(11)            DEFAULT NULL
  COMMENT '用户ID',
  `group_id`        INT(11)            DEFAULT NULL
  COMMENT '组ID',
  `create_by`       INT(11)            DEFAULT NULL,
  `create_datetime` TIMESTAMP NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 32
  DEFAULT CHARSET = utf8;

ALTER TABLE f_user_group
  COMMENT '用户组关系表';


DROP TABLE IF EXISTS f_sysuserinfo;

/*==============================================================*/
/* Table: f_sysuserinfo                                         */
/*==============================================================*/
CREATE TABLE `f_sysuserinfo` (
  `userid`            INT(11)      NOT NULL AUTO_INCREMENT
  COMMENT '主键ID，自动递增',
  `agentID`           VARCHAR(20)  NOT NULL
  COMMENT '用户工号',
  `password`          VARCHAR(100) NOT NULL
  COMMENT '用户密码',
  `usertype`          CHAR(1)      NOT NULL
  COMMENT '用户类型，对应通用字典表user_type',
  `username`          VARCHAR(50)  NOT NULL
  COMMENT '姓名',
  `sex`               CHAR(1)               DEFAULT NULL
  COMMENT '性别，对应通用字典表sex',
  `cardID`            CHAR(18)              DEFAULT NULL
  COMMENT '身份证号',
  `mobile`            CHAR(11)              DEFAULT NULL
  COMMENT '手机号',
  `nickname`          VARCHAR(50)           DEFAULT NULL
  COMMENT '昵称',
  `is_nickname`       CHAR(1)               DEFAULT NULL
  COMMENT '报告中是否使用昵称，对应通用字典表is_flag',
  `status`            CHAR(1)      NOT NULL
  COMMENT '状态，对应通用字典表status',
  `createtime`        DATETIME     NOT NULL
  COMMENT '创建时间',
  `updatetime`        TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '修改时间',
  `pwd_last_datetime` DATETIME              DEFAULT NULL
  COMMENT '密码最后修改时间',
  PRIMARY KEY (`userid`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 77
  DEFAULT CHARSET = utf8
  ROW_FORMAT = COMPACT
  COMMENT ='系统用户信息表';


ALTER TABLE f_sysuserinfo
  COMMENT '系统用户信息表';


DROP TABLE IF EXISTS f_user_resources;

/*==============================================================*/
/* Table: f_user_resources                                      */
/*==============================================================*/
CREATE TABLE `f_user_resources` (
  `id`         INT(11) NOT NULL AUTO_INCREMENT,
  `userid`     INT(11)          DEFAULT NULL,
  `resourceid` INT(11)          DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 7819
  DEFAULT CHARSET = utf8;

ALTER TABLE f_user_resources
  COMMENT '用户（权限）资源关系表';


DROP TABLE IF EXISTS f_resources;

/*==============================================================*/
/* Table: f_resources                                           */
/*==============================================================*/
CREATE TABLE `f_resources` (
  `id`          INT(11) NOT NULL AUTO_INCREMENT,
  `code`        VARCHAR(100)     DEFAULT NULL,
  `name`        VARCHAR(100)     DEFAULT NULL
  COMMENT '名称',
  `url`         VARCHAR(100)     DEFAULT NULL
  COMMENT 'URL',
  `function`    VARCHAR(100)     DEFAULT NULL
  COMMENT '功能函数',
  `description` VARCHAR(100)     DEFAULT NULL
  COMMENT '描述',
  `classname`   VARCHAR(50)      DEFAULT NULL,
  `icon`        VARCHAR(100)     DEFAULT NULL
  COMMENT '图标',
  `type`        INT(11)          DEFAULT NULL
  COMMENT '类型:1表示菜单，2表示功能按钮',
  `sort`        INT(11)          DEFAULT NULL
  COMMENT '排序',
  `pid`         INT(11)          DEFAULT NULL
  COMMENT '父ID',
  `level`       INT(11)          DEFAULT NULL
  COMMENT '层级',
  `leaf`        TINYINT(1)       DEFAULT NULL
  COMMENT '是否为子节点',
  `site`        INT(11)          DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 277
  DEFAULT CHARSET = utf8
  ROW_FORMAT = COMPACT;

ALTER TABLE f_resources
  COMMENT '资源信息';

/*========================================================================================================================================================================*/
/*-----------------------------------------------------------------------------------建表脚本-----------------------------------------------------------------------------*/
/*========================================================================================================================================================================*/


/*========================================================================================================================================================================*/
/*-----------------------------------------------------------------------------------加字段脚本-----------------------------------------------------------------------------*/
/*========================================================================================================================================================================*/



/*========================================================================================================================================================================*/
/*-----------------------------------------------------------------------------------insert语句-----------------------------------------------------------------------------*/
/*========================================================================================================================================================================*/
/*插入user用户表测试使用*/
INSERT INTO `test`.`f_sysuserinfo`
(`agentID`, `password`, `usertype`, `username`, `sex`, `cardID`, `mobile`, `nickname`, `is_nickname`, `status`, `createtime`, `updatetime`, `pwd_last_datetime`)
VALUES
  (1, 'E00D9267C1AEC025FF3E69394179ECA513E406E2044DEDA8EBF39816', '1', 'weidongdong', '1', 1, 6, 11, '1', 0, now(),
   now(), now());

/*插入资源脚本*/
INSERT INTO `test`.`f_resources` (`name`, `url`, `type`, `pid`) VALUES ('后台管理', '', '1', '0');
INSERT INTO `test`.`f_resources` (`name`, `url`, `type`, `pid`) VALUES ('用户管理', '/user', '1', '1');
INSERT INTO `test`.`f_resources` (`name`, `url`, `type`, `pid`) VALUES ('角色管理', '/role', '1', '1');
INSERT INTO `test`.`f_resources` (`name`, `url`, `type`, `pid`) VALUES ('资源管理', '/resource', '1', '1');
INSERT INTO `test`.`f_resources` (`name`, `url`, `type`, `pid`) VALUES ('用户组管理', '/group', '1', '1');

