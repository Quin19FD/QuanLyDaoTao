package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.model.NhomLop;
import com.example.quanlydaotao.repository.NhomLopRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/nhomlop")
public class NhomLopController {
    @Autowired
    private NhomLopRepo nhomLopRepo;

    @GetMapping
    public List<NhomLop> getAll(){
        return nhomLopRepo.findAll();
    }

    @GetMapping("/{manhom}")
    public ResponseEntity<?> getById(@PathVariable int maNhom){
        return nhomLopRepo.findById(maNhom)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/filter")
    public ResponseEntity<?> filterNhomLop(
            @RequestParam(value = "mahocphan", required = false) String maHocPhan,
            @RequestParam(value = "keyword", required = false) String keyword) {
        List<NhomLop> filteredNhomLops = nhomLopRepo.findAll();

        if (maHocPhan != null && !maHocPhan.isEmpty()) {
            filteredNhomLops = filteredNhomLops.stream()
                    .filter(nl -> nl.getMaHocPhan().getMaHocPhan().equals(maHocPhan))
                    .collect(Collectors.toList());
        }

        if (keyword != null && !keyword.isEmpty()) {
            String lowerKeyword = keyword.toLowerCase();
            filteredNhomLops = filteredNhomLops.stream()
                    .filter(nl ->
                            String.valueOf(nl.getMaNhom()).toLowerCase().contains(lowerKeyword) ||
                                    (nl.getMaHocPhan() != null && nl.getMaHocPhan().getMaHocPhan().toLowerCase().contains(lowerKeyword)) ||
                                    (nl.getMaHocPhan() != null && nl.getMaHocPhan().getTenHocPhan().toLowerCase().contains(lowerKeyword)) ||
                                    (nl.getMaPC() != null && nl.getMaPC().getMaGV() != null && nl.getMaPC().getMaGV().getHoTen().toLowerCase().contains(lowerKeyword)) ||
                                    String.valueOf(nl.getSoLuongToiDa()).contains(keyword) ||
                                    (nl.getDiaChi() != null && nl.getDiaChi().toLowerCase().contains(lowerKeyword)) ||
                                    formatTime(nl.getThuDi(), nl.getTietBatDau(), nl.getSoTiet()).toLowerCase().contains(lowerKeyword) // Cần hàm formatTime ở backend
                    )
                    .collect(Collectors.toList());
        }

        if (filteredNhomLops.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(filteredNhomLops);
    }

    // Cần một hàm formatTime tương tự như ở frontend
    private String formatTime(String thu, Integer tietBatDau, Integer soTiet) {
        if (thu == null || thu.isEmpty() || tietBatDau == null || soTiet == null) {
            return "Chưa xếp";
        }
        return String.format("%s (Tiết %d-%d)", thu, tietBatDau, tietBatDau + soTiet - 1);
    }

    @PostMapping
    public ResponseEntity<?> themNhom(@Valid @RequestBody NhomLop nhomLop, BindingResult result){
        if(result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        NhomLop saved = nhomLopRepo.save(nhomLop);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{manhom}")
    public ResponseEntity<?> xoaNhomLop(@PathVariable int maNhom){
        Optional<NhomLop> optionalNhomLop = nhomLopRepo.findById(maNhom);
        if(optionalNhomLop.isPresent()){
            nhomLopRepo.deleteById(maNhom);
            return ResponseEntity.ok("Xóa nhóm thành công!");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{nhomId}")
    public ResponseEntity<?> capNhatNhomLop(@PathVariable int nhomId, @Valid @RequestBody NhomLop nhomLopMoi, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        Optional<NhomLop> optionalNhomLop = nhomLopRepo.findById(nhomId);
        if (optionalNhomLop.isPresent()) {
            NhomLop nhomLopCu = optionalNhomLop.get();
            nhomLopCu.setMaHocPhan(nhomLopMoi.getMaHocPhan());
            nhomLopCu.setMaPC(nhomLopMoi.getMaPC());
            nhomLopCu.setSoLuongToiDa(nhomLopMoi.getSoLuongToiDa());
            nhomLopCu.setDiaChi(nhomLopMoi.getDiaChi());
            nhomLopCu.setThuDi(nhomLopMoi.getThuDi());
            nhomLopCu.setTietBatDau(nhomLopMoi.getTietBatDau());
            nhomLopCu.setSoTiet(nhomLopMoi.getSoTiet());
            NhomLop updatedNhomLop = nhomLopRepo.save(nhomLopCu);
            return ResponseEntity.ok(updatedNhomLop);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}