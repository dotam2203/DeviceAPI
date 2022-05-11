package com.api.service.impl;

import com.api.dto.ChiTietSDDTO;
import com.api.entity.ChiTietSDEntity;
import com.api.entity.PhongHocEntity;
import com.api.entity.TaiKhoanEntity;
import com.api.entity.ThietBiEntity;
import com.api.repository.ChiTietSDRepository;
import com.api.repository.PhongHocRepository;
import com.api.repository.TaiKhoanRepository;
import com.api.repository.ThietBiRepository;
import com.api.service.ChiTietSDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChiTietSDServiceImpl implements ChiTietSDService {
    @Autowired
    private ChiTietSDRepository chiTietSDRepository;
    @Autowired
    private PhongHocRepository phongHocRepository;
    @Autowired
    private ThietBiRepository thietBiRepository;

    @Override
    public List<ChiTietSDDTO> getChiTietSD() {
        List<ChiTietSDEntity> chiTietSDList = chiTietSDRepository.findAll();
        return chiTietSDList.stream().map(ChiTietSDDTO::new).collect(Collectors.toList());
    }

   @Override
    public List<ChiTietSDDTO> getChiTietSDtheoTB(String maTB) {
        List<ChiTietSDEntity> chiTietSDList = chiTietSDRepository.findByThietBiSD_MaTB(maTB);
            return chiTietSDList.stream().map(ChiTietSDDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ChiTietSDDTO> getChiTietSDtheoPH(String maPhong) {
        List<ChiTietSDEntity> chiTietSDList = chiTietSDRepository.findByPhongHocSD_MaPhong(maPhong);
        return chiTietSDList.stream().map(ChiTietSDDTO::new).collect(Collectors.toList());
    }

    @Override
    public ChiTietSDDTO themChiTietSD(ChiTietSDDTO chiTietSDDTO) {
        PhongHocEntity phongHocEntity = phongHocRepository.getById(chiTietSDDTO.getMaPhong());
        ThietBiEntity thietBiEntity = thietBiRepository.getById(chiTietSDDTO.getMaTB());
        ChiTietSDEntity chiTietSD = chiTietSDDTO.toEntity();
        chiTietSD.setPhongHocSD(phongHocEntity);
        chiTietSD.setThietBiSD(thietBiEntity);
        ChiTietSDEntity saveChiTietSD = chiTietSDRepository.save(chiTietSD);
        return new ChiTietSDDTO(saveChiTietSD);
    }

    @Override
    public ChiTietSDDTO suaChiTietSD(ChiTietSDDTO chiTietSDDTO) {
        ChiTietSDEntity chiTietSD = chiTietSDRepository.getById(chiTietSDDTO.getIdCTSD());
        PhongHocEntity phongHocEntity = phongHocRepository.getById(chiTietSDDTO.getMaPhong());
        ThietBiEntity thietBiEntity = thietBiRepository.getById(chiTietSDDTO.getMaTB());
        chiTietSD.setPhongHocSD(phongHocEntity);
        chiTietSD.setThietBiSD(thietBiEntity);
        chiTietSD.setNgaySD(chiTietSDDTO.getNgaySD());
        chiTietSD.setSoLuongSD(chiTietSDDTO.getSoLuongSD());
        ChiTietSDEntity saveChiTietSD = chiTietSDRepository.save(chiTietSD);
        return new ChiTietSDDTO(saveChiTietSD);
    }
    @Override
    public void xoaChiTietSD(int idCTSD) {
        chiTietSDRepository.deleteById(idCTSD);
    }
}
