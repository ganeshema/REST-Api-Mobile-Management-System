package com.ganeshgc.mobile_project.controller;

import com.ganeshgc.mobile_project.Dto.MobileVo;
import com.ganeshgc.mobile_project.service.MobileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MobileController {
    @Autowired
    private MobileService mobileService;

    @PostMapping("/mobiles")
    public void saveMobile(@RequestBody MobileVo mobileVo){
        mobileService.saveMobile(mobileVo);
    }
    @GetMapping("/mobiles/{mid}")
    public MobileVo findMobileByMid(@PathVariable int mid){
        MobileVo mobileVo=mobileService.getMobileByMid(mid);
        return mobileVo;
    }

    @GetMapping()
    public List<MobileVo> findAllMobiles(){
        List<MobileVo> mobiles=mobileService.findAllMobiles();
        return mobiles;
    }
    @DeleteMapping("/{mid}")
    public void deleteById(@PathVariable int mid){
        mobileService.deleteById(mid);
    }

    @PutMapping("/mobiles")
    public void updateMobile(@RequestBody MobileVo mobileVo) {
        mobileService.updateMobile(mobileVo);
    }
    }



