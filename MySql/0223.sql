-- table a와 b drop 시킴
-- ex51) 모대학에서 2학점인 과목을 검색하고, 이 과목을 강의하는 교수를 검색하세요

-- 교수 테이블
drop table tablea;
CREATE TABLE tablea (
  id INT NOT NULL AUTO_INCREMENT,
  pno int, 				-- 교수번호
  name varchar(10),      -- 교수이름
  PRIMARY KEY (id)
  );

insert into tablea values (null, 100, '홍길동');
insert into tablea values (null, 101, '이순신');
insert into tablea values (null, 102, '안중근');
insert into tablea values (null, 103, '임꺽정');
insert into tablea values (null, 104, '강감찬');

-- 과목 테이블
drop table tableB;
CREATE TABLE tableB (
  id INT NOT NULL AUTO_INCREMENT,
  name varchar(10),			-- 과목명
  num int,      			-- 학점
  pno int,					-- 담당 교수 번호
  PRIMARY KEY (id)
  );
insert into tableb values (null, '국어', 4, 103);
insert into tableb values (null, '영어', 3, 104);
insert into tableb values (null, '수학', 2, 102);
insert into tableb values (null, '사회', 1, 101);
insert into tableb values (null, '체육', 2, 103);
insert into tableb values (null, '생물', 2, 102);

-- 표준 조인
select t1.name from tablea t1
inner join tableb t2
on t1.pno = t2.pno
where t2.num = 2;


-- ex52)
-- 화학과 1학년의 점수
-- 1. 최종 검색 결과는 무엇인가? 		점수
-- 2. 필터링 조건이 무엇인가? 		학과, 학년
-- 3. 조인될 테이블과 칼럼은 무엇인가? 	학번

-- 학생 테이블
drop table tablea;
CREATE TABLE tablea (
  id_a INT NOT NULL AUTO_INCREMENT,
  eno int, 				-- 학번
  name varchar(10),      -- 학생이름
  major varchar(10),
  year int,
  PRIMARY KEY (id_a)
  );

insert into tablea values (null, 1000, '홍길동', '국어', 1);
insert into tablea values (null, 1001, '이순신', '화학', 1);
insert into tablea values (null, 1002, '안중근', '화학', 2);
insert into tablea values (null, 1003, '임꺽정', '국어', 2);
insert into tablea values (null, 1004, '강감찬', '화학', 1);

-- 시험점수 테이블
drop table tableB;
CREATE TABLE tableB (
  id_b INT NOT NULL AUTO_INCREMENT,  -- id_테이블명
  eno int, 				-- 학번
  cno int, 				-- 시험과목번호
  result int,      			-- 점수
  PRIMARY KEY (id_b)
  );
insert into tableb values (null, 1000, 10, 59);
insert into tableb values (null, 1000, 20, 34);
insert into tableb values (null, 1001, 10, 80);
insert into tableb values (null, 1001, 20, 79);
insert into tableb values (null, 1001, 30, 33);
insert into tableb values (null, 1002, 20, 48);
insert into tableb values (null, 1003, 30, 55);
insert into tableb values (null, 1004, 10, 99);


select result 
from tablea t1 inner join tableb t2
on t1.eno = t2.eno
where major = '화학' and year = 1;


-- ex53) 자연 조인
-- : 양쪽 테이블에서 컬럼명이 동일한 것이 1개가 있다는 전제하에 사용할 수 있다.

-- 양쪽 테이블 모두 id라는 칼럼을 가지고 있을 경우 id로도 natural join이 된다. 
select * from tablea
natural join tableb;

select * from tablea
natural join tableb
where year = 1;


-- ex54) Using 조인 : 컬럼명이 어떨 수 없이 2개 이상 중복된 경우의 조인
-- 자연조인의 일종
-- 컬럼을 꼭 찍어서 조인 시킬 수 있다.  
select * 
from tablea join tableb
using(eno); 

select * 
from tablea join tableb
using(eno)
where year = 1; 


-- ex55) 비등가조인 : = 을 제외한 비교연산

drop table tablea;
CREATE TABLE tablea (
  id_a INT NOT NULL AUTO_INCREMENT,
  name varchar(10),     -- 이름
  eno int, 				-- 부서 번호, 직급 번호
  salary int,			
  PRIMARY KEY (id_a)
  );

insert into tablea values (null, '홍길동', 20, 50 );
insert into tablea values (null, '이순신', 10, 150 );
insert into tablea values (null, '안중근', 30, 250 );
insert into tablea values (null, '임꺽정', 20, 350 );
insert into tablea values (null, '김서방', 20, 170 );
insert into tablea values (null, '강감찬', 20, 370 );



