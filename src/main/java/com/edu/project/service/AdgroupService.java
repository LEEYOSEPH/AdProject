package com.edu.project.service;

import com.edu.project.entity.Adgroup;
import com.edu.project.repository.AdgroupRepository;
import com.edu.project.repository.AdgroupRepositoryImpl;
import com.edu.project.request.*;
import com.edu.project.response.AdgroupListResponseDto;
import com.edu.project.response.AdgroupResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.StringUtils.*;

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
    public List<AdgroupListResponseDto> getAdMngAdgroupList() {
        return  adgroupImplRepository.getAdMngAdgroupList();
    }

    /*
     * 광고관리 - 광고그룹 삭제
     * */
    @Transactional
    public List<AdgroupListResponseDto> putAdgroupListActYn(AdgroupActYnListRequestDto requestDto){
        List<AdgroupActYnRequestDto> adgroupActYnRequestDtoList = requestDto.getAdgroupList().stream().map(AdgroupActYnRequestDto::new).collect(Collectors.toList());
        adgroupActYnRequestDtoList.forEach(adgroupActYnRequestDto -> {
            Adgroup adgroup = adgroupRepository.findById(adgroupActYnRequestDto.getAdgroupId()).orElseThrow(() -> new IllegalArgumentException("일치하는 광고그룹이 없습니다."));
            adgroup.adgroupActYnUpdate(adgroupActYnRequestDto.getAdgroupActYn());
        });
        return getAdMngAdgroupList();
    }

    /*
     * 광고관리 - 광고그룹리스트 사용여부 변경 - 단건
     * */
   @Transactional
    public  List<AdgroupListResponseDto> putAdgroupUseConfigYn(AdgroupUseConfigYnRequestDto requestDto) {
        Adgroup adgroup = adgroupRepository.findById(requestDto.getAdgroupId()).orElseThrow(() -> new IllegalArgumentException("일치하는 광고그룹이 없습니다."));
        adgroup.adgroupUseConfigYnUpdate(requestDto.getAdgroupUseConfigYn());
        return getAdMngAdgroupList();
    }

    /*
     * 광고관리 - 광고그룹리스트 사용여부 변경
     * */
    @Transactional
    public List<AdgroupListResponseDto> putAdgroupUseConfigListYn(AdgroupUseConfigYnListRequestDto requestDto) {
        List<AdgroupUseConfigYnRequestDto> adgroupUseConfigYnRequestDto = requestDto.getAdgroupList().stream().map(AdgroupUseConfigYnRequestDto::new).collect(Collectors.toList());
        adgroupUseConfigYnRequestDto.forEach(useConfigYnRequestDto ->{
            Adgroup adgroup = adgroupRepository.findById(useConfigYnRequestDto.getAdgroupId()).orElseThrow(() -> new IllegalArgumentException("일지하틑 회원이 없습니다."));
            adgroup.adgroupUseConfigYnUpdate(useConfigYnRequestDto.getAdgroupUseConfigYn());
        } );
        return getAdMngAdgroupList();
    }

    /*
     * 광고관리 - 광고그룹명 검색
     * */
    public List<AdgroupListResponseDto> searchAdgroupList(AdgroupNameRequestDto requestDto) {
        return adgroupImplRepository.searchAdgroupList(requestDto);
    }

    /*
     * 광고관리 -그룹 추가
     *
     * */
    public List<AdgroupListResponseDto> adMngAddAdgroup(AddAdgroupRequestDto requestDto){
        adgroupRepository.save(new Adgroup().adMngAddAdgroup(requestDto.getAdgroupName()));
        return getAdMngAdgroupList();
    }
}
