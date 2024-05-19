package com.example.springSecurity.service;

import com.example.springSecurity.dto.Product;
import com.example.springSecurity.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    List<Product> productList = null;

    public String add(Product product) {
        repository.save(product);
        return "product saved successfully";
    }

    @PostConstruct
    public void loadProductsFromDB(){
         productList = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new Product.builder()
                        .setProductId(i)
                        .setName("Product" + i)
                        .setQty(new Random().nextInt(10))
                        .setPrice(new Random().nextInt(5000)).build())
                .collect(Collectors.toList());

    }

    public List<Product> getProducts(){
        productList.stream().forEach(repository::save);
        return repository.findAll();
    }

    public Product getProduct(int id){
        return productList.stream()
                .filter(product -> product.getProductId() == id)
                .findAny()
                .orElseThrow(()-> new RuntimeException("product " + id + "not found"));
    }


}
