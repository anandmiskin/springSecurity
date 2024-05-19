package com.example.springSecurity.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue
    private int productId;
    private String name;
    private int qty;
    private double price;

    public Product() {}

    public Product(int productId, String name, int qty, double price) {
        this.productId = productId;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public static class builder {

        private int productId;
        private String name;
        private int qty;
        private double price;

        public builder setProductId(int productId) {
            this.productId = productId;
            return this;
        }

        public builder setName(String name) {
            this.name = name;
            return this;
        }

        public builder setQty(int qty) {
            this.qty = qty;
            return this;
        }

        public builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Product build(){
            return new Product(productId,name,qty,price);
        }
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
