package com.ex06.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ex06.entity.Product;

@Component
public class ShoppingCategoryService {

    private final List<Product> items = new ArrayList<>();

    public void addItem(Product item) {
        items.add(item);
    }

    public List<Product> getItems() {
        return items;
    }
}