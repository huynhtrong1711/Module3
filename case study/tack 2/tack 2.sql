USE furama_resort;

SELECT nhan_vien.* 
FROM nhan_vien 
WHERE ho_ten 
LIKE 'H%' 
OR ho_ten LIKE 'T%' 
OR ho_ten LIKE 'K%'
AND char_length(ho_ten) < 15;