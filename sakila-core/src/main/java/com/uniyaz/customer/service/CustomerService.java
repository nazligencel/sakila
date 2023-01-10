package com.uniyaz.customer.service;

import com.uniyaz.customer.dao.CustomerDao;
import com.uniyaz.customer.domain.Customer;
import com.uniyaz.actor.queryfilterdto.ActorQueryFilterDto;
import com.uniyaz.customer.queryfilterdto.CustomerQueryFilterDto;

import java.util.List;

public class CustomerService {
    public List<Customer> findAll() {
        CustomerDao customerDao=new CustomerDao();
        return customerDao.findAll();
    }

    public Customer save(Customer customer) {
        CustomerDao customerDao=new CustomerDao();
        return customerDao.save(customer);
    }

    public void delete(Customer customer) {
        CustomerDao customerDao=new CustomerDao();
        customerDao.delete(customer);
    }

    public List<Customer> findAllByName(String name) {
        CustomerDao customerDao=new CustomerDao();
        return customerDao.findAllByName(name);
    }

    public List<Customer> findAllByQueryFilterDto(CustomerQueryFilterDto customerQueryFilterDto) {
        CustomerDao customerDao=new CustomerDao();
        return customerDao.findAllByQueryFilterDto(customerQueryFilterDto);
    }
}
