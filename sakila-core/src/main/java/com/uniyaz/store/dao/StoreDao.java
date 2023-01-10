package com.uniyaz.store.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.common.dao.BaseDao;
import com.uniyaz.store.domain.Store;
import com.uniyaz.store.queryfilterdto.StoreQueryFilterDto;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import java.util.List;

public class StoreDao extends BaseDao<Store> {

    public StoreDao() {
        super(Store.class);
    }

     public List<Store> findAllByQueryFilterDto(StoreQueryFilterDto storeQueryFilterDto) {
        String hql =
                "Select store " +
                        "From Store store " +
                        "Left Join store.address address " +
                        "Left Join store.staff firstName " +
                        "where 1=1 ";

        if (storeQueryFilterDto.getId() != null){
            hql += " and store.id = :storeId";
        }
        if (storeQueryFilterDto.getAddress() != null){
            hql += " and store.address.district = :address";
        }
        if (storeQueryFilterDto.getStaff() != null){
            hql += " and store.staff.firstName = :staff";
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (storeQueryFilterDto.getId() != null){
            query.setParameter("storeId", storeQueryFilterDto.getId());
        }
        if (storeQueryFilterDto.getAddress() != null){
            query.setParameter("address", storeQueryFilterDto.getAddress().getDistrict());
        }
        if (storeQueryFilterDto.getStaff() != null){
            query.setParameter("staff", storeQueryFilterDto.getStaff().getFirstName());
        }

        List<Store> storeList = query.list();
        return storeList;
    }

    public List<Store>  findAllByQueryFilterDtoCriteria(StoreQueryFilterDto storeQueryFilterDto) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Criteria criteria = currentSession.createCriteria(Store.class);
        criteria.createAlias("address", "addressAlias", JoinType.LEFT_OUTER_JOIN);
        criteria.createAlias("staff", "staffAlias", JoinType.LEFT_OUTER_JOIN);

        if (storeQueryFilterDto.getId() != null){
            criteria.add(Restrictions.eq("id", storeQueryFilterDto.getId()));
        }
        if (storeQueryFilterDto.getAddress() != null){
            criteria.add(Restrictions.eq("addressAlias.district", storeQueryFilterDto.getAddress().getDistrict()));
        }
        if (storeQueryFilterDto.getStaff() != null){
            criteria.add(Restrictions.eq("staffAlias.firstName", storeQueryFilterDto.getStaff().getFirstName()));
        }

        List<Store> storeList = criteria.list();
        return storeList;
    }
}
