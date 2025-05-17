package com.example.quanlydaotao.controller;

import com.example.quanlydaotao.model.PhanCongGiangDay;
import com.example.quanlydaotao.repository.PhanCongGiangDayRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/phanconggiangday")
public class PhanCongGiangDayController {
    @Autowired
    private PhanCongGiangDayRepo phanCongGiangDayRepo;

    @GetMapping
    public List<PhanCongGiangDay> getAll(){
        return phanCongGiangDayRepo.findAll();
    }
}
