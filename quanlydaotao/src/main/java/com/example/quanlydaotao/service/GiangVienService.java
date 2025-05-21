package com.example.quanlydaotao.service;

import com.example.quanlydaotao.model.GiangVien;
import com.example.quanlydaotao.repository.GiangVienRepo;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class GiangVienService {

    @Autowired
    private GiangVienRepo giangVienRepo;

    public List<GiangVien> importFromExcel(MultipartFile file) throws IOException, IllegalArgumentException {
        List<GiangVien> giangViens = new ArrayList<>();
        try (InputStream inputStream = file.getInputStream();
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            if (rowIterator.hasNext()) {
                rowIterator.next();
            } else {
//                System.out.println(">>> No header row to skip.");
//                System.out.println(">>> rowIterator.hasNext() initially: " + rowIterator.hasNext());
            }

            while (rowIterator.hasNext()) {
                Row currentRow = rowIterator.next();
                GiangVien giangVien = createGiangVienFromRow(currentRow);
                if (giangVien != null) {
                    giangViens.add(giangVien);
                }
            }
        }
        return giangVienRepo.saveAll(giangViens);
    }


    private GiangVien createGiangVienFromRow(Row row) {
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            // MaGV
            Cell maGVCell = row.getCell(0);
            int maGV = (int) maGVCell.getNumericCellValue();

            // HoTen
            Cell hoTenCell = row.getCell(1);
            String hoTen = hoTenCell.getStringCellValue();

            // NgaySinh
            Cell ngaySinhCell = row.getCell(2);
            LocalDate ngaySinh;
            try {
                ngaySinh = ngaySinhCell.getDateCellValue().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
            } catch (Exception e) {
                ngaySinh = LocalDate.parse(ngaySinhCell.getStringCellValue(), dateFormatter);
            }

            // GioiTinh
            Cell gioiTinhCell = row.getCell(3);
            String gioiTinh = gioiTinhCell.getStringCellValue();

            // HocVi
            Cell hocViCell = row.getCell(4);
            String hocVi = hocViCell.getStringCellValue();

            // ChuyenNganh
            Cell chuyenNganhCell = row.getCell(5);
            String chuyenNganh = chuyenNganhCell.getStringCellValue();

            // SDT
            Cell sdtCell = row.getCell(6);
            String sdt = "";
            if (sdtCell.getCellType() == CellType.NUMERIC) {
                sdt = String.valueOf((long) sdtCell.getNumericCellValue());
            } else if (sdtCell.getCellType() == CellType.STRING) {
                sdt = sdtCell.getStringCellValue();
            }

            // Email
            Cell emailCell = row.getCell(7);
            String email = emailCell.getStringCellValue();

            return new GiangVien(maGV, hoTen, ngaySinh, gioiTinh, hocVi, chuyenNganh, sdt, email);
        } catch (Exception e) {
            return null;
        }
    }

    public byte[] exportToExcel() throws IOException {
        List<GiangVien> giangViens = giangVienRepo.findAll();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("GiangViens");

        // Tạo header row
        Row headerRow = sheet.createRow(0);
        String[] headers = {"Mã GV", "Họ và Tên", "Ngày Sinh", "Giới Tính", "Học Vị", "Chuyên Ngành", "SĐT", "Email"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Đổ dữ liệu
        int rowNum = 1;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (GiangVien gv : giangViens) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(gv.getMaGV());
            row.createCell(1).setCellValue(gv.getHoTen());
            row.createCell(2).setCellValue(gv.getNgaySinh().format(dateFormatter));
            row.createCell(3).setCellValue(gv.getGioiTinh());
            row.createCell(4).setCellValue(gv.getHocVi());
            row.createCell(5).setCellValue(gv.getChuyenNganh());
            row.createCell(6).setCellValue(gv.getSdt());
            row.createCell(7).setCellValue(gv.getEmail());
        }

        // Auto-size columns
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();
        return outputStream.toByteArray();
    }
}