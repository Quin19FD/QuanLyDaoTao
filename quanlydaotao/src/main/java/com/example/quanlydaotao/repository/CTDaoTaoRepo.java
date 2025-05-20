package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.model.CTDaoTao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CTDaoTaoRepo extends JpaRepository<CTDaoTao, Integer> {

    Optional<CTDaoTao> findByTenCTDT(String tenCTDT);
    @Query(value = "SELECT * FROM ctdaotao WHERE mactdt NOT IN (SELECT mactdt FROM ctkhung)", nativeQuery = true)
    List<CTDaoTao> findCTDTNotInCTKhungNative();

    @Query(value = "SELECT * FROM ctdaotao WHERE mactdt IN (SELECT mactdt FROM ctkhung)", nativeQuery = true)
    List<CTDaoTao> findCTDTInCTKhungNative();

}