package com.techmaker.storemanagement.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.techmaker.storemanagement.model.Item;

public class RepositoryImpl implements Repository {
	
	@Override
	public void save(Item item) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(item);
        transaction.commit();
        session.close();
	}
	
	@Override
	public Item findById(long id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
        Item item = session.find(Item.class, id);
		return item;
	}

}
