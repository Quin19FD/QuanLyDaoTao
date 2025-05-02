package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.model.KeHoachDayHoc;
import com.example.quanlydaotao.model.NhomLop;
import com.example.quanlydaotao.repository.KeHoachDayHocRepo;
import com.example.quanlydaotao.repository.NhomLopRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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
}
