package com.api.service;

import com.api.dto.TaiKhoanDTO;

import java.util.List;

public interface TaiKhoanService {
    public List<TaiKhoanDTO> getTaiKhoanTheoLoai(String loai, String ten);
    public List<TaiKhoanDTO> getDSTaiKhoan();
    public TaiKhoanDTO getTaiKhoan(String maTaiKhoan);
    public TaiKhoanDTO themTaiKhoan(TaiKhoanDTO taiKhoanDTO);
    public TaiKhoanDTO suaTaiKhoan(TaiKhoanDTO taiKhoanDTO);
    public void xoaTaiKhoan(String maTaiKhoan);
}
