package com.edu.project.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AdRequestDto {
    private Long itemId;
    private Long adgroupId;

    private List<KwdRequestDto> kWds;

    public AdRequestDto(Long itemId, Long adgroupId, List<KwdRequestDto> kWds) {
        this.itemId = itemId;
        this.adgroupId = adgroupId;
        this.kWds = kWds;

    }
}
