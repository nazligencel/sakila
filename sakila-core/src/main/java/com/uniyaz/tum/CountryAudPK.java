package com.uniyaz.tum;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CountryAudPK implements Serializable {
    private long countryId;
    private int rev;

    @Column(name = "country_id")
    @Id
    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    @Column(name = "REV")
    @Id
    public int getRev() {
        return rev;
    }

    public void setRev(int rev) {
        this.rev = rev;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryAudPK that = (CountryAudPK) o;
        return countryId == that.countryId &&
                rev == that.rev;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, rev);
    }
}
