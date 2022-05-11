package com.api.service;

import com.api.dto.ChiTietSDDTO;

import java.util.List;

public interface ChiTietSDService {
    public List<ChiTietSDDTO> getChiTietSD();
    public List<ChiTietSDDTO> getChiTietSDtheoTB(String maTB);
    public List<ChiTietSDDTO> getChiTietSDtheoPH(String maPhong);
    public ChiTietSDDTO themChiTietSD(ChiTietSDDTO chiTietSDDTO);
    public ChiTietSDDTO suaChiTietSD(ChiTietSDDTO chiTietSDDTO);
    public void xoaChiTietSD(int idCTSD);

}
