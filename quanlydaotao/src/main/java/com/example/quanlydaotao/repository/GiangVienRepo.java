package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.model.GiangVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiangVienRepo extends JpaRepository<GiangVien, Integer> {
}
