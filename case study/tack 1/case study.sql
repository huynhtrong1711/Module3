CREATE DATABASE furama_resort;

USE furama_resort;

CREATE TABLE vi_tri(
ma_vi_tri INT PRIMARY KEY AUTO_INCREMENT,
ten_vi_tri VARCHAR(50)
);

CREATE TABLE trinh_do(
ma_trinh_do INT PRIMARY KEY AUTO_INCREMENT,
ten_trinh_do VARCHAR(50)
);

CREATE TABLE bo_phan(
ma_bo_phan INT PRIMARY KEY AUTO_INCREMENT,
ten_bo_phan VARCHAR(50)
);

CREATE TABLE nhan_vien(
ma_nhan_vien INT PRIMARY KEY AUTO_INCREMENT,
ho_ten VARCHAR(50),
ngay_sinh DATE,
so_cmnd VARCHAR(50),
luong DOUBLE,
so_dien_thoai VARCHAR(50), 
email VARCHAR(50),
dia_chi VARCHAR(50),
ma_vi_tri INT,
ma_trinh_do INT,
ma_bo_phan INT,
FOREIGN KEY (ma_vi_tri) REFERENCES vi_tri(ma_vi_tri),
FOREIGN KEY (ma_trinh_do) REFERENCES trinh_do(ma_trinh_do),
FOREIGN KEY (ma_bo_phan) REFERENCES bo_phan(ma_bo_phan)
);

CREATE TABLE loai_khach(
ma_loai_khach INT PRIMARY KEY AUTO_INCREMENT ,
ten_loai_khach VARCHAR(50)
);

CREATE TABLE khach_hang (
ma_khach_hang INT PRIMARY KEY AUTO_INCREMENT,
ho_ten VARBINARY(50) NOT NULL,
ngay_sinh DATE NOT NULL,
gioi_tinh BIT(1) NOT NULL,
so_cmnd VARCHAR(50) NOT NULL,
so_dien_thoai VARCHAR(50) NOT NULL,
email VARBINARY(50),
dia_chi VARCHAR(50),
ma_loai_khach INT NOT NULL,
FOREIGN KEY (ma_loai_khach) REFERENCES loai_khach(ma_loai_khach)
);
ALTER TABLE khach_hang MODIFY COLUMN ho_ten VARCHAR(50);
ALTER TABLE khach_hang MODIFY COLUMN email VARCHAR(50);

CREATE TABLE kieu_thue (
ma_kieu_thue INT PRIMARY KEY AUTO_INCREMENT,
ten_kieu_thue VARCHAR(50)
);

CREATE TABLE loai_dich_vu (
ma_loai_dich_vu INT PRIMARY KEY AUTO_INCREMENT,
ten_loai_dich_vu VARCHAR(50)
);

CREATE TABLE dich_vu (
ma_dich_vu INT PRIMARY KEY AUTO_INCREMENT,
ten_dich_vu VARCHAR(50) NOT NULL,
dien_tich INT,
chi_phi_thue DOUBLE NOT NULL,
so_nguoi_toi_da INT,
tieu_chuan_phong VARCHAR(50),
mo_ta_tien_nghi_khac VARCHAR(50),
dien_tich_ho_boi DOUBLE,
so_tang INT,
ma_kieu_thue INT NOT NULL,
ma_loai_dich_vu INT NOT NULL,
FOREIGN KEY (ma_kieu_thue) REFERENCES kieu_thue(ma_kieu_thue),
FOREIGN KEY (ma_loai_dich_vu) REFERENCES loai_dich_vu (ma_loai_dich_vu)
);

CREATE TABLE hop_dong (
ma_hop_dong INT PRIMARY KEY AUTO_INCREMENT,
ngay_lam_hop_dong DATETIME NOT NULL,
ngay_ket_thuc DATETIME NOT NULL,
tien_dat_coc DOUBLE NOT NULL,
ma_nhan_vien INT NOT NULL,
ma_khach_hang INT NOT NULL,
ma_dich_vu INT NOT NULL,
FOREIGN KEY (ma_nhan_vien) REFERENCES nhan_vien(ma_nhan_vien),
FOREIGN KEY (ma_khach_hang) REFERENCES khach_hang(ma_khach_hang),
FOREIGN KEY (ma_dich_vu) REFERENCES dich_vu(ma_dich_vu)
);

CREATE TABLE dich_vu_di_kem (
ma_dich_vu_di_kem INT PRIMARY KEY AUTO_INCREMENT,
ten_dich_vu_di_kem VARCHAR(50) NOT NULL,
gia DOUBLE NOT NULL,
don_vi VARCHAR(10) NOT NULL,
trang_thai VARCHAR(50)
);

CREATE TABLE hop_dong_chi_tiet (
ma_hop_dong_chi_tiet INT PRIMARY KEY AUTO_INCREMENT,
so_luong INT NOT NULL,
ma_hop_dong INT,
ma_dich_vu_di_kem INT, 
FOREIGN KEY (ma_hop_dong) REFERENCES hop_dong(ma_hop_dong),
FOREIGN KEY (ma_dich_vu_di_kem) REFERENCES dich_vu_di_kem(ma_dich_vu_di_kem)
);