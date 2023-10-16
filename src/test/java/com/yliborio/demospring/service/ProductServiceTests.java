package com.yliborio.demospring.service;

import com.yliborio.demospring.entity.Product;
import com.yliborio.demospring.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTests {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        productService = new ProductService(productRepository);
    }

    @Test
    void testGetProductById() {
        // Mock data
        long productId = 1L;
        Product product = new Product();
        product.setId(productId);
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        Optional<Product> result = productService.getProductById(productId);

        assertTrue(result.isPresent());
        assertEquals(productId, result.get().getId());
    }

    @Test
    void testGetProductByIdNotFound() {
        long productId = 1L;
        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        Optional<Product> result = productService.getProductById(productId);

        assertFalse(result.isPresent());
    }

    @Test
    void testAddProduct() {
        Product product = new Product();
        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.addProduct(product);
        assertEquals(product, result);
    }

    @Test
    void testDeleteProductById() {
        // Mock data
        long productId = 1L;
        Product product = new Product();
        product.setId(productId);
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        Optional<Product> result = productService.deleteProduct(productId);

        // Assert
        verify(productRepository, times(1)).deleteById(productId);

        assertTrue(result.isPresent());
        assertEquals(productId, result.get().getId());
    }

    @Test
    void testDeleteProductDoesNotExist() {
        // Arrange
        long productId = 1L;
        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        // Act
        productService = new ProductService(productRepository);
        Optional<Product> deletedProduct = productService.deleteProduct(productId);

        // Assert
        assertEquals(Optional.empty(), deletedProduct);
    }


    @Test
    void testGetProducts() {

        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product());
        productList.add(new Product());


        when(productRepository.findAll()).thenReturn(productList);

        // Assert
        List<Product> result = productService.getProducts();

        assertEquals(productList, result );
    }

    @Test
    void testUpdateProduct() {
        Product original = new Product();
        original.setId(1L);
        // Create a product with some changes
        Product updatedProduct = new Product();
        updatedProduct.setId(1L);
        updatedProduct.setTitle("Updated Title");
        updatedProduct.setPrice(25.0);
        updatedProduct.setCategory("Updated Category");

        // Mock the behavior of getProductById
        when(productRepository.findById(1L)).thenReturn(Optional.of(original));

        // Mock the behavior of save
        when(productRepository.save(any())).thenReturn(updatedProduct);

        // Call the updateProduct method
        Optional<Product> result = productService.updateProduct(updatedProduct);

        // Verify that the product was updated
        assertEquals(updatedProduct.getTitle(), result.get().getTitle());
        assertEquals(updatedProduct.getPrice(), result.get().getPrice());
        assertEquals(updatedProduct.getCategory(), result.get().getCategory());
    }

    @Test
    void testUpdateProductDoesNotExist() {


        // Mock the behavior of getProductById
        when(productRepository.findById(1L)).thenReturn(Optional.empty());
        Product updatedProduct = new Product();
        // Mock the behavior of save
        when(productRepository.save(any())).thenReturn(updatedProduct);

        // Call the updateProduct method
        Optional<Product> result = productService.updateProduct(updatedProduct);

        // Verify that the result is empty
        assertTrue(result.isEmpty());

    }

}