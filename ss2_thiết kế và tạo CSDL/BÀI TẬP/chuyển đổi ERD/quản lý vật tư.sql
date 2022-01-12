CREATE DATABASE quan_lu_vat_tu;
USE quan_ly_vat_tu;

CREATE TABLE phieu_xuat(
so_px INT PRIMARY KEY,
ngay_xuat DATETIME
);

CREATE TABLE vat_tu(
ma_vat_tu INT PRIMARY KEY,
ten_vat_tu VARCHAR(50)
);

CREATE TABLE chi_tiet_phieu_xuat(
dg_xuat INT,
sl_xuat INT,
so_px INT,
ma_vat_tu INT,
PRIMARY KEY(so_px,ma_vat_tu),
FOREIGN KEY(so_px) REFERENCES phieu_xuat(so_px),
FOREIGN KEY(ma_vat_tu) REFERENCES vat_tu(ma_vat_tu)
);

CREATE TABLE phieu_nhap(
so_pn INT PRIMARY KEY,
ngay_nhap DATETIME
);

CREATE TABLE chi_tiet_phieu_nhap(
dg_nhap INT,
sl_nhap INT,
ma_vat_tu INT,
so_pn INT,
PRIMARY KEY(ma_vat_tu,so_pn),
FOREIGN KEY(ma_vat_tu) REFERENCES vat_tu(ma_vat_tu),
FOREIGN KEY(so_pn) REFERENCES phieu_nhap(so_pn)
);

CREATE TABLE don_dat_hang(
so_dh INT PRIMARY KEY,
ngay_dh DATETIME,
ma_ncc INT,
FOREIGN KEY(ma_ncc) REFERENCES nha_cung_cap(ma_ncc)
);

CREATE TABLE chi_tiet_don_dat_hang(
ma_vat_tu INT,
so_dh INT,
PRIMARY KEY(ma_vat_tu,so_dh),
FOREIGN KEY(ma_vat_tu) REFERENCES vat_tu(ma_vat_tu),
FOREIGN KEY(so_dh) REFERENCES don_dat_hang(so_dh)
);

CREATE TABLE nha_cung_cap(
ma_ncc INT PRIMARY KEY,
ten_ncc VARCHAR(50),
dia_chi VARCHAR(50)
);

CREATE TABLE phone(
code_phone INT PRIMARY KEY AUTO_INCREMENT,
`phone` VARCHAR(10),
ma_ncc INT,
FOREIGN KEY(ma_ncc) REFERENCES nha_cung_cap(ma_ncc)
);