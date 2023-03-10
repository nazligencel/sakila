package com.uniyaz.filmcategory.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.common.dao.BaseDao;
import com.uniyaz.film.queryfilterdto.FilmQueryFilterDto;
import com.uniyaz.filmcategory.domain.FilmCategory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.List;

public class FilmCategoryDao extends BaseDao<FilmCategory> {

    public FilmCategoryDao() {
        super(FilmCategory.class);
    }

    public List<FilmCategory> findByFileName(String name) {
        String hql =
                "Select filmcategory " +
                        "From FilmCategory filmcategory " +
                        "Left Join fetch filmcategory.category categoryName " +
                        "Left Join fetch filmcategory.film title " +
                        "where filmcategory.film.title like:name ";

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);
        query.setParameter("name",name + "%");
        List<FilmCategory> filmCategoryList = query.list();
        return filmCategoryList;

    }

    public List<FilmCategory> findAllByQueryFilterDto(FilmQueryFilterDto filmQueryFilterDto) {

        String hql =
                "Select filmcategory " +
                        "From FilmCategory filmcategory " +
                        "Left Join filmcategory.category category " +
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
            query.setParameter("category", filmQueryFilterDto.getCategory());
        }

        List<FilmCategory> categoryList = query.list();
        return categoryList;
    }
}
