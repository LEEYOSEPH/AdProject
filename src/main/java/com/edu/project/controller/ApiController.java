package com.edu.project.controller;

import com.edu.project.repository.ItemRepositoryImpl;
import com.edu.project.request.AdRequestDto;
import com.edu.project.request.AdgroupRequestDto;
import com.edu.project.request.ItemRequestDto;
import com.edu.project.response.AdgroupResponseDto;
import com.edu.project.response.ItemIdResponseDto;
import com.edu.project.response.SearchItemResponseDto;
import com.edu.project.service.AdService;
import com.edu.project.service.AdgroupService;
import com.edu.project.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final ItemService itemService;
    private final AdgroupService adgroupService;
    private final AdService adService;

    /*
     *  상품명 검색조건 조회 API - QueryDsl
     *  RequestBody : ItemRequestDto
     *  return : List<SearchItemResponseDto>
     * */
    @PostMapping("/api/searchItemLists")
    @ResponseBody
    public  List<SearchItemResponseDto> searchItemLists(@RequestBody ItemRequestDto requestDto) {
        return itemService.searchItemLists(requestDto);
    }

    /*
     *  광고그룹 등록 API
     *  requestBody : AdgroupRequestDto
     *  return : AdgroupResponseDto
     * */
    @PostMapping("/api/adgroup")
    @ResponseBody
    public AdgroupResponseDto addAdgroup (@RequestBody AdgroupRequestDto requestDto) {
        return adgroupService.addAdgroup(requestDto);
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
    *  등록된 광고 및 활성 여부 확인 API
    * */
    @GetMapping("/api/getItemId")
    @ResponseBody
    public ItemIdResponseDto getItemId (@RequestParam(value = "itemId") Long itemId) {
        ItemIdResponseDto id = adService.getItemId(itemId);
        return id;
    }
}
