package com.uniyaz.rental;

import com.uniyaz.rental.domain.Rental;
import com.uniyaz.rental.service.RentalService;
import org.junit.Test;

import java.util.List;

public class RentalServiceTset {

    @Test
    public void findAllTest() {

        RentalService rentalService=new RentalService();
        List<Rental> filmCategoryList = rentalService.findAll();
        for (Rental rental : filmCategoryList) {
            System.out.println(rental);
        }

    }
}
