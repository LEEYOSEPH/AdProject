package com.edu.project.service;

import com.edu.project.entity.Adgroup;
import com.edu.project.repository.AdgroupRepository;
import com.edu.project.repository.AdgroupRepositoryImpl;
import com.edu.project.request.AdgroupRequestDto;
import com.edu.project.response.AdgroupListResponseDto;
import com.edu.project.response.AdgroupResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class AdgroupServiceTest {

    @Autowired
    private AdgroupService adgroupService;
    @Autowired
    private AdgroupRepository adgroupRepository;

    @Test
    @DisplayName("광고그룹 등록")
    void test1 () {
        //given
        String adGroupName = "광고 테스트";
        AdgroupRequestDto adgroupRequestDto = AdgroupRequestDto.builder().adgroupName(adGroupName).build();
        //when
        AdgroupResponseDto adgroupResponseDto = adgroupService.addAdgroup(adgroupRequestDto);
        //then
    }
    
    @Test
    @DisplayName("광고그룹 조회")
    void test2() {
        //given & when
        List<AdgroupResponseDto> adGroupList = adgroupService.getAdGroupList();
        //then
        assertThat(adGroupList).isNotEmpty();
    }

    @Test
    @DisplayName("광고관리 -광고그룹 조회")
    void test3() {
        //given & when
        String advId = "adv";
        List<AdgroupListResponseDto> adgroupListResponseDto = adgroupService.adMngAdgroupList(advId);
        //then
        System.out.println(adgroupListResponseDto.toString());    }
}