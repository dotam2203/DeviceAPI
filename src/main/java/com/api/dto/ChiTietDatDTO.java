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

    public ChiTietDatDTO (ChiTietDatEntity chiTietDatEntity){
        this.idCTD = chiTietDatEntity.getIdCTD();
        this.ngayD = chiTietDatEntity.getNgayD();
        this.soLuongD = chiTietDatEntity.getSoLuongD();
        this.maTB = chiTietDatEntity.getThietBiD().getMaTB();
        this.maPhong = chiTietDatEntity.getPhongHocD().getMaPhong();
    }

    public ChiTietSDEntity toEntity(){
        ChiTietSDEntity chiTietSDEntity = new ChiTietSDEntity();
        if(this.idCTD != 0){
            chiTietSDEntity.setIdCTSD(this.idCTD);
            chiTietSDEntity.setNgaySD(this.ngayD);
            chiTietSDEntity.setSoLuongSD(this.soLuongD);
        }
        return chiTietSDEntity;
    }
}
