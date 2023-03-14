package com.edu.project.service;

import com.edu.project.entity.Adgroup;
import com.edu.project.repository.AdgroupRepository;
import com.edu.project.repository.AdgroupRepositoryImpl;
import com.edu.project.request.AdgroupActYnRequestDto;
import com.edu.project.request.AdgroupRequestDto;
import com.edu.project.response.AdgroupListResponseDto;
import com.edu.project.response.AdgroupResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdgroupService {
    private final AdgroupRepository adgroupRepository;
    private final AdgroupRepositoryImpl adgroupImplRepository;

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

    /*
    * 광고관리 - 그룹리스트 조회
    * */
    public List<AdgroupListResponseDto> getAdMngAdgroupList(String advId) {
        return  adgroupImplRepository.getAdMngAdgroupList(advId);
    }

    /*
     * 광고관리 - 광고그룹 활성상태 변경
     * */
    @Transactional
    public List<AdgroupListResponseDto> putAdgroupActYn(AdgroupActYnRequestDto adgroupActYnRequestDto) {
        Adgroup adgroup = adgroupRepository.findById(adgroupActYnRequestDto.getAdgroupId()).orElseThrow(() -> new IllegalArgumentException("일치하는 광고그룹이 없습니다."));
        adgroup.adgroupActYnUpdate(adgroupActYnRequestDto.getAdgroupActYn());
       return getAdMngAdgroupList(adgroupActYnRequestDto.getAdvId());
    }
}
