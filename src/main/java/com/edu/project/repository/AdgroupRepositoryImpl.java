package com.edu.project.repository;

import com.edu.project.entity.QAD;
import com.edu.project.entity.QAdgroup;
import com.edu.project.request.AdgroupNameRequestDto;
import com.edu.project.response.AdgroupListResponseDto;
import com.edu.project.response.QAdgroupListResponseDto;
import com.edu.project.response.QSearchItemResponseDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static com.edu.project.entity.QAD.aD;
import static com.edu.project.entity.QAdgroup.adgroup;
import static org.springframework.util.StringUtils.*;

public class AdgroupRepositoryImpl implements AdgroupRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public AdgroupRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<AdgroupListResponseDto> getAdMngAdgroupList() {
        return  queryFactory.select(new QAdgroupListResponseDto(
                adgroup.adgroupId,
                adgroup.adgroupName,
                adgroup.adgroupUseConfigYn,
                aD.adUseConfigYn.count().intValue(),
                aD.adUseConfigYn.count().intValue()
                ))
                .from(adgroup)
                .leftJoin(adgroup.adList, aD)
                .where(adgroup.adgroupActYn.eq(1)
                )
                .groupBy(adgroup.adgroupId)
                .fetch();
    }

    @Override
    public List<AdgroupListResponseDto> searchAdgroupList(AdgroupNameRequestDto requestDto) {
        return queryFactory.select(new QAdgroupListResponseDto(
                adgroup.adgroupId,
                adgroup.adgroupName,
                adgroup.adgroupUseConfigYn,
                aD.adUseConfigYn.count().intValue(),
                aD.adUseConfigYn.count().intValue()
        ))
                .from(adgroup)
                .leftJoin(adgroup.adList, aD)
                .where(adgroupNameEq(requestDto.getAdgroupName()),adgroup.adgroupActYn.eq(1)
                )
                .groupBy(adgroup.adgroupId)
                .fetch();
    }

    private BooleanExpression adgroupNameEq(String adgroupName) {
        return isEmpty(adgroupName) ? null : adgroup.adgroupName.containsIgnoreCase(adgroupName);
    }
}
