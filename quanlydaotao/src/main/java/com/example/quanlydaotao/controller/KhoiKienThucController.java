package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.model.CTKhung;
import com.example.quanlydaotao.model.KhoiKienThuc;
import com.example.quanlydaotao.repository.CTKhungRepo;
import com.example.quanlydaotao.repository.KhoiKienThucRepo;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/khoikienthuc")
public class KhoiKienThucController {

    @Autowired
    private KhoiKienThucRepo khoiKienThucRepo;

    @Autowired
    private CTKhungRepo ctKhungRepo;

    @GetMapping
    public List<KhoiKienThuc> getAllKhoiKienThuc() {
        return khoiKienThucRepo.findAll();
    }

    @GetMapping("/byKhung/{maKhung}")
    public ResponseEntity<List<KhoiKienThuc>> getKhoiKienThucByMaKhung(@PathVariable int maKhung) {
        List<KhoiKienThuc> dsKhoi = khoiKienThucRepo.findByMaKhung_MaKhung(maKhung);
        if (dsKhoi.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dsKhoi);
    }

    @GetMapping("/maxId")
    public ResponseEntity<Integer> getMaxMaKhoiKienThuc() {
        int maxId = khoiKienThucRepo.findMaxMaKhoiKienThuc();
        return ResponseEntity.ok(maxId);
    }

    @DeleteMapping("/delete-by-khung/{maKhung}")
    public ResponseEntity<Void> deleteByMaKhung(@PathVariable int maKhung) {
        khoiKienThucRepo.deleteByMaKhung_MaKhung(maKhung);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<?> addKhoiKienThuc(
            @RequestParam("maKhoiKienThuc") Integer maKhoiKienThuc,
            @RequestParam("maKhung") Integer maKhung,
            @RequestParam("tinChiBatBuoc") Integer tinChiBatBuoc,
            @RequestParam("tinChiTuChon") Integer tinChiTuChon) {

        Optional<CTKhung> ctKhungOptional = ctKhungRepo.findById(maKhung);
        if (ctKhungOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Không tìm thấy CTKhung với maKhung = " + maKhung);
        }

        if (khoiKienThucRepo.existsById(maKhoiKienThuc)) {
            return ResponseEntity.badRequest().body("Mã khối kiến thức đã tồn tại: " + maKhoiKienThuc);
        }

        if (tinChiBatBuoc < 0 || tinChiTuChon < 0) {
            return ResponseEntity.badRequest().body("Tín chỉ bắt buộc và tự chọn không được âm");
        }

        KhoiKienThuc khoiKienThuc = new KhoiKienThuc();
        khoiKienThuc.setMaKhoiKienThuc(maKhoiKienThuc);
        khoiKienThuc.setMaKhoi(ctKhungOptional.get());
        khoiKienThuc.setTinChiBatBuoc(tinChiBatBuoc);
        khoiKienThuc.setTinChiTuChon(tinChiTuChon);

        khoiKienThucRepo.save(khoiKienThuc);
        return ResponseEntity.ok("Thêm Khối Kiến Thức thành công với mã = " + maKhoiKienThuc);
    }


    @PutMapping("/{maKhoiKienThuc}")
    public ResponseEntity<?> updateKhoiKienThuc(
            @PathVariable int maKhoiKienThuc,
            @RequestBody KhoiKienThuc updateData) {

        Optional<KhoiKienThuc> optional = khoiKienThucRepo.findById(maKhoiKienThuc);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        if (updateData.getTinChiBatBuoc() < 0 || updateData.getTinChiTuChon() < 0) {
            return ResponseEntity.badRequest().body("Tín chỉ bắt buộc và tự chọn không được âm");
        }

        KhoiKienThuc entity = optional.get();
        entity.setTinChiBatBuoc(updateData.getTinChiBatBuoc());
        entity.setTinChiTuChon(updateData.getTinChiTuChon());

        khoiKienThucRepo.save(entity);
        return ResponseEntity.ok("Cập nhật Khối Kiến Thức thành công với mã = " + maKhoiKienThuc);
    }
}
