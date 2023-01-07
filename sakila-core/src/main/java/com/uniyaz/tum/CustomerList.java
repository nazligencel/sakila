package com.uniyaz.tum;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "customer_list", schema = "sakila", catalog = "")
public class CustomerList {
    private Object id;
    private String name;
    private String address;
    private String zipCode;
    private String phone;
    private String city;
    private String country;
    private String notes;
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
    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
        CustomerList that = (CustomerList) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(zipCode, that.zipCode) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(city, that.city) &&
                Objects.equals(country, that.country) &&
                Objects.equals(notes, that.notes) &&
                Objects.equals(sid, that.sid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, zipCode, phone, city, country, notes, sid);
    }
}
