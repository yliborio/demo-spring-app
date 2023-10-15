package com.yliborio.demospring.controller;

import com.yliborio.demospring.entities.Product;
import com.yliborio.demospring.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductsControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductsController productsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getProducts_shouldReturnListOfProducts() {
        List<Product> productList = new ArrayList<>();

        productList.add(new Product());
        productList.add(new Product());

        when(productService.getProducts()).thenReturn(productList);

        List<Product> result = productsController.getProducts();

        assertEquals(productList.size(), result.size());
    }

    @Test
    void getProductById_shouldReturnProduct() {
        long productId = 1L;
        Product product = new Product();
        when(productService.getProductById(productId)).thenReturn(Optional.of(product));

        Optional<Product> result = productsController.getProductById(productId);

        assertEquals(product, result.orElse(null));
    }

    @Test
    void deleteProductById_shouldReturnDeletedProduct() {
        long productId = 1L;
        Product product = new Product();  // Create a sample product
        when(productService.deleteProduct(productId)).thenReturn(Optional.of(product));

        Optional<Product> result = productsController.deleteProductById(productId);

        assertEquals(product, result.orElse(null));
    }

    @Test
    void deleteProductById_shouldReturnEmptyOptionalForNonExistingProduct() {
        long productId = 1L;
        when(productService.deleteProduct(productId)).thenReturn(Optional.empty());

        Optional<Product> result = productsController.deleteProductById(productId);

        assertEquals(Optional.empty(), result);
    }

}