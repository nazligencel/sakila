package com.uniyaz.tum;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FilmAudPK implements Serializable {
    private long filmId;
    private int rev;

    @Column(name = "film_id")
    @Id
    public long getFilmId() {
        return filmId;
    }

    public void setFilmId(long filmId) {
        this.filmId = filmId;
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
        FilmAudPK filmAudPK = (FilmAudPK) o;
        return filmId == filmAudPK.filmId &&
                rev == filmAudPK.rev;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, rev);
    }
}
