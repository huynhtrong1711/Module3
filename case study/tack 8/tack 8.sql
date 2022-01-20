USE furama_resort;

-- cách 1:
SELECT khach_hang.ho_ten FROM khach_hang 
UNION 
SELECT khach_hang.ho_ten FROM khach_hang;

-- cách 2:
SELECT DISTINCT khach_hang.ho_ten FROM khach_hang;

-- cách 3:
SELECT
     ho_ten
FROM
    khach_hang
GROUP BY ho_ten;