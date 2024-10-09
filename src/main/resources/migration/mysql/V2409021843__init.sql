CREATE TABLE `anime`
(
    `id`      bigint AUTO_INCREMENT PRIMARY KEY,
    `title`   varchar(255),
    `dou_ban` bigint,
    `season`  int,
    `time`    timestamp,
    `url`     varchar(255),
    `img`     varchar(255)
    );

CREATE TABLE `comment`
(
    `cid`        int AUTO_INCREMENT PRIMARY KEY,
    `episode_id` bigint,
    `p`          varchar(255),
    `m`          varchar(255),
    `t`          decimal(10,2)
    );

CREATE TABLE `episode`
(
    `id`            bigint AUTO_INCREMENT PRIMARY KEY,
    `title`         varchar(255),
    `url`           varchar(255),
    `time`          timestamp,
    `anime_id`      bigint,
    `episode_index` int,
    `status`        varchar(255)
    );