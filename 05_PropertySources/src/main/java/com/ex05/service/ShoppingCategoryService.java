package com.ex05.service;

import java.util.ArrayList;
import java.util.List;

import com.ex05.entity.Product;


public class ShoppingCategoryService {

    private final List<Product> items = new ArrayList<>();

    public void addItem(Product item) {
        items.add(item);
    }

    public List<Product> getItems() {
        return items;
    }
}