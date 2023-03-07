package com.edu.project.service;

import com.edu.project.entity.Adgroup;
import com.edu.project.repository.AdgroupRepository;
import com.edu.project.request.AdgroupRequestDto;
import com.edu.project.response.AdgroupResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdgroupService {
    private final AdgroupRepository adgroupRepository;

    /*
     * 광고그룹 등록
     *
     * */
    public AdgroupResponseDto addAdgroup(AdgroupRequestDto requestDto){
        Adgroup save = adgroupRepository.save(new Adgroup().addAdgroup(requestDto));
        AdgroupResponseDto responseDto = new AdgroupResponseDto(save);
        return responseDto;
    }
    
    /*
    *  광고그룹 목록 조회
    * 
    * */
    public List<AdgroupResponseDto> getAdGroupList(){
        return  adgroupRepository.findAll().stream().map(AdgroupResponseDto::new).collect(Collectors.toList());
    }
}
