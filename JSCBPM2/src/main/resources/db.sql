create table jscbpm2_member(
	jm_id varchar2(20 char) primary key,
	jm_pw varchar2(20 char) not null,
	jm_name varchar2(5 char) not null,
	jm_address varchar2(200 char) not null,
	jm_photo varchar2(100 char) not null
);

drop table jscbpm2_member;

select * from jscbpm2_member;
-------------------------------------------------
create table text_memo2(
	tm_no number(10) primary key,
	tm_id varchar2(50 char) not null,
	tm_name varchar2(10 char) not null,
	tm_title varchar2(100 char) not null,
	tm_content varchar2(500 char) not null,
	tm_date date not null
);

create sequence text_memo2_seq;

select * from text_memo2;

drop table text_memo2;

drop sequence text_memo2_seq;

select count(*) as totalCount from text_memo2
-----------------------------------------------
create table memo_reply(
	mr_no number(10) primary key,
	mr_tm_no number(15) not null,
	mr_owner varchar2(20 char) not null,
	mr_txt varchar2(150 char) not null,
	mr_date date,
	constraint memo_reply_if
		foreign key(mr_tm_no) references text_memo2(tm_no) on delete cascade
);

create sequence memo_reply_seq;

select * from memo_reply;
drop table memo_reply;
drop sequence memo_reply_seq;
delete from memo_reply;

select * from memo_reply, text_memo2 where mr_tm_no=tm_no;

-- constraint 조건 이름
--		foreign key(필드명) : 이 필드는 다른 테이블의 데이터를 참조
--		references 테이블명(필드명) : 이 테이블의 필드를 참조
--		on delete cascade : 삭제하면 참조되어있는 것 까지 모두 삭제

-- 테이블 만들고 난 뒤에 제약조건 추가하려면
alter table memo_reply
add constraint memo_reply_if
	foreign key(mr_tm_no) references text_memo2(tm_no) on delete cascade;
-- 제약 조건만 지우려면
alter table memo_reply drop constraint memo_reply_if; 