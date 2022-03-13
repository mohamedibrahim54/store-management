package com.techmaker.storemanagement;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import com.techmaker.storemanagement.service.PersistenceService;
import com.techmaker.storemanagement.service.PersistenceServiceImpl;
import com.techmaker.storemanagement.service.SearchService;
import com.techmaker.storemanagement.service.SearchServiceImpl;
import org.hibernate.Session;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.session.SearchSession;

import com.techmaker.storemanagement.model.Item;
import com.techmaker.storemanagement.persistence.HibernateUtil;
import com.techmaker.storemanagement.persistence.Repository;
import com.techmaker.storemanagement.persistence.RepositoryImpl;

public class App {

	public static void main(String[] args) {

		HibernateUtil.buildSearchIndexes();

		Item item1 = new Item("mobile phone", BigDecimal.valueOf(1000), BigDecimal.valueOf(900), 8,
				Date.from(Instant.now()));
		Item item2 = new Item("mobile charger", BigDecimal.valueOf(100), BigDecimal.valueOf(80), 5,
				Date.from(Instant.now()));
		Item item3 = new Item("TV", BigDecimal.valueOf(500), BigDecimal.valueOf(450), 7,
				Date.from(Instant.now()));
		Repository repository = new RepositoryImpl();
		PersistenceService persistenceService = new PersistenceServiceImpl(repository);
		persistenceService.save(item1);
		persistenceService.save(item2);
		persistenceService.save(item3);

		Item foundItem = persistenceService.findById(1);
		System.out.println(foundItem);

		SearchService searchService = new SearchServiceImpl();
		List<Item> items = searchService.searchName("mob"+"*");
		System.out.println("Search Result");
		items.forEach(System.out::println);
	}

}
