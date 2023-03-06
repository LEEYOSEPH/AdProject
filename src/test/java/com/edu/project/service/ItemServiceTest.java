package com.edu.project.service;

import com.edu.project.repository.ItemRepository;
import com.edu.project.response.ItemResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    private ItemService itemService;
    
    @Test
    @DisplayName("상품명 조회")
    void test1() {
        //given

        String itemName = "993";

        //when
        List<ItemResponseDto> itemList = itemService.getItemList(itemName);
        //then
        Assertions.assertThat(1).isEqualTo(itemList.size());
    }
}