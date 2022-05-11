package com.api.controller;

import com.api.dto.LoaiThietBiDTO;
import com.api.service.LoaiThietBiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/loaithietbi")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoaiThietBiController {
    @Autowired
    private LoaiThietBiService loaiThietBiService;

    @GetMapping("")
    public List<LoaiThietBiDTO> layDSLoaiThietBi() {
        return loaiThietBiService.getDSLoaiThietBi();
    }

    @PostMapping("")
    public LoaiThietBiDTO themLoaiThietBi(@Valid @RequestBody LoaiThietBiDTO loaiThietBiDTO) {
        return loaiThietBiService.themLoaiThietBi(loaiThietBiDTO);
    }

    @PutMapping("")
    public LoaiThietBiDTO suaLoaiThietBi(@Valid @RequestBody LoaiThietBiDTO loaiThietBiDTO) {
        return loaiThietBiService.suaLoaiThietBi(loaiThietBiDTO);
    }

    @DeleteMapping("/{maLoaiTB}")
    public void xoaCauHoi(@PathVariable String maLoaiTB) {
        loaiThietBiService.xoaLoaiThietBi(maLoaiTB);
    }
}
