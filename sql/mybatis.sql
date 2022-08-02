-- ============================== 
-- mybatis
-- ============================== 

create table student(
    no number,
    name varchar2(50) not null,
    tel char(11) not null,
    created_at date default sysdate,
    updated_at date,
    deleted_at date, -- 학생정보 제거시 deleted_at 컬럼을 sysdate으로 작성하면 삭제된걸로 취급(진짜 삭제는 아니고)
    constraint pk_student_no primary key(no)
);

create sequence seq_student_no;

select * from student;
select * from student where deleted_at is null;
select count(*) from student where deleted_at is null;
select * from student where deleted_at is null and no=1;

-- 삽입
insert into
    student(no,name,tel)
values(
    seq_student_no.nextval, '신사임당','01012341234');
    
insert into
    student(no,name,tel)
values(
    seq_student_no.nextval, '홍길동','01022223333');
    
insert into
    student(no,name,tel)
values(
    seq_student_no.nextval, '세종대왕','01033334444');

-- 수정
update 
    student 
set 
    tel='01088889999',
    updated_at=sysdate
where
    no=2;
-- 제거시
update
    student
set
    deleted_at = sysdate
where
    no=3;
-- 커밋
commit;


