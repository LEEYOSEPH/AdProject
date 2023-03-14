package com.edu.project.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdgroupActYnRequestDto {
    private String advId;
    private Long adgroupId;
    private Integer adgroupActYn;  // 광고그룹 활성 여부

    public AdgroupActYnRequestDto(AdgroupActYnRequestDto requestDto) {
        this.advId = requestDto.getAdvId();
        this.adgroupId = requestDto.adgroupId;
        this.adgroupActYn = requestDto.getAdgroupActYn();

    }

}
