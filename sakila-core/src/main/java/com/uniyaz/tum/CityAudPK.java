package com.uniyaz.tum;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CityAudPK implements Serializable {
    private long cityId;
    private int rev;

    @Column(name = "city_id")
    @Id
    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
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
        CityAudPK cityAudPK = (CityAudPK) o;
        return cityId == cityAudPK.cityId &&
                rev == cityAudPK.rev;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, rev);
    }
}
