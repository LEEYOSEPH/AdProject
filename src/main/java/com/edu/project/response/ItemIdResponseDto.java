package com.edu.project.response;

import com.edu.project.entity.AD;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemIdResponseDto {

    private Long itemId;

    public ItemIdResponseDto(AD ad) {
        this.itemId = ad.getItemId();
    }
}
