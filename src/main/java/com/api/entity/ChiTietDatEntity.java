package com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CHITIETDAT")
public class ChiTietDatEntity {
    @Id
    @Column(name = "IDCTD")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCTD;

    @Column(name = "NGAY")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date ngayD;

    @Column(name = "SOLUONG")
    private Integer soLuongD;

    @ManyToOne
    @JoinColumn(name = "MATHIETBI")
    private ThietBiEntity thietBiD;

    @ManyToOne
    @JoinColumn(name = "MAPHONG")
    private PhongHocEntity phongHocD;
}
