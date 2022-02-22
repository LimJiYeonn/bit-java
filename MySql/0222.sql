-- ex33) and, or 사용

CREATE TABLE table08 (
  id INT NOT NULL AUTO_INCREMENT,
  name varchar(10),
  dept varchar(10),
  salary int,
  PRIMARY KEY (id)
  );

insert into table08 values(null,'호랑이1', '경영', 100);
insert into table08 values(null,'호랑이2', '개발', 150);
insert into table08 values(null,'호랑이3', '영업', 300);
insert into table08 values(null,'호랑이4', '개발', 700);
insert into table08 values(null,'호랑이5', '영업', 500);
insert into table08 values(null,'호랑이6', '경영', 350);

-- *보다는 컬럼명을 명시하는게 더 좋다(추천됨) - 성능상 좋은 것은 아니지만 이후 코딩작업에 도움된다.
select id, name, dept, salary 
from table06;

select id, name, dept, salary 
from table06
where dept = '영업' and salary > 350;

select id, name, dept, salary 
from table06
where dept = '영업' or salary < 160;

-- A <= salary <= B
select id, name, dept, salary 
from table06
where salary >= 160 and salary <= 350;


-- salary < A of salary > B
select id, name, dept, salary 
from table06
where salary < 400 or salary > 600;


-- ex34) like : 특정 글자 검색하여 출력, 중복 자동 제거됨
CREATE TABLE table09 (
  id INT NOT NULL AUTO_INCREMENT,
  name varchar(10),
  salary int,
  PRIMARY KEY (id)
  );

insert into table09 values(null,'스타벅스', 100);
insert into table09 values(null,'올스타노래방', 150);
insert into table09 values(null,'강남만두', 300);
insert into table09 values(null,'스타일미용실', 700);
insert into table09 values(null,'닭다리스타', 500);
insert into table09 values(null,'짬뽕천국', 350);
select * from table09;

-- 처음만 star 뒤에는 어떤 것이든지 상관없다.
select * from table09
where name like '스타%';

-- % 공백도 포함 아무 글자나 ok
select * from table09
where name like '%스타%';

-- 김씨가 몇명인지 셀 때 자주 사용 ,count()  김%
select count(*) from table09
where name like '스타%';

-- 2학년 중에서 김씨는 몇 명 있는가? 
select count(*) from table09
where name like '김%' and 학년 = 2;



CREATE TABLE table10 (
  id INT NOT NULL AUTO_INCREMENT,
  name varchar(10),
  salary int,
  PRIMARY KEY (id)
  );

insert into table10 values(null,'김유신', 1);
insert into table10 values(null,'유관순', 1);
insert into table10 values(null,'이순신두', 2);
insert into table10 values(null,'김국', 1);
insert into table10 values(null,'감국찬', 1);
insert into table10 values(null,'김연', 1);
select * from table10;

table drop from table10;

select count(*) from table10
where name like '김%' and salary = 1;

-- ex37) 성과 이름이 2글자이 사원 검색
select count(*) from table10
where name like '__';

-- ex38) 성과 이름이 3글자가 아닌 사람을 검색
select count(*) from table10
where name not like '___';


-- ex39) between
 -- = 도 포함됨, a와 b 순서 변경X 
CREATE TABLE table11 (
  id INT NOT NULL AUTO_INCREMENT,
  name varchar(10),
  dept varchar(10),
  salary int,
  PRIMARY KEY (id)
  );

insert into table11 values(null,'호랑이1', '경영', 100);
insert into table11 values(null,'호랑이2', '개발', 150);
insert into table11 values(null,'호랑이3', '영업', 300);
insert into table11 values(null,'호랑이4', '개발', 700);
insert into table11 values(null,'호랑이5', '영업', 500);
insert into table11 values(null,'호랑이6', '경영', 350);


select * from table11 where salary between 200 and 600; 
-- and와 or 보다 성능 좋은건 아니지만 가독성 높아서 많이 사용 
-- where 학점 between 4.0 and 4.5


-- ex40) in 
select * from table11
where dept = '경영' or dept = '개발';

select * 
from table11
where dept in ('개발', '경영');


-- ex41) any all
/*
select * 
from table11
-- ex1)
where salary > any(300,200,250);
-- 번역 결과 : where salary > 200;
-- any 안에서 제일 작은 200 찾아 비교

-- ex2)
where salary > all(300,200,250);
-- 번역 결과 : where salary > 300;
-- all 안에서 제일 큰 300 찾아 비교

-- ex3)
where salary < any(300,200,250);
-- 번역 결과 : where salary < 300;
-- any 안에서 제일 작은 200 찾아 비교

-- ex4)
where salary < all(300,200,250);
-- 번역 결과 : where salary < 200;
-- all 안에서 제일 큰 300 찾아 비교
*/