drop table tableB;
CREATE TABLE tableB (
  id_b INT NOT NULL AUTO_INCREMENT,  -- id_테이블명
  grade varchar(10),  			-- 등급
  losalary int, 				-- 최솟값 설정
  hisalary int, 				-- 최대값 설정
  PRIMARY KEY (id_b)
  );
insert into tableb values (null,'A', 300, 9999);
insert into tableb values (null,'B', 200, 299);
insert into tableb values (null,'C', 100, 199);
insert into tableb values (null,'D', 0, 99);


-- ex1) 
select name, grade from tablea t1
inner join tableb t2
on t1.salary >= t2.losalary 
and t1.salary <= t2.hisalary;

-- ex2)
select name, grade from tablea t1
inner join tableb t2
on salary between losalary 
and hisalary;

-- ex3) 일반조인으로 비등가조인
select name, grade from tablea t1, tableb t2
where salary between losalary and hisalary;
 
-- ex4)
select name, grade from tablea t1, tableb t2
where salary between losalary and hisalary
and grade = 'A';



-- ex55) 셀프조인 : 동일 테이블끼리 조인
-- 만약 로우가 5개면 최종 결과 5*5 = 25
-- 홍길동 사원번호(1000) 사수번호(1005)
-- 이순신 사원번호(1005)

drop table tablea;
CREATE TABLE tablea (
  id_a INT NOT NULL AUTO_INCREMENT,
  name varchar(10),     -- 이름
  eno int, 				-- 사원 번호, 직급 번호
  mgr int, 				-- 사수 번호, 멘토 번호
  salary int,			
  PRIMARY KEY (id_a)
  );
  
insert into tablea values (null, '홍길동', 1000, null, 100); -- 사수가 없다. 
insert into tablea values (null, '이순신', 1001, 1000, 100);
insert into tablea values (null, '안중근', 1002, 1001, 100); 
insert into tablea values (null, '임꺽정', 1003, 1002, 100); 
select * from tablea;

-- ex1) 셀프 조인 
-- 반드시 별칭이 있어야 한다. 
select * from tablea t1, tablea t2;

-- ex2) 셀프 조인 
select * from tablea t1, tablea t2
where t1.eno = t2.mgr;
 
-- ex3) 셀프 조인 문맥상 이게 더 정확하다. 
select * from tablea t1, tablea t2
where t1.mgr = t2.eno; 

-- ex56) 동명이인 검색
drop table tablea;
CREATE TABLE tablea (
  id_a INT NOT NULL AUTO_INCREMENT,
  name varchar(10),     -- 이름			
  PRIMARY KEY (id_a)
  );
insert into tablea values (null, '홍길동'); 
insert into tablea values (null, '이순신'); 
insert into tablea values (null, '안중근'); 
insert into tablea values (null, '임꺽정'); 
insert into tablea values (null, '김서방'); 
insert into tablea values (null, '임꺽정'); 
insert into tablea values (null, '이순신'); 
insert into tablea values (null, '안중근'); 
insert into tablea values (null, '임꺽정'); 
select * from tablea;

-- ex1)
-- 아이디가 다르면서 이름이 동명이인
select * from tablea t1, tablea t2
where t1.id_a != t2.id_a    -- id가 같은 것 끼리는 하지 않음
and t1.name = t2.name;  	-- 서로 이름이 같은 것만 찾아 join

-- ex2) 동명이인 사람의 이름만 중복제거하여 출력
select distinct(t1.name) from tablea t1, tablea t2
where t1.id_a != t2.id_a    
and t1.name = t2.name;  	

-- ex3) 동명이인 사람의 아이디만 중복제거하여 출력
select distinct(t1.id_a) from tablea t1, tablea t2
where t1.id_a != t2.id_a    
and t1.name = t2.name;  	


-- ex57) 세미조인(<-> 안티조인) : 메인 쿼리에서 로우를 하나씩 가져와서 
-- 서브쿼리에서 exists 로 존재 여부를 묻는 조인

/*
메인 쿼리      서브 쿼리
메뉴 테이블     판매 테이블
짜장           짜장
짬뽕           짜장
냉면           짬뽕
              짜장
              짬뽕
*/

drop table menu;
create table menu(
	foodnum int,
    name varchar(20)
);
insert into menu values(1, '짜장');
insert into menu values(2, '짬뽕');
insert into menu values(3, '우동');
insert into menu values(4, '냉면');
insert into menu values(5, '양장피');

