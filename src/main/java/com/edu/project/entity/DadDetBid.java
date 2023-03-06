package com.edu.project.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class DadDetBid {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*입찰금액과 직접광고 상세는 1:1 관계*/
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "dadDetId", insertable = false,updatable = false)
    private DadDet dadDet;
    private Long dadDetId;
    private int bidCost;

    @Builder
    public DadDetBid(Long dadDetId, int bidCost){
        this.dadDetId = dadDetId;
        this.bidCost = bidCost;

    }
    public DadDetBid addDadDetBid(Long dadDetId, int bidCost){
        return  DadDetBid.builder()
                .dadDetId(dadDetId)
                .bidCost(bidCost)
                .build();
    }
}
