package com.uniyaz.address.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.address.domain.Address;
import com.uniyaz.address.queryfilterdto.AddressQueryFilterDto;
import com.uniyaz.common.dao.BaseDao;
import org.hibernate.*;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import java.util.List;

public class AddressDao extends BaseDao<Address> {

    public AddressDao() {
        super(Address.class);
    }


    public List<Address> findAllByQueryFilterDto(AddressQueryFilterDto addressQueryFilterDto) {

        String hql =
                "Select address " +
                        "From Address address " +
                        "Left Join fetch address.city city " +
                        "where 1=1 ";

        if (addressQueryFilterDto.getId() != null) {
            hql += " and address.id = :addressId";
        }

        if (addressQueryFilterDto.getAddress() != null) {
            hql += " and address.address = :address";
        }

        if (addressQueryFilterDto.getCity() != null) {
            hql += " and address.city = :city ";
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (addressQueryFilterDto.getId() != null) {
            query.setParameter("addressId", addressQueryFilterDto.getId());
        }

        if (addressQueryFilterDto.getAddress() != null) {
            query.setParameter("address", addressQueryFilterDto.getAddress());
        }

        if (addressQueryFilterDto.getCity() != null) {
            query.setParameter("city", addressQueryFilterDto.getCity());
        }


        List<Address> addressList = query.list();
        return addressList;
    }

    public List<Address> findAllByQueryFilterDtoCriteria(AddressQueryFilterDto addressQueryFilterDto) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Criteria criteria = currentSession.createCriteria(Address.class);
        criteria.createAlias("city", "cityAlias", JoinType.LEFT_OUTER_JOIN);

        if (addressQueryFilterDto.getId() != null) {
            criteria.add(Restrictions.eq("id", addressQueryFilterDto.getId()));
        }

        if (addressQueryFilterDto.getAddress() != null) {
            criteria.add(Restrictions.eq("address", addressQueryFilterDto.getAddress()));
        }

        if (addressQueryFilterDto.getCity() != null) {
            criteria.add(Restrictions.eq("cityAlias.city", addressQueryFilterDto.getCity().getCity()));
        }

        List<Address> addressList = criteria.list();
        return addressList;
    }

    public List<Address> findAllByQueryFilterDtoDetachedCriteria(String cityName) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Criteria criteria = currentSession.createCriteria(Address.class);

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Address.class);
        detachedCriteria.add(Restrictions.eq("city", cityName));
        detachedCriteria.setProjection(Projections.property("id"));

        criteria.add(Property.forName("city.id").in(detachedCriteria));

        List<Address> addressList = criteria.list();
        return addressList;
    }
}