drop table sell;
create table sell(
	no int,  	-- 판매 번호
    count int,	-- 판매 수량
	foodnum int	-- 판매된 음식 번호
);
insert into sell values(1, 2, 1);
insert into sell values(2, 3, 2);
insert into sell values(3, 4, 2);
insert into sell values(4, 2, 2);
insert into sell values(5, 2, 1);

-- ex1)
select s.foodnum from sell s;

-- ex2)
select * from menu m
-- where m.foodnum = 1 or m.foodnum = 2;
-- where m.foodnum in (1, 2); 						-- or과 같은 의미, 윗코드와 동일
-- where m.foodnum in (1, 2, 2, 2, 1); 				-- 윗코드와 동일
where m.foodnum in (select s.foodnum from sell s);	-- 윗코드와 동일

-- ex3) 세미조인
select * from menu m
where exists(
	select * from sell s
    where m.foodnum = s.foodnum
);
-- 주 쿼리에서 하나씩 가져와 exists로 비교

-- ex4) 안티조인 : exists 앞에 not을 붙임
select * from menu m
where not exists(
	select * from sell s
    where m.foodnum = s.foodnum
);


-- ex58) 외부조인(outer join)
drop table tablea;
create table tablea(
	id int,  	
    name varchar(20)	
);

drop table tableb;
create table tableb(
	id int,  	
    age int	
);

insert into tablea values(1, 'tiger01');
insert into tablea values(2, 'tiger02');
insert into tablea values(3, 'tiger03');
insert into tablea values(4, 'tiger04');
insert into tablea values(5, 'tiger05');

insert into tableb values(3, 30);
insert into tableb values(4, 40);
insert into tableb values(5, 50);
insert into tableb values(6, 60);
insert into tableb values(7, 70);

-- ex1) 원래의 조인
select * 
from tablea t1, tableb t2
where t1.id = t2.id;

-- ex2)
select * 
from tablea t1 
left join tableb t2
on t1.id = t2.id;

select * 
from tablea t1 
right join tableb t2
on t1.id = t2.id;

/*
-- ex3) 문제. 전체 교수 명단과 그 교수가 담당하는 과목의 이름을 검색하세요  -> left join
교수 테이블					과목 테이블
이름      	과목 번호 		과목 번호		교과목이름	
홍길동		1				1			수학
안중근		null			2			영어
홍길동		2   
이순신		2 
강감찬		null

join시 강감찬이 빠지는 문제가 발생한다.  

left join시 쿼리 결과는?
홍길동 수학
안중근 null
홍길동 영어
이순신 영어
강감찬 null
 */
 drop table tablea;
create table tablea(
    name varchar(20),
    subno int
);
insert into tablea values('홍길동', 1);
insert into tablea values('안중근', null);
insert into tablea values('홍길동', 2);
insert into tablea values('이순신', 2);
insert into tablea values('강감찬', null);


drop table tableb;
create table tableb(
	subno int,  	
    subname varchar(20)
);
insert into tableb values(1, '수학');
insert into tableb values(2, '영어');

select name, subname 
from tablea t1 
left join tableb t2
on t1.subno = t2.subno;

-- 자연 조인, Using 조인, 비등가 조인
-- 셀프 조인, 세미 조인 (안티 조인), 외부 조인
 
-- ex59) group by : ~ 별로(그룹별로, 부서별로, 학과별로, 팀별로)
-- 그룹조건 : having

-- ex) 그룹별 평균(avg) 급여 , 그룹별 사원 수(count), 그룹별 최대연봉(max)
create table tablea(
	eno int, -- 부서번호
    salary int
);
insert into tablea values(10, 800);
insert into tablea values(20, 200);
insert into tablea values(20, 400);
insert into tablea values(10, 500);
insert into tablea values(20, 300);
select * from tablea;

-- ex1) group by를 사용해서 select 할 때는 컬럼명이 들어오는게 일반적이다. ( * 말고 )
select eno, sum(salary) 
from tablea
group by eno;

-- ex2) 급여가 300 이상인 직원들을 그룹별로 나타내세요
select eno, sum(salary)
from tablea
where salary >= 300  -- select를 필터링한다. 
group by eno;

-- ex3)
select eno, sum(salary)
from tablea
group by eno
having sum(salary) >= 1000;  -- 그룹핑된 결과를 필터링

-- ex4)
select eno, sum(salary)
from tablea
where salary >= 300  -- select를 필터링한다. 
group by eno
having sum(salary) >= 1000;  -- 그룹핑된 결과를 필터링


