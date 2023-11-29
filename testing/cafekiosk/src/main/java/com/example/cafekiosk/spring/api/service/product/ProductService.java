package com.example.cafekiosk.spring.api.service.product;

import com.example.cafekiosk.spring.api.service.product.Response.ProductResponse;
import com.example.cafekiosk.spring.api.controller.product.request.ProductCreateRequest;
import com.example.cafekiosk.spring.api.service.product.request.ProductCreateServiceRequest;
import com.example.cafekiosk.spring.domain.product.Product;
import com.example.cafekiosk.spring.domain.product.ProductRepository;
import com.example.cafekiosk.spring.domain.product.ProductSellingStatus;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    //동시성 이슈 -> 유니크 제약조건 + 재시도 로직 or UUID
    @Transactional
    public ProductResponse createProduct(ProductCreateServiceRequest request) {
        String nextProductNumber = createNextProductNumber();

        Product product = request.toEntity(nextProductNumber);
        Product savedProduct = productRepository.save(product);

        return ProductResponse.of(savedProduct);
    }


    public List<ProductResponse> getSellingProducts(){
        List<Product> products = productRepository.findAllBySellingStatusIn(
            ProductSellingStatus.forDisPlay());

        return products.stream()
            .map(ProductResponse::of)
            .collect(Collectors.toList());
    }

    private String createNextProductNumber(){
        String latestProductNumber = productRepository.findLatestProductNumber();

        if (latestProductNumber == null) {
            return "001";
        }

        int latestProductNumberInt = Integer.parseInt(latestProductNumber);
        int nextProductNumberInt = latestProductNumberInt + 1;

        return String.format("%03d",nextProductNumberInt);
    }
}
