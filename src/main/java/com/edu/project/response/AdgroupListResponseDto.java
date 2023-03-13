package com.edu.project.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.ToString;

@Data
public class AdgroupListResponseDto {
    private Long adgroupId;
    private String adgroupName;
    private Integer adgroupActYn;  // 광고그룹 활성 여부
    private Integer adgroupUseConfigYn; // 광고그룹 사용 설정 여부

    @QueryProjection
    public AdgroupListResponseDto(Long adgroupId, String adgroupName, Integer adgroupActYn, Integer adgroupUseConfigYn ) {
        this.adgroupId = adgroupId;
        this.adgroupName = adgroupName;
        this.adgroupActYn = adgroupActYn;
        this.adgroupUseConfigYn = adgroupUseConfigYn;
    }
}
