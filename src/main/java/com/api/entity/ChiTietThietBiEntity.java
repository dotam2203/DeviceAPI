package com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CHITIETTHIETBI")
public class ChiTietThietBiEntity {
    @Id
    @Column(name = "IDCTTB")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCTTB;

    @Column(name = "TINHTRANG")
    @Nationalized
    private String tinhTrang;

    @ManyToOne
    @JoinColumn(name = "MATHIETBI")
    private ThietBiEntity ctThietBi;
}
