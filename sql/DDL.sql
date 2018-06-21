CREATE TABLE IF NOT EXISTS `murder_mystery`.`character_evidence` (
  `id` INT(8) AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT '主键id',
  `drama_id` INT(8) NOT NULL COMMENT '剧本id',
  `character_id` INT(8) NOT NULL COMMENT '人物id',
  `content` VARCHAR(512) NOT NULL COMMENT '证据内容',
  `img_urls` VARCHAR(45) NULL COMMENT '图片列表',
  `type` INT(4) NULL COMMENT '人物类型',
  `action_cost` INT(4) NULL COMMENT '行动点数')
  COMMENT='人物证据表'
  ENGINE = INNODB;

  CREATE TABLE IF NOT EXISTS `murder_mystery`.`character` (
  `id` INT(8) AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT '主键id',
  `drama_id` INT(8) NOT NULL COMMENT '剧本ID',
  `name` VARCHAR(64) NOT NULL COMMENT '剧本角色名',
  `description` VARCHAR(256) NOT NULL COMMENT '角色简介',
  `role_id` INT(4) NULL COMMENT '角色id(侦探,凶手,嫌疑人)')
  COMMENT='人物表'
  ENGINE = INNODB;

  CREATE TABLE IF NOT EXISTS `murder_mystery`.`drama` (
  `id` INT(8) AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT '主键id',
  `name` VARCHAR(64) NOT NULL COMMENT '剧本名称',
  `type` INT(4) NOT NULL COMMENT '剧本类型',
  `description` VARCHAR(256) NOT NULL COMMENT '剧本描述',
  `score` INT NULL COMMENT '剧本评分',
  `content` TEXT NULL COMMENT '剧本内容',
  `player_number` INT(4) NOT NULL COMMENT '游戏人数',
  `head_img` VARCHAR(128) NULL COMMENT '剧本头像',
  `paly_count` INT(8) NULL COMMENT '游玩次数',
  `difficulty_degree` INT(4) NULL COMMENT '难度系数')
   COMMENT='剧本表'
   ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS `murder_mystery`.`user` (
  `id` INT(8) AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT '主键id',
  `open_id` VARCHAR(64) NOT NULL COMMENT '用户微信id',
  `head_img` VARCHAR(256) NOT NULL COMMENT '用户头像',
  `level` INT(4) NULL COMMENT '用户等级',
  `experience` INT(8) NULL COMMENT '用户经验值')
COMMENT='用户表'
ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS `murder_mystery`.`game_user` (
  `id` INT(8) AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT '主键id',
  `character_id` INT(8) NOT NULL COMMENT '人物id',
  `user_id` BIGINT(20) NOT NULL COMMENT '用户id',
  `action_count` INT(4) NOT NULL COMMENT '行动点数',
  `voted` INT(4) NULL COMMENT '用户被投票数',
  `vote_game_user_id` INT(8) NULL COMMENT '投票给的用户id',
  `room_id` INT(8) NULL COMMENT '房间id',
  `status` INT(8) NOT NULL COMMENT '用户状态(在线,离线)')
COMMENT='游戏用户表'
ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS `murder_mystery`.`game_user_evidence` (
  `id` INT(8) AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT '主键id',
  `user_id` INT(8) NOT NULL COMMENT '用户id',
  `character_evidence_id` INT(8) NULL COMMENT '人物证据id',
  `status` INT(8) NOT NULL COMMENT '人物证据状态(未查看,已查看)',
  `checked_user_id` INT(8) NULL COMMENT '证据被查看的用户id',
  `is_open` INT(4) NOT NULL COMMENT '是否公开(0:false 1；true)')
  COMMENT='游戏用户证据表'
ENGINE = INNODB;



CREATE TABLE IF NOT EXISTS `murder_mystery`.`game_room` (
  `id` INT(8) AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT '主键id',
  `name` VARCHAR(64) NOT NULL COMMENT '房间名称',
  `user_number` INT(8) NOT NULL COMMENT '用户数量',
  `holder_id` INT(8) NULL COMMENT '房主id',
  `status` VARCHAR(45) NULL COMMENT '房间状态(未开始,已开始,进行中,已结束)')
  COMMENT='游戏房间表'
ENGINE = INNODB;

   