package com.techmaker.storemanagement.service;

import com.techmaker.storemanagement.model.Item;

import java.util.List;

public interface SearchService {
    List<Item> searchName(String name);
}
