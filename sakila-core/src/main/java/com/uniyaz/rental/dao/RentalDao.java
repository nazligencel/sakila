package com.uniyaz.rental.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.common.dao.BaseDao;
import com.uniyaz.rental.domain.Rental;
import com.uniyaz.rental.queryfilterdto.RentalQueryFilterDto;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import java.util.List;

public class RentalDao extends BaseDao<Rental> {

    public RentalDao() {
        super(Rental.class);
    }


    public List<Rental> findAllByQueryFilterDto(RentalQueryFilterDto rentalQueryFilter) {

        String hql =
                "Select rental " +
                        "From Rental rental " +
                        "Left Join fetch rental.inventory inventory " +
                        "Left Join fetch rental.staff staff " +
                        "Left Join fetch rental.customer customer " +
                        "where 1=1 ";

        if (rentalQueryFilter.getId() != null) {
            hql += "and rental.id = :rentalId";
        }

        if(rentalQueryFilter.getInventory()!=null){
            hql += "and rental.inventory = : inventory";
        }

        if(rentalQueryFilter.getCustomer()!=null){
            hql += "and rental.customer = : customer";
        }

        if (rentalQueryFilter.getStaff() != null) {
            hql += "and rental.staff = :staff";
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (rentalQueryFilter.getId() != null) {
            query.setParameter("rentalId", rentalQueryFilter.getId());
        }

        if (rentalQueryFilter.getInventory() != null) {
            query.setParameter("inventory", rentalQueryFilter.getInventory());
        }

        if (rentalQueryFilter.getStaff() != null) {
            query.setParameter("staff", rentalQueryFilter.getStaff());
        }

        if (rentalQueryFilter.getCustomer() != null) {
            query.setParameter("customer", rentalQueryFilter.getCustomer());
        }

        List<Rental> rentalList = query.list();
        return rentalList;
    }

    public List<Rental> findAllByQueryFilterDtoCriteria(RentalQueryFilterDto rentalQueryFilterDto) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Criteria criteria = currentSession.createCriteria(Rental.class);
        criteria.createAlias("rental", "rentalAlias", JoinType.LEFT_OUTER_JOIN);

        if (rentalQueryFilterDto.getId() != null) {
            criteria.add(Restrictions.eq("id", rentalQueryFilterDto.getId()));
        }

        if (rentalQueryFilterDto.getInventory() != null) {
            criteria.add(Restrictions.eq("address", rentalQueryFilterDto.getInventory()));
        }

        if (rentalQueryFilterDto.getStaff() != null) {
            criteria.add(Restrictions.eq("staff", rentalQueryFilterDto.getStaff()));
        }
        if (rentalQueryFilterDto.getCustomer() != null) {
            criteria.add(Restrictions.eq("customer", rentalQueryFilterDto.getStaff()));
        }

        List<Rental> rentalList = criteria.list();
        return rentalList;
    }

}
