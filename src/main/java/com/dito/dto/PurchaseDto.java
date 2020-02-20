package com.dito.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PurchaseDto {

    private Date timestamp;
    private Double revenue;
    private String transactionId;
    private String storeName;
    private List<ProductDto> products;

}
