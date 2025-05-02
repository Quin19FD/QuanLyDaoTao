package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.model.CTHocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CTHocPhanRepo extends JpaRepository<CTHocPhan, String> {
}
