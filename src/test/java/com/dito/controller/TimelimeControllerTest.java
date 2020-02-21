package com.dito.controller;

import com.dito.dto.FormatedTimelineDto;
import com.dito.dto.ProductDto;
import com.dito.dto.PurchaseDto;
import com.dito.model.Event;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TimelineController.class)
public class TimelimeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TimelineController controller;

    @Before
    public void init() {

        List<PurchaseDto> timeline = new ArrayList<>();

        // purchase1
        PurchaseDto purchase1 = new PurchaseDto();
        purchase1.setRevenue(120.0);
        purchase1.setTransactionId("3409340");
        purchase1.setStoreName("BH Shopping");
        ProductDto product_p1 = new ProductDto("Tenis Preto", 120.0);
        List<ProductDto> products1 = new ArrayList<>();
        products1.add(product_p1);
        purchase1.setProducts(products1);
        timeline.add(purchase1);

        // purchase2
        PurchaseDto purchase2 = new PurchaseDto();
        purchase2.setRevenue(250.0);
        purchase2.setTransactionId("3029384");
        purchase2.setStoreName("Patio Savassi");
        ProductDto product_p2 = new ProductDto("Camisa Azul", 100.0);
        ProductDto product2_p2 = new ProductDto("Calça Rosa", 150.0);
        List<ProductDto> products2 = new ArrayList<>();
        products2.add(product_p2);
        products2.add(product2_p2);
        purchase2.setProducts(products2);
        timeline.add(purchase2);

        FormatedTimelineDto formatedTimelineDto = new FormatedTimelineDto(timeline);
        when(controller.getEndpoint()).thenReturn(ResponseEntity.ok(formatedTimelineDto));
    }

    @Test
    public void autocomplete() throws Exception {

        mockMvc.perform(get("/timeline")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("timeline", hasSize(2)))
                .andExpect(jsonPath("timeline[0].transactionId", is("3409340")))
                .andExpect(jsonPath("timeline[0].revenue", is(120.0)))
                .andExpect(jsonPath("timeline[0].storeName", is("BH Shopping")))
                .andExpect(jsonPath("timeline[0].products[0].name", is("Tenis Preto")))
                .andExpect(jsonPath("timeline[0].products[0].price", is(120.0)))

                .andExpect(jsonPath("timeline[1].transactionId", is("3029384")))
                .andExpect(jsonPath("timeline[1].revenue", is(250.0)))
                .andExpect(jsonPath("timeline[1].storeName", is("Patio Savassi")))
                .andExpect(jsonPath("timeline[1].products[0].name", is("Camisa Azul")))
                .andExpect(jsonPath("timeline[1].products[0].price", is(100.0)))
                .andExpect(jsonPath("timeline[1].products[1].name", is("Calça Rosa")))
                .andExpect(jsonPath("timeline[1].products[1].price", is(150.0)));

    }


}
