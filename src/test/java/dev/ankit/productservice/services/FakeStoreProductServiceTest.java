package dev.ankit.productservice.services;

import dev.ankit.productservice.dtos.FakeStoreProductDto;
import dev.ankit.productservice.models.Product;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FakeStoreProductServiceTest {

    private RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
    private RedisTemplate redisTemplate = Mockito.mock(RedisTemplate.class);

    private ValueOperations valueOperations = Mockito.mock(ValueOperations.class);

    FakeStoreProductService fakeStoreProductService =
            new FakeStoreProductService(restTemplate, redisTemplate);


    @Test
    public void testGetSingleProductWhenDataIsInCache() {
        Product testProduct = new Product();
        testProduct.setTitle("Test Product");

        when(redisTemplate.opsForValue()).thenReturn(valueOperations);
        when(valueOperations.get("1")).thenReturn(testProduct);

        Product productFromCache = fakeStoreProductService.getSingleProduct(1L);

        assertEquals("Test Product", productFromCache.getTitle());
    }

    @Test
    public void testGetSingleProductWhenDataIsNotInCache() {
        when(redisTemplate.opsForValue()).thenReturn(valueOperations);
        when(valueOperations.get("1")).thenReturn(null);

        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle("Test Product");

        ResponseEntity<FakeStoreProductDto> responseEntity =
                new ResponseEntity<>(fakeStoreProductDto, HttpStatusCode.valueOf(200));

        when(restTemplate.getForEntity(
                "https://fakestoreapi.com/products/1", FakeStoreProductDto.class))
                .thenReturn(responseEntity);

        Product product = fakeStoreProductService.getSingleProduct(1L);

        assertEquals("Test Product", product.getTitle());

        verify(valueOperations, times(1)).set(any(), any());
    }


}