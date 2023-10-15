package com.yliborio.demospring.util;

import com.yliborio.demospring.entities.Product;
import com.yliborio.demospring.repository.ProductRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final ProductRepository productRepository;

    public AppStartupEvent(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Product> rooms = this.productRepository.findAll();
        rooms.forEach(System.out::println);
    }
}
