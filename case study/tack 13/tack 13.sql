use furama_resort;

SELECT dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem, SUM(so_luong) AS 'so_luong_dich_vu_di_kem'
FROM dich_vu_di_kem
LEFT JOIN hop_dong_chi_tiet ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
GROUP BY dich_vu_di_kem.ma_dich_vu_di_kem
having sum(so_luong) = (SELECT sum(so_luong) from dich_vu_di_kem JOIN hop_dong_chi_tiet ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
group by dich_vu_di_kem.ma_dich_vu_di_kem
order by sum(so_luong) desc limit 1);