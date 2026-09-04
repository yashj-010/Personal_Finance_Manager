package com.syfe.financemanager.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionRequest {
    private Double amount;
    private String date;
    private String category;
    private String description;
}
