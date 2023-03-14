package com.edu.project.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class AdgroupActYnListRequestDto {

    private List<AdgroupActYnRequestDto> adgroupList;
}
