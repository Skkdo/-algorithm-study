SELECT ANIMAL_ID, NAME
FROM ANIMAL_OUTS o
WHERE NOT EXISTS
   (SELECT ANIMAL_ID
    FROM ANIMAL_INS i
    WHERE o.ANIMAL_ID = i.ANIMAL_ID)
ORDER BY ANIMAL_ID