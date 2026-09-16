package com.ex17.service;

import java.util.ArrayList;
import java.util.List;

import com.ex17.entity.Product;
import org.springframework.stereotype.Service;

@Service

public class ShoppingCategoryService {

    private final List<Product> items = new ArrayList<>();

    public void addItem(Product item) {
        items.add(item);
    }

    public List<Product> getItems() {
        return items;
    }
}
