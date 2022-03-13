package com.techmaker.storemanagement.service;

import com.techmaker.storemanagement.model.Item;

public interface PersistenceService {
    void save(Item item);

    Item findById(long id);
}
