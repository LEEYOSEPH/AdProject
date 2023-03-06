package com.edu.project.response;

import com.edu.project.entity.Adgroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdgroupResponseDto {

    private Long adgroupId;
    private String adgroupName;

    public AdgroupResponseDto(Adgroup adgroup) {
        this.adgroupId = adgroup.getAdgroupId();
        this.adgroupName = adgroup.getAdgroupName();
    }
}
