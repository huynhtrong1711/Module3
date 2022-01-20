use furama_resort;

SELECT nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, trinh_do.ten_trinh_do, bo_phan.ten_bo_phan, nhan_vien.so_dien_thoai, nhan_vien.dia_chi
FROM nhan_vien
JOIN trinh_do ON trinh_do.ma_trinh_do = nhan_vien.ma_trinh_do
JOIN bo_phan ON bo_phan.ma_bo_phan = nhan_vien.ma_bo_phan
JOIN hop_dong ON hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
 WHERE 
       YEAR(hop_dong.ngay_lam_hop_dong) between 2020 and 2021
       GROUP BY hop_dong.ma_nhan_vien
       HAVING count(hop_dong.ma_nhan_vien) <= 3
       ORDER BY ma_nhan_vien ASC;