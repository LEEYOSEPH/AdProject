package com.edu.project.entity;

import com.edu.project.request.AdgroupRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
public class Adgroup {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adgroupId;
    private String adgroupName;
    private Date regTime;
    private Integer adgroupActYn;
    private Integer adgroupUseConfigYn;

    @Builder
    public Adgroup(String adgroupName){
        this.adgroupName = adgroupName;
        this.regTime = new Date();
        this.adgroupActYn = 1;
        this.adgroupUseConfigYn = 1;

    }

    public Adgroup addAdgroup(AdgroupRequestDto requestDto){
        Adgroup adgroup = Adgroup.builder()
                .adgroupName(requestDto.getAdgroupName())
                .build();
        return adgroup;
    }
}
