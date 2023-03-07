package com.edu.project.response;

import com.edu.project.entity.Adgroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdgroupResponseDto {

    private String adgroupName;

    public AdgroupResponseDto(Adgroup adgroup) {
        this.adgroupName = adgroup.getAdgroupName();
    }
}
