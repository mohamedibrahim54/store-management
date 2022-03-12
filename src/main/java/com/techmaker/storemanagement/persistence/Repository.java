package com.techmaker.storemanagement.persistence;

import com.techmaker.storemanagement.model.Item;

public interface Repository {

	void save(Item item);

	Item findById(long id);

}