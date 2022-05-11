package com.api.entity;

import lombok.*;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="THIETBI")
public class ThietBiEntity {
    @Id
    @Column(name = "MATHIETBI")
    @Nationalized
    private String maTB;

    @Column(name = "TENTHIETBI")
    @Nationalized
    private String tenTB;

    @Column(name = "XUATXU")
    @Nationalized
    private String xuatXu;

    @Column(name = "SOLUONG")
    private Integer soLuong;

    @ManyToOne
    @JoinColumn(name = "MALOAITB")
    private LoaiThietBiEntity loaiTB;

    @OneToMany(mappedBy = "thietBiSD", fetch = FetchType.EAGER)
    private List<ChiTietSDEntity> chiTietSDs = new ArrayList<>();

//    @OneToMany(mappedBy = "thietBiD", fetch = FetchType.EAGER)
//    private List<ChiTietDatEntity> chiTietDs = new ArrayList<>();
//
//    @OneToMany(mappedBy = "ctThietBi", fetch = FetchType.EAGER)
//    private List<ChiTietThietBiEntity> cTThietBis = new ArrayList<>();
}
