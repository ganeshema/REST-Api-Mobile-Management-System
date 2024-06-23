package com.ganeshgc.mobile_project.service;

import com.ganeshgc.mobile_project.Dto.MobileVo;
import com.ganeshgc.mobile_project.payload.MobileResponse;


import java.util.List;

public interface MobileService {
    List<MobileVo> findAllMobiles();
    MobileResponse findAllMobiles(int pageNo, int pageSize);
    MobileResponse findAllMobiles(int pageNo, int pageSize, String sortBy, String sortOrder);
    void saveMobile(MobileVo mobileVo);
    MobileVo getMobileByMid(int mid );
    void deleteById(int mid);
    void updateMobile(MobileVo mobileVo);

}
