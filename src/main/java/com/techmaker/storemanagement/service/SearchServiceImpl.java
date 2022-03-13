package com.techmaker.storemanagement.service;

import com.techmaker.storemanagement.model.Item;
import com.techmaker.storemanagement.persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;

import java.util.List;

public class SearchServiceImpl implements SearchService {

    @Override
    public List<Item> searchName(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        SearchSession searchSession = Search.session(session);
        SearchResult<Item> searchResult = searchSession.search(Item.class)
                .where(i -> i.wildcard().field("name").matching(name)).fetch(20);

        session.close();
        return searchResult.hits();
    }

}
