package com.edu.project.service;

import com.edu.project.entity.Adv;
import com.edu.project.repository.AdvRepository;
import com.edu.project.request.AdIngActYnRequestDto;
import com.edu.project.request.AdvRequestDto;
import com.edu.project.request.DayLimitBudgetRequestDto;
import com.edu.project.response.AdvResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AdvService {
    private final AdvRepository advRepository;
    
    /*
    *  광고주 정보 조회
    * */
    public AdvResponseDto getAdvInfo(AdvRequestDto advRequestDto) {
        return advRepository.findByAdvId(advRequestDto.getAdvId());
    }

    /*
    * 광고주 활성여부 변경
    * */
    @Transactional
    public AdvResponseDto putAdIngActYn(AdIngActYnRequestDto adIngActYnRequestDto) {
        Adv adv = advRepository.findById(adIngActYnRequestDto.getAdvId()).orElseThrow(() -> new IllegalArgumentException("회정 정보가 없습니다."));
        adv.adIngActYnUpdate(adIngActYnRequestDto.getAdIngActYn());
        return advRepository.findByAdvId(adv.getAdvId());
    }

    /*
     * 광고주 일일 허용 예산 변경
     * */
    @Transactional
    public AdvResponseDto putDayLimitBudget(DayLimitBudgetRequestDto dayLimitBudgetRequestDto) {
        Adv adv = advRepository.findById(dayLimitBudgetRequestDto.getAdvId()).orElseThrow(() -> new IllegalArgumentException("회원 정보가 없습니다."));
        adv.dayLimitBudgetUpdate(dayLimitBudgetRequestDto.getDayLimitBudget());
        return advRepository.findByAdvId(dayLimitBudgetRequestDto.getAdvId());
    }
}
