package com.api.dto;

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
public class ChiTietSDDTO {
    private int idCTSD;
    private Date ngaySD;
    private int soLuongSD;
    private String maTB;
    private String maPhong;

    public ChiTietSDDTO(ChiTietSDEntity chiTietSDEntity) {
        this.idCTSD = chiTietSDEntity.getIdCTSD();
        this.ngaySD = chiTietSDEntity.getNgaySD();
        this.soLuongSD = chiTietSDEntity.getSoLuongSD();
        this.maTB = chiTietSDEntity.getThietBiSD().getMaTB();
        this.maPhong = chiTietSDEntity.getPhongHocSD().getMaPhong();
    }

    public ChiTietSDEntity toEntity() {
        ChiTietSDEntity chiTietSDEntity = new ChiTietSDEntity();
        chiTietSDEntity.setIdCTSD(this.idCTSD);
        chiTietSDEntity.setNgaySD(this.ngaySD);
        chiTietSDEntity.setSoLuongSD(this.soLuongSD);
        return chiTietSDEntity;
    }
}
