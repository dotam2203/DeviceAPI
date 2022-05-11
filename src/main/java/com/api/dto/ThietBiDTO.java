package com.api.dto;

import com.api.entity.ChiTietDatEntity;
import com.api.entity.ChiTietSDEntity;
import com.api.entity.ThietBiEntity;
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
public class ThietBiDTO {
    private String maTB;
    private String tenTB;
    private String xuatXu;
    private Integer soLuong;
    private String maLoaiTB;
    private List<ChiTietSDDTO> chiTietSDs = new ArrayList<>();
//    private List<ChiTietDatDTO> chiTietDs = new ArrayList<>();
//    private List<ChiTietThietBiDTO> cTThietBis = new ArrayList<>();

    public ThietBiDTO (ThietBiEntity thietBiEntity){
        this.maTB = thietBiEntity.getMaTB();
        this.tenTB = thietBiEntity.getTenTB();
        this.xuatXu = thietBiEntity.getXuatXu();
        this.soLuong = thietBiEntity.getSoLuong();
        this.maLoaiTB = thietBiEntity.getLoaiTB().getMaLoaiTB();
        this.chiTietSDs = thietBiEntity.getChiTietSDs().stream().map(ChiTietSDDTO::new).collect(Collectors.toList());
//        this.chiTietDs = thietBiEntity.getChiTietDs().stream().map(ChiTietDatDTO::new).collect(Collectors.toList());
//        this.cTThietBis = thietBiEntity.getCTThietBis().stream().map(ChiTietThietBiDTO::new).collect(Collectors.toList());
    }

    public ThietBiEntity toEntity(){
        ThietBiEntity thietBiEntity = new ThietBiEntity();
        thietBiEntity.setMaTB(this.maTB);
        thietBiEntity.setTenTB(this.tenTB);
        thietBiEntity.setXuatXu(this.xuatXu);
        thietBiEntity.setSoLuong(this.soLuong);
        return thietBiEntity;
    }

}
