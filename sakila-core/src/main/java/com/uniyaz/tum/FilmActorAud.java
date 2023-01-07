package com.uniyaz.tum;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "film_actor_aud", schema = "sakila", catalog = "")
@IdClass(FilmActorAudPK.class)
public class FilmActorAud {
    private long filmActorId;
    private int rev;
    private Byte revtype;
    private Timestamp lastUpdate;
    private Long actorId;
    private Long filmId;

    @Id
    @Column(name = "film_actor_id")
    public long getFilmActorId() {
        return filmActorId;
    }

    public void setFilmActorId(long filmActorId) {
        this.filmActorId = filmActorId;
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
    @Column(name = "actor_id")
    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    @Basic
    @Column(name = "film_id")
    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActorAud that = (FilmActorAud) o;
        return filmActorId == that.filmActorId &&
                rev == that.rev &&
                Objects.equals(revtype, that.revtype) &&
                Objects.equals(lastUpdate, that.lastUpdate) &&
                Objects.equals(actorId, that.actorId) &&
                Objects.equals(filmId, that.filmId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmActorId, rev, revtype, lastUpdate, actorId, filmId);
    }
}
