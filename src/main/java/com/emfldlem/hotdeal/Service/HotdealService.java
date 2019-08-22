package com.emfldlem.hotdeal.Service;


import com.emfldlem.hotdeal.Entity.HotdealEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotdealService {

    @Autowired
    HotdealRepository hotdealRepository;


    public HotdealEntity saveHotdealInfo(HotdealEntity hotdealEntity) {
        return hotdealRepository.save(hotdealEntity);
    }


    public String getLastBoardNo(String boardSe) {
        HotdealEntity empEntity = hotdealRepository.findFirstByBoardSeOrderByNoDesc(boardSe);
        return empEntity.getNo();
    }

    public List<HotdealEntity> getListHotdeal(String boardSe) {
        return hotdealRepository.findListByBoardSe(boardSe);
    }



}
