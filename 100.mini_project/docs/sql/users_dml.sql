/* 0. ȸ�� ���� */
INSERT INTO users VALUES('lyg91','a0309','�̿���','lkl0309@naver.com','A','2016/08/25',1000,'M',1991,'0309');

/* 1. Ư��ȸ�� ��ȸ(�Ϲ�/ ������) */
SELECT * 
FROM users 
WHERE u_id='admin';

/* 2. ��üȸ�� ��ȸ(������) */
SELECT * 
FROM users
ORDER BY u_entry_date DESC;

/* 3. �α���(�Ϲ�/ ������) */
SELECT u_name,u_grade 
FROM users
WHERE u_id='admin' AND u_pw='1234';

/* 4. ����Ʈ �̿� ȸ�� ��� ���� �˻� (������)*/
SELECT AVG(u_birth_year)
FROM users;

/* 5. ����Ʈ �̿� ȸ���� ���� �ο��� ��� (������)*/
SELECT u_gender, COUNT(u_gender)
FROM users
GROUP BY u_gender;

/* 6. ȸ������ ���� (������) */
UPDATE users
SET U_PW='1234', U_NAME='������', U_EMAIL='webtest@google.co.kr', U_GRADE='A', U_MILEAGE=null, U_GENDER='M', U_BIRTH_YEAR=1990, U_BIRTH_MONDAY='0817'
WHERE U_ID='admin';

/* 7. ȸ������ ���� (�Ϲݻ����) */
UPDATE users
SET U_PW='1234', U_NAME='������', U_EMAIL='webtest@google.co.kr', U_GENDER='M', U_BIRTH_YEAR=1990, U_BIRTH_MONDAY='0817'
WHERE U_ID='admin';

/* 8. ȸ�� Ż��(�Ϲ� / ������) */
DELETE users
WHERE u_id='kyun0102';

/* +. ID�� ȸ�� ��ȸ */
SELECT *
FROM users
WHERE u_id LIKE '%lyg%';

/* +. �̸����� ȸ�� ��ȸ */
SELECT *
FROM users
WHERE u_name LIKE '%��%';

/* +. �̸��Ϸ� ȸ�� ��ȸ */
SELECT *
FROM users
WHERE u_email LIKE '%naver%';

/* ���̵� �˻� */
SELECT u_id
FROM users
WHERE u_name='�̿���' AND u_mobile='010-3472-3606';

/* ��й�ȣ �˻� */ 
SELECT u_pw
FROM users
WHERE u_id='lyg91' AND u_name='�̿���' AND u_mobile='010-3472-3606';