package com.edu.project.controller;

import com.edu.project.entity.AD;
import com.edu.project.request.AdRequestDto;
import com.edu.project.request.AdgroupRequestDto;
import com.edu.project.request.KwdRequestDto;
import com.edu.project.response.AdgroupResponseDto;
import com.edu.project.response.ItemIdResponseDto;
import com.edu.project.response.ItemResponseDto;
import com.edu.project.service.AdService;
import com.edu.project.service.AdgroupService;
import com.edu.project.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final ItemService itemService;
    private final AdgroupService adgroupService;
    private final AdService adService;

    /*
    *  상품명 검색조건 조회 API
    *  params : itemName
    *  return : List<ItemResponseDto>
    * */
    @GetMapping("/api/getItemList")
    @ResponseBody
    public List<ItemResponseDto> getItemList(@RequestParam(value = "itemName") String itemName) {
        return itemService.getItemList(itemName);
    }

    /*
     *  광고그룹 등록 API
     *  requestBody : AdgroupRequestDto
     *  return : void
     * */
    @PostMapping("/api/adgroup")
    @ResponseBody
    public Long postAdgroup(@RequestBody AdgroupRequestDto requestDto){

        return  adgroupService.addAdgroup(requestDto);
    }

    /*
     *  광고그룹 목록 조회 API
     *  return : List<AdgroupResponseDto>
     * */
    @GetMapping("/api/adgroup")
    @ResponseBody
    public List<AdgroupResponseDto> getAdgroupList() {
        List<AdgroupResponseDto> agroupList = adgroupService.getAdGroupList();

        return agroupList;
    }

    /*
    *  광고등록 API
    * */
    @PostMapping("/api/postAd")
    @ResponseBody
    public void postAd(@RequestBody AdRequestDto requestDto) {
        adService.postAd(requestDto);
    }

    /*
    *  등록된 광고 확인 API
    * */
    @GetMapping("/api/getItemId")
    @ResponseBody
    public ItemIdResponseDto getItemId (@RequestParam(value = "itemId") Long itemId) {
        ItemIdResponseDto id = adService.getItemId(itemId);
        return id;
    }
}