-- 실행 작동 순서
-- ① FROM ② ON ③ JOIN ④ WHERE ⑤ GROUP BY ⑥ CUBE | ROLLUP ⑦ HAVING ⑧ SELECT ⑨ DISTINCT ⑩ ORDER BY ⑪ TOP

-- 유니크키 : 중복된 값이 들어오면 오류냄
-- Pk = 주민번호 부여X
-- 주민번호는 유니크 키 사용
-- Pk : 삭제하고 새로 들어오면 무조건 다른 번호가 들어와야한다.



-- ex60) B binary 체크 : 비교할 때 대소문자 구분하지 않고 검색
-- 없을 때
drop table tablea;
CREATE TABLE tablea (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) ,
  PRIMARY KEY (`id`));

insert into tablea values(null, 'tiger');
insert into tablea values(null, 'Tiger');
insert into tablea values(null, 'TIger');
insert into tablea values(null, 'TigerLion');

select * from tableA
where name = 'tiger';

select * from tableA;

-- 있을 때
drop table tablea;
CREATE TABLE tablea (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) BINARY NULL,
  PRIMARY KEY (`id`));

insert into tablea values(null, 'tiger');
insert into tablea values(null, 'Tiger');
insert into tablea values(null, 'TIger');
insert into tablea values(null, 'TigerLion');

select * from tableA
where name = 'tiger';



-- un 
-- int 형식에서만 지원
-- unsigned : 음수 사용 불가 (나이, 데시벨 등)

-- ZF
-- int 형식에서만 지원
-- 
drop table tableb;
CREATE TABLE tableb (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) BINARY NULL,
  age int(5),       -- 99999가 최대 받을 수 있는 수
  PRIMARY KEY (`id`));

-- 남는 최대 자릿수가 주어지고 남는 자릿수를 0으로 채워 출력

drop table tableb;
CREATE TABLE tableb (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) BINARY NULL,
  age int(5) ZEROFILL null,       -- 남는 자릿수 0으로 채우기
  PRIMARY KEY (`id`));

insert into tableb values(null, 'tiger', 23);
select * from tableb; -- 결과 : 00023

-- G
-- age, year(근속연수)
-- 서로 곱하고 싶다. 만들때부터 연산을 하여 필드에 넣고 싶다. 
-- 만들 때 부터 필드끼리 연산을 하도록하여 테이블이 생성될 때  바로 넣기 - default / expression에 넣기
/*
`width` INT NULL,
  `height` INT NULL,
  `new_tablecol1` VARCHAR(45) GENERATED ALWAYS AS (width * height) VIRTUAL,
  */
 -- 1. 
select * from payment;   
select customer_id, sum(amount)
	from payment
	group by customer_id;

-- 2.     
select CS.first_name, CS.last_name, sum(amount)
	from payment PM join customer CS 
	on PM.customer_id = CS.customer_id
    group by CS.first_name, CS.last_name;
    
-- 3.고객ID별 총 대여 수를 출력(대여 수 많은 고객부터)
select customer_id, count(rental_id)
	from rental
	group by customer_id
	order by count(rental_id) desc;
    
-- 4.위 쿼리에서 고객ID 대신 고객의 first_name, last_name을 출력하라
select cs.first_name, cs.last_name,count(rt.rental_id)
from rental rt,customer cs
where cs.customer_id = rt.customer_id
group by cs.fisrt_name, cs.last_name
order by count(rt.rental_id);

select CS.first_name, CS.last_name, count(rental_id)
	from rental RT join customer CS 
    on RT.customer_id = CS.customer_id
	group by CS.first_name, CS.last_name
	order by count(rental_id) desc;
-- 5.action 분야 영화의 다음 속성들을 출력하시오
	-- 필름번호, 제목, 설명, 분야, 발매년도, 언어
  select f.title
  from film f
  where film_id  in ( select film_id
				from category c join film_category fc
                on c.category_id = fc.category_id
                where c.name = 'action');
  
select FL.film_id as 필름번호, FL.title as 제목, FL.description as 설명, CG.name as 분야
	, FL.release_year as 발매년도, LG.name as 언어
	from film as FL join film_category as FC on FL.film_id = FC.film_id
	join category as CG on FC.category_id = CG.category_id
	join language as LG on FL.language_id = LG.language_id
	where CG.name = 'action';

