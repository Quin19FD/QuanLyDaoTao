package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.model.HocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HocPhanRepo extends JpaRepository<HocPhan, String> {
    List<HocPhan> findByTenHocPhanContainingIgnoreCase(String tenHocPhan);
}
