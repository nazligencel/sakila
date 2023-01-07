package com.uniyaz.filmcategory.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.filmcategory.domain.FilmCategory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class FilmCategoryDao {
    public List<FilmCategory> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("Select filmCategory From FilmCategory filmCategory");
        List<FilmCategory> filmCategoryList = query.list();
        return filmCategoryList;
    }

    public FilmCategory save(FilmCategory filmCategory) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        filmCategory = (FilmCategory) currentSession.merge(filmCategory);
        transaction.commit();
        return filmCategory;
    }

    public void delete(FilmCategory filmCategory) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(filmCategory);
        transaction.commit();
    }
}