-- 6  출연작이 많은 순으로 배우의 first_name, last_name, 작품수 를 출력하시오(susan 동명이인 있는거)group by actor_id 추가
   select a.actor_id, a.first_name, a.last_name , count(fa.actor_id)
   from actor a join film_actor fa
   on a.actor_id = fa.actor_id
   group by a.first_name, a.last_name,a.actor_id
   order by count(fa.actor_id) desc;
   
   select A.actor_id, A.first_name, A.last_name, count(film_id) as "작품수"
	from film_actor FA join actor as A
	on FA.actor_id = A.actor_id
	group by A.actor_id, A.first_name, A.last_name
	order by count(film_id) desc;
  
  -- 7. MARY KEITEL의 출연작을 영화제목 오름차순으로 출력하시오. 출력 컬럼은 다음과 같다.
	-- first_name, last_name, 영화제목, 출시일, 대여 비용

select a.first_name , a.last_name , f.title , f.release_year, f.rental_rate
from actor a join film_actor fa on a.actor_id = fa.actor_id
join film f on f.film_id = fa.film_id
where a.first_name = 'MARY' and a.last_name ='KEITEL'
order by f.title ;

select AC.first_name, AC.last_name, FL.title, FL.release_year, FL.rental_rate
	from actor AC join film_actor FA on AC.actor_id = FA.actor_id
	join film FL on FA.film_id = FL.film_id
	where AC.first_name = 'MARY' and AC.last_name = 'KEITEL'
	order by FL.title;

  -- 8. 배우의 'R' 등급 영화 작품 수를 카운트하여, 가장 많은 작품수를 가지는 배우부터 출력하시오, 출력 컬럼은 다음과 같다.
	-- actor_id, first_name, last_name, 'R'등급 작품 수

select a.actor_id , a.first_name, a.last_name , count(f.rating)
from actor a join film_actor fa on a.actor_id = fa.actor_id
join film f on f.film_id =fa.film_id
where f.rating ='R'
group by a.actor_id , a.first_name, a.last_name
order by count(fa.actor_id) desc;

select AC.actor_id, AC.first_name, AC.last_name, count(FL.title)
	from film FL join film_actor FA on FL.film_id = FA.film_id
	join actor AC on AC.actor_id = FA.actor_id
	where FL.rating = 'R'
	group by AC.actor_id, AC.first_name, AC.last_name
	order by count(FL.title) desc;

-- 9. 'R' 등급 영화에 출연한 적이 없는 배우의 first_name, last_name, 출연영화제목을 출시일 순으로 출력(not in 쓰는거 우리는 != 이렇게 함 근데 안됨)

select a.first_name, a.last_name , f.title ,f.release_year
from actor a join film_actor fa on a.actor_id = fa.actor_id
join film f on f.film_id =fa.film_id
where a.actor_id not in(select fa.actor_id
						from film f join film_actor fa 
                        on f.film_id = fa.film_id
                        where f.rating ='R')
group by a.first_name, a.last_name ,f.title
order by f.release_year;
                        
