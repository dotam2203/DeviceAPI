package com.api.repository;

import com.api.entity.LoaiThietBiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoaiThietBiRepository extends JpaRepository<LoaiThietBiEntity, String> {
    /*List<LoaiThietBiEntity> findByLoaiTB_MaLoaiTB(String maLoaiTB);*/
}
