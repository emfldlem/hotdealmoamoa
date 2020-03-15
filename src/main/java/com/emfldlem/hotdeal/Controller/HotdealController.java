package com.emfldlem.hotdeal.Controller;


import com.emfldlem.hotdeal.Entity.HotdealEntity;
import com.emfldlem.hotdeal.Service.HotdealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping(value = "/hotdeal")
public class HotdealController {


    @Value("${ruriweb.url}")
    String ruriwebUrl;

    @Value("${ppomppu.rul}")
    String ppomppuUrl;

    @Autowired
    HotdealService hotdealService;

    /*@GetMapping("")
    public String hotdealView() {

        return "hotdeal/list";
    }


    @GetMapping("/newList")
    public String new_hotdealView() {

        return "hotdeal/hotdealList";
    }*/

    @GetMapping("/initData")
    @ResponseBody
    public Map<String, Object> initData() {
        Map<String, Object> rsltMap = new HashMap<>();

        List<HotdealEntity> ruriList = hotdealService.getListHotdeal("ruriweb");
        List<HotdealEntity> ppoList = hotdealService.getListHotdeal("ppomppu");
        List<HotdealEntity> allList = new ArrayList<>();
        allList.addAll(ruriList);
        allList.addAll(ppoList);

        rsltMap.put("ruriList", ruriList);
        rsltMap.put("ppoList", ppoList);
        rsltMap.put("allList", allList);

        return rsltMap;

    }


    //jsp 테스트
    @RequestMapping("/hotdealList")
    public ModelAndView mav() throws Exception{
        ModelAndView model = new ModelAndView("hotdeal/hotdealList");


        Map<String, Object> rsltMap = new HashMap<>();

        List<HotdealEntity> ruriList = hotdealService.getListHotdeal("ruriweb");
        List<HotdealEntity> ppoList = hotdealService.getListHotdeal("ppomppu");
        List<HotdealEntity> allList = new ArrayList<>();
        allList.addAll(ruriList);
        allList.addAll(ppoList);

        rsltMap.put("ruriList", ruriList);
        rsltMap.put("ppoList", ppoList);
        rsltMap.put("allList", allList);


        model.addObject("allList", allList);

        return model;
    }



}
