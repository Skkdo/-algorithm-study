SELECT
    MCDP_CD	AS "진료과 코드",
    COUNT(*) AS "5월예약건수"
FROM
   (SELECT
        MCDP_CD
    FROM    
        APPOINTMENT
    WHERE
        APNT_YMD BETWEEN TO_DATE('2022-05-01','yyyy-mm-dd') AND TO_DATE('2022-05-31','yyyy-mm-dd'))
GROUP BY 
    MCDP_CD
ORDER BY
    "5월예약건수", "진료과 코드"