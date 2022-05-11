package com.api.repository;

import com.api.entity.ChiTietDatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiTietDatRepository extends JpaRepository<ChiTietDatEntity, Integer> {
    List<ChiTietDatEntity> findByPhongHocD_MaPhong(String maPhong);
    List<ChiTietDatEntity> findByThietBiD_MaTB(String maTB);

}
