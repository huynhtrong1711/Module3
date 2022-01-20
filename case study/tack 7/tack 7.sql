USE furama_resort;

SELECT dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.so_nguoi_toi_da, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
FROM
    dich_vu
	JOIN loai_dich_vu ON loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
	JOIN hop_dong ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
WHERE 
dich_vu.ma_dich_vu IN (SELECT hop_dong.ma_dich_vu FROM hop_dong
WHERE
YEAR(hop_dong.ngay_lam_hop_dong) = 2020)
GROUP BY dich_vu.ma_dich_vu;