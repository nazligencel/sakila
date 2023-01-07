package com.uniyaz.category.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.category.domain.Category;
import com.uniyaz.category.queryfilterdto.CategoryQueryFilterDto;
import org.hibernate.*;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import java.util.List;

public class CategoryDao {

    public List<Category> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("Select category From Category category");
        List<Category> categoryList = query.list();
        return categoryList;
    }

    public Category save(Category category) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        category = (Category) currentSession.merge(category);
        transaction.commit();
        return category;
    }

    public void delete(Category category) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(category);
        transaction.commit();
    }

    public List<Category> findAllByQueryFilterDto(CategoryQueryFilterDto categoryQueryFilterDto) {

        String hql =
                "Select category " +
                        "From Category category " +
                        "where 1=1 ";

        if (categoryQueryFilterDto.getId() != null) {
            hql += " and category.id = :categoryId";
        }

        if (categoryQueryFilterDto.getCategory() != null) {
            hql += " and category.category = :category";
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (categoryQueryFilterDto.getId() != null) {
            query.setParameter("categoryId", categoryQueryFilterDto.getId());
        }

        if (categoryQueryFilterDto.getCategory() != null) {
            query.setParameter("category", categoryQueryFilterDto.getCategory());
        }

        List<Category> categoryList = query.list();
        return categoryList;
    }


    public List<Category> findAllByQueryFilterDtoCriteria(CategoryQueryFilterDto categoryQueryFilterDto) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Criteria criteria = currentSession.createCriteria(Category.class);
        criteria.createAlias("category", "categoryAlias", JoinType.LEFT_OUTER_JOIN);

        if (categoryQueryFilterDto.getId() != null) {
            criteria.add(Restrictions.eq("id", categoryQueryFilterDto.getId()));
        }

        if (categoryQueryFilterDto.getCategory() != null) {
            criteria.add(Restrictions.eq("category", categoryQueryFilterDto.getCategory()));
        }

        List<Category> categoryList = criteria.list();
        return categoryList;
    }

    public List<Category> findAllByQueryFilterDtoDetachedCriteria(String categoryName) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Criteria criteria = currentSession.createCriteria(Category.class);

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Category.class);
        detachedCriteria.add(Restrictions.eq("category", categoryName));
        detachedCriteria.setProjection(Projections.property("id"));

        criteria.add(Property.forName("category.id").in(detachedCriteria));

        List<Category> categoryList = criteria.list();
        return categoryList;
    }
}
