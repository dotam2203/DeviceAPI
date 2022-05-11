package com.api.service.impl;

import com.api.dto.ThietBiDTO;
import com.api.entity.LoaiThietBiEntity;
import com.api.entity.ThietBiEntity;
import com.api.repository.LoaiThietBiRepository;
import com.api.repository.ThietBiRepository;
import com.api.service.ThietBiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThietBiServiceImpl implements ThietBiService {
    @Autowired
    ThietBiRepository thietBiRepository;

    @Autowired
    LoaiThietBiRepository loaiThietBiRepository;

    @Override
    public List<ThietBiDTO> getDSThietBi() {
        List<ThietBiEntity> DSThietBi = thietBiRepository.findAll();
        return DSThietBi.stream().map(ThietBiDTO::new).collect(Collectors.toList());
    }
    public ThietBiDTO getThietBi(String maTB){
        ThietBiEntity thietBiEntity = thietBiRepository.getById(maTB);
        return new ThietBiDTO(thietBiEntity);
    }

    @Override
    public ThietBiDTO themThietBi(ThietBiDTO thietBiDTO) {
        LoaiThietBiEntity loaiThietBiEntity = loaiThietBiRepository.getById(thietBiDTO.getMaLoaiTB());
        ThietBiEntity thietBiEntity = thietBiDTO.toEntity();
        thietBiEntity.setLoaiTB(loaiThietBiEntity);
        ThietBiEntity saveThietBiDTO = thietBiRepository.save(thietBiEntity);
        return new ThietBiDTO(saveThietBiDTO);
    }

    @Override
    public void xoaThietBi(String maTB) {
        thietBiRepository.deleteById(maTB);
    }

    @Override
    public ThietBiDTO suaThietBi(ThietBiDTO thietBiDTO) {
        ThietBiEntity thietBiEntity = thietBiRepository.getById(thietBiDTO.getMaTB());
        LoaiThietBiEntity loaiThietBiEntity = loaiThietBiRepository.getById(thietBiDTO.getMaLoaiTB());
        thietBiEntity.setLoaiTB(loaiThietBiEntity);
        thietBiEntity.setTenTB(thietBiDTO.getTenTB());
        thietBiEntity.setSoLuong(thietBiDTO.getSoLuong());
        thietBiEntity.setXuatXu(thietBiDTO.getXuatXu());
        ThietBiEntity saveThietBiDTO = thietBiRepository.save(thietBiEntity);
        return new ThietBiDTO(saveThietBiDTO);
    }
}
