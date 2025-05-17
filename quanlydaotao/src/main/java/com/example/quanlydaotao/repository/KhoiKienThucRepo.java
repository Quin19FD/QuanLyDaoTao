package com.example.quanlydaotao.repository;


import com.example.quanlydaotao.model.KhoiKienThuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhoiKienThucRepo extends JpaRepository<KhoiKienThuc, Integer> {
}
