package com.uniyaz.rental.service;

import com.uniyaz.rental.dao.RentalDao;
import com.uniyaz.rental.domain.Rental;

import java.util.List;

public class RentalService {

    public List<Rental> findAll() {
        RentalDao rentalDao=new RentalDao();
        return rentalDao.findAll();
    }

    public Rental save(Rental rental) {
        RentalDao rentalDao=new RentalDao();
        return rentalDao.save(rental);
    }

    public void delete(Rental rental) {
        RentalDao rentalDao=new RentalDao();
        rentalDao.delete(rental);
    }
}
