package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.model.KhoiKienThuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface KhoiKienThucRepo extends JpaRepository<KhoiKienThuc, Integer> {
    List<KhoiKienThuc> findByMaKhung_MaKhung(int maKhung);

    @Query("SELECT COALESCE(MAX(k.maKhoiKienThuc), 0) FROM KhoiKienThuc k")
    int findMaxMaKhoiKienThuc();

    @Transactional
    void deleteByMaKhung_MaKhung(int maKhung);
}