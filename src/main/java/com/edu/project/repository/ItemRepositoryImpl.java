package com.edu.project.repository;

import com.edu.project.request.ItemRequestDto;
import com.edu.project.response.QSearchItemResponseDto;
import com.edu.project.response.SearchItemResponseDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.persistence.EntityManager;
import java.util.List;

import static com.edu.project.entity.QItem.item;
import static org.springframework.util.StringUtils.*;

public class ItemRepositoryImpl implements ItemRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public ItemRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<SearchItemResponseDto> searchItemLists(ItemRequestDto requestDto) {
        return queryFactory
                .select(new QSearchItemResponseDto(
                        item.itemId,
                        item.itemNo,
                        item.itemName,
                        item.itemOrgCost,
                        item.itemActYn,
                        item.adultYn
                ))
                .from(item)
                .where(itemNameEq(requestDto.getItemName()),
                        itemNoEq(requestDto.getItemNo())
                )
                .fetch();
    }

    private BooleanExpression itemNameEq(String itemName) {
        return isEmpty(itemName) ? null : item.itemName.contains(itemName);
    }

    private BooleanExpression itemNoEq(String itemNo) {
        return isEmpty(itemNo) ? null : item.itemNo.contains(itemNo);
    }

}
