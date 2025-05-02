package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.model.GiangVien;
import com.example.quanlydaotao.model.KeHoachDayHoc;
import com.example.quanlydaotao.repository.KeHoachDayHocRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/kehoachdayhoc")
public class KeHoachDayHocController {
    @Autowired
    private KeHoachDayHocRepo keHoachDayHocRepo;

    @GetMapping
    public List<KeHoachDayHoc> getAll(){
        return keHoachDayHocRepo.findAll();
    }

    @PostMapping
    public ResponseEntity<?> themKeHoach(@Valid @RequestBody KeHoachDayHoc keHoachDayHoc, BindingResult result){
        if(result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        KeHoachDayHoc saved = keHoachDayHocRepo.save(keHoachDayHoc);
        return ResponseEntity.ok(saved);
    }
}
