-- 코드를 입력하세요
SELECT j.flavor
FROM first_half fh right join july j on fh.shipment_id = j.shipment_id
group by j.flavor
order by fh.total_order + sum(j.total_order) desc limit 3
