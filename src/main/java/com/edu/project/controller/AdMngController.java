package com.edu.project.controller;

import com.edu.project.request.AdIngActYnRequestDto;
import com.edu.project.request.AdgroupActYnRequestDto;
import com.edu.project.request.AdvRequestDto;
import com.edu.project.request.DayLimitBudgetRequestDto;
import com.edu.project.response.AdgroupListResponseDto;
import com.edu.project.response.AdvResponseDto;
import com.edu.project.service.AdgroupService;
import com.edu.project.service.AdvService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdMngController {
    private final AdvService advService;
    private final AdgroupService adgroupService;

    /*
     *  광고주 정보조회 API
     *  RequestBody : AdvRequestDto
     *  return : AdvResponseDto
     * */
    @PostMapping("/api/advInfo")
    @ResponseBody
    public AdvResponseDto getAdvInfo(@RequestBody  AdvRequestDto advRequestDto) {
        System.out.println(advRequestDto.getAdvId());
        AdvResponseDto advInfo = advService.getAdvInfo(advRequestDto);
        return advInfo;
    }

    /*
     *  광고주 광고설정 업데이트 API
     *  RequestBody : AdIngActYnRequestDto
     *  return : AdvResponseDto
     * */
    @PutMapping("/api/putAdIngActYn")
    @ResponseBody
    public AdvResponseDto putAdIngActYn(@RequestBody AdIngActYnRequestDto adIngActYnRequestDto) {
        System.out.println(adIngActYnRequestDto);
        return advService.putAdIngActYn(adIngActYnRequestDto);
    }

    /*
     *  광고주 일일 허용예산 업데이트 API
     *  RequestBody : AdIngActYnRequestDto
     *  return : AdvResponseDto
     * */
    @PutMapping("/api/putDayLimitBudget")
    @ResponseBody
    public AdvResponseDto putDayLimitBudget(@RequestBody DayLimitBudgetRequestDto dayLimitBudgetRequestDto) {
        return advService.putDayLimitBudget(dayLimitBudgetRequestDto);
    }
    
    /*
     *  광고그룹 리스트 조회 API
     *  RequestParam : advId
     *  return :  List<AdgroupListResponseDto>
     * */
    @GetMapping("/api/getAdMngAdgroupList")
    @ResponseBody
    public List<AdgroupListResponseDto> getAdMngAdgroupList(@RequestParam(value = "advId") String advId) {
        return adgroupService.getAdMngAdgroupList(advId);
    }

    /*
     *  광고그룹 활성여부 변경 API
     *  RequestBody : AdgroupActYnRequestDto
     *  return :  List<AdgroupListResponseDto>
     * */
    @PutMapping("/api/putAdgroupActYn")
    @ResponseBody
    public List<AdgroupListResponseDto> putAdgroupActYn(@RequestBody AdgroupActYnRequestDto adgroupActYnRequestDto) {
        return adgroupService.putAdgroupActYn(adgroupActYnRequestDto);
    }
}
