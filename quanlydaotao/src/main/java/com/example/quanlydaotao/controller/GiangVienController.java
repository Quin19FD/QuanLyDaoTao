package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.model.GiangVien;
import com.example.quanlydaotao.repository.GiangVienRepo;
import com.example.quanlydaotao.service.GiangVienService; // Import service
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/giangvien")
public class GiangVienController {
    @Autowired
    private GiangVienRepo giangVienRepo;

    @Autowired
    private GiangVienService giangVienService; // Inject service

    @GetMapping
    public List<GiangVien> getAll(){
        return giangVienRepo.findAll();
    }

    @GetMapping("/{magv}")
    public ResponseEntity<?> getById(@PathVariable int magv) {
        return giangVienRepo.findById(magv)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Thêm giảng viên
    @PostMapping
    public ResponseEntity<?> themGiangVien(@Valid @RequestBody GiangVien giangVien, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        GiangVien saved = giangVienRepo.save(giangVien);
        return ResponseEntity.ok(saved);
    }

    // Cập nhật giảng viên
    @PutMapping("/{magv}")
    public ResponseEntity<?> updateGiangVien(@PathVariable int magv, @Valid @RequestBody GiangVien giangVien, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        Optional<GiangVien> optionalGV = giangVienRepo.findById(magv);
        if (optionalGV.isPresent()) {
            giangVien.setMaGV(magv); // đảm bảo ID đúng
            GiangVien updated = giangVienRepo.save(giangVien);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa giảng viên
    @DeleteMapping("/{magv}")
    public ResponseEntity<?> xoaGiangVien(@PathVariable int magv) {
        Optional<GiangVien> optionalGV = giangVienRepo.findById(magv);
        if (optionalGV.isPresent()) {
            giangVienRepo.deleteById(magv);
            return ResponseEntity.ok("Xóa giáo viên thành công!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/import")
    public ResponseEntity<?> importGiangVien(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please upload a file!");
        }

        try {
            List<GiangVien> importedGiangViens = giangVienService.importFromExcel(file);
            return ResponseEntity.ok("Imported " + importedGiangViens.size() + " lecturers.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Could not import the file: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportGiangVien() throws IOException {
        byte[] excelBytes = giangVienService.exportToExcel();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "giangviens.xlsx");
        return new ResponseEntity<>(excelBytes, headers, HttpStatus.OK);
    }
}