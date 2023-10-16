package com.yliborio.demospring.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTests {

    @Test
    void testGettersAndSetters() {
        Product product = new Product();

        // Set values
        product.setId(1);
        product.setTitle("Test Product");
        product.setPrice(10.0);
        product.setDescription("description");
        product.setImage("image.url");
        product.setCategory("test");
        product.setRating_count(10);
        product.setRating_rate(5);

        // Set other fields similarly

        // Check if values are set correctly
        assertEquals(1, product.getId());
        assertEquals("Test Product", product.getTitle());
        assertEquals(10.0, product.getPrice(), 0.001);
        assertEquals("description", product.getDescription());
        assertEquals("image.url", product.getImage());
        assertEquals("test", product.getCategory());
        assertEquals(10, product.getRating_count());
        assertEquals(5, product.getRating_rate());


        // Modify values and recheck
        product.setId(2);
        assertEquals(2, product.getId());
        assertEquals("Product{id=2, title='Test Product', price=10.0, description='description', category='test', image='image.url', rating_rate=5, rating_count=10}", product.toString());

    }


}