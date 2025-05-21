package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.model.CTHocPhan;
import com.example.quanlydaotao.model.HocPhan;
import com.example.quanlydaotao.repository.CTHocPhanRepo;
import com.example.quanlydaotao.repository.HocPhanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cthocphan")
public class CTHocPhanController {

    @Autowired
    private CTHocPhanRepo cthocPhanRepo;

    @Autowired
    private HocPhanRepo hocPhanRepo;

    // Lấy tất cả chi tiết học phần
    @GetMapping
    public List<CTHocPhan> getAll() {
        return cthocPhanRepo.findAll();
    }

    // Thêm mới chi tiết học phần
    @PostMapping
    public CTHocPhan create(@RequestBody CTHocPhan ct) {
        return cthocPhanRepo.save(ct);
    }

    // Cập nhật chi tiết học phần
    @PutMapping("/{maHocPhan}")
    public ResponseEntity<CTHocPhan> update(@PathVariable String maHocPhan, @RequestBody CTHocPhan updated) {
        Optional<HocPhan> optional = hocPhanRepo.findById(maHocPhan);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Optional<CTHocPhan> optionalCT = cthocPhanRepo.findById(maHocPhan);
        if (optionalCT.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        CTHocPhan existing = optionalCT.get();

        // Cập nhật các trường cần thiết
        existing.setLyThuyet(updated.getLyThuyet());
        existing.setThucHanh(updated.getThucHanh());
        existing.setThucTap(updated.getThucTap());

        return ResponseEntity.ok(cthocPhanRepo.save(existing));
    }


    // Xóa chi tiết học phần
    @DeleteMapping("/{maHocPhan}")
    public ResponseEntity<?> delete(@PathVariable String maHocPhan) {
        if (cthocPhanRepo.existsById(maHocPhan)) {
            cthocPhanRepo.deleteById(maHocPhan);
            return ResponseEntity.ok("Đã xóa chi tiết học phần: " + maHocPhan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/custom")
    public ResponseEntity<?> createCustomCTHocPhan(
            @RequestParam String maHocPhan,
            @RequestParam int lyThuyet,
            @RequestParam int thucHanh,
            @RequestParam int thucTap) {

        Optional<HocPhan> optionalHocPhan = hocPhanRepo.findById(maHocPhan);
        if (optionalHocPhan.isEmpty()) {
            return ResponseEntity.badRequest().body("Không tìm thấy học phần với mã: " + maHocPhan);
        }

        if (cthocPhanRepo.existsById(maHocPhan)) {
            return ResponseEntity.badRequest().body("Chi tiết học phần đã tồn tại cho mã: " + maHocPhan);
        }

        HocPhan hocPhan = optionalHocPhan.get();

        CTHocPhan ct = new CTHocPhan();
        ct.setMaHocPhan(hocPhan);
        ct.setLyThuyet(lyThuyet);
        ct.setThucHanh(thucHanh);
        ct.setThucTap(thucTap);

        CTHocPhan saved = cthocPhanRepo.save(ct);
        return ResponseEntity.ok(saved);
    }


}
