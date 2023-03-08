package com.edu.project.service;

import com.edu.project.repository.ItemRepositoryImpl;
import com.edu.project.request.ItemRequestDto;
import com.edu.project.response.SearchItemResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepositoryImpl itemRepositoryImpl;

    /*
     * 상품명 조회 - QueryDsl
     *
     * */
    public List<SearchItemResponseDto> searchItemLists(ItemRequestDto requestDto) {
        return itemRepositoryImpl.searchItemLists(requestDto);
    }


}
