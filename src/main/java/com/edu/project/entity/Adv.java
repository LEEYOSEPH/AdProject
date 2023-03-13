package com.edu.project.entity;

import com.edu.project.request.AdvRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
public class Adv implements Serializable {

    @Id
    private String advId;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "adv_id",referencedColumnName = "member_id")
    private Member member;
    private Integer adIngActYn; // 광고진행 활성여부
    private Integer balance; // 잔액
    private Integer eventMoneyBalance; // 이벤트 머니 잔액
    private Integer dayLimitBudget; // 일제한 예산

    /* 광고 진행 활성여부 update*/
    public void adIngActYnUpdate(Integer adIngActYn) {
        this.adIngActYn = adIngActYn;
    }

    /* 일일 허용 예산 update*/
    public void dayLimitBudgetUpdate(Integer dayLimitBudget) {this.dayLimitBudget = dayLimitBudget;}
}
