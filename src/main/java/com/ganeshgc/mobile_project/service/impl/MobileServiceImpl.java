package com.ganeshgc.mobile_project.service.impl;

import com.ganeshgc.mobile_project.Dto.MobileVo;
import com.ganeshgc.mobile_project.model.MobileEntity;
import com.ganeshgc.mobile_project.Repository.MobileRepository;
import com.ganeshgc.mobile_project.exception.MobileNotFoundException;
import com.ganeshgc.mobile_project.payload.MobileResponse;
import com.ganeshgc.mobile_project.service.MobileService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MobileServiceImpl implements MobileService {
    @Autowired
    private MobileRepository mobileRepository;

    @Override
    public List<MobileVo> findAllMobiles() {
        List<MobileVo> mobileVos = new ArrayList<>();
        List<MobileEntity> mobileEntities = mobileRepository.findAll();
        for (MobileEntity mobileEntity : mobileEntities) {
            MobileVo mobileVo = new MobileVo();
            BeanUtils.copyProperties(mobileEntity, mobileVo);
            mobileVos.add(mobileVo);
        }
        return mobileVos;
    }
    @Override
    public  MobileResponse findAllMobiles(int pageNo, int pageSize) {
        List<MobileVo> mobileVos = new ArrayList<>();
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<MobileEntity> mobileEntities = mobileRepository.findAll(pageable);
        if (mobileEntities != null) {
            for (MobileEntity mobileEntity : mobileEntities) {
                MobileVo mobileVo = new MobileVo();
                BeanUtils.copyProperties(mobileEntity, mobileVo);
                mobileVos.add(mobileVo);
            }
            MobileResponse mobileResponse = MobileResponse.builder()
                    .content(mobileVos)
                    .pageNo(mobileEntities.getNumber())
                    .pageSize(mobileEntities.getSize())
                    .totalPage(mobileEntities.getTotalPages())
                    .totalCount(mobileEntities.getTotalElements())
                    .isLastPage(mobileEntities.isLast())
                    .build();
            return mobileResponse;
        }
        return null;
    }
    @Override
    public  MobileResponse findAllMobiles(int pageNo, int pageSize, String sortBy, String sortOrder) {
        Pageable pageable=null;
        if(sortBy!=null && sortOrder!=null) {
            Sort sort = sortOrder.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
            pageable = PageRequest.of(pageNo, pageSize, sort);
        }else{
            pageable = PageRequest.of(pageNo, pageSize);
        }
        List<MobileVo> mobileVos = new ArrayList<>();
        Page<MobileEntity> mobileEntities = mobileRepository.findAll(pageable);
        if (mobileEntities != null) {
            for (MobileEntity mobileEntity : mobileEntities) {
                MobileVo mobileVo = new MobileVo();
                BeanUtils.copyProperties(mobileEntity, mobileVo);
                mobileVos.add(mobileVo);
            }
            MobileResponse mobileResponse = MobileResponse.builder()
                    .content(mobileVos)
                    .pageNo(mobileEntities.getNumber())
                    .pageSize(mobileEntities.getSize())
                    .totalPage(mobileEntities.getTotalPages())
                    .totalCount(mobileEntities.getTotalElements())
                    .isLastPage(mobileEntities.isLast())
                    .build();
            return mobileResponse;
        }
        return null;
    }

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



