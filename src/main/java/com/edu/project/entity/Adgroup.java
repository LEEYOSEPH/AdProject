package com.edu.project.entity;

import com.edu.project.request.AdgroupRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Adgroup {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adgroupId;
    private String adgroupName;
    private Date regTime;
    private Integer adgroupActYn;  // 광고그룹 활성 여부
    private Integer adgroupUseConfigYn; // 광고그룹 사용 설정 여부

    @OneToMany(mappedBy = "adgroup", cascade = CascadeType.ALL)
    private List<AD> adList = new ArrayList<>();

    @Builder
    public Adgroup(String adgroupName){
        this.adgroupName = adgroupName;
        this.regTime = new Date();
        this.adgroupActYn = 1;
        this.adgroupUseConfigYn = 1;

    }

    /* 광고그룹 생성*/
    public Adgroup addAdgroup(AdgroupRequestDto requestDto){
        Adgroup adgroup = Adgroup.builder()
                .adgroupName(requestDto.getAdgroupName())
                .build();
        return adgroup;
    }

    /*광고그룹 활성여부 변경*/
    public void adgroupActYnUpdate(Integer adgroupActYn) {
        this.adgroupActYn = adgroupActYn;
    }
}
