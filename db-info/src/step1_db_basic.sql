/*
 *  SQL(Structured Query Language) : 구조적 질의 언어
 * 									 database 제어 언어
 *  1. DDL(Data Definition Language) :
 * 		create	: table 생성
 * 		drop	: table 삭제
 * 		alter	: table 정보 수정
 * 	2. DML(Data Manipulation Language)
 * 		insert	: 정보 추가
 * 		delete	: 정보 삭제
 * 		updata	: 정보 수정
 * 	3. DQL(Data Query Language)
 * 		select : 정보 조회
 * 	4. DCL(Data Control Language)
 * 		commit	: 트랜잭션(작업단위)의 결과를 실제로 반영
 * 		rollback: 트랜잭션의 작업결과를 취소하고 원래대로 복구
 * 		grant	: 권한 부여
 * 
 */

create table member(
	id varchar2(100) primary key,
	password varchar2(100) not null,
	name varchar2(100) not null,
	address varchar2(100)
)

insert into MEMBER(id,password,name,address)
values('java','1234','아이유','판교');

select id,password,name,address from member;

drop table member;

-- member table에 회원 정보를 삽입
-- ORA-00001: 무결성 제약 조건(SCOTT.SYS_C0040000)에 위배됩니다.
-- 위와 같은 에러가 난다
-- id는 primary key 제약조건이 설정되어 있고
-- 반드시 유일하게 존재해야 한다
-- id가 중복되므로 error가 나고 추가가 되지 않는다
insert into MEMBER(id,password,name,address)
values('java','1234','부반장','야탑');

insert into MEMBER(id,password,name,address)
values('gandi','1234','김호겸','야탑');

-- name 컬럼에 not null 제약조건이 있어서 반드시 name을 insert해야 한다
insert into MEMBER(id,password,address)
values('test','1234','야탑');
-- 가능 address는 별도의 제약조건이 없으므로 insert 안해도 된다
insert into MEMBER(id,password,name)
values('test','1234','황잡스');

select * from MEMBER;

select count(*) from MEMBER;

select name from MEMBER;

select id,address from MEMBER;

select name,address from MEMBER where id='gandi';

select name,address from MEMBER where id='java' and password='1234';

select name,address from MEMBER where address is null;
select name,address from MEMBER where address is not null;

update member set name='개미' where id='gandi'; 
select name from MEMBER where id='gandi';

update member set address='판교' where address is NULL;

select id,name from MEMBER where address='판교';

insert into MEMBER(id,password,name,address)
values('jdbc','abcd','설현','부천');

select * from MEMBER where id='jdbc';

update MEMBER set name='김호겸' where address='야탑';
update MEMBER set name='황윤상' where name='황잡스';

delete from member where name='설현';

commit --실제 db에 작업결과를 반영

-- 정렬
select * from member order by id asc;