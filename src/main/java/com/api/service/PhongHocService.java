package com.api.service;

import com.api.dto.PhongHocDTO;

import java.util.List;

public interface PhongHocService {
    List<PhongHocDTO> getDSPhongHoc();

    PhongHocDTO getPhongHoc(String maPhong);
    PhongHocDTO themPhongHoc(PhongHocDTO phongHocDTO);

    void xoaPhongHoc(String maPhong);

    PhongHocDTO suaPhongHoc(PhongHocDTO phongHocDTO);
}
