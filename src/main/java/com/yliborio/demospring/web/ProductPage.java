package com.yliborio.demospring.web;

import com.yliborio.demospring.entities.Product;
import com.yliborio.demospring.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/products")
public class ProductPage {

    private final ProductRepository productRepository;

    public ProductPage(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getGuests(Model model){
        Iterable<Product> products = this.productRepository.findAll();
        model.addAttribute("products", products);
        return "products-page";
    }

}
