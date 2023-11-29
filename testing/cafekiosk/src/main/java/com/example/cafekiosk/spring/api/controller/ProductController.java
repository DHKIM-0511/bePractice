package com.example.cafekiosk.spring.api.controller;

import com.example.cafekiosk.spring.api.service.product.ProductService;
import com.example.cafekiosk.spring.api.service.product.Response.ProductResponse;
import com.example.cafekiosk.spring.api.service.product.request.ProductCreateRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    @PostMapping("api/v1/products/new")
    public void createProduct(ProductCreateRequest request){
        productService.createProduct(request);
    }

    @GetMapping("/api/v1/products/selling")
    public List<ProductResponse> getSellingProducts(){
        return productService.getSellingProducts();
    }
}
