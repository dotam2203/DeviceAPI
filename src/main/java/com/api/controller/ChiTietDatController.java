package com.api.controller;

import com.api.dto.ChiTietDatDTO;
import com.api.dto.ChiTietSDDTO;
import com.api.service.ChiTietDatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/chitietdat")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ChiTietDatController {
    @Autowired
    private ChiTietDatService chiTietDatService;
    @GetMapping("")
    public List<ChiTietDatDTO> layDSChiTietDat(){
        return chiTietDatService.getChiTietDat();
    }
    @GetMapping("/tb")//truyền vào maTB
    public List<ChiTietDatDTO> layDSTheoMaTB(@RequestParam(value = "maTB") String maTB){
        return chiTietDatService.getChiTietDattheoTB(maTB);
    }
    @GetMapping("/ph")//truyền maPhong
    public List<ChiTietDatDTO> layDSTheoMaPH(@RequestParam(value = "maPhong") String maPhong){
        return chiTietDatService.getChiTietDattheoPH(maPhong);
    }
    @PostMapping("")
    public ChiTietDatDTO themChiTietDat(@Valid @RequestBody ChiTietDatDTO chiTietDatDTO){
        return chiTietDatService.themChiTietDat(chiTietDatDTO);
    }
    @PutMapping("")
    public ChiTietDatDTO suaChiTietDat(@Valid @RequestBody ChiTietDatDTO chiTietDatDTO){
        return chiTietDatService.suaChiTietDat(chiTietDatDTO);
    }
    @DeleteMapping("/{idCTD}")
    public void xoaChiTietDat(@PathVariable Integer idCTD){
        chiTietDatService.xoaChiTietDat(idCTD);
    }
}