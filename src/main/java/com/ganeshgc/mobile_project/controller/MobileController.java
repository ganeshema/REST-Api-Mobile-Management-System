package com.ganeshgc.mobile_project.controller;

import com.ganeshgc.mobile_project.Dto.MobileVo;
import com.ganeshgc.mobile_project.service.MobileService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mobiles")
public class MobileController {
    @Autowired
    private MobileService mobileService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void saveMobile(@Valid @RequestBody MobileVo mobileVo){
        mobileService.saveMobile(mobileVo);
    }


    @GetMapping("/{mid}")
    public MobileVo findMobileByMid(@PathVariable int mid){
        MobileVo mobileVo=mobileService.getMobileByMid(mid);
        return mobileVo;
    }

    @GetMapping
    public List<MobileVo> findAllMobiles(){
        List<MobileVo> mobiles=mobileService.findAllMobiles();
        return mobiles;
    }
    @DeleteMapping("/{mid}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity deleteById(@PathVariable int mid){
        mobileService.deleteById(mid);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void updateMobile(@RequestBody @Valid MobileVo mobileVo) {
        mobileService.updateMobile(mobileVo);
    }
    }



