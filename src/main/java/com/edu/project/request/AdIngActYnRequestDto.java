package com.edu.project.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdIngActYnRequestDto {
    private String advId;
    private Integer adIngActYn; // 광고진행 활성여부

    @Builder
    public AdIngActYnRequestDto (String advId, Integer adINgActYn) {
        this.advId = advId;
        this.adIngActYn = adINgActYn;

    }
}
