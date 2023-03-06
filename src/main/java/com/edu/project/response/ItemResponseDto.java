package com.edu.project.response;

import com.edu.project.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponseDto {

    private Long itemId;
    private Long itemNo;
    private String itemName;

    public ItemResponseDto(Item item) {
        this.itemId = item.getItemId();
        this.itemNo = item.getItemNo();
        this.itemName = item.getItemName();
    }

}
