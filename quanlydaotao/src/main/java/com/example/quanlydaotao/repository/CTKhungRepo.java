package com.example.quanlydaotao.repository;


import com.example.quanlydaotao.model.CTKhung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CTKhungRepo extends JpaRepository<CTKhung,Integer> {
}
