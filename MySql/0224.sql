--  ascii(s) : 문자를 ascii로 변환
SELECT ASCII('CustomerName') 
FROM dual;
 
 
-- CHAR_LENGTH(s) CHARACTER_LENGTH(s) LENGTH(s) : 글자 수 
SELECT CHAR_LENGTH("SQL Tutorial")
FROM dual;
SELECT CHARACTER_LENGTH("SQL Tutorial");
SELECT LENGTH("SQL Tutorial");


-- concat : 문자열 합치기
SELECT CONCAT("SQL ", "Tutorial ", "is ", "fun!")
FROM dual;

-- CONCAT_WS(a, 문자1, 2, ,,,) : 문자들을 a로 연결하여 이음
-- 문자1a문자2a문자3
SELECT CONCAT_WS("-", "SQL", "Tutorial", "is", "fun!")
FROM dual;
-- 결과 : SQL-Tutorial-is-fun!


-- FIELD(찾아야하는 대상, 찾을 곳1, 찾을 곳2, 찾을 곳3);
-- 없으면 0, 있으면 해당 번호 출력
-- mysql은 처음이 "1!!!" 0아니다!!
SELECT FIELD("q", "s", "q", "l"); 	-- 결과 : 2
SELECT FIELD("q", "s", "l"); 		-- 결과 : 0

-- FIND_IN_SET("찾아야하는 대상", "찾는 곳 (리스트, 콤마로 연결되어야 한다. )");
SELECT FIND_IN_SET("q", "s,q,l");	-- 결과 : 2
SELECT FIND_IN_SET("s", "s,q,l");	-- 결과 : 1
SELECT FIND_IN_SET("q", "sql");		-- 결과 : 0


-- FORMAT(숫자, n)  : 소수점 n자리까지 반올림
SELECT FORMAT(250500.5634, 1);
SELECT FORMAT(250500.5634, 2);
SELECT FORMAT(250500.5634, 3);


-- INSERT(문자열1, a, b, 문자열2) :  문자열1의 a~b번째의 문자를 지우고, 그 자리에 문자열2를 써라
SELECT INSERT("W3Schools.com", 1, 9, "Example");
SELECT INSERT("W3Schools.com", 1, 7, "Example333333333");


-- 문자열a에서 해당 문자열b의 위치 찾기
-- INSTR(문자열a, 찾고자하는 문자열b) : 찾고자하는 문자열의 시작 위치 찾기
SELECT INSTR("W3Schools.com", "3");
SELECT INSTR("W3Schools.com", "3S");
SELECT INSTR("W3Schools.com", "COM");

--  LOCATE(찾고자하는 문자열b, 문자열a) 문자열에서 찾고자하는 문자열의 시작 위치 찾기
SELECT LOCATE("W3", "W3Schools.com");

-- LCASE(문자열) LOWER(문자열) : 소문자로
SELECT LCASE("SQL Tutorial is FUN!");
SELECT LOWER("SQL Tutorial is FUN!");


-- LEFT(문자열, n) : 왼쪽에서부터 n개 출력 
SELECT LEFT("SQL Tutorial", 3);
SELECT LEFT("SQL Tutorial", 7);

-- LPAD(s1, n, s2) : s1의 길이가 n개 될 때까지 왼쪽에 s2를 계속 붙인다. 
SELECT LPAD("SQL Tutorial", 20, "ABC"); -- ABCABCABSQL Tutorial

-- LTRIM(s) : 왼쪽 공백 제거
SELECT LTRIM("     SQL Tutorial");

--  MID(s, a, b) : 문자열s에서 a번째 문자부터 b개 출력 
SELECT MID("SQL Tutorial", 5, 3);


