package com.syfe.financemanager.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GoalRequest {
    private String goalName;
    private Double targetAmount;
    private String targetDate;
    private String startDate;
}
