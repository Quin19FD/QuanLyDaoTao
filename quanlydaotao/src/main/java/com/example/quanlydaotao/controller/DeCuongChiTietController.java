package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.model.DeCuongChiTiet;
import com.example.quanlydaotao.repository.DeCuongChiTietRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/decuongchitiet")
public class DeCuongChiTietController {

    @Autowired
    private DeCuongChiTietRepo deCuongChiTietRepo;

    // Lấy tất cả đề cương chi tiết
    @GetMapping
    public List<DeCuongChiTiet> getAll() {
        return deCuongChiTietRepo.findAll();
    }

    // Thêm đề cương chi tiết
    @PostMapping
    public DeCuongChiTiet create(@RequestBody DeCuongChiTiet dcc) {
        return deCuongChiTietRepo.save(dcc);
    }

    // Cập nhật đề cương chi tiết
    @PutMapping("/{maBoPhan}")
    public ResponseEntity<DeCuongChiTiet> update(@PathVariable String maBoPhan, @RequestBody DeCuongChiTiet updated) {
        Optional<DeCuongChiTiet> optional = deCuongChiTietRepo.findById(maBoPhan);
        if (optional.isPresent()) {
            updated.setMaBoPhan(maBoPhan);  // Sửa đúng tên field
            return ResponseEntity.ok(deCuongChiTietRepo.save(updated));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa đề cương chi tiết
    @DeleteMapping("/{maBoPhan}")
    public ResponseEntity<?> delete(@PathVariable String maBoPhan) {
        if (deCuongChiTietRepo.existsById(maBoPhan)) {
            deCuongChiTietRepo.deleteById(maBoPhan);
            return ResponseEntity.ok("Đã xóa DeCuongChiTiet: " + maBoPhan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
