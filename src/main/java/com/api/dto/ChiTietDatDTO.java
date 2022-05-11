package com.api.dto;

import com.api.entity.ChiTietDatEntity;
import com.api.entity.ChiTietSDEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietDatDTO {
    private int idCTD;
    private Date ngayD;
    private int soLuongD;
    private String maTB;
    private String maPhong;

    public ChiTietDatDTO(ChiTietDatEntity chiTietDatEntity) {
        this.idCTD = chiTietDatEntity.getIdCTD();
        this.ngayD = chiTietDatEntity.getNgayD();
        this.soLuongD = chiTietDatEntity.getSoLuongD();
        this.maTB = chiTietDatEntity.getThietBiD().getMaTB();
        this.maPhong = chiTietDatEntity.getPhongHocD().getMaPhong();
    }

    public ChiTietDatEntity toEntity() {
        ChiTietDatEntity chiTietDatEntity = new ChiTietDatEntity();
        chiTietDatEntity.setIdCTD(this.idCTD);
        chiTietDatEntity.setNgayD(this.ngayD);
        chiTietDatEntity.setSoLuongD(this.soLuongD);
        return chiTietDatEntity;
    }
}
