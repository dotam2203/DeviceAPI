package com.api.controller;

import com.api.dto.TaiKhoanDTO;
import com.api.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/taikhoan")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TaiKhoanController {
    @Autowired
    private TaiKhoanService taiKhoanService;

    @GetMapping("")//truyền loại và tên, nếu không có tên thì tên để #
    public List<TaiKhoanDTO> layDSTheoLoai(@RequestParam(value = "loai") String loai, @RequestParam(value = "ten") String ten){
        return taiKhoanService.getTaiKhoanTheoLoai(loai,ten);
    }

    @GetMapping("/danhsach")
    public  List<TaiKhoanDTO> layDSTaiKhoan(){
        return taiKhoanService.getDSTaiKhoan();
    }

    @GetMapping("/{maTaiKhoan}")
    public TaiKhoanDTO layTaiKhoan(@PathVariable String maTaiKhoan){
        return  taiKhoanService.getTaiKhoan(maTaiKhoan);
    }

    @PostMapping("")
    public TaiKhoanDTO themTaiKhoan(@Valid @RequestBody TaiKhoanDTO taiKhoanDTO){
        return  taiKhoanService.themTaiKhoan(taiKhoanDTO);
    }

    @PutMapping("")
    public TaiKhoanDTO suaTaiKhoan(@Valid @RequestBody TaiKhoanDTO taiKhoanDTO){
        return  taiKhoanService.suaTaiKhoan(taiKhoanDTO);
    }

    @DeleteMapping("/{maTaiKhoan}")
    public void xoaTaiKhoan(@PathVariable String maTaiKhoan){
        taiKhoanService.xoaTaiKhoan(maTaiKhoan);
    }


}
