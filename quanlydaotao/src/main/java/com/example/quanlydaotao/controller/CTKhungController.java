package com.example.quanlydaotao.controller;


import com.example.quanlydaotao.model.CTKhung;
import com.example.quanlydaotao.repository.CTKhungRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/khungchuongtrinh")
public class CTKhungController {

    @Autowired
    private CTKhungRepo ctkhungRepo;

    @GetMapping
    public List<CTKhung> getAllCTKhung() {
        return ctkhungRepo.findAll();
    }

    @GetMapping("/{makhung}")
    public ResponseEntity<CTKhung> getCTKhungById(@PathVariable int id) {
        Optional<CTKhung> optionalCTKhung = ctkhungRepo.findById(id);
        return optionalCTKhung.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
