SELECT
    year_max.y AS YEAR,
    year_max.M - d.SIZE_OF_COLONY AS YEAR_DEV,
    d.ID AS ID
FROM
    (SELECT
        YEAR(DIFFERENTIATION_DATE) AS y,
        MAX(SIZE_OF_COLONY) AS M
     FROM
        ECOLI_DATA
     GROUP BY 
        YEAR(DIFFERENTIATION_DATE)
    ) AS year_max
JOIN
    ECOLI_DATA d ON year_max.y = YEAR(d.DIFFERENTIATION_DATE)
ORDER BY
    year_max.y, YEAR_DEV
