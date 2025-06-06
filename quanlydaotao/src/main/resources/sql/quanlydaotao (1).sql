-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 22, 2025 lúc 08:55 AM
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
(1, 'Đại học, Bậc 7/8 đối với đào tạo kỹ sư', 'Theo Quyết định số ...../QĐ-ĐHSG ngày 15 tháng 5 năm 2025 của Hiệu trưởng Đại học Sài Gòn', 'Công nghệ thông tin', 'Kỹ sư', 'Chính quy', 'Tiếng việt', 155, 'Chương trình đào tạo ngành công nghệ thông tin', 4.5),
(2, 'Đại học, Bậc 7/8 đối với đào tạo kỹ sư', 'Theo Quyết định số ...../QĐ-ĐHSG ngày 15 tháng 5 năm 2025 của Hiệu trưởng Đại học Sài Gòn', 'Điện tử viễn thông', 'Kỹ sư', 'Chính quy', 'Tiếng việt', 155, 'Chương trình đào tạo ngành điện tử viễn thông', 4.5),
(3, 'Đại học, Bậc 7/8 đối với đào tạo cử nhân', 'Theo Quyết định số ...../QĐ-ĐHSG ngày 15 tháng 5 năm 2025 của Hiệu trưởng Đại học Sài Gòn', 'Quản trị kinh doanh', 'Cử nhân', 'Chính quy', 'Tiếng việt', 130, 'Chương trình đào tạo ngành quản trị kinh doanh', 4),
(4, 'Đại học, Bậc cử nhân', 'Theo Quyết định số ...../QĐ-ĐHSG ngày 15 tháng 5 năm 2025 của Hiệu trưởng Đại học Sài Gòn', 'Tài chính - Kế toán', 'Cử nhân', 'Chính quy', 'Tiếng việt', 130, 'Chương trình đào tạo ngành tài chính - kế toán', 4);

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
(30, 0, 0, '361302'),
(30, 0, 0, '361303'),
(30, 0, 0, '361304'),
(30, 0, 0, '361305'),
(15, 30, 0, '841020'),
(30, 30, 0, '841047'),
(0, 0, 90, '841070'),
(45, 0, 0, '841310'),
(30, 30, 0, '841408'),
(30, 30, 0, '841411'),
(30, 30, 0, '841413'),
(45, 0, 0, '841414'),
(30, 30, 0, '841449'),
(30, 30, 0, '841481'),
(45, 0, 0, '861301'),
(2, 28, 0, '862101'),
(37, 8, 0, '862406'),
(22, 8, 0, '862407'),
(14, 16, 0, '862408'),
(4, 56, 0, '862409'),
(45, 0, 0, '864005'),
(45, 0, 0, '864006'),
(45, 0, 0, '864007'),
(45, 0, 0, '864508'),
(30, 0, 0, '865006'),
(45, 0, 0, '866401'),
(45, 0, 0, '866402'),
(45, 0, 0, '866403');

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
(1, 1),
(2, 2),
(3, 3),
(4, 4);

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
(1, 'Điểm quá trình (1.1 + 1.2)', 0.4, 'DGQT'),
(2, 'Điểm chuyên cần, thái độ học tập', 0.1, 'YTH_BP'),
(3, 'Điểm bài tập (ở nhà/trên lớp/bài tập lớn)', 0.1, 'HSTS_BP'),
(4, 'Điểm thuyết trình, thực hành, thảo luận', 0, 'HSTS_BP'),
(5, 'Điểm làm việc nhóm', 0, 'HSTS_BP'),
(6, 'Điểm kiểm tra giữa kỳ', 0.2, 'HSTS_BP'),
(7, 'Điểm cuối kỳ (≥ 0.5)', 0.5, 'DGCK_BP'),
(8, 'Thi tự luận', 0, 'DGCK_BP'),
(9, 'Điểm thành phần 1', 0.2, 'DGQT_CT'),
(10, 'Điểm thành phần 2', 0.2, 'DGQT_CT');

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
('DGCK_BP', 'Đánh giá cuối kỳ', 1),
('DGQT', 'Đánh giá quá trình', 1),
('DGQT_CT', 'Đánh giá quá trình chi tiết', 1),
('HSTS_BP', 'Hồ sơ học tập', 1),
('YTH_BP', 'Ý thức học tập', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giangvien`
--

CREATE TABLE `giangvien` (
  `magv` int(11) NOT NULL,
  `hoten` varchar(255) NOT NULL,
  `ngaysinh` date NOT NULL,
  `gioitinh` enum('Nam','Nữ','Khác') NOT NULL,
  `hocvi` varchar(100) NOT NULL,
  `chuyennganh` varchar(255) NOT NULL,
  `sdt` varchar(20) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `giangvien`
--

INSERT INTO `giangvien` (`magv`, `hoten`, `ngaysinh`, `gioitinh`, `hocvi`, `chuyennganh`, `sdt`, `email`) VALUES
(1, 'Nguyễn Văn An', '1980-05-12', 'Nam', 'TS', 'Công nghệ phần mềm', '0912345678', 'an.nguyen@abc.edu.vn'),
(2, 'Trần Thị Bình', '1975-09-20', 'Nữ', 'ThS', 'Mạng máy tính', '0987654321', 'binh.tran@abc.edu.vn'),
(3, 'Lê Văn Cường', '1982-03-11', 'Nam', 'TS', 'Trí tuệ nhân tạo', '0905123456', 'cuong.le@abc.edu.vn'),
(4, 'Phạm Thị Dung', '1985-08-25', 'Nữ', 'ThS', 'Khoa học dữ liệu', '0934567890', 'dung.pham@abc.edu.vn'),
(5, 'Đỗ Mạnh Hùng', '1979-12-30', 'Nam', 'PGS.TS', 'Hệ thống thông tin', '0975123456', 'hung.do@abc.edu.vn'),
(6, 'Ngô Thị Hoa', '1987-04-15', 'Nữ', 'ThS', 'Kỹ thuật phần mềm', '0911223344', 'hoa.ngo@abc.edu.vn'),
(7, 'Vũ Văn Thành', '1981-10-18', 'Nam', 'TS', 'Lập trình Web', '0909223344', 'thanh.vu@abc.edu.vn'),
(8, 'Hoàng Thị Lan', '1990-06-07', 'Nữ', 'ThS', 'Cơ sở dữ liệu', '0944556677', 'lan.hoang@abc.edu.vn'),
(9, 'Nguyễn Minh Tâm', '1984-02-01', 'Nam', 'TS', 'Phân tích hệ thống', '0933445566', 'tam.nguyen@abc.edu.vn'),
(10, 'Lương Hải Yến', '1986-09-13', 'Nữ', 'TS', 'Hệ điều hành', '0966778899', 'yen.luong@abc.edu.vn'),
(11, 'Trịnh Văn Nam', '1977-11-22', 'Nam', 'PGS.TS', 'Mạng và bảo mật', '0977334466', 'nam.trinh@abc.edu.vn'),
(12, 'Phan Thị Thảo', '1988-01-16', 'Nữ', 'ThS', 'Công nghệ thông tin', '0911557799', 'thao.phan@abc.edu.vn'),
(13, 'Đặng Minh Hòa', '1983-05-19', 'Nam', 'TS', 'Kỹ thuật máy tính', '0933557799', 'hoa.dang@abc.edu.vn'),
(14, 'Trương Thị Mai', '1992-07-09', 'Nữ', 'ThS', 'Công nghệ Web', '0908664466', 'mai.truong@abc.edu.vn'),
(15, 'Nguyễn Quốc Bảo', '1980-12-03', 'Nam', 'TS', 'Phát triển phần mềm', '0944778822', 'bao.nguyen@abc.edu.vn'),
(16, 'Lý Thị Kim', '1989-08-27', 'Nữ', 'ThS', 'Trí tuệ nhân tạo', '0977665544', 'kim.ly@abc.edu.vn'),
(17, 'Hồ Minh Tuấn', '1982-06-30', 'Nam', 'TS', 'Phần mềm nhúng', '0933441122', 'tuan.ho@abc.edu.vn'),
(18, 'Đinh Thị Quyên', '1991-03-23', 'Nữ', 'ThS', 'Hệ thống thông tin quản lý', '0912443355', 'quyen.dinh@abc.edu.vn'),
(19, 'Bùi Văn Sơn', '1985-01-10', 'Nam', 'TS', 'Cơ sở dữ liệu nâng cao', '0955667788', 'son.bui@abc.edu.vn'),
(20, 'Tạ Thị Hằng', '1990-11-05', 'Nữ', 'ThS', 'Lập trình hướng đối tượng', '0966998877', 'hang.ta@abc.edu.vn');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hocphan`
--

CREATE TABLE `hocphan` (
  `mahocphan` varchar(255) NOT NULL,
  `he_so` float NOT NULL,
  `machuyennganh` varchar(100) NOT NULL,
  `so_tin_chi` int(11) NOT NULL,
  `ten_hoc_phan` varchar(255) NOT NULL,
  `mactdt` int(11) NOT NULL,
  `makhoikienthuc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `hocphan`
--

INSERT INTO `hocphan` (`mahocphan`, `he_so`, `machuyennganh`, `so_tin_chi`, `ten_hoc_phan`, `mactdt`, `makhoikienthuc`) VALUES
('361302', 1, '', 2, 'Kinh tế chính trị Mác - Lênin', 1, 3),
('361303', 1, '', 2, 'Chủ nghĩa xã hội khoa học', 1, 3),
('361304', 1, '', 2, 'Tư tưởng Hồ Chí Minh', 1, 3),
('361305', 1, '', 2, 'Lịch sử Đảng Cộng sản Việt Nam', 1, 3),
('841020', 1, '', 3, 'Cơ sở lập trình', 1, 5),
('841047', 1, '', 4, 'Công nghệ phần mềm', 1, 6),
('841070', 1, '', 6, 'Thực tập tốt nghiệp', 1, 6),
('841310', 1, '', 3, 'Lý thuyết đồ thị', 1, 6),
('841408', 1, 'Kỹ thuật phần mềm', 4, 'Kiểm thử phần mềm', 1, 7),
('841411', 1, 'Kỹ thuật máy tính', 4, 'Quản trị mạng', 1, 7),
('841413', 1, 'Hệ thống thông tin', 4, 'Cơ sở dữ liệu phân tán', 1, 7),
('841414', 1, '', 3, 'Thiết kế và phân tích giải thuật', 1, 6),
('841449', 1, 'Khoa học máy tính', 4, 'Nhập môn máy học', 1, 7),
('841481', 1, 'Kỹ thuật phần mềm', 4, 'Thiết kế giao diện', 1, 7),
('861301', 1, '', 3, 'Triết học Mác – Lênin', 1, 3),
('862101', 1, '', 1, 'Giáo dục thể chất (I)', 1, 1),
('862406', 1, '', 3, 'Giáo dục quốc phòng và an ninh I', 1, 1),
('862407', 1, '', 2, 'Giáo dục quốc phòng và an ninh II', 1, 1),
('862408', 1, '', 2, 'Giáo dục quốc phòng và an ninh III', 1, 1),
('862409', 1, '', 4, 'Giáo dục quốc phòng và an ninh IV', 1, 1),
('864005', 1, '', 3, 'Giải tích 1', 1, 5),
('864006', 1, '', 3, 'Giải tích 2', 1, 5),
('864007', 1, '', 3, 'Đại số tuyến tính', 1, 5),
('864508', 1, '', 3, 'Xác suất thống kê', 1, 5),
('865006', 1, '', 2, 'Pháp luật đại cương', 1, 4),
('866401', 1, '', 3, 'Tiếng Anh 1', 1, 2),
('866402', 1, '', 3, 'Tiếng Anh 2', 1, 2),
('866403', 1, '', 3, 'Tiếng Anh 3', 1, 2);

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
(2, '861302', '861301', 2, 1, '2'),
(3, '861303', NULL, 3, 1, '2'),
(4, '861304', NULL, 4, 1, '2'),
(5, '861305', NULL, 5, 1, '2'),
(6, '866401', NULL, 6, 1, '3'),
(7, '866402', '866401', 7, 1, '3'),
(8, '866403', '866402', 8, 1, '3'),
(9, '865506', NULL, 9, 1, '2'),
(10, '864508', NULL, 10, 1, '3'),
(11, '864405', NULL, 11, 1, '2'),
(12, '864406', '864405', 12, 1, '3'),
(13, '864407', NULL, 13, 1, '2'),
(14, 'CNTT1001', NULL, 14, 1, '1'),
(15, 'CNTT1002', 'CNTT1001', 15, 1, '2'),
(16, 'CNTT1003', NULL, 16, 1, '1'),
(17, 'CNTT2001', 'CNTT1001', 17, 1, '3'),
(18, 'CNTT2002', 'CNTT1002', 18, 1, '3'),
(19, 'CNTT2003', 'CNTT1003', 19, 1, '2'),
(20, 'CNTT3001', 'CNTT2001', 20, 1, '4'),
(21, 'CNTT3002', 'CNTT2002', 21, 1, '4'),
(22, 'CNTT3003', 'CNTT2003', 22, 1, '3');

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
(7, 16, 15, 1),
(8, 12, 2, 2),
(9, 9, 0, 2),
(10, 11, 0, 2),
(11, 14, 0, 2),
(12, 37, 0, 2),
(13, 37, 16, 2),
(14, 16, 15, 2),
(15, 12, 2, 3),
(16, 9, 0, 3),
(17, 11, 0, 3),
(18, 14, 0, 3),
(19, 37, 0, 3),
(20, 37, 16, 3),
(21, 16, 15, 3),
(22, 12, 2, 4),
(23, 9, 0, 4),
(24, 11, 0, 4),
(25, 14, 0, 4),
(26, 37, 0, 4),
(27, 37, 16, 4),
(28, 16, 15, 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhomlop`
--

CREATE TABLE `nhomlop` (
  `manhom` int(11) NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `sltoida` int(11) NOT NULL,
  `thudi` varchar(255) NOT NULL,
  `tietbatdau` int(11) NOT NULL,
  `sotiet` int(11) NOT NULL,
  `mahocphan` varchar(255) NOT NULL,
  `mapc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhomlop`
--

INSERT INTO `nhomlop` (`manhom`, `diachi`, `sltoida`, `thudi`, `tietbatdau`, `sotiet`, `mahocphan`, `mapc`) VALUES
(1, 'C.E102', 100, 'Thứ 2', 7, 3, '861301', 2),
(2, 'C.A101', 80, 'Thứ 3, Thứ 5', 1, 2, '861302', 2),
(3, 'C.C205', 90, 'Thứ 4', 3, 2, '861303', 3),
(4, 'C.B301', 75, 'Thứ 6', 8, 3, '861304', 4),
(5, 'C.D402', 110, 'Thứ 2', 1, 3, '861305', 5),
(6, 'C.A103', 60, 'Thứ 5', 6, 2, '866401', 6),
(7, 'C.A201', 85, 'Thứ 3', 9, 2, '866402', 7),
(8, 'C.A306', 95, 'Thứ 4, Thứ 6', 4, 2, '866403', 8),
(9, 'C.E404', 70, 'Thứ 2', 1, 2, '865506', 9),
(10, 'C.B102', 105, 'Thứ 5', 7, 3, '864508', 10),
(11, 'C.B203', 88, 'Thứ 3', 3, 3, '864405', 11),
(12, 'C.A302', 92, 'Thứ 6', 6, 2, '864406', 12),
(13, 'C.A401', 78, 'Thứ 4', 8, 2, '864407', 13),
(14, 'C.C105', 120, 'Thứ 2, Thứ 4', 2, 3, 'CNTT1001', 14),
(15, 'C.C202', 82, 'Thứ 5', 9, 2, 'CNTT1002', 15),
(16, 'C.D304', 98, 'Thứ 3', 6, 3, 'CNTT1003', 16),
(17, 'C.D403', 72, 'Thứ 6', 1, 3, 'CNTT2001', 17),
(18, 'C.E104', 115, 'Thứ 2', 4, 2, 'CNTT2002', 18),
(19, 'C.E206', 86, 'Thứ 4, Thứ 5', 7, 2, 'CNTT2003', 19),
(20, 'C.B303', 91, 'Thứ 3', 1, 4, 'CNTT3001', 20),
(21, 'C.E405', 77, 'Thứ 6', 5, 3, 'CNTT3002', 21),
(22, 'C.A106', 102, 'Thứ 2', 8, 3, 'CNTT3003', 22);

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
(1, 1, 'Học kỳ 1', 9, 45, 1, 1, '861301'),
(2, 1, 'Học kỳ 1', 50, 50, 1, 12, '841481');

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
-- AUTO_INCREMENT cho bảng `khoikienthuc`
--
ALTER TABLE `khoikienthuc`
  MODIFY `makhoikienthuc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
