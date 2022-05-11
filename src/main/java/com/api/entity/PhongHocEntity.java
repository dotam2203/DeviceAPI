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
@Table(name="PHONGHOC")
public class PhongHocEntity {
    @Id
    @Column(name = "MAPHONG")
    @Nationalized
    private String maPhong;

    @Column(name = "LOAIPHONG")
    @Nationalized
    private String loaiPhong;

    @Column(name = "TANG")
    private Integer tang;

    @OneToMany(mappedBy = "phongHocSD", fetch = FetchType.EAGER)
    private List<ChiTietSDEntity> chiTietSDs = new ArrayList<>();

//    @OneToMany(mappedBy = "phongHocD", fetch = FetchType.EAGER)
//    private List<ChiTietDatEntity> chiTietDs = new ArrayList<>();

}
