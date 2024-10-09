-- ----------------------------
-- Table structure for vben_sys_dept
-- ----------------------------
DROP TABLE IF EXISTS "public"."vben_sys_dept";
CREATE TABLE "public"."vben_sys_dept" (
                                          "id" int4 NOT NULL,
                                          "dept_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
                                          "remark" varchar(255) COLLATE "pg_catalog"."default",
                                          "parent_id" int4 NOT NULL,
                                          "order_no" int4,
                                          "create_time" timestamp(6) NOT NULL,
                                          "update_time" timestamp(6) NOT NULL
)
;
ALTER TABLE "public"."vben_sys_dept" OWNER TO "root";

-- ----------------------------
-- Table structure for vben_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."vben_sys_menu";
CREATE TABLE "public"."vben_sys_menu" (
                                          "id" int4 NOT NULL,
                                          "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
                                          "path" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
                                          "component" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
                                          "redirect" varchar(255) COLLATE "pg_catalog"."default",
                                          "title" varchar(255) COLLATE "pg_catalog"."default",
                                          "icon" varchar(255) COLLATE "pg_catalog"."default",
                                          "order_no" int4,
                                          "status" int2,
                                          "type" int4,
                                          "hide_menu" int2 NOT NULL,
                                          "parent_id" int4 NOT NULL,
                                          "affix" int2 NOT NULL,
                                          "carry_aram" int2 NOT NULL,
                                          "frame_src" varchar(255) COLLATE "pg_catalog"."default",
                                          "hide_tab" int2 NOT NULL,
                                          "hide_breadcrumb" int2 NOT NULL,
                                          "ignore_keep_alive" int2 NOT NULL,
                                          "create_time" timestamp(6) NOT NULL,
                                          "update_time" timestamp(6) NOT NULL
)
;
ALTER TABLE "public"."vben_sys_menu" OWNER TO "root";
COMMENT ON COLUMN "public"."vben_sys_menu"."path" IS '导航路径';
COMMENT ON COLUMN "public"."vben_sys_menu"."component" IS '组件路径';
COMMENT ON COLUMN "public"."vben_sys_menu"."redirect" IS '重定向地址';
COMMENT ON COLUMN "public"."vben_sys_menu"."order_no" IS '排序,越小越靠前';
COMMENT ON COLUMN "public"."vben_sys_menu"."status" IS '启用';
COMMENT ON COLUMN "public"."vben_sys_menu"."type" IS '类型';
COMMENT ON COLUMN "public"."vben_sys_menu"."hide_menu" IS '隐藏菜单';
COMMENT ON COLUMN "public"."vben_sys_menu"."parent_id" IS '父目录';
COMMENT ON COLUMN "public"."vben_sys_menu"."affix" IS '固定标签';
COMMENT ON COLUMN "public"."vben_sys_menu"."carry_aram" IS '如果该路由会携带参数，且需要在tab页上面显示。则需要设置为true';
COMMENT ON COLUMN "public"."vben_sys_menu"."frame_src" IS '内嵌iframe的地址';
COMMENT ON COLUMN "public"."vben_sys_menu"."hide_tab" IS '当前路由不再标签页显示';
COMMENT ON COLUMN "public"."vben_sys_menu"."hide_breadcrumb" IS '隐藏该路由在面包屑上面的显示';
COMMENT ON COLUMN "public"."vben_sys_menu"."ignore_keep_alive" IS '忽略keep alive 缓存';

-- ----------------------------
-- Table structure for vben_sys_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."vben_sys_role";
CREATE TABLE "public"."vben_sys_role" (
                                          "rid" int4 NOT NULL,
                                          "name" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
                                          "value" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
                                          "description" varchar(200) COLLATE "pg_catalog"."default",
                                          "create_time" timestamp(6) NOT NULL,
                                          "update_time" timestamp(6) NOT NULL
)
;
ALTER TABLE "public"."vben_sys_role" OWNER TO "root";

-- ----------------------------
-- Table structure for vben_sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."vben_sys_role_menu";
CREATE TABLE "public"."vben_sys_role_menu" (
                                               "rid" int4 NOT NULL,
                                               "mid" int4 NOT NULL,
                                               "value" text COLLATE "pg_catalog"."default",
                                               "create_time" timestamp(6) NOT NULL,
                                               "update_time" timestamp(6) NOT NULL
)
;
ALTER TABLE "public"."vben_sys_role_menu" OWNER TO "root";
COMMENT ON COLUMN "public"."vben_sys_role_menu"."rid" IS 'vben_sys_role 表 id';
COMMENT ON COLUMN "public"."vben_sys_role_menu"."mid" IS 'vben_sys_menu 表 id';
COMMENT ON COLUMN "public"."vben_sys_role_menu"."value" IS '留作验证';

