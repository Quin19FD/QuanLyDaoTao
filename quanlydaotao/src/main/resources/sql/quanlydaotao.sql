-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 15, 2025 lúc 10:13 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlydaotao`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctdaotao`
--

CREATE TABLE `ctdaotao` (
  `mactdt` int(11) NOT NULL,
  `bac` varchar(255) NOT NULL,
  `banhanh` varchar(255) NOT NULL,
  `khoaquanly` varchar(255) NOT NULL,
  `loaibang` varchar(255) NOT NULL,
  `loaihinhdaotao` varchar(255) NOT NULL,
  `ngonngu` varchar(255) NOT NULL,
  `sotintoithieu` int(11) NOT NULL,
  `tenctdt` varchar(255) NOT NULL,
  `thoigian` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ctdaotao`
--

INSERT INTO `ctdaotao` (`mactdt`, `bac`, `banhanh`, `khoaquanly`, `loaibang`, `loaihinhdaotao`, `ngonngu`, `sotintoithieu`, `tenctdt`, `thoigian`) VALUES
(1, 'Đại học, Bậc 7/8 đối với đào tạo kỹ sư', 'Theo Quyết định số ...../QĐ-ĐHSG ngày 15 tháng 5 năm 2025 của Hiệu trưởng Đại học Sài Gòn', 'Công nghệ thông tin', 'Kỹ sư', 'Chính quy', 'Tiếng việt', 155, 'Chương trình đào tạo ngành công nghệ thông tin', 4.5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cthocphan`
--

CREATE TABLE `cthocphan` (
  `lythuyet` int(11) NOT NULL,
  `thuchanh` int(11) NOT NULL,
  `thuctap` int(11) NOT NULL,
  `mahocphan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `cthocphan`
--

INSERT INTO `cthocphan` (`lythuyet`, `thuchanh`, `thuctap`, `mahocphan`) VALUES
(45, 0, 0, '861301');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctkhung`
--

CREATE TABLE `ctkhung` (
  `makhung` int(11) NOT NULL,
  `mactdt` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ctkhung`
--

INSERT INTO `ctkhung` (`makhung`, `mactdt`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danhgiabophan`
--

CREATE TABLE `danhgiabophan` (
  `madiemdanhgia` int(11) NOT NULL,
  `hinhthucdanhgia` varchar(255) NOT NULL,
  `trongso` float NOT NULL,
  `mabophan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `danhgiabophan`
--

INSERT INTO `danhgiabophan` (`madiemdanhgia`, `hinhthucdanhgia`, `trongso`, `mabophan`) VALUES
(1, '', 0.4, '1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `decuongchitiet`
--

CREATE TABLE `decuongchitiet` (
  `mabophan` varchar(255) NOT NULL,
  `tenbophan` varchar(255) NOT NULL,
  `mactdt` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `decuongchitiet`
--

INSERT INTO `decuongchitiet` (`mabophan`, `tenbophan`, `mactdt`) VALUES
('1', 'Đánh giá quá trình', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giangvien`
--

CREATE TABLE `giangvien` (
  `magv` int(11) NOT NULL,
  `congtackhac` varchar(255) DEFAULT NULL,
  `hocvi` varchar(255) NOT NULL,
  `namsinh` varchar(255) NOT NULL,
  `tengv` varchar(255) NOT NULL,
  `tongclc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `giangvien`
--

INSERT INTO `giangvien` (`magv`, `congtackhac`, `hocvi`, `namsinh`, `tengv`, `tongclc`) VALUES
(1, '367', 'PGS, TS, GVCC', '1972', 'Phạm Thế Bảo', 368);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hocphan`
--

CREATE TABLE `hocphan` (
  `mahocphan` varchar(255) NOT NULL,
  `he_so` float NOT NULL,
  `machuyennganh` int(11) NOT NULL,
  `so_tin_chi` int(11) NOT NULL,
  `ten_hoc_phan` varchar(255) NOT NULL,
  `mactdt` int(11) NOT NULL,
  `makhoikienthuc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `hocphan`
--

INSERT INTO `hocphan` (`mahocphan`, `he_so`, `machuyennganh`, `so_tin_chi`, `ten_hoc_phan`, `mactdt`, `makhoikienthuc`) VALUES
('861301', 1, 1, 3, 'Triết học Mác - Lênin', 1, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `kehoachdayhoc`
--

CREATE TABLE `kehoachdayhoc` (
  `makehoach` int(11) NOT NULL,
  `mahocphan` varchar(255) NOT NULL,
  `mahocphantruoc` varchar(255) DEFAULT NULL,
  `mapc` int(11) NOT NULL,
  `mactdt` int(11) NOT NULL,
  `hockythuchien` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `kehoachdayhoc`
--

INSERT INTO `kehoachdayhoc` (`makehoach`, `mahocphan`, `mahocphantruoc`, `mapc`, `mactdt`, `hockythuchien`) VALUES
(1, '861301', NULL, 1, 1, '2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khoikienthuc`
--

CREATE TABLE `khoikienthuc` (
  `makhoikienthuc` int(11) NOT NULL,
  `tinbatbuoc` int(11) NOT NULL,
  `tintuchon` int(11) NOT NULL,
  `makhung` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `khoikienthuc`
--

INSERT INTO `khoikienthuc` (`makhoikienthuc`, `tinbatbuoc`, `tintuchon`, `makhung`) VALUES
(1, 12, 2, 1),
(2, 9, 0, 1),
(3, 11, 0, 1),
(4, 14, 0, 1),
(5, 37, 0, 1),
(6, 37, 16, 1),
(7, 16, 15, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhomlop`
--

CREATE TABLE `nhomlop` (
  `manhom` int(11) NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `sltoida` int(11) NOT NULL,
  `mahocphan` varchar(255) NOT NULL,
  `mapc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhomlop`
--

INSERT INTO `nhomlop` (`manhom`, `diachi`, `sltoida`, `mahocphan`, `mapc`) VALUES
(1, 'C.E502', 100, '861301', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phanconggiangday`
--

CREATE TABLE `phanconggiangday` (
  `mapc` int(11) NOT NULL,
  `hesohocphan` float NOT NULL,
  `khoahoc` varchar(255) NOT NULL,
  `slsvmotnhom` int(11) NOT NULL,
  `sotietthucte` int(11) NOT NULL,
  `tongsonhom` int(11) NOT NULL,
  `magv` int(11) NOT NULL,
  `mahocphan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phanconggiangday`
--

INSERT INTO `phanconggiangday` (`mapc`, `hesohocphan`, `khoahoc`, `slsvmotnhom`, `sotietthucte`, `tongsonhom`, `magv`, `mahocphan`) VALUES
(1, 0.45, '22', 100, 40, 1, 1, '861301');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `username` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `namsinh` bigint(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sdt` varchar(255) DEFAULT NULL,
  `tenuser` varchar(255) DEFAULT NULL,
  `trangthai` int(11) DEFAULT NULL,
  `vaitro` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`username`, `email`, `namsinh`, `password`, `sdt`, `tenuser`, `trangthai`, `vaitro`) VALUES
('3122410043', 'cuong10a07@gmail.com', 20, 'cuong11a07', '0818707056', 'Cao Tiến Cường', 1, 'student'),
('cuonghero9a', 'cuongcaotien9a@gmail.com', 20, 'cuong10a07', '0962385165', 'Cao Tien Cuong', 1, 'admin'),
('gvsgu001', 'cuongcuong@gmail.com', 20, 'cuong12a07', '0812345697', 'Cao Cường', 1, 'teacher');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ctdaotao`
--
ALTER TABLE `ctdaotao`
  ADD PRIMARY KEY (`mactdt`);

--
-- Chỉ mục cho bảng `cthocphan`
--
ALTER TABLE `cthocphan`
  ADD PRIMARY KEY (`mahocphan`);

--
-- Chỉ mục cho bảng `ctkhung`
--
ALTER TABLE `ctkhung`
  ADD PRIMARY KEY (`makhung`),
  ADD KEY `FKhtdahybb9xnu8lyotaiop29x6` (`mactdt`);

--
-- Chỉ mục cho bảng `danhgiabophan`
--
ALTER TABLE `danhgiabophan`
  ADD PRIMARY KEY (`madiemdanhgia`),
  ADD KEY `FKgm6k29pkd972mr55jvjjlpey7` (`mabophan`);

--
-- Chỉ mục cho bảng `decuongchitiet`
--
ALTER TABLE `decuongchitiet`
  ADD PRIMARY KEY (`mabophan`),
  ADD KEY `FK4ri4bc4cqv4jsnr2bs43kw81w` (`mactdt`);

--
-- Chỉ mục cho bảng `giangvien`
--
ALTER TABLE `giangvien`
  ADD PRIMARY KEY (`magv`);

--
-- Chỉ mục cho bảng `hocphan`
--
ALTER TABLE `hocphan`
  ADD PRIMARY KEY (`mahocphan`),
  ADD KEY `FK45kan28215jh1mq283yucnt8m` (`mactdt`),
  ADD KEY `FKpyrfrf4sj4k8w0ytuerikvspe` (`makhoikienthuc`);

--
-- Chỉ mục cho bảng `kehoachdayhoc`
--
ALTER TABLE `kehoachdayhoc`
  ADD PRIMARY KEY (`makehoach`),
  ADD UNIQUE KEY `UK_jn4q8dubaecorthblrtxgimdt` (`mahocphantruoc`),
  ADD KEY `FKgylxq85exhc9mjla7914l20ox` (`mahocphan`),
  ADD KEY `FK215u29dfx153viivtehqlrv21` (`mapc`),
  ADD KEY `FKq08gw8uk6swhqqtwfrgwl6gpw` (`mactdt`);

--
-- Chỉ mục cho bảng `khoikienthuc`
--
ALTER TABLE `khoikienthuc`
  ADD PRIMARY KEY (`makhoikienthuc`),
  ADD KEY `FK26kyauugeu41dvh0o0b7uiwla` (`makhung`);

--
-- Chỉ mục cho bảng `nhomlop`
--
ALTER TABLE `nhomlop`
  ADD PRIMARY KEY (`manhom`),
  ADD KEY `FKdb50kmh4ipubeojgt2s80vihi` (`mahocphan`),
  ADD KEY `FK3uolbiimagibqc96lcpu3smv8` (`mapc`);

--
-- Chỉ mục cho bảng `phanconggiangday`
--
ALTER TABLE `phanconggiangday`
  ADD PRIMARY KEY (`mapc`),
  ADD KEY `FK9tr2x4d6fg4uxanasgmn844hq` (`magv`),
  ADD KEY `FKowtfa0yk8n5la59a6tmtbuc5k` (`mahocphan`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `kehoachdayhoc`
--
ALTER TABLE `kehoachdayhoc`
  MODIFY `makehoach` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `khoikienthuc`
--
ALTER TABLE `khoikienthuc`
  MODIFY `makhoikienthuc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `cthocphan`
--
ALTER TABLE `cthocphan`
  ADD CONSTRAINT `FKej3qnanitbgx7g3e6kw37275o` FOREIGN KEY (`mahocphan`) REFERENCES `hocphan` (`mahocphan`);

--
-- Các ràng buộc cho bảng `ctkhung`
--
ALTER TABLE `ctkhung`
  ADD CONSTRAINT `FKhtdahybb9xnu8lyotaiop29x6` FOREIGN KEY (`mactdt`) REFERENCES `ctdaotao` (`mactdt`);

--
-- Các ràng buộc cho bảng `danhgiabophan`
--
ALTER TABLE `danhgiabophan`
  ADD CONSTRAINT `FKgm6k29pkd972mr55jvjjlpey7` FOREIGN KEY (`mabophan`) REFERENCES `decuongchitiet` (`mabophan`);

--
-- Các ràng buộc cho bảng `decuongchitiet`
--
ALTER TABLE `decuongchitiet`
  ADD CONSTRAINT `FK4ri4bc4cqv4jsnr2bs43kw81w` FOREIGN KEY (`mactdt`) REFERENCES `ctdaotao` (`mactdt`);

--
-- Các ràng buộc cho bảng `hocphan`
--
ALTER TABLE `hocphan`
  ADD CONSTRAINT `FK45kan28215jh1mq283yucnt8m` FOREIGN KEY (`mactdt`) REFERENCES `ctdaotao` (`mactdt`),
  ADD CONSTRAINT `FKpyrfrf4sj4k8w0ytuerikvspe` FOREIGN KEY (`makhoikienthuc`) REFERENCES `khoikienthuc` (`makhoikienthuc`);

--
-- Các ràng buộc cho bảng `kehoachdayhoc`
--
ALTER TABLE `kehoachdayhoc`
  ADD CONSTRAINT `FK215u29dfx153viivtehqlrv21` FOREIGN KEY (`mapc`) REFERENCES `phanconggiangday` (`mapc`),
  ADD CONSTRAINT `FK2bjb9levics4r9gr81tkv58vn` FOREIGN KEY (`mahocphantruoc`) REFERENCES `hocphan` (`mahocphan`),
  ADD CONSTRAINT `FKgylxq85exhc9mjla7914l20ox` FOREIGN KEY (`mahocphan`) REFERENCES `hocphan` (`mahocphan`),
  ADD CONSTRAINT `FKq08gw8uk6swhqqtwfrgwl6gpw` FOREIGN KEY (`mactdt`) REFERENCES `ctdaotao` (`mactdt`);

--
-- Các ràng buộc cho bảng `khoikienthuc`
--
ALTER TABLE `khoikienthuc`
  ADD CONSTRAINT `FK26kyauugeu41dvh0o0b7uiwla` FOREIGN KEY (`makhung`) REFERENCES `ctkhung` (`makhung`);

--
-- Các ràng buộc cho bảng `nhomlop`
--
ALTER TABLE `nhomlop`
  ADD CONSTRAINT `FK3uolbiimagibqc96lcpu3smv8` FOREIGN KEY (`mapc`) REFERENCES `phanconggiangday` (`mapc`),
  ADD CONSTRAINT `FKdb50kmh4ipubeojgt2s80vihi` FOREIGN KEY (`mahocphan`) REFERENCES `hocphan` (`mahocphan`);

--
-- Các ràng buộc cho bảng `phanconggiangday`
--
ALTER TABLE `phanconggiangday`
  ADD CONSTRAINT `FK9tr2x4d6fg4uxanasgmn844hq` FOREIGN KEY (`magv`) REFERENCES `giangvien` (`magv`),
  ADD CONSTRAINT `FKowtfa0yk8n5la59a6tmtbuc5k` FOREIGN KEY (`mahocphan`) REFERENCES `hocphan` (`mahocphan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
