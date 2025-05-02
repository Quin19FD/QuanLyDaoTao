package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.model.DanhGiaBoPhan;
import com.example.quanlydaotao.repository.DanhGiaBoPhanRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/danhgiabophan")
public class DanhGiaBoPhanController {

    @Autowired
    private DanhGiaBoPhanRepo danhGiaBoPhanRepo;

    // Lấy tất cả đánh giá bộ phận
    @GetMapping
    public List<DanhGiaBoPhan> getAll() {
        return danhGiaBoPhanRepo.findAll();
    }

    // Tìm kiếm đánh giá bộ phận theo mã bộ phận
    @GetMapping("/search")
    public List<DanhGiaBoPhan> search(@RequestParam String maBoPhan) {
        return danhGiaBoPhanRepo.findByMaBoPhan_MaBoPhanContainingIgnoreCase(maBoPhan);
    }

    // Thêm đánh giá bộ phận
    @PostMapping
    public DanhGiaBoPhan create(@RequestBody DanhGiaBoPhan danhGiaBoPhan) {
        return danhGiaBoPhanRepo.save(danhGiaBoPhan);
    }

    // Cập nhật đánh giá bộ phận
    @PutMapping("/{madiemdanhgia}")
    public ResponseEntity<DanhGiaBoPhan> update(@PathVariable int maDiemDanhGia, @Valid @RequestBody DanhGiaBoPhan updated) {
        Optional<DanhGiaBoPhan> optional = danhGiaBoPhanRepo.findById(maDiemDanhGia);
        if (optional.isPresent()) {
            updated.setMaDiemDanhGia(maDiemDanhGia);  // Sửa đúng tên field
            return ResponseEntity.ok(danhGiaBoPhanRepo.save(updated));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa đánh giá bộ phận
    @DeleteMapping("/{madiemdanhgia}")
    public ResponseEntity<?> delete(@PathVariable int maDiemDanhGia) {
        if (danhGiaBoPhanRepo.existsById(maDiemDanhGia)) {
            danhGiaBoPhanRepo.deleteById(maDiemDanhGia);
            return ResponseEntity.ok("Đã xóa DanhGiaBoPhan: " + maDiemDanhGia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
