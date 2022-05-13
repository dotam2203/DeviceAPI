package com.api.repository;

import com.api.entity.PhongHocEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhongHocRepository extends JpaRepository<PhongHocEntity, String> {
   /* List<PhongHocEntity> findByLoaiPhong_MaPhong(String maPhong);*/
}
