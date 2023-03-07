package com.edu.project.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
public class DadDet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dadDetId;
    private String dadCnrStatus; // 기본: APPROVAL
    private Integer dadUseConfigYn;
    private Integer dadActYn;
    private Date regTime;

    /*직접광고 상세와 키워드는 N:1관계*/
    @ManyToOne
    @JoinColumn(name = "kwdId",insertable = false,updatable = false)
    private Kwd kwd;
    private Long kwdId;

    /*직접광고 상세와 광고는 N:1 관계*/
    @ManyToOne
    @JoinColumn(name = "adId",insertable = false,updatable = false)
    private AD ad;
    private Long adId;

    @Builder
    public DadDet(Long adId,Long kwdId) {
        this.adId = adId;
        this.kwdId = kwdId;
        this.dadCnrStatus = "APPROVAL";
        this.dadUseConfigYn = 1;
        this.dadActYn = 1;
        this.regTime = new Date();

    }
    
    /*
    *  직접광고 상세 등록 키워드 제외
    * */
    public DadDet addDadDet(Long adId) {
        return DadDet.builder()
                .adId(adId)
                .build();
    }

    /*
     *  직접광고 상세 등록 키워드 제외
     * */
    public DadDet addDadDetKwd(Long adId,Long kwdId) {
        return DadDet.builder()
                .kwdId(kwdId)
                .adId(adId)
                .build();
    }
}
