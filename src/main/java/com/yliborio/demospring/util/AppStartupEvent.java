package com.yliborio.demospring.util;

import com.yliborio.demospring.entity.Product;
import com.yliborio.demospring.repository.ProductRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final ProductRepository productRepository;

    public AppStartupEvent(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Product> products = this.productRepository.findAll();
        products.forEach(System.out::println);
    }
}