-- 문제) 20번 부서의 최고 월급보다 작은 연봉을 받는 직원을 검색하세요
CREATE TABLE table12 (
  id INT NOT NULL AUTO_INCREMENT,
  eno int,       -- 부서번호
  name varchar(10), -- 이름
  salary int,  -- 급여
  PRIMARY KEY (id)
  );

insert into table12 values(null,10, 'tige1',100);
insert into table12 values(null,20, 'tiger2',200);
insert into table12 values(null,30, 'tiger3',300);
insert into table12 values(null,40, 'tiger4',400);
insert into table12 values(null,10, 'tiger5',500);
insert into table12 values(null,20, 'tiger6',600);
insert into table12 values(null,30, 'tiger7',700);
insert into table12 values(null,10, 'tiger8',800);
insert into table12 values(null,20, 'tiger9',350);
insert into table12 values(null,30, 'tiger10',999);

select * 
from table12;

-- 20번 부서의 급여를 모두 검색
select salary 
from table12
where eno = 20;

-- 20번 부서의 최고 급여는 얼마인가
select max(salary) 
from table12
where eno = 20;


-- 20번 부서의 최고 급여를 받는 직원의 이름은 무엇입니까? 
select name 
from table12
where salary = 600;

-- 변형1 , 서브쿼리이용
select name 
from table12
where salary = (
	select max(salary) 
	from table12
	where eno = 20
    );


-- 변형2 600보다 적게 받는 사람
select name 
from table12
where salary < (
	select max(salary) 
	from table12
	where eno = 20
    );

-- 변형3 (변형2와 동격)
select name, eno -- 20번 부서도 같이 나옴 
from table12
-- where salary < any(300,200,250);
-- 번역 결과 : where salary < 300;
where salary < any(
	select salary 
	from table12
	where eno = 20
    );


-- (변형3에서) 20번 부서를 제외 하고 보고싶다. 
select name, eno 
from table12
where salary < any(
	select salary 
	from table12
	where eno = 20
    )and eno != 20;


-- 유사 예제
-- 문제 컴공과에서 제일 낮은 점수를 받은 학생보다 성적이 낮은 학생들은 누구인가?
/*
컴공 40
컴공 20
컴공 50   -> 컴공에서 제일 낮은 점수의 학생
중국 80
중국 70
중국 10  -> 결과
일어 40
일어 05   -> 결과
*/


-- ex42) 통계함수
select min(salary) from table12;
select max(salary) from table12;
select avg(salary) from table12;
select sum(salary) from table12;

-- 실제 이름을 얻을 때
select name from table12
where salary = (
	select max(salary) from table12
);


-- ex43) join : 2개 이상의 테이블을 합병시키는 것
-- 1. ??? 조인이 약 8개
-- 2. 2가지 방법으로 나뉘어 있다.
      -- oracle(비표준이라 다른 곳에서도 사용할 수도 있고 안 될 수도 있다.) join 문법,
      -- ANSI(표준) join 문법
-- 필요에 따라 테이블을 분리한 것들을 다시 합치기 위해 join

-- ex44) 교차 조인(cross join) : 테카르트 곱, 카테시안 곱
-- A table의 로우가 3개, B table의 로우가 4개 
-- 조합의 개수는 총 3 * 4 = 12개
-- 실전에서 안쓰여도 개념은 정확히 짚고 넘어가기, 조인 중 기본개념

drop table tablea;
CREATE TABLE tablea (
  id INT NOT NULL AUTO_INCREMENT,
  name varchar(10), -- 이름
  eno int,       -- 직업번호
  salary int,  -- 급여
  PRIMARY KEY (id)
  );

insert into tablea values(null,'홍길동', 20, 1000);
insert into tablea values(null,'이순신', 10, 2000);
insert into tablea values(null,'안중근', 30, 3000);
insert into tablea values(null,'임꺽정', 20, 4000);

select * from tablea;



drop table tableb;
CREATE TABLE tableb (
  id INT NOT NULL AUTO_INCREMENT,
  eno int,       -- 직업번호
  job varchar(10),  -- 직업
  PRIMARY KEY (id)
  );

insert into tableb values(null, 10, '장군');
insert into tableb values(null, 20, '의적');
insert into tableb values(null, 30, '의사');
select * from tableb;

