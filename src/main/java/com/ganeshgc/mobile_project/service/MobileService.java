package com.ganeshgc.mobile_project.service;

import com.ganeshgc.mobile_project.Dto.MobileVo;

import java.util.List;

public interface MobileService {
    List<MobileVo> findAllMobiles();
    void saveMobile(MobileVo mobileVo);
    MobileVo getMobileByMid(int mid );
    void deleteById(int mid);
    void updateMobile(MobileVo mobileVo);
}
