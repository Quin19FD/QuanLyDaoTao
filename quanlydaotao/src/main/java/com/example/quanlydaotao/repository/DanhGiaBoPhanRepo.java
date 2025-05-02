package com.example.quanlydaotao.repository;

import com.example.quanlydaotao.model.DanhGiaBoPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanhGiaBoPhanRepo extends JpaRepository<DanhGiaBoPhan, Integer> {
    List<DanhGiaBoPhan> findByMaBoPhan_MaBoPhanContainingIgnoreCase(String maBoPhan);
}
