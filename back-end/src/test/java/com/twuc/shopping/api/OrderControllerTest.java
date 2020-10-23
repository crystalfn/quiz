package com.twuc.shopping.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.dto.OrderRequestDto;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.repository.OrderRepository;
import com.twuc.shopping.repository.ProductRepository;
import com.twuc.shopping.utils.EntityUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class OrderControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;

    @Test
    void should_add_product_in_order() throws Exception {
        ProductEntity productEntity = EntityUtil.createProductEntity();
        productRepository.save(productEntity);

        OrderRequestDto orderRequestDto = OrderRequestDto.builder().productId(productEntity.getId()).build();

        ObjectMapper objectMapper = new ObjectMapper();
        String productJson = objectMapper.writeValueAsString(orderRequestDto);

        mockMvc.perform(post("/order")
                .content(productJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}