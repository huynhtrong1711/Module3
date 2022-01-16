USE furama_resort;

SELECT * FROM khach_hang
WHERE (year(current_timestamp) - year(ngay_sinh)) BETWEEN 18 AND 50
AND (dia_chi LIKE '%Đà Nẵng' OR dia_chi LIKE '%Quảng Trị');