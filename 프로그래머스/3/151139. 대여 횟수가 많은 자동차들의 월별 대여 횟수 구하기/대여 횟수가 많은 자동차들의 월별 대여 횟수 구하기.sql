SELECT
    MONTH,
    CAR_ID,
    COUNT(*) AS RECORDS
FROM
    (SELECT
        EXTRACT(MONTH FROM START_DATE) AS MONTH,
        CAR_ID
     FROM
        CAR_RENTAL_COMPANY_RENTAL_HISTORY
     WHERE
        START_DATE BETWEEN TO_DATE('2022-08-01','yyyy-mm-dd') AND TO_DATE('2022-10-31','yyyy-mm-dd')  
    )
WHERE
    CAR_ID IN
      (SELECT
             CAR_ID
         FROM
             (SELECT
                 CAR_ID,
                 COUNT(*) AS c
              FROM
                 CAR_RENTAL_COMPANY_RENTAL_HISTORY
              WHERE
                 START_DATE BETWEEN TO_DATE('2022-08-01','yyyy-mm-dd') AND TO_DATE('2022-10-31','yyyy-mm-dd')
              GROUP BY
                 CAR_ID
             )
         WHERE
            c >= 5
        )
GROUP BY
    MONTH, CAR_ID
ORDER BY
    MONTH, CAR_ID DESC