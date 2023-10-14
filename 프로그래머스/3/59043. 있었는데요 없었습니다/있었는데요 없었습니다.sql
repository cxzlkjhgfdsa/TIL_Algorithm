SELECT ai.animal_id, ai.name
FROM animal_ins ai join animal_outs ao on ai.animal_id = ao.animal_id
WHERE ai.datetime > ao.datetime
ORDER BY ai.datetime;
