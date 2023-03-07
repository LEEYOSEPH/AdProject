package com.edu.project.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
public class Adv implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "adv_id",referencedColumnName = "member_id")
    private Member member;
    private Integer adIngActYn;
    private Integer balance;
    private Integer eventMoneyBalance;
    private Integer dayLimitBudget;
}
