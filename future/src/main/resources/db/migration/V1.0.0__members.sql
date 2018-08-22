/* Drop Tables */

DROP TABLE IF EXISTS members;

/* Create Tables */

-- 会員情報一覧テーブル
CREATE TABLE members
(
	-- id
	id int NOT NULL AUTO_INCREMENT COMMENT 'id',
	-- 名前
	name varchar(255) NOT NULL COMMENT '名前',
	-- レコード生成日時
	created_at datetime DEFAULT NOW() NOT NULL COMMENT 'レコード生成日時',
	-- レコード更新日時
	updated_at datetime COMMENT 'レコード更新日時',
	PRIMARY KEY (id)
) COMMENT = '会員情報一覧テーブル';