select AC.first_name, AC.last_name, FL.title
	from film FL join film_actor FA on FL.film_id = FA.film_id
	join actor AC on AC.actor_id = FA.actor_id
	where AC.actor_id not in (select FA.actor_id
	        from film FL join film_actor FA on FL.film_id = FA.film_id
	        where rating = 'R')
	order by FL.release_year;
    
    -- 10 영화 'AGENT TRUMAN' 를 보유하고 있는 매장의 정보를 아래와 같이 출력함.
	-- 영화제목, 매장ID, 매장staff first_name, 매장staff last_name, 매장의 address, address2
	-- , district, city, country, 해당 타이틀 "보유수량"
    select f.title, s.store_id, sf.first_name,sf.last_name, a.address,a.address2,a.district, c.city, coun.country, count(i.film_id)
    from film f join inventory i on f.film_id = i.film_id
    join store s on i.store_id = s.store_id
    join address a on s.address_id = a.address_id
    join staff sf on a.address_id = sf.address_id
    join city c on a.city_id = c.city_id
    join country coun on c.country_id = coun.country_id
    where f.title ='AGENT TRUMAN'
    GROUP BY f.title, s.store_id, sf.first_name,sf.last_name, a.address,a.address2,a.district, c.city, coun.country;
    
	select f.title, s.store_id, sf.first_name,sf.last_name, a.address,a.address2,a.district, c.city, coun.country, count(i.film_id)
    from film f join inventory i on f.film_id = i.film_id
    join store s on i.store_id = s.store_id
	join staff sf on s.store_id = sf.store_id
    join address a on s.address_id = a.address_id
    join city c on a.city_id = c.city_id
    join country coun on c.country_id = coun.country_id
    where f.title ='AGENT TRUMAN'
    GROUP BY f.title, s.store_id, sf.first_name,sf.last_name, a.address,a.address2,a.district, c.city, coun.country;
    
    -- 11. 영화 'AGENT TRUMAN' 를 보유하고 있는 매장의 정보와 해당 타이틀의 대여 정보를(대여 정보가 없을 경우에는 관련 컬럼은 null 처리) 아래와 같이 출력함.
	-- 영화제목, 매장ID, 인벤토리ID, 매장의 address, address2, district, city, country,
	-- 대여 일자, 회수일자, 대여고객의 first_name, last_name
    
	select f.title, s.store_id, i.inventory_id, a.address, a.address2, a.district, c.city, coun.country, r.rental_date, r.return_date, cu.first_name, cu.last_name
   from film f join inventory i on f.film_id = i.film_id
   join store s on s.store_id = i.store_id
   join staff sf on s.store_id = sf.store_id
   join address a on s.address_id = a.address_id
   join city c on a.city_id = c.city_id
   join country coun on c.country_id = coun.country_id
   left join rental r on r.inventory_id = i.inventory_id
   join customer cu on cu.customer_id = r.customer_id
   where f.title = 'AGENT TRUMAN';
   
    select FL.title, ST.store_id, IV.inventory_id, AD.address, AD.address2
	, AD.district, CT.city, CU.country, RT.rental_date, RT.return_date, CS.first_name, CS.last_name
	from film FL join inventory IV on FL.film_id = IV.film_id
	join store ST on IV.store_id = ST.store_id
	join address AD on ST.address_id = AD.address_id
	join city CT on AD.city_id = CT.city_id
	join country CU on CT.country_id = CU.country_id
     -- 대여 정보가 없을 경우에는 관련 컬럼은 null 처리
	left join rental RT on IV.inventory_id = RT.inventory_id
	join customer CS on RT.customer_id = CS.customer_id
	where FL.title = 'AGENT TRUMAN';
    
    -- 12. 대여된 영화 타이틀과 대여회수를 출력하시오(대여 회수 내림차순)
    select f.title, count(r.rental_id)
    from film f join inventory i on f.film_id = i.film_id
    join rental r on i.inventory_id = r.inventory_id
    group by f.title
    order by count(r.rental_id) desc;
    
    -- 속도 더 빠름
    select FL.title, sum(rental_info.rental_cnt)
	from inventory IV join (
			select inventory_id, count(rental_id) as rental_cnt
	        from rental
	        group by inventory_id) as rental_info
	on IV.inventory_id = rental_info.inventory_id
	join film FL on IV.film_id = FL.film_id
	group by FL.title
	order by sum(rental_info.rental_cnt) desc;
    
    
    
    -- 13. 고객의 지불정보를 총지불금액 내림차순, 다음과 같이 출력하시오
	-- 고객의  first_name, last_name, 총지불금액, 고객의 주소 address, address2, district
	-- , city, country
    select c.first_name, c.last_name, sum(p.amount), address, address2, 
    district, city, country
    from customer c join payment p on c.customer_id = p.customer_id
    join address a on a.address_id = c.address_id
    join city ci on a.city_id = ci.city_id
    join country co on co.country_id = ci.country_id
    GROUP BY c.first_name, c.last_name, address, address2, district, city, country
    order by sum(p.amount) desc;
    
    select CS.first_name, CS.last_name, sum(PM.amount), AD.address, AD.address2, AD.district
	, CT.city, CU.country
	from payment PM join customer CS on PM.customer_id = CS.customer_id
	join address AD on CS.address_id = AD.address_id
	join city CT on AD.city_id = CT.city_id
	join country CU on CT.country_id = CU.country_id
	group by CS.customer_id
	order by sum(PM.amount) desc;
    
    
    -- 14. 총 지불 금액별 고객 등급을 출력하고자 한다. 등급 구분과 출력 컬럼은 다음과 같다.(case 문 사용)
	-- 'A' : 총 지불금액이 200 이상
	-- 'B' : 총 지불금액이 200 미만 100 이상
	-- 'C' : 총 지불금액이 100 미만 고객
	-- 고객의 firs_name, last_name, 총 지불금액, 등급
	-- 총 지불금액이 많은 고객부터 출력
    
    select c.first_name, c.last_name, sum(p.amount), 
    case 
    when sum(p.amount) >= 200 then 'A' 
    when sum(p.amount) < 200 and sum(p.amount) >= 100 then 'B'
    else 'C'
    end as '등급'
    from customer c join payment p on c.customer_id = p.customer_id
    group by c.first_name, c.last_name
    order by sum(p.amount) desc;
    
    
