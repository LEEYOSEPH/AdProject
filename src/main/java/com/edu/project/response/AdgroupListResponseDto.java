package com.edu.project.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.ToString;

@Data
public class AdgroupListResponseDto {
    private Long adgroupId;
    private String adgroupName;
    private Integer adgroupUseConfigYn;  // 광고그룹  사용여부
    private Integer adActYn; // 광고 활성 여부
    private Integer adUseConfigYn; // 광고 사용 설정 여부

    @QueryProjection
    public AdgroupListResponseDto(Long adgroupId, String adgroupName, Integer adgroupUseConfigYn,Integer adActYn, Integer adUseConfigYn ) {
        this.adgroupId = adgroupId;
        this.adgroupName = adgroupName;
        this.adgroupUseConfigYn = adgroupUseConfigYn;
        this.adActYn = adActYn;
        this.adUseConfigYn = adUseConfigYn;
    }
}
