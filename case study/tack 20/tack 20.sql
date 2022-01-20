USE furama_resort;

SELECT ma_nhan_vien AS '#ID' ,ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi , "1" AS `TABLE`
FROM nhan_vien
UNION ALL
SELECT ma_khach_hang AS '#ID',ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi, "2" AS `TABLE`
FROM khach_hang;