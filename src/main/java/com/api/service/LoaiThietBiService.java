package com.api.service;

import com.api.dto.LoaiThietBiDTO;

import java.util.List;

public interface LoaiThietBiService {
    List<LoaiThietBiDTO> getDSLoaiThietBi();

    LoaiThietBiDTO themLoaiThietBi(LoaiThietBiDTO loaiThietBiDTO);

    void xoaLoaiThietBi(String maLoaiTB);

    LoaiThietBiDTO suaLoaiThietBi(LoaiThietBiDTO loaiThietBiDTO);
}
