package com.api.service.impl;

import com.api.dto.ChiTietDatDTO;
import com.api.dto.ChiTietSDDTO;
import com.api.entity.ChiTietDatEntity;
import com.api.entity.ChiTietSDEntity;
import com.api.entity.PhongHocEntity;
import com.api.entity.ThietBiEntity;
import com.api.repository.ChiTietDatRepository;
import com.api.repository.PhongHocRepository;
import com.api.repository.ThietBiRepository;
import com.api.service.ChiTietDatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChiTietDatServiceImpl implements ChiTietDatService {
    @Autowired
    private ChiTietDatRepository chiTietDatRepository;
    @Autowired
    private PhongHocRepository phongHocRepository;
    @Autowired
    private ThietBiRepository thietBiRepository;

    @Override
    public List<ChiTietDatDTO> getChiTietDat() {
        List<ChiTietDatEntity> chiTietDatList = chiTietDatRepository.findAll();
        return chiTietDatList.stream().map(ChiTietDatDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ChiTietDatDTO> getChiTietDattheoTB(String maTB) {
        List<ChiTietDatEntity> chiTietDatList = chiTietDatRepository.findByThietBiD_MaTB(maTB);
        return chiTietDatList.stream().map(ChiTietDatDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ChiTietDatDTO> getChiTietDattheoPH(String maPhong) {
        List<ChiTietDatEntity> chiTietDatList = chiTietDatRepository.findByPhongHocD_MaPhong(maPhong);
        return chiTietDatList.stream().map(ChiTietDatDTO::new).collect(Collectors.toList());
    }

    @Override
    public ChiTietDatDTO themChiTietDat(ChiTietDatDTO chiTietDatDTO) {
        PhongHocEntity phongHocEntity = phongHocRepository.getById(chiTietDatDTO.getMaPhong());
        ThietBiEntity thietBiEntity = thietBiRepository.getById(chiTietDatDTO.getMaTB());
        ChiTietDatEntity chiTietDat = chiTietDatDTO.toEntity();
        chiTietDat.setPhongHocD(phongHocEntity);
        chiTietDat.setThietBiD(thietBiEntity);
        ChiTietDatEntity saveChiTietDat = chiTietDatRepository.save(chiTietDat);
        return new ChiTietDatDTO(saveChiTietDat);
    }

    @Override
    public ChiTietDatDTO suaChiTietDat(ChiTietDatDTO chiTietDatDTO) {
        ChiTietDatEntity chiTietDat = chiTietDatRepository.getById(chiTietDatDTO.getIdCTD());
        PhongHocEntity phongHocEntity = phongHocRepository.getById(chiTietDatDTO.getMaPhong());
        ThietBiEntity thietBiEntity = thietBiRepository.getById(chiTietDatDTO.getMaTB());
        chiTietDat.setPhongHocD(phongHocEntity);
        chiTietDat.setThietBiD(thietBiEntity);
        chiTietDat.setNgayD(chiTietDatDTO.getNgayD());
        chiTietDat.setSoLuongD(chiTietDatDTO.getSoLuongD());
        ChiTietDatEntity saveChiTietDat = chiTietDatRepository.save(chiTietDat);
        return new ChiTietDatDTO(saveChiTietDat);
    }
    @Override
    public void xoaChiTietDat(int idCTD) {
        chiTietDatRepository.deleteById(idCTD);
    }
}
