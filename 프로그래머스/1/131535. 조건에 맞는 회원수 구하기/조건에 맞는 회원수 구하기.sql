-- 코드를 입력하세요
SELECT
    COUNT(*) AS USERS
FROM
    USER_INFO
WHERE
    JOINED >= TO_DATE('2021-01-01', 'yyyy-mm-dd') AND
    JOINED < TO_DATE('2022-01-01', 'yyyy-mm-dd') AND
    AGE BETWEEN 20 AND 29