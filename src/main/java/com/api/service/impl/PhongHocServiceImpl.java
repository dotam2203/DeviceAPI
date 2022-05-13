package com.api.service.impl;

import com.api.dto.LoaiThietBiDTO;
import com.api.dto.PhongHocDTO;
import com.api.entity.LoaiThietBiEntity;
import com.api.entity.PhongHocEntity;
import com.api.repository.PhongHocRepository;
import com.api.service.PhongHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhongHocServiceImpl implements PhongHocService {
    @Autowired
    PhongHocRepository phongHocRepository;

    @Override
    public List<PhongHocDTO> getDSPhongHoc() {
        List<PhongHocEntity> DSPhongHoc = phongHocRepository.findAll();
        return DSPhongHoc.stream().map(PhongHocDTO::new).collect(Collectors.toList());
    }
    @Override
    public PhongHocDTO getPhongHoc(String maPhong) {
        PhongHocEntity phongHoc = phongHocRepository.getById(maPhong);
        return new PhongHocDTO(phongHoc);
    }

    @Override
    public PhongHocDTO themPhongHoc(PhongHocDTO phongHocDTO) {
        PhongHocEntity savePhongHocDTO = phongHocRepository.save(phongHocDTO.toEntity());
        return new PhongHocDTO(savePhongHocDTO);
    }

    @Override
    public void xoaPhongHoc(String maPhong) {
        phongHocRepository.deleteById(maPhong);
    }

    @Override
    public PhongHocDTO suaPhongHoc(PhongHocDTO phongHocDTO) {
        PhongHocEntity phongHocEntity = phongHocRepository.getById(phongHocDTO.getMaPhong());
        phongHocEntity.setMaPhong(phongHocDTO.getMaPhong());
        phongHocEntity.setLoaiPhong(phongHocDTO.getLoaiPhong());
        phongHocEntity.setTang(phongHocDTO.getTang());
        PhongHocEntity savePhongHocDTO = phongHocRepository.save(phongHocEntity);
        return new PhongHocDTO(savePhongHocDTO);
    }
}
