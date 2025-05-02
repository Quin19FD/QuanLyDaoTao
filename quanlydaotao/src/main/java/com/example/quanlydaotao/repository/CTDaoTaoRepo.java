package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.model.CTDaoTao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CTDaoTaoRepo extends JpaRepository<CTDaoTao, Integer> {

    Optional<CTDaoTao> findByTenCTDT(String tenCTDT);
}