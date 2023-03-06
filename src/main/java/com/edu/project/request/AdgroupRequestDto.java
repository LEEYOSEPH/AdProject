package com.edu.project.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class AdgroupRequestDto {
    private String adgroupName;

    @Builder
    public AdgroupRequestDto(String adgroupName) {
        this.adgroupName = adgroupName;
    }
}
