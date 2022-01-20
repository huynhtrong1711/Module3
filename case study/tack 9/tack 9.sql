use furama_resort;

SELECT 
    MONTH(ngay_lam_hop_dong) thang, COUNT( MONTH(ngay_lam_hop_dong)) so_luong_khach_hang FROM hop_dong
WHERE
    YEAR(ngay_lam_hop_dong) = 2021
GROUP BY MONTH(ngay_lam_hop_dong)
ORDER BY MONTH(ngay_lam_hop_dong);