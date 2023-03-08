package com.edu.project.request;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class AdRequestDto {
    private Long itemId;
    private Long adgroupId;
    private String adgroupName;
    private String advId;
    private List<KwdRequestDto> kWds;

    public AdRequestDto(Long itemId, Long adgroupId, List<KwdRequestDto> kWds, String advId) {
        this.itemId = itemId;
        this.adgroupId = adgroupId;
        this.kWds = kWds;
        this.advId = advId;
    }
}
