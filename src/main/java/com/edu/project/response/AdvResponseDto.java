package com.edu.project.response;


import com.edu.project.entity.Adv;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdvResponseDto {
    private String advId;
    private Integer adIngActYn; // 광고진행 활성여부
    private Integer balance; // 잔액
    private Integer eventMoneyBalance; // 이벤트 머니 잔액
    private Integer dayLimitBudget; // 일제한 예산

    public AdvResponseDto(Adv adv) {
        this.advId = adv.getAdvId();
        this.adIngActYn = adv.getAdIngActYn();
        this.balance = adv.getBalance();
        this.eventMoneyBalance = adv.getEventMoneyBalance();
        this.dayLimitBudget = adv.getDayLimitBudget();
    }
}
