package com.edu.project.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class AdgroupUseConfigYnRequestDto {

    private Long adgroupId;
    private Integer adgroupUseConfigYn; // 광고그룹 사용 설정 여부

    public AdgroupUseConfigYnRequestDto(AdgroupUseConfigYnRequestDto requestDto) {
        this.adgroupId = requestDto.adgroupId;
        this.adgroupUseConfigYn = requestDto.adgroupUseConfigYn;
    }
}
