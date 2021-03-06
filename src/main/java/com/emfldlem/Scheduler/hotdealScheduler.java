package com.emfldlem.Scheduler;

import com.emfldlem.hotdeal.Entity.HotdealEntity;
import com.emfldlem.hotdeal.Service.HotdealService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Slf4j
@Component
public class hotdealScheduler {

    @Value("${ruriweb.url}")
    String ruriwebUrl;

    @Value("${ppomppu.rul}")
    String ppomppuUrl;

    @Autowired
    HotdealService hotdealService;

    //todo 나중에 스케줄러만 따로 배치로 만들자
    //10분마다
    //@Scheduled(cron = "* */10  *  *  * *")
    //10초마다
    //@Scheduled(cron = "*/10 *  *  *  * *")
    void getRuriDataTEST() {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 스케줄 시작한다.");

        try {
            String URL = "";
            URL = ruriwebUrl + "1";
            Document doc = Jsoup.connect(URL).get();
            Elements elemList = doc.select(".table_body:not(.notice)");

            for (Element anElem : elemList) {
                if(!StringUtils.isEmpty(anElem.select(".id").text()) ){
                    String no = anElem.select(".id").text();
                    int empNo = Integer.parseInt(anElem.select(".id").text());
                    int lastNo = Integer.parseInt(hotdealService.getLastBoardNo("ruriweb"));

                    if (empNo > lastNo) {
                        HotdealEntity hotdealEntity = new HotdealEntity();
                        String subject = anElem.select(".deco").text();
                        String url = anElem.select(".deco").attr("href");

                        hotdealEntity.setNo(no);
                        hotdealEntity.setBoardSe("ruriweb");
                        hotdealEntity.setSubject(subject);
                        hotdealEntity.setUrl(url);

                        hotdealService.saveHotdealInfo(hotdealEntity);

                    }
                }

            }
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    //@Scheduled(cron = "* */10  *  *  * *")
   // @Scheduled(cron = "*/15 *  *  *  * *")
    void getPPoData() {
        try {
            String URL = ppomppuUrl;

            URL = URL + 1;

            Document doc = Jsoup.connect(URL).get();
            Elements elemList_list1 = doc.select(".list1");
            Elements elemList_list0 = doc.select(".list0");
            Elements total = new Elements();

            for (int l = 9; l >= 0; l--) {
                total.add(elemList_list1.get(l));
                total.add(elemList_list0.get(l));
            }

            for (Element anElem : total) {

                HotdealEntity hotdealEntity = new HotdealEntity();

                String no = anElem.child(0).text();
                String subject = anElem.select(".list_title").text();
                String url = "http://www.ppomppu.co.kr/zboard/" + anElem.select(".list_title").parents().attr("href");

                int empNo = Integer.parseInt(no);
                int lastNo = Integer.parseInt(hotdealService.getLastBoardNo("ppomppu"));

                if (empNo > lastNo) {

                    hotdealEntity.setNo(no);
                    hotdealEntity.setBoardSe("ppomppu");
                    hotdealEntity.setSubject(subject);
                    hotdealEntity.setUrl(url);

                    hotdealService.saveHotdealInfo(hotdealEntity);
                }
            }
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }

    }

}
