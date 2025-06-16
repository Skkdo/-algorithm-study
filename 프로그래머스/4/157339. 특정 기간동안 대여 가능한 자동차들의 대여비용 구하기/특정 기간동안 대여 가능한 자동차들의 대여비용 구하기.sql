SELECT *
FROM (
    SELECT
        c.CAR_ID,
        c.CAR_TYPE,
        FLOOR(c.DAILY_FEE * 30 * (1 - p.DISCOUNT_RATE / 100)) AS FEE
    FROM CAR_RENTAL_COMPANY_CAR c
    JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
        ON c.CAR_TYPE = p.CAR_TYPE
    WHERE
        c.CAR_TYPE IN ('세단', 'SUV')
        AND p.DURATION_TYPE = '30일 이상'
        AND NOT EXISTS (
            SELECT 1
            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY r
            WHERE r.CAR_ID = c.CAR_ID
              AND (
                   r.START_DATE <= TO_DATE('2022-11-30', 'YYYY-MM-DD')
               AND r.END_DATE >= TO_DATE('2022-11-01', 'YYYY-MM-DD')
              )
        )
)
WHERE FEE >= 500000 AND FEE < 2000000
ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC;
