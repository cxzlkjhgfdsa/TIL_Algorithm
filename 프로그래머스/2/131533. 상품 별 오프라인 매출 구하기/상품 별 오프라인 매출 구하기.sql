-- 코드를 입력하세요
SELECT p.PRODUCT_CODE , p.PRICE * sum(os.SALES_AMOUNT) as SALES
FROM PRODUCT p join OFFLINE_SALE os on p.PRODUCT_ID = os.PRODUCT_ID
GROUP BY p.PRODUCT_ID
ORDER BY SALES desc, p.PRODUCT_CODE;