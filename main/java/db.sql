DROP DATABASE IF EXISTS jsptry;

CREATE DATABASE jsptry;

# jsptry 사용
USE jsptry;

# 게시글 테이블 삭제
DROP TABLE article;

# 게시글 테이블 생성
CREATE TABLE article (
	idx INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	title VARCHAR(50) NOT NULL,
	`body` TEXT NOT NULL,
	`name` VARCHAR(30) NOT NULL

);

# 전체 게시글 조회
SELECT * FROM article;

# 게시글 등록
INSERT INTO article
SET regDate=NOW(),
updateDate=NOW(),
title='test1',
`body`='test1',
`name`='관리자';

# 특정 게시글 조회
SELECT * FROM article
WHERE idx=1;

# 게시글 수정
UPDATE article
SET updateDate=NOW(),
title='test11',
`body`='test11'
WHERE idx=5;

# 게시글 삭제
DELETE FROM article
WHERE idx=2;

# 회원 테이블 삭제
DROP TABLE `member`;

# 회원 테이블 생성
CREATE TABLE `member` (
	idx INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	loginId VARCHAR(50) NOT NULL,
	loginPw VARCHAR(50) NOT NULL,
	`name` VARCHAR(30) NOT NULL
);

# 전체 회원 조회
SELECT * FROM `member`;

# 회원가입
INSERT INTO `member`
SET regDate=NOW(),
loginId='admin',
loginPw='admin',
`name`='관리자';

# 로그인 정보와 일치하는 회원번호 가져오기
SELECT idx FROM `member`
WHERE loginId='test1' AND loginPw='test1';

# 회원번호에 해당하는 회원객체 가져오기
SELECT * FROM `member`
WHERE idx=1;

# 댓글 테이블 삭제
DROP TABLE `articleReply`;

# 댓글 테이블 생성
CREATE TABLE `articleReply` (
	idx INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	articleIdx INT UNSIGNED,
	`body` VARCHAR(200) NOT NULL,
	`name` VARCHAR(30) NOT NULL
);

# 전체 댓글 조회
SELECT * FROM `articleReply`;

# 댓글 등록
INSERT INTO articleReply
SET regDate=NOW(),
articleIdx=1,
`body`='replyTest1',
`name`='관리자';

# 게시글에 해당하는 댓글 목록 가져오기
SELECT * FROM articleReply
WHERE articleIdx=1;

# 특정 댓글 가져오기
SELECT * FROM articleReply
WHERE idx=1;

# 댓글 수정하기
UPDATE articleReply
SET regDate=NOW(),
`body`='댓글 수정!'
WHERE idx=2;

# 댓글 삭제하기
DELETE FROM articleReply
WHERE idx=4;

# 주소록 테이블 삭제
DROP TABLE address;

# 주소록 테이블 생성
CREATE TABLE address (
	idx INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	addr VARCHAR(50) NOT NULL,
	phone VARCHAR(14) NOT NULL,
	`name` VARCHAR(20) NOT NULL
);

# 전체 주소록 조회
SELECT * FROM address;

# 주소록 등록하기
INSERT INTO address
SET addr='서울',
phone='010-0000-0000',
`name`='관리자';

# 이름으로 주소록 검색하기
SELECT * FROM address
WHERE `name`='관리자';

# 주소으로 주소록 검색하기
SELECT * FROM address
WHERE addr LIKE CONCAT('%', '서울', '%');

# 번호로 주소록 가져오기
SELECT * FROM address
WHERE idx=1;

# 주소록 수정하기
UPDATE address
SET addr='test',
phone='010-test'
WHERE idx=1;

# 주소록 삭제하기
DELETE FROM address
WHERE idx=3;

# 본인의 주소록 목록 가져오기
SELECT a.*
FROM address a
LEFT JOIN `member` m
ON a.name = m.name
WHERE m.name='관리자';

# 이름으로 회원불러오기
SELECT * FROM `member`
WHERE `name`='관리자';

SELECT * FROM `member`;

# 비밀번호 변경
UPDATE `member`
SET loginPw='test99'
WHERE idx=5;

# 내가 쓴 게시글
SELECT a.* 
FROM article a 
LEFT JOIN `member` m 
ON a.name = m.name 
WHERE m.name='홍길동';