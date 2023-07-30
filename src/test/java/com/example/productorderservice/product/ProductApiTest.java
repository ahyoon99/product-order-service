package com.example.productorderservice.product;

import com.example.productorderservice.ApiTest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ProductApiTest extends ApiTest{

     private final ProductSteps productSteps = new ProductSteps();

     @Autowired
     ProductRepository productRepository;

     @Test
    void 상품등록(){
        final var request = ProductSteps.상품등록요청_생성();

        // API 요청
        final var response = productSteps.상품등록요청(request);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    public ExtractableResponse<Response> 상품등록요청(AddProductRequest request) {
        return productSteps.상품등록요청(request);
    }

     @Test
     void 상품조회() {
         ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
         Long productId = 1L;

         final var response = productSteps.상품조회요청(productId);

         assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
         assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");
     }

     @Test
     void 상품수정() {
         ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
         final long productId = 1L;

         final ExtractableResponse<Response> response = ProductSteps.상품수정요청(productId);

         assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
         assertThat(productRepository.findById(1L).get().getName()).isEqualTo("상품 수정");
     }

 }