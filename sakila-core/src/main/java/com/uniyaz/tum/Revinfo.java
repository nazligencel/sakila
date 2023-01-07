package com.uniyaz.tum;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Revinfo {
    private int rev;
    private Long revtstmp;

    @Id
    @Column(name = "REV")
    public int getRev() {
        return rev;
    }

    public void setRev(int rev) {
        this.rev = rev;
    }

    @Basic
    @Column(name = "REVTSTMP")
    public Long getRevtstmp() {
        return revtstmp;
    }

    public void setRevtstmp(Long revtstmp) {
        this.revtstmp = revtstmp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Revinfo revinfo = (Revinfo) o;
        return rev == revinfo.rev &&
                Objects.equals(revtstmp, revinfo.revtstmp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rev, revtstmp);
    }
}
