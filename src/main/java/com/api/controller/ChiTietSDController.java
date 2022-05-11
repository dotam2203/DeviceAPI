package com.api.controller;

import com.api.dto.ChiTietSDDTO;
import com.api.service.ChiTietSDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/chitietsd")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ChiTietSDController {
    @Autowired
    private ChiTietSDService chiTietSDService;
    @GetMapping("")
    public List<ChiTietSDDTO> layDSChiTietSD(){
        return chiTietSDService.getChiTietSD();
    }
    @GetMapping("/tb")//truyền vào maTB
    public List<ChiTietSDDTO> layDSTheoMaTB(@RequestParam(value = "maTB") String maTB){
        return chiTietSDService.getChiTietSDtheoTB(maTB);
    }
    @GetMapping("/ph")//truyền maPhong
    public List<ChiTietSDDTO> layDSTheoMaPH(@RequestParam(value = "maPhong") String maPhong){
        return chiTietSDService.getChiTietSDtheoPH(maPhong);
    }
    @PostMapping("")
    public ChiTietSDDTO themChiTietSD(@Valid @RequestBody ChiTietSDDTO chiTietSDDTO){
        return chiTietSDService.themChiTietSD(chiTietSDDTO);
    }
    @PutMapping("")
    public ChiTietSDDTO suaChiTietSD(@Valid @RequestBody ChiTietSDDTO chiTietSDDTO){
        return chiTietSDService.suaChiTietSD(chiTietSDDTO);
    }
    @DeleteMapping("/{idCTSD}")
    public void xoaChiTietSD(@PathVariable Integer idCTSD){
        chiTietSDService.xoaChiTietSD(idCTSD);
    }
}
