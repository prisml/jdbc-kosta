drop table account;
drop sequence acc_seq;
create sequence acc_seq;
create table account(
	account_no number primary key,
	name varchar2(100) not null,
	password varchar2(100) not null,
	balance number default 1000
);