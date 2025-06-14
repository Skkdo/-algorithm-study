SELECT
    e.EMP_NO,
    e.EMP_NAME,
    CASE
        WHEN s.SCORE >= 96 THEN 'S'
        WHEN s.SCORE >= 90 THEN 'A'
        WHEN s.SCORE >= 80 THEN 'B'
        ELSE 'C'
    END AS GRADE,
    CASE
        WHEN s.SCORE >= 96 THEN e.SAL * 0.2
        WHEN s.SCORE >= 90 THEN e.SAL * 0.15
        WHEN s.SCORE >= 80 THEN e.SAL * 0.1
        ELSE 0
    END AS BONUS
FROM
   (SELECT EMP_NO, (SUM(SCORE) / 2) AS SCORE
    FROM HR_GRADE
    GROUP BY EMP_NO) s
JOIN HR_EMPLOYEES e ON s.EMP_NO = e.EMP_NO
ORDER BY e.EMP_NO