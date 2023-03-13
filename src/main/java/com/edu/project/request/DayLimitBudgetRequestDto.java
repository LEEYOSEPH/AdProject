package com.edu.project.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DayLimitBudgetRequestDto {
    private String advId;
    private Integer dayLimitBudget; // 일제한 예산

    @Builder
    public DayLimitBudgetRequestDto (String advId, Integer dayLimitBudget) {
        this.advId = advId;
        this.dayLimitBudget = dayLimitBudget;

    }
}
