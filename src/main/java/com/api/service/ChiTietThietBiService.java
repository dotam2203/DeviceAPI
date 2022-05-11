package com.api.service;

import com.api.dto.ChiTietThietBiDTO;

import java.util.List;

public interface ChiTietThietBiService{
    List<ChiTietThietBiDTO> getDSChiTietThietBi();

    ChiTietThietBiDTO themChiThietThietBi(ChiTietThietBiDTO chiTietThietBiDTO);

    ChiTietThietBiDTO suaChiTietThietBi(ChiTietThietBiDTO chiTietThietBiDTO);
}
