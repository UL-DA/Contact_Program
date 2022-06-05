--시퀀스 생성
CREATE SEQUENCE contact_seq
START WITH 1
INCREMENT BY 1
MINVALUE 1
;

--Category table 생성 (* 구분 관리 테이블, 부모 테이블)
CREATE TABLE CATEGORY(
		categoryno VARCHAR2(2)
	, categorynm VARCHAR2(10)
NOT NULL UNIQUE
);

--Category 테이블의 categoryno를 pk로 지정
ALTER TABLE CATEGORY
ADD CONSTRAINTS categoryno_pk
PRIMARY KEY(categoryno)
;

--Contact table 생성 (* 연락처 저장 테이블, 자식 테이블)
CREATE TABLE CONTACT(
		contactno		VARCHAR2(10)
	,	contactnm		VARCHAR2(20)
	, contactnum	VARCHAR2(13)
	, contactaddr VARCHAR2(50)
	, categoryno 	VARCHAR2(2)
	, CONSTRAINTS	categoryno_fk
		FOREIGN KEY (categoryno)
		REFERENCES	category(categoryno)
);

CREATE TABLE MEMBER(
	  memid		VARCHAR2(20)
	, pwd			VARCHAR2(20)
	, memname	VARCHAR2(30)
	, memtel 	VARCHAR2(20)
	, regdate DATE DEFAULT SYSDATE
);

DESC MEMBER;
DESC CONTACT;
DESC CATEGORY;
SELECT * FROM MEMBER ORDER BY REGDATE;
SELECT * FROM CONTACT;
SELECT * FROM CATEGORY ORDER BY CATEGORYNO;

COMMIT;
ROLLBACK;