-- 15. DVD 대여 후 아직 반납하지 않은 고객정보를 다음의 정보로 출력한다.(case 문 사용)
-- 영화타이틀, 인벤토리ID, 매장ID, 고객의 first_name, last_name, 대여일자, 고객등급
-- join 순서
select f.title, i.inventory_id, s.store_id, c.first_name, c.last_name, r.rental_date,
case 
    when sum(p.amount) >= 200 then 'A' 
    when sum(p.amount) < 200 and sum(p.amount) >= 100 then 'B'
    else 'C'
end as '등급'
from film f join inventory i on f.film_id = i.film_id
join store s on s.store_id = i.store_id
join customer c on c.store_id = s.store_id 
join payment p on c.customer_id = p.customer_id
join rental r on r.customer_id = c.customer_id
where r.return_date is null
group by f.title, i.inventory_id, s.store_id, c.first_name, c.last_name, r.rental_date;


select FL.title, IV.inventory_id, IV.store_id, CS.first_name, CS.last_name
	, RT.rental_date, case when (sum(PM.amount) >= 200) then 'A'
	        when (sum(PM.amount) >= 100) then 'B'
	                    else 'C' end as customer_grade
	from rental RT join customer CS on RT.customer_id = CS.customer_id
	join inventory IV on RT.inventory_id = IV.inventory_id
	join film FL on IV.film_id = FL.film_id
	join store ST on IV.store_id = ST.store_id
	join payment PM on CS.customer_id = PM.customer_id
	where RT.return_date is null
	group by FL.title, IV.inventory_id, IV.store_id, CS.first_name, CS.last_name
	, RT.rental_date;
    
    
-- 16. '2005-08-01' 부터 '2005-08-15' 사이, Canada(country) Alberta(district) 주에서 대여한 영화의 타이틀 정보를 아래와 같이 출력하시오
-- 	대여일, 영화 타이틀, 인벤토이ID, 매장ID, 매장 전체 주소    
 
select t.rental_date, f.title, i.inventory_id, s.store_id, a.address
from film f join inventory i on f.film_id = i.film_id
join rental t on i.inventory_id = t.inventory_id
join store s on s.store_id = i.store_id
join address a on a.address_id = s.address_id
join city ci on a.city_id = ci.city_id
join country c on c.country_id = ci.country_id
where t.rental_date between '2005-08-01' and '2005-08-15'  
 and a.district = 'Alberta' and c.country = 'Canada';
    
    select RT.rental_date, FL.title, IV.inventory_id, IV.store_id, AD.address, AD.address2, AD.district, CT.city, CU.country
	from rental RT join inventory IV on RT.inventory_id = IV.inventory_id
	join store ST on IV.store_id = ST.store_id
	join address AD on ST.address_id = AD.address_id
	join city CT on AD.city_id = CT.city_id
	join country CU on CT.country_id = CU.country_id
	join film FL on IV.film_id = FL.film_id
	where rental_date between '2005-08-01' and '2005-08-15'
	and AD.district = 'Alberta'
	and CU.country = 'Canada';
  
  
-- 17. 도시별 'Horror' 영화 대여회수를 알고자 한다. 도시와 대여수를 출력하라. 대여수 내림차순, 도시명 오름차순으로 정렬하시오
-- having은 gb에 대한 조건이어서 같은 테이블일때만 가능
select ci.city, count(r.rental_id)
from film f join film_category fc on f.film_id = fc.film_id
join category ca on ca.category_id = fc.category_id
join inventory i on i.film_id = f.film_id
join rental r on r.inventory_id = i.inventory_id  
join customer cu on cu.customer_id = r.customer_id
join address ad on ad.address_id = cu.address_id
join city ci on ci.city_id = ad.city_id 
where ca.name = 'Horror'
group by ci.city
order by count(r.rental_id) desc, ci.city asc;



	select CT.city, count(FL.title)
	from film FL join film_category FC on FL.film_id = FC.film_id
	join category CG on FC.category_id = CG.category_id
	join inventory IV on FL.film_id = IV.film_id
	join rental RT on IV.inventory_id = RT.inventory_id
	join customer CS on RT.customer_id = CS.customer_id
	join address AD on CS.address_id = AD.address_id
	join city CT on AD.city_id = CT.city_id
	join country CU on CT.country_id = CU.country_id
	where CG.name = 'Horror'
	group by CT.city
	order by count(FL.title) desc, CT.city;

