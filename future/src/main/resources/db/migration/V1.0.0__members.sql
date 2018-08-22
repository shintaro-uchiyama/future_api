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
	PRIMARY KEY (id)
) COMMENT = '会員情報一覧テーブル';



