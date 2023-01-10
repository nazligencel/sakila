package com.uniyaz.payment.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.payment.domain.Payment;
import com.uniyaz.payment.queryfilterdto.PaymentQueryFilterDto;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class PaymentDao {
    public List<Payment> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        String hql =
                "Select payment " +
                        "From Payment payment " +
                        "Left Join fetch payment.customer firstName " +
                        "Left Join fetch payment.staff firstName " +
                        "Left Join fetch payment.rental id "
                ;
        Query query = currentSession.createQuery(hql);
        List<Payment> paymentList = query.list();
        return paymentList;
    }
    public List<Payment> findAllByQueryFilterDto(PaymentQueryFilterDto paymentQueryFilterDto) {
        String hql =
                "Select payment " +
                        "From Payment payment " +
                        "Left Join fetch payment.customer firstName " +
                        "Left Join fetch payment.staff firstName " +
                        "Left Join fetch payment.rental id " +
                        "where 1=1 ";

        if (paymentQueryFilterDto.getId() != null){
            hql += " and payment.id = :paymentId";
        }
        if (paymentQueryFilterDto.getCustomer() != null){
            hql += " and payment.customer.firstName = :customer ";
        }
        if (paymentQueryFilterDto.getStaff() != null){
            hql += " and payment.staff.firstName  = :staff ";
        }
        if (paymentQueryFilterDto.getRental() != null){
            hql += " and payment.rental.id = :rental ";
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);

        if (paymentQueryFilterDto.getId() != null){
            query.setParameter("paymentId", paymentQueryFilterDto.getId());
        }
        if (paymentQueryFilterDto.getCustomer() != null){
            query.setParameter("customer", paymentQueryFilterDto.getCustomer().getFirstName());
        }
        if (paymentQueryFilterDto.getStaff() != null){
            query.setParameter("staff", paymentQueryFilterDto.getStaff().getFirstName());
        }
        if (paymentQueryFilterDto.getRental() != null){
            query.setParameter("rental", paymentQueryFilterDto.getRental().getId());
        }

        List<Payment> paymentList = query.list();
        return paymentList;
    }

}
