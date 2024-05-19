package com.example.springSecurity.controller;

import com.example.springSecurity.dto.Product;
import com.example.springSecurity.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String addProduct(@RequestBody Product product){
        return service.add(product);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Product> getAllProducts(){
        return service.getProducts();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Product findProductById(@RequestParam int id){
        return service.getProduct(id);
    }

}
