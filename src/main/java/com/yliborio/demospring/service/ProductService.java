package com.yliborio.demospring.service;

import com.yliborio.demospring.entities.Product;
import com.yliborio.demospring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public Optional<Product> getProductById(long id){
        return this.productRepository.findById(id);
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public Optional<Product> deleteProduct(long id){
        Optional<Product> deletedP = this.getProductById(id);
        productRepository.deleteById(id);
        return deletedP;
    }


    public Optional<Product> updateProduct(Product updatedProduct){
        Optional<Product> product = this.getProductById(updatedProduct.getId());
        if(product.isEmpty()) return product;
        product.get().setTitle(updatedProduct.getTitle());
        product.get().setPrice(updatedProduct.getPrice());
        product.get().setCategory(updatedProduct.getCategory());
        product.get().setImage(updatedProduct.getImage());
        product.get().setDescription(updatedProduct.getDescription());
        productRepository.save(product.get());
        return product;
    }

}
