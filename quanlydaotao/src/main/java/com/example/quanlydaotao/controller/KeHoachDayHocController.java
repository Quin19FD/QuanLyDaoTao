package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.model.CTDaoTao;
import com.example.quanlydaotao.model.HocPhan;
import com.example.quanlydaotao.model.KeHoachDayHoc;
import com.example.quanlydaotao.model.PhanCongGiangDay;
import com.example.quanlydaotao.repository.CTDaoTaoRepo;
import com.example.quanlydaotao.repository.HocPhanRepo;
import com.example.quanlydaotao.repository.KeHoachDayHocRepo;
import com.example.quanlydaotao.repository.PhanCongGiangDayRepo;
import jakarta.validation.Valid;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/kehoachdayhoc")
public class KeHoachDayHocController {

    @Autowired
    private KeHoachDayHocRepo keHoachDayHocRepo;

    @Autowired
    private HocPhanRepo hocPhanRepo;

    @Autowired
    private PhanCongGiangDayRepo phanCongGiangDayRepo;

    @Autowired
    private CTDaoTaoRepo ctDaoTaoRepo;


    // Lấy tất cả kế hoạch (chỉ load eager maHocPhan)
    @GetMapping
    @EntityGraph(attributePaths = {"maHocPhan"}) // Chỉ load eager maHocPhan
    public ResponseEntity<?> getAllKeHoachDayHoc() {
        try {
            List<KeHoachDayHoc> list = keHoachDayHocRepo.findAll();

            List<Map<String, Object>> result = list.stream().map(kh -> {
                Map<String, Object> dto = new HashMap<>();
                dto.put("maKeHoach", kh.getMaKeHoach());
                dto.put("hocKyThucHien", kh.getHocKyThucHien());

                // Thông tin học phần (được load eager)
                Map<String, Object> hp = new HashMap<>();
                if (kh.getMaHocPhan() != null) {
                    hp.put("maHocPhan", kh.getMaHocPhan().getMaHocPhan());
                    hp.put("tenHocPhan", kh.getMaHocPhan().getTenHocPhan());
                    hp.put("soTinChi", kh.getMaHocPhan().getSoTinChi());
                }
                dto.put("maHocPhan", hp);

                // Thông tin học phần trước (cần fetch riêng nếu cần)
                dto.put("maHocPhanTruoc", kh.getMaHocPhanTruoc() != null ?
                        kh.getMaHocPhanTruoc().getMaHocPhan() : null);

                // Các thông tin khác không được load eager
                dto.put("maPC", kh.getMaPC() != null ? kh.getMaPC().getMaPC() : null);
                dto.put("mactdt", kh.getMactdt() != null ? kh.getMactdt().getMaCTDT() : null);

                return dto;
            }).collect(Collectors.toList());

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of(
                            "error", "Lỗi khi lấy danh sách kế hoạch",
                            "message", e.getMessage()
                    ));
        }
    }

    // Lấy kế hoạch theo mã (vẫn load full để hiển thị chi tiết)
    @GetMapping("/{maKeHoach}")
    @EntityGraph(attributePaths = {"maHocPhan", "maHocPhanTruoc"}) // Chỉ load eager các trường cần thiết
    public ResponseEntity<?> getKeHoachById(@PathVariable int maKeHoach) {
        try {
            return keHoachDayHocRepo.findById(maKeHoach)
                    .map(kh -> {
                        // Đảm bảo không null
                        if (kh.getMaHocPhan() == null) kh.setMaHocPhan(new HocPhan());
                        if (kh.getMaHocPhanTruoc() == null) kh.setMaHocPhanTruoc(new HocPhan());

                        // Tạo DTO đơn giản để tránh lỗi serialization
                        Map<String, Object> dto = new HashMap<>();
                        dto.put("maKeHoach", kh.getMaKeHoach());
                        dto.put("hocKyThucHien", kh.getHocKyThucHien());

                        // Thông tin học phần
                        Map<String, Object> hp = new HashMap<>();
                        hp.put("maHocPhan", kh.getMaHocPhan().getMaHocPhan());
                        hp.put("tenHocPhan", kh.getMaHocPhan().getTenHocPhan());
                        hp.put("soTinChi", kh.getMaHocPhan().getSoTinChi());
                        dto.put("maHocPhan", hp);

                        // Thông tin học phần trước
                        if (kh.getMaHocPhanTruoc() != null) {
                            Map<String, Object> hpTruoc = new HashMap<>();
                            hpTruoc.put("maHocPhan", kh.getMaHocPhanTruoc().getMaHocPhan());
                            hpTruoc.put("tenHocPhan", kh.getMaHocPhanTruoc().getTenHocPhan());
                            dto.put("maHocPhanTruoc", hpTruoc);
                        }

                        return ResponseEntity.ok(dto);
                    })
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(Map.of("error", "Lỗi khi lấy thông tin kế hoạch", "message", e.getMessage()));
        }
    }


    @PostMapping
    public ResponseEntity<?> createKeHoachDayHoc(@RequestBody KeHoachDayHoc keHoachDayHoc) {
        try {
            // Validate
            if (!isValidHocKy(keHoachDayHoc.getHocKyThucHien())) {
                return errorResponse("Học kỳ thực hiện phải từ 1 đến 12");
            }
            if (keHoachDayHoc.getMaHocPhan() == null ||
                    !hocPhanRepo.existsById(keHoachDayHoc.getMaHocPhan().getMaHocPhan())) {
                return errorResponse("Học phần không hợp lệ");
            }

            // Tự động tạo mã
            keHoachDayHoc.setMaKeHoach(keHoachDayHocRepo.findMaxMaKeHoach() + 1);

            // Giá trị mặc định
            if (keHoachDayHoc.getMaPC() == null) {
                keHoachDayHoc.setMaPC(phanCongGiangDayRepo.findById(1).orElse(new PhanCongGiangDay()));
            }
            if (keHoachDayHoc.getMactdt() == null) {
                keHoachDayHoc.setMactdt(ctDaoTaoRepo.findById(1).orElse(new CTDaoTao()));
            }

            return ResponseEntity.ok(keHoachDayHocRepo.save(keHoachDayHoc));
        } catch (Exception e) {
            return errorResponse("thêm kế hoạch: " );
        }
    }

    private ResponseEntity<?> errorResponse(String message) {
        return ResponseEntity.badRequest()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Map.of());
    }


    @PutMapping("/{maKeHoach}")
    public ResponseEntity<?> updateKeHoachDayHoc(@PathVariable int maKeHoach,
                                                 @RequestBody Map<String, Object> updateData) {
        try {
            Optional<KeHoachDayHoc> existingOpt = keHoachDayHocRepo.findById(maKeHoach);
            if (existingOpt.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            KeHoachDayHoc existing = existingOpt.get();

            // Cập nhật từng trường một
            if (updateData.containsKey("hocKyThucHien")) {
                existing.setHocKyThucHien((String) updateData.get("hocKyThucHien"));
            }

            if (updateData.containsKey("maHocPhanTruoc")) {
                Object hpTruoc = updateData.get("maHocPhanTruoc");
                if (hpTruoc == null) {
                    existing.setMaHocPhanTruoc(null);
                } else {
                    Map<?, ?> hpTruocMap = (Map<?, ?>) hpTruoc;
                    HocPhan hp = new HocPhan();
                    hp.setMaHocPhan((String) hpTruocMap.get("maHocPhan"));
                    existing.setMaHocPhanTruoc(hp);
                }
            }

            // Giữ nguyên các trường quan hệ không thay đổi
            KeHoachDayHoc updated = keHoachDayHocRepo.save(existing);

            // Trả về DTO đơn giản
            Map<String, Object> response = new HashMap<>();
            response.put("maKeHoach", updated.getMaKeHoach());
            response.put("hocKyThucHien", updated.getHocKyThucHien());
            response.put("maHocPhan", Map.of(
                    "maHocPhan", updated.getMaHocPhan().getMaHocPhan(),
                    "tenHocPhan", updated.getMaHocPhan().getTenHocPhan()
            ));
            if (updated.getMaHocPhanTruoc() != null) {
                response.put("maHocPhanTruoc", Map.of(
                        "maHocPhan", updated.getMaHocPhanTruoc().getMaHocPhan()
                ));
            }

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Map.of("error", "Lỗi khi cập nhật kế hoạch", "message", e.getMessage()));
        }
    }

    @DeleteMapping("/{maKeHoach}")
    public ResponseEntity<?> deleteKeHoachDayHoc(@PathVariable int maKeHoach) {
        try {
            if (!keHoachDayHocRepo.existsById(maKeHoach)) {
                return ResponseEntity.notFound().build();
            }
            keHoachDayHocRepo.deleteById(maKeHoach);
            return ResponseEntity.ok(Map.of(
                    "message", "Đã xóa kế hoạch có mã: " + maKeHoach
            ));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(Map.of(
                            "error", "Lỗi khi xóa kế hoạch",
                            "message", e.getMessage()
                    ));
        }
    }

    @GetMapping("/exists/{maKeHoach}")
    public ResponseEntity<Boolean> checkExists(@PathVariable int maKeHoach) {
        boolean exists = keHoachDayHocRepo.existsById(maKeHoach);
        return ResponseEntity.ok(exists);
    }

    private boolean isValidHocKy(String hocKy) {
        try {
            int hk = Integer.parseInt(hocKy);
            return hk >= 1 && hk <= 12;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
