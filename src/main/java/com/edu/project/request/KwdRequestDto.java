package com.edu.project.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KwdRequestDto {

    private String kwdName;
    private int bidCost;


    public KwdRequestDto(KwdRequestDto kwdRequestDto) {
        this.kwdName = kwdRequestDto.getKwdName();
        this.bidCost = kwdRequestDto.getBidCost();
    }
}
