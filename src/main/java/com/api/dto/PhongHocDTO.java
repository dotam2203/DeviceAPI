package com.api.dto;

import com.api.entity.PhongHocEntity;
import com.api.entity.TaiKhoanEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhongHocDTO {
    private String maPhong;
    private String loaiPhong;
    private Integer tang;
    private List<ChiTietSDDTO> chiTietSDs = new ArrayList<>();

    public PhongHocDTO(PhongHocEntity phongHocEntity){
        this.maPhong = phongHocEntity.getMaPhong();
        this.loaiPhong = phongHocEntity.getLoaiPhong();
        this.tang = phongHocEntity.getTang();
        this.chiTietSDs = phongHocEntity.getChiTietSDs().stream().map(ChiTietSDDTO::new).collect(Collectors.toList());
    }

    public PhongHocEntity toEntity(){
        PhongHocEntity phongHocEntity = new PhongHocEntity();
        phongHocEntity.setMaPhong(this.maPhong);
        phongHocEntity.setLoaiPhong(this.loaiPhong);
        phongHocEntity.setTang(this.tang);
        return phongHocEntity;
    }

}
