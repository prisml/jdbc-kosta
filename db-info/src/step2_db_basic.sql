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
/*
 * 데이블 만들기
 * table 명 : typetest, column : name 과 money
 * datatype : varchar2(9) 문자열 데이터 타입 9는 영문자 기준 한글은 3자까지
 * 				number 숫자 데이터 타입
 * 제약조건(constraints) : primary key(pk, 주키) -> unique + not null
 */
create table typetest(
	name varchar2(9) primary key,
	money number not null
)

insert into typetest(name, money) values('javaking',100);

select money from typetest where name='javaking';
-- insert test, 테이블 생성시 최대 9자(영문)로 제한했으므로 error
insert into typetest(name, money) values('barackobama',200);
-- insert ok
insert into typetest(name, money) values('강정호',200);
-- insert fail 최대9는 한글 3자까지 허용
insert into typetest(name, money) values('최강정호',200);
-- 조회시 연산
select money*2, name from typetest

drop talbe typetest;

create table test1(
	id varchar2(100) primary key,
	hit number default 0
)
-- default 0 은 제약조건으로 별도의 정보를 insert하지 않으면
-- 기본 값 0이 추가된다
-- id가 java인 정보를 insert
insert into test1(id) values('java')
select * from test1
alter table test1 rename to test2;
select * from test2
-- alter를 이용해 컬럼명을 변경
/*
 * alter talbe 테이블명
 * rename column 병경해야할 컬럼명 to 새로운 컬럼명;
 * hit를 count로 변경
 */ 
*/
alter table test2 rename column hit to count;
select * from test2
/*
 * 테이블명 : product
 * 컬럼명 : id, name, maker, price
 * 데이터 타입 : id, name, maker는 모두 varchar2(100)
 * 				price는 number
 * 제약조건 : id는 primary key, 나머지는 not null
 * 
 * 테이블 생성후 조회 결과
 * id	name	maker	price
 * a	갤럭시7	삼성		150
 * b	갤럭시6	삼성		100
 * c	아이폰6	애플		120
 */

create table product(
	id varchar2(100) primary key,
	name varchar2(100) not null,
	maker varchar2(100) not null,
	price number not null
)

insert into product(id,name,maker,price) values ('a','갤럭시7','삼성',150);
insert into product(id,name,maker,price) values ('b','갤럭시6','삼성',100);
insert into product(id,name,maker,price) values ('c','아이폰6','애플',120);

select * from product;

select count(*) from pruduct;

select max(price) from product;
select min(price) from product;
select avg(price) from product;
select round(avg(price)) from product;
select ceil(avg(price)) from product;
select floor(avg(price)) from product;
select * from product order by price desc;
select * from product where price<=130
select id,name,price from product where maker='삼성' order by price asc
select * from product where price>=100 and price<=120