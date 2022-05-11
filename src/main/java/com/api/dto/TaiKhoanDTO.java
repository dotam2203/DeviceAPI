package com.api.dto;

import com.api.entity.TaiKhoanEntity;
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
public class TaiKhoanDTO {
    private String maTaiKhoan;
    private String matKhau;
    private String ho;
    private String ten;
    private String email;
    private String hinhAnh;
    private String loai;

    private List<ChiTietSDDTO> chiTietSDs = new ArrayList<>();
    public TaiKhoanDTO (TaiKhoanEntity taiKhoanEntity){
        this.maTaiKhoan = taiKhoanEntity.getMaTaiKhoan();
        this.matKhau = taiKhoanEntity.getMatKhau();
        this.ho = taiKhoanEntity.getHo();
        this.ten = taiKhoanEntity.getTen();
        this.email = taiKhoanEntity.getEmail();
        this.hinhAnh = taiKhoanEntity.getHinhAnh();
        this.loai = taiKhoanEntity.getLoai();
    }
    public TaiKhoanEntity toEntity(){
        TaiKhoanEntity taiKhoanEntity = new TaiKhoanEntity();
        taiKhoanEntity.setMaTaiKhoan(this.maTaiKhoan);
        taiKhoanEntity.setMatKhau(this.matKhau);
        taiKhoanEntity.setHo(this.ho);
        taiKhoanEntity.setTen(this.ten);
        taiKhoanEntity.setEmail(this.email);
        taiKhoanEntity.setHinhAnh(this.hinhAnh);
        taiKhoanEntity.setLoai(this.loai);

        return taiKhoanEntity;
    }
}
