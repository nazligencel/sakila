package com.uniyaz.customer.queryfilterdto;

import com.uniyaz.country.domain.Country;

public class CustomerQueryFilterDto {

    private Long id;
    private String firstName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}