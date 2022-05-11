package com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="LOAITHIETBI")
public class LoaiThietBiEntity {
    @Id
    @Column(name = "MALOAITB")
    @Nationalized
    private String maLoaiTB;

    @Column(name = "TENLOAITB")
    @Nationalized
    private String tenLoaiTB;

    @OneToMany(mappedBy = "loaiTB", fetch = FetchType.EAGER)
    private List<ThietBiEntity> thietBis = new ArrayList<>();

}
