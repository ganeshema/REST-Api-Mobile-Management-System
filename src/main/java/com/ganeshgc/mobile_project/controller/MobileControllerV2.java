package com.ganeshgc.mobile_project.controller;

import com.ganeshgc.mobile_project.Dto.MobileVo;
import com.ganeshgc.mobile_project.payload.MobileResponse;
import com.ganeshgc.mobile_project.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/mobiles")
public class MobileControllerV2 {
    @Autowired
    private MobileService mobileService;


    @GetMapping
    public MobileResponse findAllMobiles(@RequestParam(name = "pageNo", defaultValue = "0", required = false) int pageNo,
                                         @RequestParam(name = "pageSize", defaultValue = "10", required = false) int pageSize,
                                         @RequestParam(name = "sortBy", defaultValue = "vendor", required = false)String sortBy,
                                         @RequestParam(name = "sortOrder", defaultValue = "asc", required = false)String sortOrder){
        return  mobileService.findAllMobiles(pageNo,pageSize, sortBy, sortOrder);
    }
    }



