package com.twuc.shopping.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.dto.ProductDto;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.repository.ProductRepository;
import com.twuc.shopping.utils.EntityUtil;
import com.twuc.shopping.utils.ProductUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ProductsControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ProductRepository productRepository;

    @Test
    void should_get_all_products() throws Exception {
        for (int i = 0; i < 6; i++) {
            ProductEntity productEntity = EntityUtil.createProductEntity();
            productRepository.save(productEntity);
        }

        mockMvc.perform(get("/products"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(6)))
            .andExpect(jsonPath("$[0].name", is("可乐")))
            .andExpect(jsonPath("$[0].price", is(3)))
            .andExpect(jsonPath("$[0].unit", is("瓶")));
    }

    @Test
    void should_add_product() throws Exception {
        ProductDto productDto = ProductUtil.creatProduct();
        ObjectMapper objectMapper = new ObjectMapper();
        String productJson = objectMapper.writeValueAsString(productDto);

        mockMvc.perform(post("/product")
            .content(productJson)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated());

        final List<ProductEntity> productEntityList = productRepository.findAll();
        assertEquals(1, productEntityList.size());
        assertEquals("可乐", productEntityList.get(0).getName());
    }

    @Test
    void should_add_product_fail_when_product_exits() throws Exception {
        ProductEntity productEntity = EntityUtil.createProductEntity();
        productRepository.save(productEntity);

        ProductDto productDto = ProductUtil.creatProduct();
        ObjectMapper objectMapper = new ObjectMapper();
        String productJson = objectMapper.writeValueAsString(productDto);

        mockMvc.perform(post("/product")
            .content(productJson)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
    }
}