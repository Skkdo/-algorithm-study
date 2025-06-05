-- 코드를 작성해주세요
SELECT
    ID,
    (
    SELECT
        COUNT(*)
    FROM
        ECOLI_DATA c
    WHERE
        p.ID = c.PARENT_ID) AS CHILD_COUNT
FROM
    ECOLI_DATA p
ORDER BY 
    p.ID


