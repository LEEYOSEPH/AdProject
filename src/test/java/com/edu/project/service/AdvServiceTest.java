package com.edu.project.service;

import com.edu.project.request.AdIngActYnRequestDto;
import com.edu.project.request.AdvRequestDto;
import com.edu.project.request.DayLimitBudgetRequestDto;
import com.edu.project.response.AdvResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdvServiceTest {

    @Autowired
    private AdvService advService;

    @Test
    @DisplayName("광고주 정보 불러오기")
    void test() {
        //given
        String advId = "adv";
        AdvRequestDto advRequestDto = new AdvRequestDto();
        advRequestDto.setAdvId(advId);

        //when
        AdvResponseDto advInfo = advService.getAdvInfo(advRequestDto);

        //then
        assertThat(advId).isEqualTo(advInfo.getAdvId());

    }

    @Test
    @DisplayName("광고주 활성정보 여부 변경")
    void test2() {
        //given
        String advId = "adv";
        AdIngActYnRequestDto adIngActYnRequestDto = new AdIngActYnRequestDto();
        adIngActYnRequestDto.setAdvId(advId);
        adIngActYnRequestDto.setAdIngActYn(1);

        //when
        AdvResponseDto advResponseDto = advService.putAdIngActYn(adIngActYnRequestDto);

        //then
        assertThat(1).isEqualTo(advResponseDto.getAdIngActYn());
    }


    @Test
    @DisplayName("광고주 일일 허용 예산변경")
    void test3() {
        //given
        String advId = "adv";
        DayLimitBudgetRequestDto dayLimitBudgetRequestDto = new DayLimitBudgetRequestDto();
        dayLimitBudgetRequestDto.setAdvId(advId);
        dayLimitBudgetRequestDto.setDayLimitBudget(2000);
        //when
        AdvResponseDto advResponseDto = advService.putDayLimitBudget(dayLimitBudgetRequestDto);

        //then
        assertThat(2000).isEqualTo(advResponseDto.getDayLimitBudget());
    }
}