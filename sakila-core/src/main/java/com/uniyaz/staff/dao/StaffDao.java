package com.uniyaz.staff.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.common.dao.BaseDao;
import com.uniyaz.staff.domain.Staff;
import com.uniyaz.staff.queryfilterdto.StaffQueryFilterDto;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.List;

public class StaffDao extends BaseDao<Staff> {

    public StaffDao() {
        super(Staff.class);
    }

    public List<Staff> findAllByQueryFilterDto(StaffQueryFilterDto staffQueryFilterDto) {

        String hql =
                "Select staff " +
                        "From Staff staff " +
                        "Left Join fetch staff.address address " +
                        "Left Join fetch staff.store id " +
                        "where 1=1 ";

        if (staffQueryFilterDto.getId() != null) {
            hql += " and staff.id = :staffId";
        }

        if (staffQueryFilterDto.getFirstName() != null) {
            hql += " and staff.firstName = :firstName";
        }
        if (staffQueryFilterDto.getAddress()!= null) {
            hql += " and staff.address = :address";
        }
        if (staffQueryFilterDto.getStore()!= null) {
            hql += " and staff.store = :store";
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (staffQueryFilterDto.getId() != null) {
            query.setParameter("actorId", staffQueryFilterDto.getId());
        }

        if (staffQueryFilterDto.getFirstName() != null) {
            query.setParameter("firstName", staffQueryFilterDto.getFirstName());
        }
        if (staffQueryFilterDto.getAddress()!= null) {
            query.setParameter("address",staffQueryFilterDto.getAddress());
        }
        if (staffQueryFilterDto.getStore()!= null) {
            query.setParameter("store",staffQueryFilterDto.getStore());
        }

        List<Staff> staffList = query.list();
        return staffList;
    }


}
