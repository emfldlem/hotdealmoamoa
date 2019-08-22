package com.emfldlem.hotdeal.Service;

import com.emfldlem.hotdeal.Entity.HotdealEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotdealRepository extends CrudRepository<HotdealEntity, String> {

    HotdealEntity findByBoardSe(String boardSe);

    HotdealEntity findFirstByBoardSeOrderByNoDesc(String boardSe);

    @Query(value = "select * from board_info where board_se = :boardSe order by no DESC limit 20", nativeQuery = true)
    List<HotdealEntity> findListByBoardSe(@Param("boardSe") String boardSe);





}
