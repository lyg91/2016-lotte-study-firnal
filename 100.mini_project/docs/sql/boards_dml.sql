/* 0. ������ �ۼ� (������) */
INSERT INTO boards VALUES(seq_boards_number.nextval, '���������Դϴ�.', 0392, '�����Ӱ� ���� �÷��ּ���.', 'admin', '16/07/25 13:03:38', null, null, null, 0, 1, 0, 0, 0);

/* 1. �Ϲ� �Խñ� �ۼ� (�Ϲ�ȸ��) */
INSERT INTO boards VALUES(seq_boards_number.nextval, 'JAVA vs C���', 1234, '����ּ���.', 'lyg91', '16/08/25 11:05:18', null, null, null, 0, 0, 0, 0, 0);

SELECT b_number, b_title, b_content, b_author, b_date, b_hit, b_notice 
FROM ( SELECT rownum as rown, b_number, b_title, b_content, b_author, b_date, b_hit, b_notice FROM (SELECT rownum AS rown, b_number, b_title, b_content, b_author, b_date, b_hit, b_notice FROM boards WHERE b_title LIKE '%vs%' ORDER BY b_notice DESC, b_date DESC))
WHERE rown>=1 AND rown<=10;

SELECT COUNT(*) FROM boards WHERE b_title LIKE '%vs%';
SELECT b_number, b_title, b_content, b_author, b_date, b_hit, b_notice FROM ( SELECT rownum as rown, b_number, b_title, b_content, b_author, b_date, b_hit, b_notice FROM (SELECT rownum AS rown, b_number, b_title, b_content, b_author, b_date, b_hit, b_notice FROM boards WHERE b_title LIKE '%vs%' ORDER BY b_notice DESC, b_date DESC)) WHERE rown>=1 AND rown<=10;
SELECT COUNT(*) FROM ( SELECT rownum as rown, b_number, b_title, b_content, b_author, b_date, b_hit, b_notice FROM (SELECT rownum AS rown, b_number, b_title, b_content, b_author, b_date, b_hit, b_notice FROM boards WHERE b_title LIKE 'vs' ORDER BY b_notice DESC, b_date DESC));
desc boards;

/* 2. ��ü �Խñ� ��� ��� */
SELECT * FROM boards;

/* 3. Ư�� �Խñ� ���� ��� */
SELECT * FROM boards WHERE b_number=3;

/* 4. �Խñ� ���� ���� */
UPDATE boards
SET b_title='å ��..', b_password=1234, b_content='��������?', b_date=to_char(sysdate,'yy/MM/dd hh24:mm:ss')
WHERE b_number=3 AND b_author='user01';

/* 5. �Խñ� ���� */
/* 6. �Խñ� ��õ */
/* 7. �Խñ� �˻� */
