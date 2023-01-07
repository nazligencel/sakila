package com.uniyaz.tum;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "staff_list", schema = "sakila", catalog = "")
public class StaffList {
    private Object id;
    private String name;
    private String address;
    private String zipCode;
    private String phone;
    private String city;
    private String country;
    private Object sid;

    @Basic
    @Column(name = "ID")
    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "zip code")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "SID")
    public Object getSid() {
        return sid;
    }

    public void setSid(Object sid) {
        this.sid = sid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffList staffList = (StaffList) o;
        return Objects.equals(id, staffList.id) &&
                Objects.equals(name, staffList.name) &&
                Objects.equals(address, staffList.address) &&
                Objects.equals(zipCode, staffList.zipCode) &&
                Objects.equals(phone, staffList.phone) &&
                Objects.equals(city, staffList.city) &&
                Objects.equals(country, staffList.country) &&
                Objects.equals(sid, staffList.sid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, zipCode, phone, city, country, sid);
    }
}
