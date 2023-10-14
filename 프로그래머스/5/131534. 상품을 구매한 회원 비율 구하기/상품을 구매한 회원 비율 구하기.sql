-- 코드를 입력하세요
SELECT year(sales_date) YEAR, month(sales_date) MONTH , count(distinct os.user_id) as PURCHASED_USER,
ROUND(count(distinct os.user_id) / (
                    select count(user_id)
                    from user_info
                    where joined like '%2021%' 
                    ) , 1) as PUCHASED_RATIO

from online_sale os join user_info ui on os.user_id = ui.user_id
where year(ui.joined) = 2021
group by YEAR, MONTH
order by YEAR, MONTH;