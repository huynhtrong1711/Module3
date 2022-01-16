USE furama_resort;

SELECT khach_hang.ma_khach_hang, khach_hang.ho_ten, count(ma_hop_dong) AS so_lan
FROM hop_dong 
INNER JOIN khach_hang ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
INNER JOIN loai_khach ON khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
WHERE loai_khach.ma_loai_khach = '1'
GROUP BY ma_khach_hang
ORDER BY so_lan ASC;