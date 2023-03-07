package com.edu.project.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class SearchItemResponseDto {

    private Long itemId;
    private String itemNo;
    private String itemName;
    private Integer adultYn;
    private String itemOrgCost;
    private Integer itemActYn;

    @QueryProjection
    public SearchItemResponseDto(Long itemId, String itemNo, String itemName, String itemOrgCost, Integer itemActYn, Integer adultYn) {
        this.itemId = itemId;
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.itemOrgCost = itemOrgCost;
        this.itemActYn = itemActYn;
        this.adultYn = adultYn;
    }
}
