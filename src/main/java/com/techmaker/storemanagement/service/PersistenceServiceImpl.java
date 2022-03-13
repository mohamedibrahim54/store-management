package com.techmaker.storemanagement.service;

import com.techmaker.storemanagement.model.Item;
import com.techmaker.storemanagement.persistence.Repository;

public class PersistenceServiceImpl implements PersistenceService {
    private final Repository repository;

    public PersistenceServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Item item) {
        repository.save(item);
    }

    @Override
    public Item findById(long id) {
        return repository.findById(id);
    }
}
