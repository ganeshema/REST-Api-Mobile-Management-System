package com.ganeshgc.mobile_project.service;

import com.ganeshgc.mobile_project.Dto.MobileVo;

public interface MobileService {
    public void saveMobile(MobileVo mobileVo);
    public MobileVo getMobileByMid(int mid );
    public void deleteById(int mid);
    public void updateMobile(MobileVo mobileVo);
}
