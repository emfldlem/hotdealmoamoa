package com.emfldlem.hotdeal.main;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/hotdeal")
public class HotdealController {

    @GetMapping("")
    public String hotdealView() {

        return "hotdeal/list";
    }

    @GetMapping("/initData")
    @ResponseBody
    public Map<String, Object> initData() {
        Map<String, Object>  rsltMap = new HashMap<>();


        try {
            List<HotdealEntity> ruriList = getRuriData();
            List<HotdealEntity> ppoList = getPPoData();
            List<HotdealEntity> allList = new ArrayList<>();
            allList.addAll(ruriList);
            allList.addAll(ppoList);

            rsltMap.put("ruriList", ruriList);
            rsltMap.put("ppoList", ppoList);
            rsltMap.put("allList", allList);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return rsltMap;

    }

     List<HotdealEntity> getRuriData() throws IOException {

        List<HotdealEntity> hotdealList = new ArrayList<>();
        String URL = "";
        for(int i =1; i<=3; i++) {
            URL = "http://bbs.ruliweb.com/ps/board/1020/list?page="+i;
            Document doc = Jsoup.connect(URL).get();
            Elements elemList = doc.select(".table_body:not(.notice)");

            for (Element anElem : elemList) {
                HotdealEntity hotdealEntity = new HotdealEntity();

                String site = "루리웹";
                String subject = anElem.select(".deco").text();
                String url = anElem.select(".deco").attr("href");

                hotdealEntity.setSite(site);
                hotdealEntity.setSubject(subject);
                hotdealEntity.setUrl(url);

                hotdealList.add(hotdealEntity);
            }

        }

        return hotdealList;

    }

     List<HotdealEntity> getPPoData() throws IOException {

        List<HotdealEntity> hotdealList = new ArrayList<>();
        String URL = "http://www.ppomppu.co.kr/zboard/zboard.php?id=ppomppu&page=";

        String site ="뽐뿌";
        for(int i=1; i<=3; i++) {
            URL = URL+i;
            Document doc = Jsoup.connect(URL).get();
            Elements elemList = doc.select(".list_title");
            for (Element anElem : elemList) {
                HotdealEntity hotdealEntity = new HotdealEntity();
                Element elem1 = anElem.parent();

                String subject = elem1.text();
                String url = "http://www.ppomppu.co.kr/zboard/" + elem1.attr("href");

                hotdealEntity.setSite(site);
                hotdealEntity.setSubject(subject);
                hotdealEntity.setUrl(url);

                hotdealList.add(hotdealEntity);
            }
        }

        return hotdealList;

    }

}
