package com.edu.project.repository;

import com.edu.project.entity.Item;
import com.edu.project.request.ItemRequestDto;
import com.edu.project.response.SearchItemResponseDto;

import java.util.List;

public interface ItemRepositoryCustom {
    List<SearchItemResponseDto> searchItemLists(ItemRequestDto requestDto);
}
