package com.uniyaz.country;

import com.uniyaz.country.dao.CountryDao;
import com.uniyaz.country.domain.Country;
import org.junit.Test;

import java.util.List;

public class CountryDaoTest {
    @Test
    public void findAll() {
        CountryDao countryDao = new CountryDao();
        List<Country> countryList = countryDao.findAll();
        for (Country country : countryList) {
            System.out.println(country);
        }
    }

}
