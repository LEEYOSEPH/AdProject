package com.edu.project.service;

import com.edu.project.response.ItemResponseDto;
import com.edu.project.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    
    /*
    * 상품명 조회
    *
    * */
    public List<ItemResponseDto> getItemList(String itemName) {
        return  itemRepository.findByItemNameContaining(itemName).stream().map(ItemResponseDto::new).collect(Collectors.toList());
    }



}
