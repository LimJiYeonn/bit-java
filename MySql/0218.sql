-- ex1) 주석 : (-- ) /**/
-- ex2) 실행단축키 (Ctrl + enter,Ctrl + shirt + enter )
-- ex3) 데이터베이스 생성
CREATE database db01;
-- ex4) 데이터베이스 목록 확인
show databases;

-- ex5) 데이터베이스 삭제  
drop database db01;

-- mysql에서 DB = 스키마
-- 스키마 : data에 대한 규칙 (4글자 이상 못들어옴, default 값 등)

-- ex6) 테이블 생성 
-- 지금부터 사용하는 명령어는 db01안에서
--  = navigator에서 DB를 두꺼워질때까지 클릭
use db01; 

-- ''안 써도 됨
-- char(16개 만들어두고 시작), varchar(max가 16개, 2개만 들어오면 2개의 메모리만 차지)
CREATE TABLE table01 (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(16), 
  age INT,
  salary INT,
  PRIMARY KEY (id)
  );
  
-- ex7) (해당 DB 안의)테이블 목록 보기
show tables;

-- ex8) 컬럼 목록 보기
desc table01;

-- ex9) 테이블 삭제
drop table table01;

-- ex10) DB 사용 근본 목적 : CRUD
-- Create(로우 생성)
-- insert into 테이블명 values (값, );
insert into table01 values (null, '이순신',24, 300);
insert into table01 values (null, '홍길동',20, 300);
insert into table01 values (null, '호랑이',24, 500);
insert into table01 values (null, '홍길동',23, 400);
insert into table01 values (null, '코끼리',null, null);

-- AUTO_INCREMENT니까 null 입력
-- 문자열 표시 : ''

-- ex11) CR(read)UD : 조회, 검색
select * from table01;

-- ex12) Update 
-- 옵션 체크 필요 : Edit - Preferences - sql editor - 맨 밑 uncheck
-- 같다는 표시 =
-- update table01 set age = 99
-- 조건X -> 모든 로우가 해당 컬럼으로 변경됨
update table01 set age = 99
where name = '홍길동';

update table01 set name = '소나무' where id = 4;
update table01 set name = '대나무', age = 888 where id = 4;

-- ex13) delete
delete from table01 
where name='홍길동';

-- ex14)
insert into table01 values(null, '호랑이', 10, 633);
select * from table01; 
update table01 set age = 20 where name = '호랑이';
delete from table01 where name = '호랑이';


insert into table01 values(null, '호랑이', 20, 300);
select * from table01;
update table01 set age=30 where name='호랑이';
delete from table01 where name='호랑이';
insert into table01 values(null, '호랭', 20, 300);
select * from table01;
update table01 set salary=200 where name='호랭'; 

-- ex15)
-- 모두 채울 때 (묵시적 방법)
insert into table01 values(null, '유니콘', 20, 300);

-- 선택적으로 채울 때 (명시적 방법)
insert into table01(id, name, age, salary) values(null, '유니콘', 20, 300);
insert into table01(id, age) values(null, 20);
insert into table01(age, id) values(20, null);
select * from table01;

-- ex16) WorkBench에서 n개의 로우를 삭제할 때   
-- select 후 해당 로우 우클릭하고 apply 버튼 선택하여 n개 삭제 가능
-- 반드시 apply 적용

-- ex17) 로우의 개수를 출력
select count(*) from table01;  

-- ex18) sakila db에서 (선택된 상태) 검색 및 개수 출력
select * from actor;
select count(*) from actor;
select * from city;
select count(*) from city;
-- 검색 로우의 개수가 다른 것을 검색으로 같이 사용할 수 없다.
-- 결과1개와 n개를 동시 출력X
select count(*), city_id from city;

-- ex19) 출력개수 제한
select * from city limit 0, 6; -- index 0번 부터 6개만 출력
-- index 0번 부터 3개 출력
select * from city limit 0, 3;  
select * from city limit 3; 
-- index 2번부터 3개
select * from city limit 2, 3;  


-- ex20) 선택적으로 컬럼 선택 검색
select id from table01;  
select id, name from table01;  
select id, name, name, salary from table01;  


