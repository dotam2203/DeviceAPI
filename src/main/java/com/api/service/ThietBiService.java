package com.api.service;

import com.api.dto.ThietBiDTO;

import java.util.List;

public interface ThietBiService {
    List<ThietBiDTO> getDSThietBi();
    List<ThietBiDTO> getDSTBtheoMaTB(String maTB);
    ThietBiDTO themThietBi(ThietBiDTO thietBiDTO);
    void xoaThietBi(String maTB);
    ThietBiDTO suaThietBi(ThietBiDTO thietBiDTO);

}
