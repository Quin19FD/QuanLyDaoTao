package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.model.*;
import com.example.quanlydaotao.repository.PhanCongGiangDayRepo;
import com.example.quanlydaotao.repository.GiangVienRepo;
import com.example.quanlydaotao.repository.HocPhanRepo;
import com.example.quanlydaotao.service.TaiKhoanService;
import org.apache.catalina.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/phanconggiangday")
public class PhanCongGiangDayController {

    @Autowired
    private PhanCongGiangDayRepo phanCongGiangDayRepo;

    @Autowired
    private GiangVienRepo giangVienRepo;

    @Autowired
    private HocPhanRepo hocPhanRepo;

    // Lấy tất cả phân công với thông tin đầy đủ
    @GetMapping
    @EntityGraph(attributePaths = {"maGV", "maHocPhan"})
    public ResponseEntity<?> getAllPhanCong() {
        try {
            List<PhanCongGiangDay> list = phanCongGiangDayRepo.findAll();

            if (list == null || list.isEmpty()) {
                return ResponseEntity.ok(Collections.emptyList());
            }

            // Tạo DTO đơn giản để tránh lỗi serialization
            List<Map<String, Object>> result = list.stream().map(pc -> {
                Map<String, Object> dto = new HashMap<>();
                dto.put("maPC", pc.getMaPC());
                dto.put("khoaHoc", pc.getKhoaHoc());
                dto.put("heSoHP", pc.getHeSoHP());
                dto.put("tongSoNhom", pc.getTongSoNhom());
                dto.put("slSVMotNhom", pc.getSlSVMotNhom());
                dto.put("soTietThucTe", pc.getSoTietThucTe());

                // Xử lý giảng viên
                Map<String, Object> gv = new HashMap<>();
                if (pc.getMaGV() != null) {
                    gv.put("maGV", pc.getMaGV().getMaGV());
                    gv.put("hoTen", pc.getMaGV().getHoTen());
                }
                dto.put("maGV", gv);

                // Xử lý học phần
                Map<String, Object> hp = new HashMap<>();
                if (pc.getMaHocPhan() != null) {
                    hp.put("maHocPhan", pc.getMaHocPhan().getMaHocPhan());
                    hp.put("tenHocPhan", pc.getMaHocPhan().getTenHocPhan());
                    hp.put("soTinChi", pc.getMaHocPhan().getSoTinChi());
                }
                dto.put("maHocPhan", hp);

                return dto;
            }).collect(Collectors.toList());

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of(
                            "error", "Lỗi khi lấy danh sách phân công",
                            "message", e.getMessage()
                    ));
        }
    }

    // Lấy phân công theo mã với đầy đủ thông tin
    @GetMapping("/{maPC}")
    @EntityGraph(attributePaths = {"maGV", "maHocPhan"})
    public ResponseEntity<?> getPhanCongById(@PathVariable int maPC) {
        return phanCongGiangDayRepo.findByMaPC(maPC)
                .map(pc -> {
                    // Đảm bảo không null
                    if (pc.getMaGV() == null) pc.setMaGV(new GiangVien());
                    if (pc.getMaHocPhan() == null) pc.setMaHocPhan(new HocPhan());
                    return ResponseEntity.ok(pc);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/exists/{maPC}")
    public ResponseEntity<Boolean> checkMaPCExists(@PathVariable int maPC) {
        boolean exists = phanCongGiangDayRepo.existsByMaPC(maPC);
        return ResponseEntity.ok(exists);
    }


    // Thêm phân công mới
    @PostMapping
    public ResponseEntity<?> createPhanCong(@RequestBody PhanCongGiangDay phanCong) {
        try {
            // Validate input
            if (phanCong.getMaGV() == null || phanCong.getMaHocPhan() == null) {
                return ResponseEntity.badRequest().body("Thiếu thông tin giảng viên hoặc học phần");
            }

            // Kiểm tra tồn tại giảng viên
            Optional<GiangVien> gvOpt = giangVienRepo.findById(phanCong.getMaGV().getMaGV());
            if (gvOpt.isEmpty()) {
                return ResponseEntity.badRequest().body("Không tìm thấy giảng viên với mã: " + phanCong.getMaGV().getMaGV());
            }

            // Kiểm tra tồn tại học phần
            Optional<HocPhan> hpOpt = hocPhanRepo.findById(phanCong.getMaHocPhan().getMaHocPhan());
            if (hpOpt.isEmpty()) {
                return ResponseEntity.badRequest().body("Không tìm thấy học phần với mã: " + phanCong.getMaHocPhan().getMaHocPhan());
            }

            // Set đầy đủ thông tin
            phanCong.setMaGV(gvOpt.get());
            phanCong.setMaHocPhan(hpOpt.get());

            // Validate business rules
            if (phanCong.getTongSoNhom() <= 0 || phanCong.getSlSVMotNhom() <= 0) {
                return ResponseEntity.badRequest().body("Số nhóm và số SV phải lớn hơn 0");
            }

            PhanCongGiangDay saved = phanCongGiangDayRepo.save(phanCong);
            return ResponseEntity.ok(saved);

        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Lỗi khi thêm phân công: " + e.getMessage());
        }
    }

    // Cập nhật phân công
    @PutMapping("/{maPC}")
    @EntityGraph(attributePaths = {"maGV", "maHocPhan"})
    public ResponseEntity<?> updatePhanCong(@PathVariable int maPC, @RequestBody PhanCongGiangDay phanCong) {
        try {
            if (!phanCongGiangDayRepo.existsByMaPC(maPC)) {
                return ResponseEntity.notFound().build();
            }

            // Kiểm tra giảng viên tồn tại
            if (!giangVienRepo.existsById(phanCong.getMaGV().getMaGV())) {
                return ResponseEntity.badRequest().body("Không tìm thấy giảng viên với mã: " + phanCong.getMaGV().getMaGV());
            }

            // Kiểm tra học phần tồn tại
            if (!hocPhanRepo.existsById(phanCong.getMaHocPhan().getMaHocPhan())) {
                return ResponseEntity.badRequest().body("Không tìm thấy học phần với mã: " + phanCong.getMaHocPhan().getMaHocPhan());
            }

            phanCong.setMaPC(maPC);
            PhanCongGiangDay updated = phanCongGiangDayRepo.save(phanCong);
            return ResponseEntity.ok(updated);

        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Lỗi khi cập nhật: " + e.getMessage());
        }
    }

    // Xóa phân công
    @DeleteMapping("/{maPC}")
    public ResponseEntity<?> deletePhanCong(@PathVariable int maPC) {
        if (!phanCongGiangDayRepo.existsByMaPC(maPC)) {
            return ResponseEntity.notFound().build();
        }
        phanCongGiangDayRepo.deleteById(maPC);
        return ResponseEntity.ok("Đã xóa phân công có mã: " + maPC);
    }

    // Lấy phân công theo mã giảng viên
    @GetMapping("/giangvien/{maGV}")
    public ResponseEntity<List<PhanCongGiangDay>> getByMaGV(@PathVariable int maGV) {
        List<PhanCongGiangDay> list = phanCongGiangDayRepo.findByMaGV_MaGV(maGV);
        return ResponseEntity.ok(list);
    }

    // Lấy phân công theo mã học phần
    @GetMapping("/hocphan/{maHocPhan}")
    public ResponseEntity<List<PhanCongGiangDay>> getByMaHocPhan(@PathVariable String maHocPhan) {
        List<PhanCongGiangDay> list = phanCongGiangDayRepo.findByMaHocPhan_MaHocPhan(maHocPhan);
        return ResponseEntity.ok(list);
    }
}
