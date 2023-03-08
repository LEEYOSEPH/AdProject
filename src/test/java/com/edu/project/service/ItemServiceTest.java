package com.edu.project.service;

import com.edu.project.entity.Item;
import com.edu.project.repository.ItemRepository;
import com.edu.project.request.ItemRequestDto;
import com.edu.project.response.SearchItemResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    private ItemService itemService;


    @Test
    @DisplayName("상품 조회 - 조건이 없을때")
    void test() {
        //given
        ItemRequestDto itemRequestDto = new ItemRequestDto();
        itemRequestDto.setItemName(null);
        itemRequestDto.setItemNo(null);

        //when
        List<SearchItemResponseDto> itemResponseDto = itemService.searchItemLists(itemRequestDto);

        //then
        assertThat(itemResponseDto.isEmpty()).isFalse();
    }

    @Test
    @DisplayName("상품 조회 - 상품명만 있을때")
    void test2() {
        //given
        ItemRequestDto itemRequestDto = new ItemRequestDto();
        itemRequestDto.setItemName("나이키");
        itemRequestDto.setItemNo(null);

        //when
        List<SearchItemResponseDto> itemResponseDto = itemService.searchItemLists(itemRequestDto);
        //then
        itemResponseDto.forEach(searchItemResponseDto -> {
            String itemName = searchItemResponseDto.getItemName();
            assertThat(itemName).contains(itemRequestDto.getItemName());
        });
    }

    @Test
    @DisplayName("상품 조회 - 상품번호만 있을때")
    void test3() {
        //given
        ItemRequestDto itemRequestDto = new ItemRequestDto();
        itemRequestDto.setItemName(null);
        itemRequestDto.setItemNo("1");

        //when
        List<SearchItemResponseDto> itemResponseDto = itemService.searchItemLists(itemRequestDto);
        //then
        itemResponseDto.forEach(searchItemResponseDto -> {
            String itemNo = searchItemResponseDto.getItemNo();
            assertThat(itemNo).contains(itemRequestDto.getItemNo());
        });
    }

    @Test
    @DisplayName("상품 조회 - 상품명 및 상품번호 있을때")
    void test4() {
        //given
        ItemRequestDto itemRequestDto = new ItemRequestDto();
        itemRequestDto.setItemName("나이티");
        itemRequestDto.setItemNo("1");

        //when
        List<SearchItemResponseDto> itemResponseDto = itemService.searchItemLists(itemRequestDto);
        //then
        itemResponseDto.forEach(searchItemResponseDto -> {
            String itemNo = searchItemResponseDto.getItemNo();
            String itemName = searchItemResponseDto.getItemName();
            assertThat(itemNo).contains(itemRequestDto.getItemNo());
            assertThat(itemName).contains(itemRequestDto.getItemName());
        });
    }

}