package com.edu.project.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
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
}