-- ex20) 선택컬럼에 산술식을 사용할 수 있다. 
select name, salary from table01;
select name, salary, salary*0.1 as '10퍼' from table01;
select 
	name, salary, salary*0.1, salary+salary*0.1, salary*1.1
from table01;


-- ex21) 컬럼명에 별칭 사용
select name as 이름, salary as 급여 from table01;
select 
	name, salary, salary*0.1 as 보너스, salary+salary*0.1 as 실수령액
from table01;

-- as는 생략 가능 (대부분 생략)
select name 이름, salary 급여 from table01;

-- 별칭 사이에 공백이 들어가는 경우 빽쿼터''를 이용 
select name '이 름', salary '급   여' from table01;

-- 단순 쿼리 정리
select name '이 름', salary * 12 '연   봉' from table01;

-- ex22) 컬럼연결이 필요한 경우 (컬럼 + 컬럼 >> 컬럼컬럼 ) 
select concat(name, salary) 이름급여 from table01;
select concat(name, " 님의 급여는 : ",salary, '만원입니다. ') 이름급여 from table01;
-- 다른 언어에서는 concat 3개이상 제공안할수있으니 문서 참조 
select concat(name,concat( " 님의 급여는 : ", concat(salary, '만원입니다. '))) 이름급여 from table01;

-- ex23) 단순 산술식이나 날짜를 얻고 싶을 때 
-- dual = row가 하나밖에 없는 가상 테이블
select 3 * 5 from dual;
select sysdate(), 3 * 7 from dual;

-- 몫값은 실제 연산 결과값이다. 
select 9+2,9-2, 9*2, 9/2, 9%2 from dual;

-- ex24) null 검색
select * from table01;
-- 절대 안됨
select * from table01 where salary = null;
-- 이렇게 사용
select * from table01 where salary is null;
select * from table01 where salary is not null;
select name '급여를 받는 사람' from table01 where salary is not null;

-- ex25) 직원들의 연봉을 모두 검색하여 출력
CREATE TABLE table02 (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(16), 
  salary INT,
  bonus INT,
  PRIMARY KEY (id)
  );
  
  select * from table02;
  insert into table02 values(null, '호랑이1',100, 10);
  insert into table02 values(null, '호랑이2',200, null);
  insert into table02 values(null, '호랑이3',300, 40);
  insert into table02 values(null, '호랑이4',400, 30);
  insert into table02 values(null, '호랑이5',500, null);

-- 원하는 결과가 나오지 않는 쿼리
-- null 들어가면 연산이 무효화됨 -> null
select salary * 12 + bonus from table02;
select salary * 12 + ifnull(bonus, 0) from table02;

-- ex26) table02의 bonus가 null인 컬럼을 0으로 수정(갱신)하세요
update table02 set bonus=0 where bonus is null;
select * from table02;

-- ex27) 4.5 만점의 학점을 100점 기준으로 환산 결과로 출력
CREATE TABLE table03 (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(16), 
  result float,
  PRIMARY KEY (id)
  );
  
  select * from table03;
  insert into table03 values(null, '호랑이1', 4.5);
  insert into table03 values(null, '호랑이2', 3.8 );
  insert into table03 values(null, '호랑이3', 2.7 );
  insert into table03 values(null, '호랑이4', 4.2 );
  insert into table03 values(null, '호랑이5', 3.6 );
 
select result 학점, result * 100 / 4.5 '100점대 환산' from table03;

-- ex28) 중복 제거된 결과

	-- 하위(서브) 쿼리 사용안하고 비관계형 테이블 하나로 사용
	-- 하드디스크 용량 상관안함, 부족하면 더 꽂으면 됨
	-- 최신 디스크보다 과거의 디스크를 하나 새로 사서 꽃음
	-- 하드 여러개 -> 병렬 처리(n개의 데이터를 하드의 개수대로 분리시켜 저장)
