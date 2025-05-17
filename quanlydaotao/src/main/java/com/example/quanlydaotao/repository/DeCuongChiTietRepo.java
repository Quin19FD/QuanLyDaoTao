package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.model.DeCuongChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeCuongChiTietRepo extends JpaRepository<DeCuongChiTiet, String> {
}
