package com.uniyaz.tum;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "city_aud", schema = "sakila", catalog = "")
@IdClass(CityAudPK.class)
public class CityAud {
    private long cityId;
    private int rev;
    private Byte revtype;
    private String city;
    private Timestamp lastUpdate;
    private Long countryId;

    @Id
    @Column(name = "city_id")
    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    @Id
    @Column(name = "REV")
    public int getRev() {
        return rev;
    }

    public void setRev(int rev) {
        this.rev = rev;
    }

    @Basic
    @Column(name = "REVTYPE")
    public Byte getRevtype() {
        return revtype;
    }

    public void setRevtype(Byte revtype) {
        this.revtype = revtype;
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
    @Column(name = "last_update")
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Basic
    @Column(name = "country_id")
    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityAud cityAud = (CityAud) o;
        return cityId == cityAud.cityId &&
                rev == cityAud.rev &&
                Objects.equals(revtype, cityAud.revtype) &&
                Objects.equals(city, cityAud.city) &&
                Objects.equals(lastUpdate, cityAud.lastUpdate) &&
                Objects.equals(countryId, cityAud.countryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, rev, revtype, city, lastUpdate, countryId);
    }
}
