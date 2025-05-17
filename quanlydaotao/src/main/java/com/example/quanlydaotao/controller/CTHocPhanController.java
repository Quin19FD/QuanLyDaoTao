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
        updated.setMaHocPhan(optional.get());
        updated.setMaHocPhanId(maHocPhan);
        return ResponseEntity.ok(cthocPhanRepo.save(updated));
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
}
