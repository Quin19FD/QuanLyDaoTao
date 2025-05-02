package com.example.quanlydaotao.controller;


import com.example.quanlydaotao.model.KhoiKienThuc;
import com.example.quanlydaotao.repository.KhoiKienThucRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/khoikienthuc")
public class KhoiKienThucController {

    @Autowired
    private KhoiKienThucRepo khoiKienThucRepo;

    @GetMapping
    public List<KhoiKienThuc> getallKhoiKienThuc() {
        return khoiKienThucRepo.findAll();
    }

    @GetMapping("/{makhung}")
    public ResponseEntity<KhoiKienThuc> getKhoiKienThucById(@PathVariable int maKhung) {
        Optional<KhoiKienThuc> optionalKhoiKienThuc = khoiKienThucRepo.findById(maKhung);
        return optionalKhoiKienThuc.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