CREATE TABLE table04 (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(16),
  contury VARCHAR(16),
  PRIMARY KEY (id)
  );
  
  select * from table04;
  insert into table04 values(null, '호랑이1', '한국');
  insert into table04 values(null, '호랑이2', '중국');
  insert into table04 values(null, '호랑이1', '중국');
  insert into table04 values(null, '호랑이2', '한국');
  insert into table04 values(null, '호랑이3', '일본');
  insert into table04 values(null, '호랑이4', null);
-- null을 하나의 항목으로 보지 않아 집계(통계)에 포함되지 않음
  insert into table04 values(null, '호랑이2', '한국');

  select distinct name from table04;
  -- 중복제거된 목록
  select distinct contury from table04;
  -- 중복제거된 목록의 개수
  select count(distinct contury) from table04;


-- ex29) 정렬
CREATE TABLE table05 (
  id INT NOT NULL AUTO_INCREMENT, -- 컬럼1
  contury VARCHAR(16), -- 컬럼2
  gold_num int , -- 컬럼3
  silver_num int , -- 컬럼4
  PRIMARY KEY (id)
  );
  insert into table05 values(null, '중국', 2, 9);
  insert into table05 values(null, '일본', 4, 8);
  insert into table05 values(null, '한국', 10, 10);
  insert into table05 values(null, '미국', 7, 3);
  insert into table05 values(null, '독일', 7, 7);
  
--  select * from table05 order by 컬럼  ; 
-- asc는 생략 가능 : 오름차순, 순차정렬
-- 테이블이 수정되는 것은 아님, 출력 결과만 정렬해서 보여줌
select * from table05 order by gold_num asc;
select * from table05 order by gold_num desc;  
select * from table05 order by 3 desc;
-- 정렬 기준 1개 = 1차 정렬

-- 2차 정렬 : 1차 정렬에서 동일하게 나온 것들만 재정렬
select * from table05 order by gold_num desc, silver_num desc;  

-- ex30) 정렬
CREATE TABLE table06 (
  id INT NOT NULL AUTO_INCREMENT,
  name varchar(10),
  dept varchar(10),
  salary int,
  PRIMARY KEY (id)
  );
insert into table06 values(null,'호랑이1', '경영', 100);
insert into table06 values(null,'호랑이2', '개발', 150);
insert into table06 values(null,'호랑이3', '영업', 300);
insert into table06 values(null,'호랑이4', '개발', 700);
insert into table06 values(null,'호랑이5', '영업', 500);
insert into table06 values(null,'호랑이6', '경영', 350);
insert into table06 values(null,'호랑이7', '개발', 250);
insert into table06 values(null,'호랑이8', '영업', 450);
insert into table06 values(null,'호랑이9', '개발', 550);

select * from table06;
-- 부서별로 순차정렬을 하고 급여를 역순정렬하여 나타내시오
select * from table06 order by dept, salary desc;

-- ~~별로(나라별로, 부서별로, 성별로, 학과별로) 
-- 1. order by (단순검색, 정렬)			2. group by (대부분, 통계자료 뽑고 싶을 때)


-- ex31) 성적 합에 대한 역순정렬(키포인터는 별칭 사용)
CREATE TABLE table07 (
  id INT NOT NULL AUTO_INCREMENT,
  name varchar(10),
  kor int,
  eng int,
  mat int,
  PRIMARY KEY (id)
  );
insert into table07 values(null,'호랑이1', 66, 78, 80);
insert into table07 values(null,'호랑이2', 80, 79, 92);
insert into table07 values(null,'호랑이3', 98, 94, 100);
insert into table07 values(null,'호랑이4', 77, 67, 82);
insert into table07 values(null,'호랑이5', 75, 86, 90);
select * from table07;
select name, kor+eng+mat as total from table07 order by total desc;


-- ex32) 대소비교 ( =, !=, >, >=, < , <= )
select * from table07 where kor >= 80;
select * , (kor+eng+mat)/3 from table07 where (kor+eng+mat)/3 >= 80;

-- 안 됨 select에서 정의된 별칭은 where에서 사용 불가
-- 테이블 이름을 별칭으로 만들 수 있는데, 이때 만든 별칭은 where에서 사용할 수 있다.
select * , (kor+eng+mat)/3 result from table07 where result >= 80;