-- ----------------------------
-- Table structure for vben_sys_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."vben_sys_user";
CREATE TABLE "public"."vben_sys_user" (
                                          "uid" int4 NOT NULL,
                                          "username" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
                                          "password" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
                                          "email" varchar(200) COLLATE "pg_catalog"."default",
                                          "phone" varchar(200) COLLATE "pg_catalog"."default",
                                          "salt" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
                                          "nickname" varchar(200) COLLATE "pg_catalog"."default",
                                          "real_name" varchar(200) COLLATE "pg_catalog"."default",
                                          "avatar" varchar(200) COLLATE "pg_catalog"."default",
                                          "home_path" varchar(200) COLLATE "pg_catalog"."default",
                                          "dept_id" int4,
                                          "description" varchar(400) COLLATE "pg_catalog"."default",
                                          "enabled" int2 NOT NULL,
                                          "account_non_expired" int2 NOT NULL,
                                          "credentials_non_expired" int2 NOT NULL,
                                          "account_non_locked" int2 NOT NULL,
                                          "create_time" timestamp(6) NOT NULL,
                                          "update_time" timestamp(6) NOT NULL
)
;
ALTER TABLE "public"."vben_sys_user" OWNER TO "root";

-- ----------------------------
-- Table structure for vben_sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."vben_sys_user_role";
CREATE TABLE "public"."vben_sys_user_role" (
                                               "uid" int4 NOT NULL,
                                               "rid" int4 NOT NULL,
                                               "create_time" timestamp(6) NOT NULL,
                                               "update_time" timestamp(6) NOT NULL
)
;
ALTER TABLE "public"."vben_sys_user_role" OWNER TO "root";

-- ----------------------------
-- Primary Key structure for table vben_sys_dept
-- ----------------------------
ALTER TABLE "public"."vben_sys_dept" ADD CONSTRAINT "vben_sys_dept_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table vben_sys_menu
-- ----------------------------
ALTER TABLE "public"."vben_sys_menu" ADD CONSTRAINT "_copy_5" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table vben_sys_role
-- ----------------------------
CREATE UNIQUE INDEX "value" ON "public"."vben_sys_role" USING btree (
    "value" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Primary Key structure for table vben_sys_role
-- ----------------------------
ALTER TABLE "public"."vben_sys_role" ADD CONSTRAINT "_copy_4" PRIMARY KEY ("rid");

-- ----------------------------
-- Primary Key structure for table vben_sys_role_menu
-- ----------------------------
ALTER TABLE "public"."vben_sys_role_menu" ADD CONSTRAINT "_copy_3" PRIMARY KEY ("rid", "mid");

-- ----------------------------
-- Indexes structure for table vben_sys_user
-- ----------------------------
CREATE UNIQUE INDEX "username" ON "public"."vben_sys_user" USING btree (
    "username" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );
CREATE INDEX "username_email_phone_index" ON "public"."vben_sys_user" USING btree (
    "username" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
    "email" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
    "phone" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Primary Key structure for table vben_sys_user
-- ----------------------------
ALTER TABLE "public"."vben_sys_user" ADD CONSTRAINT "_copy_2" PRIMARY KEY ("uid");

-- ----------------------------
-- Primary Key structure for table vben_sys_user_role
-- ----------------------------
ALTER TABLE "public"."vben_sys_user_role" ADD CONSTRAINT "_copy_1" PRIMARY KEY ("uid", "rid");


INSERT INTO "vben_sys_role" ("rid", "name", "value", "description", "create_time", "update_time") VALUES (1, 'admin', 'ROLE_ADMIN', '管理员', '2024-10-08 03:09:13', '2024-10-08 03:09:13');
INSERT INTO "vben_sys_role" ("rid", "name", "value", "description", "create_time", "update_time") VALUES (2, 'user', 'ROLE_USER', '用户', '2024-10-08 03:09:13', '2024-10-08 03:09:13');

INSERT INTO "vben_sys_user" ("uid", "username", "password", "email", "phone", "salt", "nickname", "real_name", "avatar", "home_path", "dept_id", "description", "enabled", "account_non_expired", "credentials_non_expired", "account_non_locked", "create_time", "update_time") VALUES (1, 'vben', '$2a$10$QzpKOwpJYX9Wyr9nc711ceJwI5mywTYDTiJnjs5eNwsrDCzErMzZu', NULL, NULL, 'vben', 'vben', NULL, '', NULL, NULL, NULL, 1, 1, 1, 1, '2024-10-08 03:09:13', '2024-10-08 03:09:13');

INSERT INTO "vben_sys_user_role" ("uid", "rid", "create_time", "update_time") VALUES (1, 1, '2024-10-08 03:09:13', '2024-10-08 03:09:13');