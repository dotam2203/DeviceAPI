package com.api.service;

import com.api.dto.ChiTietDatDTO;

import java.util.List;

public interface ChiTietDatService {
    public List<ChiTietDatDTO> getChiTietDat();
    public List<ChiTietDatDTO> getChiTietDattheoTB(String maTB);
    public List<ChiTietDatDTO> getChiTietDattheoPH(String maPhong);
    public ChiTietDatDTO themChiTietDat(ChiTietDatDTO chiTietDatDTO);
    public ChiTietDatDTO suaChiTietDat(ChiTietDatDTO chiTietDatDTO);
    public void xoaChiTietDat(int idCTD);
}
