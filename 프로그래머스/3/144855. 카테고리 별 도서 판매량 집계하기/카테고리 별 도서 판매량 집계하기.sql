-- 코드를 입력하세요
SELECT b.CATEGORY , SUM(bs.SALES) as TOTAL_SALES
FROM BOOK b join BOOK_SALES bs 
on b.BOOK_ID = bs.BOOK_ID
WHERE bs.SALES_DATE like "2022-01%"
GROUP BY b.CATEGORY
ORDER BY b.CATEGORY ASC