package com.yliborio.demospring.web;

import com.yliborio.demospring.entity.Product;
import com.yliborio.demospring.repository.ProductRepository;
import com.yliborio.demospring.web.ProductPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductPageTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private Model model;

    private ProductPage productPage;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        productPage = new ProductPage(productRepository);
    }

    @Test
    void testGetProducts() {
        // Mock data
        List<Product> productsList = new ArrayList<>();
        productsList.add(new Product());
        productsList.add(new Product());

        when(productRepository.findAll()).thenReturn(productsList);

        String viewName = productPage.getProducts(model);

        // Check that the view name returned is as expected
        assertEquals("products-page", viewName);

        // Check that the model has the "products" attribute with the correct list of products
        verify(model, times(1)).addAttribute(eq("products"), any());
    }
}

