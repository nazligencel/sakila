package com.uniyaz.staff.queryfilterdto;

import com.uniyaz.address.domain.Address;
import com.uniyaz.store.domain.Store;

public class StaffQueryFilterDto {

    private Long id;
    private String firstName;
    private Address address;
    private Store store;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}