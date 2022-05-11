package com.api.repository;

import com.api.entity.ChiTietSDEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiTietSDRepository extends JpaRepository<ChiTietSDEntity, Integer> {
    List<ChiTietSDEntity> findByPhongHocSD_MaPhong(String maPhong);
    List<ChiTietSDEntity> findByThietBiSD_MaTB(String maTB);
}
