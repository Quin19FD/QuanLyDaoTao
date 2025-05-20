package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.model.CTDaoTao;
import com.example.quanlydaotao.repository.CTDaoTaoRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/CTDT_View")
public class CTDaoTaoController {

    @Autowired
    private CTDaoTaoRepo ctDaoTaoRepo;

    @GetMapping
    public List<CTDaoTao> getAllCTDaoTao() {
        return ctDaoTaoRepo.findAll();
    }

    @GetMapping("/{mactdt}")
    public ResponseEntity<CTDaoTao> getCTDaoTaoById(@PathVariable("mactdt") int id) {
        Optional<CTDaoTao> optionalCT = ctDaoTaoRepo.findById(id);
        return optionalCT.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CTDaoTao> createCTDaoTao(@Valid @RequestBody CTDaoTao ctDaoTao) {
        if (ctDaoTaoRepo.existsById(ctDaoTao.getMaCTDT())){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ctDaoTaoRepo.save(ctDaoTao));
    }

    @PutMapping("/{mactdt}")
    public ResponseEntity<CTDaoTao> updateCTDaoTao(@PathVariable("mactdt") int id, @Valid @RequestBody CTDaoTao ctDaoTao) {
        if(!ctDaoTaoRepo.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        ctDaoTao.setMaCTDT(id);
        return ResponseEntity.ok(ctDaoTaoRepo.save(ctDaoTao));
    }

    @DeleteMapping("/{mactdt}")
    public ResponseEntity<Void> deleteCTDaoTao(@PathVariable("mactdt") int id) {
        if (!ctDaoTaoRepo.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        ctDaoTaoRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/exists/{mactdt}")
    public ResponseEntity<Boolean> checkMaCTDTExists(@PathVariable("mactdt") int maCTDT) {
        boolean exists = ctDaoTaoRepo.existsById(maCTDT);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/chua-co-khung")
    public ResponseEntity<List<CTDaoTao>> getCTDTChuaCoKhung() {
        List<CTDaoTao> result = ctDaoTaoRepo.findCTDTNotInCTKhungNative();
        return result.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(result);
    }
    @GetMapping("/da-co-khung")
    public ResponseEntity<List<CTDaoTao>> getCTDTCoKhung() {
        List<CTDaoTao> result = ctDaoTaoRepo.findCTDTInCTKhungNative();
        return result.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(result);
    }

}