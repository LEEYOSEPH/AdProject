package com.edu.project.service;

import com.edu.project.response.ItemIdResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class AdServiceTest {

    @Autowired
    private AdService adService;

    @Test
    @DisplayName("등록된 상품여부 조회")
    void test() {
        //given
        Long itemId = 1L;
        
        //when
        ItemIdResponseDto adItem = adService.getItemId(itemId);
        
        //then
        assertThat(itemId).isEqualTo(adItem.getItemId());
    }
    
}