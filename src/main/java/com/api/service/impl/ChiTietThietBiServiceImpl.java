package com.api.service.impl;

import com.api.dto.ChiTietThietBiDTO;
import com.api.entity.ChiTietThietBiEntity;
import com.api.entity.ThietBiEntity;
import com.api.repository.ChiTietThietBiRepository;
import com.api.repository.ThietBiRepository;
import com.api.service.ChiTietThietBiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ChiTietThietBiServiceImpl implements ChiTietThietBiService {
    @Autowired
    ChiTietThietBiRepository chiTietThietBiRepository;

    @Autowired
    ThietBiRepository thietBiRepository;

    @Override
    public List<ChiTietThietBiDTO> getDSChiTietThietBi() {
        List<ChiTietThietBiEntity> DSCTThietBi = chiTietThietBiRepository.findAll();
        return DSCTThietBi.stream().map(ChiTietThietBiDTO::new).collect(Collectors.toList());
    }

    @Override
    public ChiTietThietBiDTO themChiThietThietBi(ChiTietThietBiDTO chiTietThietBiDTO) {
        ThietBiEntity thietBiEntity = thietBiRepository.getById(chiTietThietBiDTO.getMaThietBi());
        ChiTietThietBiEntity chiTietThietBiEntity = chiTietThietBiDTO.toEntity();
        chiTietThietBiEntity.setCtThietBi(thietBiEntity);
        ChiTietThietBiEntity saveChiTietThietBiDTO = chiTietThietBiRepository.save(chiTietThietBiEntity);
        return new ChiTietThietBiDTO(saveChiTietThietBiDTO);
    }

    @Override
    public ChiTietThietBiDTO suaChiTietThietBi(ChiTietThietBiDTO chiTietThietBiDTO) {
        ChiTietThietBiEntity chiTietThietBiEntity = chiTietThietBiRepository.getById(chiTietThietBiDTO.getIdCTTB());
        ThietBiEntity thietBiEntity = thietBiRepository.getById(chiTietThietBiDTO.getMaThietBi());
        chiTietThietBiEntity.setTinhTrang(chiTietThietBiDTO.getTinhTrang());
        chiTietThietBiEntity.setCtThietBi(thietBiEntity);
        ChiTietThietBiEntity saveChiTietThietBiDTO = chiTietThietBiRepository.save(chiTietThietBiEntity);
        return new ChiTietThietBiDTO(saveChiTietThietBiDTO);
    }
}
