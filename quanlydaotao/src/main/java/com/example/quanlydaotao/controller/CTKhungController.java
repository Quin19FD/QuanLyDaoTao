package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.model.CTDaoTao;
import com.example.quanlydaotao.model.CTKhung;
import com.example.quanlydaotao.repository.CTDaoTaoRepo;
import com.example.quanlydaotao.repository.CTKhungRepo;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/khungchuongtrinh")
@CrossOrigin(origins = "*") // Optional
public class CTKhungController {

    @Autowired
    private CTKhungRepo ctkhungRepo;

    @Autowired
    private CTDaoTaoRepo ctDaoTaoRepo;

    @GetMapping
    public List<CTKhung> getAllCTKhung() {
        return ctkhungRepo.findAll();
    }

    @GetMapping("/{makhung}")
    public ResponseEntity<CTKhung> getCTKhungById(@PathVariable("makhung") int makhung) {
        Optional<CTKhung> optionalCTKhung = ctkhungRepo.findById(makhung);
        return optionalCTKhung.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/maxId")
    public ResponseEntity<Integer> getMaxMaKhung() {
        Integer maxId = ctkhungRepo.findMaxMaKhung();
        return ResponseEntity.ok(maxId == null ? 0 : maxId);
    }

    @GetMapping("/theomaCTDT/{maCTDT}")
    public ResponseEntity<List<CTKhung>> getCTKhungByMaCTDT(@PathVariable int maCTDT) {
        List<CTKhung> list = ctkhungRepo.findByMaCTDT_MaCTDT(maCTDT);
        return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
    }


    @DeleteMapping("/deleteByMaCTDT/{maCTDT}")
    public ResponseEntity<String> deleteCTKhungByMaCTDT(@PathVariable int maCTDT) {
        ctkhungRepo.deleteByMaCTDT_MaCTDT(maCTDT);
        return ResponseEntity.ok("Đã xóa tất cả CTKhung với maCTDT = " + maCTDT);
    }

    @PostMapping
    public ResponseEntity<?> addCTKhung(
            @RequestParam("maCTDT") @NotNull(message = "Mã chương trình đào tạo không được để trống") Integer maCTDT,
            @RequestParam("maKhung") @NotNull(message = "Mã khung không được để trống") Integer maKhung) {

        Optional<CTDaoTao> ctdaoTaoOptional = ctDaoTaoRepo.findById(maCTDT);
        if (ctdaoTaoOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Không tìm thấy CTDaoTao với maCTDT = " + maCTDT);
        }

        CTKhung ctkhung = new CTKhung(ctdaoTaoOptional.get(), maKhung);
        ctkhungRepo.save(ctkhung);

        return ResponseEntity.ok("Thêm CTKhung thành công với maKhung = " + ctkhung.getMaKhung());
    }
}
