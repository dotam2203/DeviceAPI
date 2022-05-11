package com.api.dto;

import com.api.entity.ChiTietThietBiEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietThietBiDTO {
    private Integer idCTTB;

    private String tinhTrang;

    private String maThietBi;

    public ChiTietThietBiDTO(ChiTietThietBiEntity chiThietThietBiEntity){
        this.idCTTB = chiThietThietBiEntity.getIdCTTB();
        this.tinhTrang = chiThietThietBiEntity.getTinhTrang();
        this.maThietBi = chiThietThietBiEntity.getCtThietBi().getMaTB();
    }

    public ChiTietThietBiEntity toEntity(){
        ChiTietThietBiEntity chiThietThietBiEntity = new ChiTietThietBiEntity();
        if(this.idCTTB != 0){
            chiThietThietBiEntity.setIdCTTB(this.idCTTB);
            chiThietThietBiEntity.setTinhTrang(this.tinhTrang);
        }
        return chiThietThietBiEntity;
    }
}
