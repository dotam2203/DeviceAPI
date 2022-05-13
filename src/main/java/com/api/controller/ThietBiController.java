package com.api.controller;

import com.api.dto.ThietBiDTO;
import com.api.service.ThietBiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/thietbi")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ThietBiController {
    @Autowired
    private ThietBiService thietBiService;

    @GetMapping("")
    public List<ThietBiDTO> layDSThietBi() {
        return thietBiService.getDSThietBi();
    }

    @GetMapping("/tb")
    public ThietBiDTO layThietBi(@RequestParam(value = "maTB") String maTB){
        return thietBiService.getThietBi(maTB);
    }

    @PostMapping("")
    public ThietBiDTO themThietBi(@Valid @RequestBody ThietBiDTO thietBiDTO) {
        return thietBiService.themThietBi(thietBiDTO);
    }

    @PutMapping("")
    public ThietBiDTO suaThietBi(@Valid @RequestBody ThietBiDTO thietBiDTO) {
        return thietBiService.suaThietBi(thietBiDTO);
    }

    @DeleteMapping("/{maTB}")
    public void xoaThietBi(@PathVariable String maTB) {
        thietBiService.xoaThietBi(maTB);
    }
}
