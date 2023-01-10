package com.uniyaz.staff.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.staff.domain.Staff;
import com.uniyaz.staff.queryfilterdto.StaffQueryFilterDto;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class StaffDao {
    public List<Staff> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("Select staff From Staff staff");
        List<Staff> staffList = query.list();
        return staffList;
    }

    public Staff save(Staff staff) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        staff = (Staff) currentSession.merge(staff);
        transaction.commit();
        return staff;
    }

    public void delete(Staff staff) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(staff);
        transaction.commit();
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
