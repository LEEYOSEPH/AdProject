package com.edu.project.entity;

import com.edu.project.request.AdRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
public class AD {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adId;
    private Integer adUseConfigYn;
    private Date regTime;
    private Integer adActYn;
    
    /*광고와 상품은 N:1 관계*/
    @ManyToOne
    @JoinColumn(name = "itemId",insertable = false, updatable = false)
    private Item item;
    private Long itemId;

    /*광고와 광고 그룹은 N:1 관계*/
    @ManyToOne
    @JoinColumn(name = "adgroupId",insertable = false, updatable = false)
    private Adgroup adgroup;
    private Long adgroupId;

    @Builder
    public AD (Long itemId, Long adgroupId) {
        this.adUseConfigYn = 1;
        this.regTime = new Date();
        this.adActYn = 1;
        this.itemId = itemId;
        this.adgroupId = adgroupId;
    }

    public AD addAd (AdRequestDto requestDto) {
        AD ad = AD.builder()
                .itemId(requestDto.getItemId())
                .adgroupId(requestDto.getAdgroupId())
                .build();
        return ad;
    }
}
