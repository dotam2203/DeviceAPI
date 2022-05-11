package com.api.repository;

import com.api.entity.ChiTietSDEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietDatRepository extends JpaRepository<ChiTietSDEntity, Integer> {
}
