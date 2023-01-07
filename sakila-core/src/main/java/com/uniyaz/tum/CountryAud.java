package com.uniyaz.tum;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "country_aud", schema = "sakila", catalog = "")
@IdClass(CountryAudPK.class)
public class CountryAud {
    private long countryId;
    private int rev;
    private Byte revtype;
    private String country;
    private Timestamp lastUpdate;

    @Id
    @Column(name = "country_id")
    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
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
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
        CountryAud that = (CountryAud) o;
        return countryId == that.countryId &&
                rev == that.rev &&
                Objects.equals(revtype, that.revtype) &&
                Objects.equals(country, that.country) &&
                Objects.equals(lastUpdate, that.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, rev, revtype, country, lastUpdate);
    }
}
