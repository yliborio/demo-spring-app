package com.yliborio.demospring.controller;


import com.yliborio.demospring.entity.Product;
import com.yliborio.demospring.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductsController {

    private final ProductService productsService;

    public ProductsController(ProductService productsService) {
        this.productsService = productsService;
    }


    @RequestMapping(path="/products")
    public List<Product> getProducts() {
        return productsService.getProducts();
    }


    @GetMapping("/products/{productId}")
    public Optional<Product> getProductById(@PathVariable long productId){
        return this.productsService.getProductById(productId);
    }

    @DeleteMapping(path="/products/{productId}")
    public Optional<Product> deleteProductById(@PathVariable long productId){
        return this.productsService.deleteProduct(productId);
    }


    @PostMapping(path = "/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product){
        return this.productsService.addProduct(product);
    }

    @PatchMapping(path = "/products/{productId}")
    public Optional<Product> updateProduct(@RequestBody Product product, @PathVariable long productId){
        return this.productsService.updateProduct(product);
    }
}
