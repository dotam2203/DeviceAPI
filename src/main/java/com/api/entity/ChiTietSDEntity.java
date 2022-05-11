package com.api.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CHITIETSUDUNG")
public class ChiTietSDEntity {
    @Id
    @Column(name = "IDCTSD")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCTSD;

    @Column(name = "NGAY")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date ngaySD;

    @Column(name = "SOLUONG")
    private Integer soLuongSD;

    @ManyToOne
    @JoinColumn(name = "MATHIETBI")
    private ThietBiEntity thietBiSD;

    @ManyToOne
    @JoinColumn(name = "MAPHONG")
    private PhongHocEntity phongHocSD;
}
