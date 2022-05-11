package com.api.repository;

import com.api.entity.TaiKhoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoanEntity, String> {
    List<TaiKhoanEntity> findByLoai(String loai);
    //List<TaiKhoanEntity> findByMatKhau(String maKhau);
}
