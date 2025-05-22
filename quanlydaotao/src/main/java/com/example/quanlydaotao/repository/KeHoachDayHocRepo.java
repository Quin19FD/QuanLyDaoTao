package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.model.KeHoachDayHoc;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KeHoachDayHocRepo extends JpaRepository<KeHoachDayHoc, Integer> {

    @Query("SELECT MAX(k.maKeHoach) FROM KeHoachDayHoc k")
    Integer findMaxMaKeHoach();


    @EntityGraph(attributePaths = {"maHocPhan"})
    @Override
    List<KeHoachDayHoc> findAll();

    @EntityGraph(attributePaths = {"maHocPhan"})
    @Override
    Optional<KeHoachDayHoc> findById(Integer maKeHoach);

    // Tìm kiếm theo mã học phần
    @EntityGraph(attributePaths = {"maHocPhan"})
    List<KeHoachDayHoc> findByMaHocPhan_MaHocPhan(String maHocPhan);


}
