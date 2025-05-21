package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.model.HocPhan;
import com.example.quanlydaotao.repository.HocPhanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
// import javax.servlet.http.HttpSession;
import org.springframework.security.core.userdetails.User;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hocphan")
public class HocPhanController {

    @Autowired
    private HocPhanRepo hocPhanRepo;

    // Lấy tất cả học phần
    @GetMapping
    public List<HocPhan> getAll() {
        return hocPhanRepo.findAll();
    }

    // Tìm học phần theo tên
    @GetMapping("/search")
    public List<HocPhan> searchByTen(@RequestParam String tenHocPhan) {
        return hocPhanRepo.findByTenHocPhanContainingIgnoreCase(tenHocPhan);
    }

    // Thêm học phần
    @PostMapping
    public HocPhan create(@RequestBody HocPhan hocPhan) {
        return hocPhanRepo.save(hocPhan);
    }

    // Cập nhật học phần
    @PutMapping("/{maHocPhan}")
    public ResponseEntity<HocPhan> update(@PathVariable String maHocPhan, @RequestBody HocPhan updated) {
        Optional<HocPhan> optional = hocPhanRepo.findById(maHocPhan);
        if (optional.isPresent()) {
            updated.setMaHocPhan(maHocPhan);
            return ResponseEntity.ok(hocPhanRepo.save(updated));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa học phần
    @DeleteMapping("/{maHocPhan}")
    public ResponseEntity<?> delete(@PathVariable String maHocPhan) {
        if (hocPhanRepo.existsById(maHocPhan)) {
            hocPhanRepo.deleteById(maHocPhan);
            return ResponseEntity.ok("Đã xóa học phần: " + maHocPhan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}




