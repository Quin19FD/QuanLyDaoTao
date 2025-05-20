package com.example.quanlydaotao.repository;


import com.example.quanlydaotao.model.CTKhung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public interface CTKhungRepo extends JpaRepository<CTKhung,Integer> {

    @Query("SELECT MAX(c.maKhung) FROM CTKhung c")
    Integer findMaxMaKhung();
    List<CTKhung> findByMaCTDT_MaCTDT(int maCTDT);


    @Transactional
    void deleteByMaCTDT_MaCTDT(int maCTDT);


}
