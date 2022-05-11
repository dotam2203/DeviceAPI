package com.api.service.impl;

import com.api.dto.TaiKhoanDTO;
import com.api.entity.TaiKhoanEntity;
import com.api.exception.NotFoundException;
import com.api.repository.TaiKhoanRepository;
import com.api.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {
    @Autowired
    TaiKhoanRepository taiKhoanRepository;

    @Override
    public List<TaiKhoanDTO> getTaiKhoanTheoLoai(String loai, String ten) {
        List<TaiKhoanEntity> taiKhoanEntityList = taiKhoanRepository.findByLoai(loai);
        if(ten.equals("#"))
            return taiKhoanEntityList.stream().map(TaiKhoanDTO::new).collect(Collectors.toList());
        else {
            List<TaiKhoanEntity> taiKhoans = new ArrayList<>();
            for (TaiKhoanEntity tk: taiKhoanEntityList) {
                if(tk.getTen().toLowerCase().contains(ten.toLowerCase()))
                    taiKhoans.add(tk);
            }
            return taiKhoans.stream().map(TaiKhoanDTO::new).collect(Collectors.toList());
        }
    }

    @Override
    public List<TaiKhoanDTO> getDSTaiKhoan() {
        List<TaiKhoanEntity> taiKhoanEntityList = taiKhoanRepository.findAll();
        return taiKhoanEntityList.stream().map(TaiKhoanDTO::new).collect(Collectors.toList());
    }

    @Override
    public TaiKhoanDTO getTaiKhoan(String maTaiKhoan) {
        TaiKhoanEntity taiKhoanEntity = taiKhoanRepository.findById(maTaiKhoan).orElseThrow(()->new NotFoundException("Tài khoản " + maTaiKhoan + " không tồn tại!"));
        return new TaiKhoanDTO(taiKhoanEntity);
    }

    @Override
    public TaiKhoanDTO themTaiKhoan(TaiKhoanDTO taiKhoanDTO) {
        TaiKhoanEntity saveTaiKhoan = taiKhoanRepository.save(taiKhoanDTO.toEntity());
        return new TaiKhoanDTO(saveTaiKhoan);
    }

    @Override
    public TaiKhoanDTO suaTaiKhoan(TaiKhoanDTO taiKhoanDTO) {
        TaiKhoanEntity taiKhoanEntity = taiKhoanRepository.save(taiKhoanDTO.toEntity());
        taiKhoanEntity.setMaTaiKhoan(taiKhoanDTO.getMaTaiKhoan());
        taiKhoanEntity.setMatKhau(taiKhoanDTO.getMatKhau());
        taiKhoanEntity.setHo(taiKhoanDTO.getHo());
        taiKhoanEntity.setTen(taiKhoanDTO.getTen());
        taiKhoanEntity.setEmail(taiKhoanDTO.getEmail());
        taiKhoanEntity.setHinhAnh(taiKhoanDTO.getHinhAnh());
        taiKhoanEntity.setLoai(taiKhoanDTO.getLoai());
        TaiKhoanEntity saveTaiKhoan = taiKhoanRepository.save(taiKhoanEntity);
        return new TaiKhoanDTO(saveTaiKhoan);
    }

    @Override
    public void xoaTaiKhoan(String maTaiKhoan) {
        taiKhoanRepository.deleteById(maTaiKhoan);
    }
}
