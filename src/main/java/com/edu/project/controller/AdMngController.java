package com.edu.project.controller;

import com.edu.project.request.AdIngActYnRequestDto;
import com.edu.project.request.AdvRequestDto;
import com.edu.project.request.DayLimitBudgetRequestDto;
import com.edu.project.response.AdvResponseDto;
import com.edu.project.service.AdvService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AdMngController {
    private final AdvService advService;

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
        System.out.println(dayLimitBudgetRequestDto);
        return advService.putDayLimitBudget(dayLimitBudgetRequestDto);
    }
}
