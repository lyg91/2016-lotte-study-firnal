/* 0. 공지글 작성 (관리자) */
INSERT INTO boards VALUES(seq_boards_number.nextval, '공지사항입니다.', 0392, '자유롭게 글을 올려주세요.', 'admin', '16/07/25 13:03:38', null, null, null, 0, 1, 0, 0, 0);

/* 1. 일반 게시글 작성 (일반회원) */
INSERT INTO boards VALUES(seq_boards_number.nextval, 'JAVA vs C언어', 1234, '골라주세요.', 'lyg91', '16/08/25 11:05:18', null, null, null, 0, 0, 0, 0, 0);

SELECT b_number, b_title, b_content, b_author, b_date, b_hit, b_notice 
FROM ( SELECT rownum as rown, b_number, b_title, b_content, b_author, b_date, b_hit, b_notice FROM (SELECT rownum AS rown, b_number, b_title, b_content, b_author, b_date, b_hit, b_notice FROM boards WHERE b_title LIKE '%vs%' ORDER BY b_notice DESC, b_date DESC))
WHERE rown>=1 AND rown<=10;

SELECT COUNT(*) FROM boards WHERE b_title LIKE '%vs%';
SELECT b_number, b_title, b_content, b_author, b_date, b_hit, b_notice FROM ( SELECT rownum as rown, b_number, b_title, b_content, b_author, b_date, b_hit, b_notice FROM (SELECT rownum AS rown, b_number, b_title, b_content, b_author, b_date, b_hit, b_notice FROM boards WHERE b_title LIKE '%vs%' ORDER BY b_notice DESC, b_date DESC)) WHERE rown>=1 AND rown<=10;
SELECT COUNT(*) FROM ( SELECT rownum as rown, b_number, b_title, b_content, b_author, b_date, b_hit, b_notice FROM (SELECT rownum AS rown, b_number, b_title, b_content, b_author, b_date, b_hit, b_notice FROM boards WHERE b_title LIKE 'vs' ORDER BY b_notice DESC, b_date DESC));
desc boards;

/* 2. 전체 게시글 목록 출력 */
SELECT * FROM boards;

/* 3. 특정 게시글 내용 출력 */
SELECT * FROM boards WHERE b_number=3;

/* 4. 게시글 내용 수정 */
UPDATE boards
SET b_title='책 좀..', b_password=1234, b_content='뭐가좋음?', b_date=to_char(sysdate,'yy/MM/dd hh24:mm:ss')
WHERE b_number=3 AND b_author='user01';

/* 5. 게시글 삭제 */
/* 6. 게시글 추천 */
/* 7. 게시글 검색 */
