package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.model.PhanCongGiangDay;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhanCongGiangDayRepo extends JpaRepository<PhanCongGiangDay, Integer> {

    // Lấy tất cả phân công với thông tin giảng viên và học phần
    @EntityGraph(attributePaths = {"maGV", "maHocPhan"})
    @Override
    List<PhanCongGiangDay> findAll();

    // Lấy phân công theo mã với thông tin giảng viên và học phần
    @EntityGraph(attributePaths = {"maGV", "maHocPhan"})
    Optional<PhanCongGiangDay> findByMaPC(int maPC);

    // Tìm kiếm theo mã giảng viên
    @EntityGraph(attributePaths = {"maGV", "maHocPhan"})
    List<PhanCongGiangDay> findByMaGV_MaGV(int maGV);

    // Tìm kiếm theo mã học phần
    @EntityGraph(attributePaths = {"maGV", "maHocPhan"})
    List<PhanCongGiangDay> findByMaHocPhan_MaHocPhan(String maHocPhan);

    // Kiểm tra tồn tại phân công giảng dạy
    boolean existsByMaPC(int maPC);
}
