/* 0. 회원 가입 */
INSERT INTO users VALUES('lyg91','a0309','이영걸','lkl0309@naver.com','A','2016/08/25',1000,'M',1991,'0309');

/* 1. 특정회원 조회(일반/ 관리자) */
SELECT * 
FROM users 
WHERE u_id='admin';

/* 2. 전체회원 조회(관리자) */
SELECT * 
FROM users
ORDER BY u_entry_date DESC;

/* 3. 로그인(일반/ 관리자) */
SELECT u_name,u_grade 
FROM users
WHERE u_id='admin' AND u_pw='1234';

/* 4. 사이트 이용 회원 평균 나이 검색 (관리자)*/
SELECT AVG(u_birth_year)
FROM users;

/* 5. 사이트 이용 회원의 성별 인원수 통계 (관리자)*/
SELECT u_gender, COUNT(u_gender)
FROM users
GROUP BY u_gender;

/* 6. 회원정보 변경 (관리자) */
UPDATE users
SET U_PW='1234', U_NAME='관리자', U_EMAIL='webtest@google.co.kr', U_GRADE='A', U_MILEAGE=null, U_GENDER='M', U_BIRTH_YEAR=1990, U_BIRTH_MONDAY='0817'
WHERE U_ID='admin';

/* 7. 회원정보 변경 (일반사용자) */
UPDATE users
SET U_PW='1234', U_NAME='관리자', U_EMAIL='webtest@google.co.kr', U_GENDER='M', U_BIRTH_YEAR=1990, U_BIRTH_MONDAY='0817'
WHERE U_ID='admin';

/* 8. 회원 탈퇴(일반 / 관리자) */
DELETE users
WHERE u_id='kyun0102';

/* +. ID로 회원 조회 */
SELECT *
FROM users
WHERE u_id LIKE '%lyg%';

/* +. 이름으로 회원 조회 */
SELECT *
FROM users
WHERE u_name LIKE '%관%';

/* +. 이메일로 회원 조회 */
SELECT *
FROM users
WHERE u_email LIKE '%naver%';

/* 아이디 검색 */
SELECT u_id
FROM users
WHERE u_name='이영걸' AND u_mobile='010-3472-3606';

/* 비밀번호 검색 */ 
SELECT u_pw
FROM users
WHERE u_id='lyg91' AND u_name='이영걸' AND u_mobile='010-3472-3606';