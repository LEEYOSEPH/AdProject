package com.edu.project.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AdgroupUseConfigYnListRequestDto {
    private List<AdgroupUseConfigYnRequestDto> adgroupList;
}
