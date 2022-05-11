package com.api.dto;

import com.api.entity.LoaiThietBiEntity;
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
public class LoaiThietBiDTO {
    private String maLoaiTB;
    private String tenLoaiTB;
    private List<ThietBiDTO> thietBis = new ArrayList<>();

    public LoaiThietBiDTO(LoaiThietBiEntity loaiThietBiEntity){
        this.maLoaiTB = loaiThietBiEntity.getMaLoaiTB();
        this.tenLoaiTB = loaiThietBiEntity.getTenLoaiTB();
        this.thietBis = loaiThietBiEntity.getThietBis().stream().map(ThietBiDTO::new).collect(Collectors.toList());
    }

    public LoaiThietBiEntity toEntity(){
        LoaiThietBiEntity loaiThietBiEntity = new LoaiThietBiEntity();
        loaiThietBiEntity.setMaLoaiTB(this.maLoaiTB);
        loaiThietBiEntity.setTenLoaiTB(this.tenLoaiTB);
        return loaiThietBiEntity;
    }

}
