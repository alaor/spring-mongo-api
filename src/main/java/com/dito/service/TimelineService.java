package com.dito.service;

import com.dito.dto.ProductDto;
import com.dito.dto.PurchaseDto;
import com.dito.dto.external.CustomDataDto;
import com.dito.dto.external.EventDto;
import com.dito.dto.external.TimelineDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TimelineService {

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    public List<PurchaseDto> getTimeline() {
        List<PurchaseDto> purchases = new ArrayList<>();
        organizePurchases(getSource(), purchases);
        return purchases.stream().sorted(Comparator.comparing(PurchaseDto::getTimestamp)
                .reversed()).collect(Collectors.toList());
    }

    private TimelineDto getSource() {
        return restTemplate.getForObject("https://storage.googleapis.com/dito-questions/events.json",
                TimelineDto.class);
    }

    private void organizePurchases(TimelineDto messyTimeline, List<PurchaseDto> compras) {
        for(EventDto event : messyTimeline.getEvents()) {
            PurchaseDto newPurchase = new PurchaseDto();
            String transactionId = "";

            // if event is comprou
            if (event.getEvent().equalsIgnoreCase("comprou")) {

                for (CustomDataDto customData : event.getCustomData()) {
                    if (customData.getKey().equals("transaction_id")) {
                        transactionId = customData.getValue();
                    }

                    if (customData.getKey().equals("store_name")) {
                        newPurchase.setStoreName(customData.getValue());
                    }
                }

                newPurchase.setRevenue(Double.parseDouble(event.getRevenue()));
                newPurchase.setTimestamp(event.getTimestamp());
                newPurchase.setTransactionId(transactionId);
                newPurchase.setProducts(getProductsByStoreTransactionId(messyTimeline.getEvents(), newPurchase.getTransactionId()));
                compras.add(newPurchase);

            }

        }
    }

    private List<ProductDto> getProductsByStoreTransactionId(List<EventDto> events, String transactionId) {
        List<ProductDto> products = new ArrayList<>();
        for (EventDto event : events) {

            if (event.getEvent().equalsIgnoreCase("comprou-produto")) {

                String boughtProducttransactionId = "";
                String productName = "";
                String productPrice = "";

                for (CustomDataDto customDataDto : event.getCustomData()) {
                    if (customDataDto.getKey().equalsIgnoreCase("transaction_id")) {
                        boughtProducttransactionId = customDataDto.getValue();
                    }
                    if (customDataDto.getKey().equalsIgnoreCase("product_name")) {
                        productName = customDataDto.getValue();
                    }
                    if (customDataDto.getKey().equalsIgnoreCase("product_price")) {
                        productPrice = customDataDto.getValue();
                    }
                }

                if (boughtProducttransactionId.equalsIgnoreCase(transactionId)) {
                    products.add(new ProductDto(productName, Double.parseDouble(productPrice)));
                }

            }

        }
        return products;
    }

}
