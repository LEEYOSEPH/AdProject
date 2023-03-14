package com.edu.project.repository;

import com.edu.project.request.AdgroupNameRequestDto;
import com.edu.project.response.AdgroupListResponseDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdgroupRepositoryCustom {
    List<AdgroupListResponseDto> getAdMngAdgroupList();

    List<AdgroupListResponseDto> searchAdgroupList(AdgroupNameRequestDto requestDto);
}
