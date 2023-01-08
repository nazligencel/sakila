package com.uniyaz.filmcategory.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.category.domain.Category;
import com.uniyaz.city.domain.City;
import com.uniyaz.film.queryfilterdto.FilmQueryFilterDto;
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
    public List<Category> findAllByQueryFilterDto(FilmQueryFilterDto filmQueryFilterDto) {

        String hql =
                "Select filmcategory " +
                        "From FilmCategory filmcategory " +
                        "Left Join fetch filmcategory.category category " +
                        "where 1=1 ";

        if (filmQueryFilterDto.getId() != null) {
            hql += " and filmcategory.id = :id";
        }

        if (filmQueryFilterDto.getFilm() != null) {
            hql += " and filmcategory.filmcategory = :filmcategory";
        }

        if (filmQueryFilterDto.getCategory() != null) {
            hql += " and filmcategory.category = :category ";
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (filmQueryFilterDto.getId() != null) {
            query.setParameter("id", filmQueryFilterDto.getId());
        }

        if (filmQueryFilterDto.getFilm() != null) {
            query.setParameter("filmcategory", filmQueryFilterDto.getFilm());
        }

        if (filmQueryFilterDto.getCategory() != null) {
            query.setParameter("country", filmQueryFilterDto.getCategory());
        }

        List<Category> categoryList = query.list();
        return categoryList;
    }
}
