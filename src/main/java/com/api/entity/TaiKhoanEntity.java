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
@Table(name="TAIKHOAN")
public class TaiKhoanEntity {
    @Id
    @Column(name = "MATAIKHOAN")
    @Nationalized
    private String maTaiKhoan;

    @Column(name = "MATKHAU")
    @Nationalized
    private String matKhau;

    @Column(name = "HO")
    @Nationalized
    private String ho;

    @Column(name = "TEN")
    @Nationalized
    private String ten;

    @Column(name = "EMAIL")
    @Nationalized
    private String email;

    @Column(name = "HINHANH")
    @Nationalized
    private String hinhAnh;

    @Column(name = "LOAI")
    @Nationalized
    private String loai;
}
