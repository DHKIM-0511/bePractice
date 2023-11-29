package com.example.cafekiosk.spring.api.controller;

import static com.example.cafekiosk.spring.domain.product.ProductSellingStatus.SELLING;
import static com.example.cafekiosk.spring.domain.product.ProductType.HANDMADE;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.cafekiosk.spring.api.controller.product.ProductController;
import com.example.cafekiosk.spring.api.service.product.ProductService;
import com.example.cafekiosk.spring.api.service.product.Response.ProductResponse;
import com.example.cafekiosk.spring.api.controller.product.request.ProductCreateRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

@WebMvcTest(controllers = ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMVC;

    @Autowired
    private ObjectMapper objectMapper;

    //controller는 service라는 빈 주입이 되어야 만들어질 수 있음
    @MockBean
    private ProductService productService;

    @DisplayName("신규 상품을 등록한다.")
    @Test
    void createProduct() throws Exception {
        //given
        ProductCreateRequest request = ProductCreateRequest.builder()
            .type(HANDMADE)
            .sellingStatus(SELLING)
            .name("아메리카노")
            .price(4000)
            .build();

        //when //then
        mockMVC.perform(
            post("/api/v1/products/new")
                .content(objectMapper.writeValueAsString(request))
                .contentType(APPLICATION_JSON)
        )
        .andDo(print()) // log
        .andExpect(status().isOk());
    }

    @DisplayName("신규 상품을 등록할 때 상품 타입은 필수값이다.")
    @Test
    void createProductWithoutType() throws Exception {
        //given
        ProductCreateRequest request = ProductCreateRequest.builder()
            .sellingStatus(SELLING)
            .name("아메리카노")
            .price(4000)
            .build();

        //when //then
        mockMVC.perform(
            post("/api/v1/products/new")
                .content(objectMapper.writeValueAsString(request))
                .contentType(APPLICATION_JSON)
        )
        .andDo(print()) // log
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.code").value("400"))
        .andExpect(jsonPath("$.status").value("BAD_REQUEST"))
        .andExpect(jsonPath("$.message").value("상품 타입은 필수입니다."))
        .andExpect(jsonPath("$.data").isEmpty());
    }

    @DisplayName("신규 상품을 등록할 때 상품 판매상태는 필수값이다.")
    @Test
    void createProductWithoutSellingStatus() throws Exception {
        //given
        ProductCreateRequest request = ProductCreateRequest.builder()
            .type(HANDMADE)
            .name("아메리카노")
            .price(4000)
            .build();

        //when //then
        mockMVC.perform(
            post("/api/v1/products/new")
                .content(objectMapper.writeValueAsString(request))
                .contentType(APPLICATION_JSON)
        )
        .andDo(print()) // log
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.code").value("400"))
        .andExpect(jsonPath("$.status").value("BAD_REQUEST"))
        .andExpect(jsonPath("$.message").value("상품 판매상태는 필수입니다."))
        .andExpect(jsonPath("$.data").isEmpty());
    }

    @DisplayName("신규 상품을 등록할 때 상품 이름은 필수값이다.")
    @Test
    void createProductWithoutName() throws Exception {
        //given
        ProductCreateRequest request = ProductCreateRequest.builder()
            .type(HANDMADE)
            .sellingStatus(SELLING)
            .price(4000)
            .build();

        //when //then
        mockMVC.perform(
            post("/api/v1/products/new")
                .content(objectMapper.writeValueAsString(request))
                .contentType(APPLICATION_JSON)
        )
        .andDo(print()) // log
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.code").value("400"))
        .andExpect(jsonPath("$.status").value("BAD_REQUEST"))
        .andExpect(jsonPath("$.message").value("상품 이름은 필수입니다."))
        .andExpect(jsonPath("$.data").isEmpty());
    }

    @DisplayName("신규 상품을 등록할 때 상품 가격은 양수이다.")
    @Test
    void createProductWithZeroPrice() throws Exception {
        //given
        ProductCreateRequest request = ProductCreateRequest.builder()
            .sellingStatus(SELLING)
            .name("아메리카노")
            .price(-1)
            .build();

        //when //then
        mockMVC.perform(
            post("/api/v1/products/new")
                .content(objectMapper.writeValueAsString(request))
                .contentType(APPLICATION_JSON)
        )
        .andDo(print()) // log
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.code").value("400"))
        .andExpect(jsonPath("$.status").value("BAD_REQUEST"))
        .andExpect(jsonPath("$.message").value("상품 가격은 양수여야 합니다."))
        .andExpect(jsonPath("$.data").isEmpty());
    }

    @DisplayName("판매 상품을 조회한다.")
    @Test
    void getSellingProducts() throws Exception {
        //given
        List<ProductResponse> result= List.of();
        when(productService.getSellingProducts()).thenReturn(result);

        //when //then
        mockMVC.perform(
            get("/api/v1/products/selling")
//                .queryParam("name","아메리카노") queryString을 받을 수 있다
        )
        .andDo(print()) // log
        .andExpect(status().isOk())
            .andExpect(jsonPath("$.code").value("200"))
            .andExpect(jsonPath("$.status").value("OK"))
            .andExpect(jsonPath("$.message").value("OK"))
            .andExpect(jsonPath("$.data").isArray());
    }
}