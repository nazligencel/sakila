package com.uniyaz.tum;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FilmActorAudPK implements Serializable {
    private long filmActorId;
    private int rev;

    @Column(name = "film_actor_id")
    @Id
    public long getFilmActorId() {
        return filmActorId;
    }

    public void setFilmActorId(long filmActorId) {
        this.filmActorId = filmActorId;
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
        FilmActorAudPK that = (FilmActorAudPK) o;
        return filmActorId == that.filmActorId &&
                rev == that.rev;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmActorId, rev);
    }
}
