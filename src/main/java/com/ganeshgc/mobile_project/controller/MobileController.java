package com.ganeshgc.mobile_project.controller;

import com.ganeshgc.mobile_project.Dto.MobileVo;
import com.ganeshgc.mobile_project.service.MobileService;
import com.ganeshgc.mobile_project.service.MobileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.function.Function;

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
    @DeleteMapping("/mobiles/{mid}")
    public void deleteById(@PathVariable int mid){
        mobileService.deleteById(mid);
    }
    @PutMapping("/mobiles")
    public void updateMobile(@RequestBody MobileVo mobileVo){
        mobileService.updateMobile(mobileVo);
    }

}
