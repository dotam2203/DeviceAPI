package com.api.service.impl;

import com.api.dto.LoaiThietBiDTO;
import com.api.entity.LoaiThietBiEntity;
import com.api.repository.LoaiThietBiRepository;
import com.api.service.LoaiThietBiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class LoaiThietBiServiceImpl implements LoaiThietBiService {

    @Autowired
    LoaiThietBiRepository loaiThietBiRepository;


    @Override
    public List<LoaiThietBiDTO> getDSLoaiThietBi() {
        List<LoaiThietBiEntity> DSLoaiThietBi = loaiThietBiRepository.findAll();
        return DSLoaiThietBi.stream().map(LoaiThietBiDTO::new).collect(Collectors.toList());
    }

    @Override
    public LoaiThietBiDTO themLoaiThietBi(LoaiThietBiDTO loaiThietBiDTO) {
        LoaiThietBiEntity saveLoaiThietBiDTO = loaiThietBiRepository.save(loaiThietBiDTO.toEntity());
        return new LoaiThietBiDTO(saveLoaiThietBiDTO);
    }

    @Override
    public void xoaLoaiThietBi(String maLoaiTB) {
        loaiThietBiRepository.deleteById(maLoaiTB);
    }

    @Override
    public LoaiThietBiDTO suaLoaiThietBi(LoaiThietBiDTO loaiThietBiDTO) {
        LoaiThietBiEntity loaiThietBiEntity = loaiThietBiRepository.getById(loaiThietBiDTO.getMaLoaiTB());
        loaiThietBiEntity.setMaLoaiTB(loaiThietBiDTO.getMaLoaiTB());
        loaiThietBiEntity.setTenLoaiTB(loaiThietBiDTO.getTenLoaiTB());
        LoaiThietBiEntity saveLoaiThietBiDTO = loaiThietBiRepository.save(loaiThietBiEntity);
        return new LoaiThietBiDTO(saveLoaiThietBiDTO);
    }
}
