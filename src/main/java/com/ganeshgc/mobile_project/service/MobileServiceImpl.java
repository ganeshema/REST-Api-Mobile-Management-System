package com.ganeshgc.mobile_project.service;

import com.ganeshgc.mobile_project.Dto.MobileVo;
import com.ganeshgc.mobile_project.Repository.MobileEntity;
import com.ganeshgc.mobile_project.Repository.MobileRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MobileServiceImpl implements MobileService{
    private MobileRepository mobileRepository;

    @Override
        public void saveMobile(MobileVo mobileVo){
            MobileEntity mobileEntity=new MobileEntity();
            BeanUtils.copyProperties(mobileVo,mobileEntity);
            mobileRepository.save(mobileEntity);
    }
    @Override
    public MobileVo getMobileByMid(int mid) {
        Optional<MobileEntity> optional=mobileRepository.findById(mid);
        return optional.map(mobile-> {
            MobileVo mobileVo = new MobileVo();
            BeanUtils.copyProperties(mobile, mobileVo);
            return mobileVo;
        }).orElseThrow(()->new MobileNotFoundException("mobile not found by id :"+mid));

    }

    @Override
    public void deleteById(int mid) {
        Optional<MobileEntity> optional=mobileRepository.findById(mid);
        optional.ifPresentOrElse(mobile->mobileRepository.delete(mobile),
                ()->{ throw new MobileNotFoundException("mobile not found by id :"+mid);});
                }

    @Override
    public void updateMobile(MobileVo mobileVo) {
        int id=mobileVo.getMid();
        Optional<MobileEntity> mobile=mobileRepository.findById(id);
        MobileEntity updatedMobile=mobile.get();
        updatedMobile.setMid(mobileVo.getMid());
        updatedMobile.setColor(mobileVo.getColor());
        updatedMobile.setVendor(mobileVo.getVendor());
        updatedMobile.setPrice(mobileVo.getPrice());
        updatedMobile.setDescription(mobileVo.getDescription());
        mobileRepository.save(updatedMobile);

    }

}



