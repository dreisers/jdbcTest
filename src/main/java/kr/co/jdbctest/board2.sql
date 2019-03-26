-- board2.SQL
-- 테이블 생성
CREATE TABLE board2(
	idx		 Int PRIMARY KEY,
	name 	 VARCHAR(10),
	email 	 VARCHAR(50),
	homepage VARCHAR(50),
	title 	 VARCHAR(50),
	content  VARCHAR(2000),
	pwd 	 VARCHAR(10),
	wdate 	 DATE,
	hit 	 INT
);

-- 시퀀스 생성
CREATE SEQUENCE board2_idx_seq;


INSERT INTO board2(idx, name, email, homepage, title, content, pwd, wdate, hit) 
VALUES (board2_idx_seq.nextval , '손흥민'  , 'sol@soldesk.com'  , 'www.soldesk.com'  , '축구선수'  , '영국 토트넘'  , '1234'  , sysdate  , 0)
; 

DROP TABLE board2;