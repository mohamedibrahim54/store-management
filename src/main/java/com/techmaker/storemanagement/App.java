package com.techmaker.storemanagement;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

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

		Session session = HibernateUtil.getSessionFactory().openSession();
		SearchSession searchSession = Search.session(session);

		MassIndexer indexer = searchSession.massIndexer(Item.class).threadsToLoadObjects(7);

		try {
			indexer.startAndWait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Item item1 = new Item("mobile phone", BigDecimal.valueOf(1000), BigDecimal.valueOf(900), 8,
				Date.from(Instant.now()));
		Item item2 = new Item("mobile charger", BigDecimal.valueOf(100), BigDecimal.valueOf(80), 5,
				Date.from(Instant.now()));
		Item item3 = new Item("TV", BigDecimal.valueOf(500), BigDecimal.valueOf(450), 7,
				Date.from(Instant.now()));
		Repository repositoryImpl = new RepositoryImpl();
		repositoryImpl.save(item1);
		repositoryImpl.save(item2);
		repositoryImpl.save(item3);

		Item foundItem = repositoryImpl.findById(1);
		System.out.println(foundItem);

		System.out.println("Search Reasult:");
		SearchResult<Item> searchResult = searchSession.search(Item.class)
				.where(i -> i.match().field("name").matching("Mobile")).fetch(20);

		searchResult.hits().forEach(System.out::println);
	}

}
