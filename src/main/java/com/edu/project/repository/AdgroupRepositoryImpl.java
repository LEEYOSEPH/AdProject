package com.edu.project.repository;

import com.edu.project.entity.QAD;
import com.edu.project.entity.QAdgroup;
import com.edu.project.response.AdgroupListResponseDto;
import com.edu.project.response.QAdgroupListResponseDto;
import com.edu.project.response.QSearchItemResponseDto;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.List;

import static com.edu.project.entity.QAD.aD;
import static com.edu.project.entity.QAdgroup.adgroup;

public class AdgroupRepositoryImpl implements AdgroupRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public AdgroupRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<AdgroupListResponseDto> getAdMngAdgroupList(String advId) {
        return  queryFactory.select(new QAdgroupListResponseDto(
                adgroup.adgroupId,
                adgroup.adgroupName,
                adgroup.adgroupActYn,
                adgroup.adgroupUseConfigYn
                ))
                .from(adgroup)
                .join(adgroup.adList, aD)
                .where(aD.advId.eq(advId),
                        adgroup.adgroupActYn.eq(1),
                        adgroup.adgroupUseConfigYn.eq(1)
                )
                .fetch();
    }
}
