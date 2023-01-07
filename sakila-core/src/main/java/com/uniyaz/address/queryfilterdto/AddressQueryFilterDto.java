package com.uniyaz.address.queryfilterdto;

import com.uniyaz.city.domain.City;
import com.uniyaz.country.domain.Country;

public class AddressQueryFilterDto {

    private Long id;
    private String address;
    private City city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}