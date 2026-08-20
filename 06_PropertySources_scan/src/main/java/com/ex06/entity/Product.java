package com.ex06.entity;


public class Product {
    
    private String name;
    private double price;
    private int discount;
    
    public Product(String name, double price, int discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + ", discount=" + discount + "]";
    }
}
