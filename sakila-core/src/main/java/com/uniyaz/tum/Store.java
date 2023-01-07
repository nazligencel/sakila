package com.uniyaz.tum;

import com.uniyaz.address.domain.Address;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Store {
    private Object storeId;
    private Timestamp lastUpdate;
    private Staff staffByManagerStaffId;
    private Address addressByAddressId;

    @Id
    @Column(name = "store_id")
    public Object getStoreId() {
        return storeId;
    }

    public void setStoreId(Object storeId) {
        this.storeId = storeId;
    }

    @Basic
    @Column(name = "last_update")
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(storeId, store.storeId) &&
                Objects.equals(lastUpdate, store.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId, lastUpdate);
    }

    @ManyToOne
    @JoinColumn(name = "manager_staff_id", referencedColumnName = "staff_id", nullable = false)
    public Staff getStaffByManagerStaffId() {
        return staffByManagerStaffId;
    }

    public void setStaffByManagerStaffId(Staff staffByManagerStaffId) {
        this.staffByManagerStaffId = staffByManagerStaffId;
    }

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(Address addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }
}
