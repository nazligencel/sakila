package com.uniyaz.tum;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "film_aud", schema = "sakila", catalog = "")
@IdClass(FilmAudPK.class)
public class FilmAud {
    private long filmId;
    private int rev;
    private Byte revtype;
    private Timestamp lastUpdate;
    private String title;

    @Id
    @Column(name = "film_id")
    public long getFilmId() {
        return filmId;
    }

    public void setFilmId(long filmId) {
        this.filmId = filmId;
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
    @Column(name = "last_update")
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmAud filmAud = (FilmAud) o;
        return filmId == filmAud.filmId &&
                rev == filmAud.rev &&
                Objects.equals(revtype, filmAud.revtype) &&
                Objects.equals(lastUpdate, filmAud.lastUpdate) &&
                Objects.equals(title, filmAud.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, rev, revtype, lastUpdate, title);
    }
}
