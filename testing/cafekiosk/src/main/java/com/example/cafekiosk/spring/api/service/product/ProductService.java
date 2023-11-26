package com.example.cafekiosk.spring.api.service.product;

import com.example.cafekiosk.spring.api.service.product.Response.ProductResponse;
import com.example.cafekiosk.spring.domain.product.Product;
import com.example.cafekiosk.spring.domain.product.ProductRepository;
import com.example.cafekiosk.spring.domain.product.ProductSellingStatus;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductResponse> getSellingProducts(){
        List<Product> products = productRepository.findAllBySellingStatusIn(
            ProductSellingStatus.forDisPlay());

        return products.stream()
            .map(ProductResponse::of)
            .collect(Collectors.toList());
    }

}
