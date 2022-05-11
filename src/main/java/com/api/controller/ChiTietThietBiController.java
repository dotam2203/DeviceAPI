package com.api.controller;

import com.api.dto.ChiTietThietBiDTO;
import com.api.service.ChiTietThietBiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/chitietthietbi")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ChiTietThietBiController {
    @Autowired
    private ChiTietThietBiService chiTietThietBiService;

    @GetMapping("")
    public List<ChiTietThietBiDTO> layDSChiTietThietBi() {
        return chiTietThietBiService.getDSChiTietThietBi();
    }


    @PostMapping("")
    public ChiTietThietBiDTO themChiTietThietBi(@Valid @RequestBody ChiTietThietBiDTO chiTietThietBiDTO) {
        return chiTietThietBiService.themChiThietThietBi(chiTietThietBiDTO);
    }

    @PutMapping("")
    public ChiTietThietBiDTO suaChitietThietBi(@Valid @RequestBody ChiTietThietBiDTO chiTietThietBiDTO) {
        return chiTietThietBiService.suaChiTietThietBi(chiTietThietBiDTO);
    }

}