-- 교차 조인 (일반적인 조인방식)
select * from tableA, tableB; -- 3개도 가능
-- 결과가 무조건 순차적으로 나오는 건 아니다. 모든 경우의 수가 나옴
-- 내부의 옵티마이저에 의해 순서가 결정됨
-- 병합 전에 테이블간의 "조건 찾고 확인한다. " 만족(true)이 되면 join
select count(*) from tableA, tableB; 


-- 교차 조인 (명시(ANSI)적인 조인방식)
-- 가독성이 좋으며 합리적임
-- 생략X 처음부터 ansi 표준이다.
select * from tablea
cross join tableb;

select count( *) from tablea
	cross join tableb;


-- ex45) 내부 조인(외부 조인이 아닌 것)
-- 내부 조인은 종류가 엄청 많다. 외부조인은 outer join 하나밖에 없다. 

-- 전제 : 조건과 무조건 같이 쓴다. 
-- 결과적으로 cross join이 일어남 
-- 조건을 빠트릴 경우 cross join과 같은 것처럼 보인다. 

-- 밑의 문장은 처음부터 사용을 잘못하는 것이다. 
select * from tablea
	inner join tableb;

-- 정상적인 내부 조인 쿼리
select * from tablea
	inner join tableb
    on tablea.eno = tableb.eno;

-- 하나씩 꺼내 조건(on) 만족하면 병합
-- on : join을 할 조인 조건 


-- 등가조인 (=) : 같다고 물으니 등가조인
-- 내부조인이면서 등가조인
select * from tablea
	inner join tableb
    on tablea.eno = tableb.eno  -- 조인 조건
    where salary >= 3000;   -- 필터(검색) 조건 : 조인의 최종 결과에 대해서 where로 필터 한번 더
-- 권장사항


-- ex46) 일반 조인
select * from tablea, tableb
where tablea.eno = tableb.eno; -- 조인 조건
-- 실제로 이걸 많이 씀

select * from tablea, tableb
where tablea.eno = tableb.eno -- 조인 조건  
and salary >= 3000;  -- 필터조건도 할 경우


-- ex47) 테이블 이름에 별칭(별명)을 사용할 수 있다. 
-- 일반적으로 테이블명 첫번째를 딴다. 앞이 같을 경우 뒤에 숫자 붙이기
-- 정확하게는 별칭이라기 보다는 리네임이다. 이름이 바뀌었기 때문에 원래의 테이블명 말고 리네임한 글자를 작성해야 오류 안 남
select * from tablea t1, tableb t2
where t1.eno = t2.eno -- 조인 조건  
and salary >= 3000;  -- 필터조건도 할 경우
-- salary 칼럼은 t1 테이블에만 있어서 생략 가능
-- 원래 정식적인 코드 : and t1.salary >= 3000; 


-- 중복되는 칼럼은 테이블명 무조건 명시하기
-- id는 컬럼명이 중복되므로 별칭 명시필수
select t1.eno, name, t1.id from tablea t1, tableb t2
where t1.eno = t2.eno 
and salary >= 3000; 


-- ex48) 결과는 나오지만 잘못사용하고 있다.
-- cross join은 조건 입력안하는게 정상적인 방법이다.
select * from tablea
cross join tableb
on tablea.eno = tableb.eno;


-- ex49)
-- 조인 조건(on)이 없으니까 교차조인이 일어난다. 
-- 조인결과를 필터 조인하므로 아주 좋지 않은 쿼리문이다. 
select * from tablea
inner join tableb -- (조인 조건 on 이 없어)교차조인이 일어남
where tablea.eno = tableb.eno; -- 필터조건
-- 교차조인을 다 하고나서 필터링을 하니까 너무나도 잘못된 조인이다. 



-- ex50) 이순신의 직업은 무엇입니까?

-- 1. 등가 join 사용
select name, job from tablea t1, tableb t2
where t1.eno = t2.eno
and name = '이순신';
-- 자주 사용됨


-- 2. 서브쿼리
-- 데이터마다 쿼리를 돌려야한다. 
-- name 뽑을 수 있는 방법없나? 해봐라지여나
select job from tableb
where eno = (
	select eno 
	from tablea 
	where name='이순신' -- 힌트
    );

-- 내부 옵티마이저에 의해 실행속도가 결정됨 - 우리의 생각대로 로직하지 않음
-- 100만개의 data - 속도 차이 확 남

-- 교차조인, 내부조인, 등가조인   (일반조인, 안시조인)