-- 18. 각 store 별 총 대여금액을 출력하시오.
-- 왜 다르지?
select s.store_id, sum(p.amount)
from store st join staff s on st.store_id = s.store_id
join payment p on p.staff_id = s.staff_id
group by s.store_id;


select ST.store_id, sum(amount)
	from rental RT join payment PM on RT.rental_id = PM.rental_id
	join inventory IV on RT.inventory_id = IV.inventory_id
	join store ST on IV.store_id = ST.store_id
	group by ST.store_id;
    
    
-- 19. 대여된 영화 중 대여기간이 연체된 건을 다음의 정보로 조회하시오.(현재날짜기준)
-- 	영화타이틀. inventory_id, 대여일, 반납일, 기준대여기간, 실제대여기간
-- 	** 아직 반납이 되지 않은 경우, 실제대여기간 컬럼에 'Unknown' 출력
select f.title, i.inventory_id, r.rental_date, r.return_date, f.rental_duration, 
-- datediff(r.return_date, r.rental_date)    ifnull(r.return_date, 'Unkown') as '실제 대여 기간'  
IFNULL(DATEDIFF(RT.return_date, RT.rental_date), 'Unknown')
-- coalesce(DATEDIFF(RT.return_date, RT.rental_date), 'Unknown')
from film f join inventory i on f.film_id = i.film_id
join rental r on r.inventory_id = i.inventory_id;

select FL.title, IV.inventory_id, RT.rental_date, RT.return_date, FL.rental_duration, 
IFNULL(DATEDIFF(RT.return_date, RT.rental_date), 'Unknown')
	from rental RT join inventory IV on RT.inventory_id = IV.inventory_id
	join film FL on IV.film_id = FL.film_id
	where DATEDIFF(IFNULL(RT.return_date, curdate()), RT.rental_date) > FL.rental_duration; 
    
    
-- 20. 고객별 연체 건수가 많은 수부터 출력하시오(고객 first_name, last_name, 연체건수)
-- 	연체기준은 현재날짜  
select c.first_name, c.last_name, count(rental_id)
from customer c join rental r on c.customer_id = r.customer_id  
join inventory i on r.inventory_id = i.inventory_id
join film f on i.film_id = f.film_id
where DATEDIFF(IFNULL(r.return_date, curdate()), r.rental_date) > f.rental_duration
group by c.first_name, c.last_name
order by count(rental_id) desc; 

select CS.first_name, CS.last_name, count(RT.rental_id)
	from rental RT join inventory IV on RT.inventory_id = IV.inventory_id
	join film FL on IV.film_id = FL.film_id
	join customer CS on RT.customer_id = CS.customer_id
	where datediff(IFNULL(RT.return_date, curdate()), RT.rental_date) > FL.rental_duration
	group by CS.first_name, CS.last_name
	order by count(RT.rental_id) desc;


-- 21. 대여횟수 상위 5위 고객이 대여한 영화의 title을 알파벳순으로 출력
	-- 출력 컬럼 : 고객이름(first, last), 영화제목, 총 대여수
    -- 서브쿼리에 있는 거 별칭 해서 사용하기
select c.first_name, c.last_name, f.title, top5.coun
from (
select customer_id, count(rental_id) as coun
from rental
group by customer_id
order by count(rental_id) desc limit 5
) as top5 join rental r on r.customer_id = top5.customer_id
join inventory i on r.inventory_id = i.inventory_id
join film f on i.film_id = f.film_id
join customer c on c.customer_id = top5.customer_id
order by top5.coun desc, f.title;


select CS.first_name, CS.last_name, FL.title, top5.tot_cnt
	from (select customer_id, count(rental_id) as tot_cnt
	        from rental
	        group by customer_id
	        order by count(rental_id) desc
	        limit 5) as top5 join rental RT on top5.customer_id = RT.customer_id
	join inventory IV on RT.inventory_id = IV.inventory_id
	join film FL on IV.film_id = FL.film_id
	join customer CS on top5.customer_id = CS.customer_id
	order by top5.tot_cnt desc, FL.title;

    
    -- 22. 배우 'WALTER TORN' 보다 출연작이 많은 배우의 정보를, 배우ID, 
    -- 배우 이름(first_name, last_name), 출연작 타이틀, 작품 출시일을 출력하시오
    -- (정렬순서: 배우ID, 타이틀, 출시일) 


    select 
    from (
		select actor_id
		from actor
		where name = 'WALTER TORN'
    )as cnt join film_actor fa 
		on a.actor_id = fa.actor_id
    join film f on f.film_id = fa.film_id


 
    