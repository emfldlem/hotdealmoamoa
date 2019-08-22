package com.emfldlem.hotdeal.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "board_info")
@Entity
@IdClass(Hotdealkey.class)
public class HotdealEntity implements Serializable {

    @Id
    @Column(name="no")
    String no;

    @Id
    @Column(name="boardSe")
    String boardSe;

    @Column(name="keyword")
    String keyword;
    @Column(name="subject")
    String subject;
    @Column(name="url")
    String url;


}
