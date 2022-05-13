package com.api.controller;

import com.api.dto.PhongHocDTO;
import com.api.service.PhongHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/phonghoc")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PhongHocController {
    @Autowired
    private PhongHocService phongHocService;

    @GetMapping("")
    public List<PhongHocDTO> layDSPhongHoc() {
        return phongHocService.getDSPhongHoc();
    }

    @GetMapping("/ph")
    public PhongHocDTO layPhongHoc(@RequestParam(value = "maPhong") String maPhong) {
        return phongHocService.getPhongHoc(maPhong);
    }

    @PostMapping("")
    public PhongHocDTO themPhongHoc(@Valid @RequestBody PhongHocDTO phongHocDTO) {
        return phongHocService.themPhongHoc(phongHocDTO);
    }

    @DeleteMapping("/{maPhong}")
    public void xoaPhongHoc(@PathVariable String maPhong) {
        phongHocService.xoaPhongHoc(maPhong);
    }

    @PutMapping("")
    public PhongHocDTO suaPhongHoc(@Valid @RequestBody PhongHocDTO phongHocDTO) {
        return phongHocService.suaPhongHoc(phongHocDTO);
    }
}
