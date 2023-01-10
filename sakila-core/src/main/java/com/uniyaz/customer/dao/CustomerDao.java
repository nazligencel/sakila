package com.uniyaz.customer.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.common.dao.BaseDao;
import com.uniyaz.customer.domain.Customer;
import com.uniyaz.customer.queryfilterdto.CustomerQueryFilterDto;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CustomerDao extends BaseDao<Customer> {

    public CustomerDao() {
        super(Customer.class);
    }


    public List<Customer> findAllByName(String name) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("Select customer From Customer customer where customer.firstName = :name ");
        query.setParameter("name", name);
        List<Customer> customerList = query.list();
        return customerList;
    }

    public List<Customer> findAllByQueryFilterDto(CustomerQueryFilterDto customerQueryFilterDto) {

        String hql =
                "Select customer " +
                        "From Customer customer " +
                        "where 1=1 ";

        if (customerQueryFilterDto.getId() != null) {
            hql += " and customer.id = :customerId";
        }

        if (customerQueryFilterDto.getFirstName() != null) {
            hql += " and customer.firstName = :firstName";
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (customerQueryFilterDto.getId() != null) {
            query.setParameter("customerId", customerQueryFilterDto.getId());
        }

        if (customerQueryFilterDto.getFirstName() != null) {
            query.setParameter("firstName", customerQueryFilterDto.getFirstName());
        }

        List<Customer> customerList = query.list();
        return customerList;
    }


    public List<Customer> findAllByQueryFilterDtoCriteria(CustomerQueryFilterDto customerQueryFilterDto) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Criteria criteria = currentSession.createCriteria(Customer.class);

        if (customerQueryFilterDto.getId() != null) {
            criteria.add(Restrictions.eq("id", customerQueryFilterDto.getId()));
        }

        if (customerQueryFilterDto.getFirstName() != null) {
            criteria.add(Restrictions.eq("firstName", customerQueryFilterDto.getFirstName()));
        }

        List<Customer> customerList = criteria.list();
        return customerList;
    }
}
