package com.uniyaz.tum;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "film_actor", schema = "sakila", catalog = "")
@IdClass(FilmActorPK.class)
public class FilmActor {
    private Object actorId;
    private Object filmId;
    private Timestamp lastUpdate;
    private long filmActorId;
    private Film filmByFilmId;

    @Id
    @Column(name = "actor_id")
    public Object getActorId() {
        return actorId;
    }

    public void setActorId(Object actorId) {
        this.actorId = actorId;
    }

    @Id
    @Column(name = "film_id")
    public Object getFilmId() {
        return filmId;
    }

    public void setFilmId(Object filmId) {
        this.filmId = filmId;
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
    @Column(name = "film_actor_id")
    public long getFilmActorId() {
        return filmActorId;
    }

    public void setFilmActorId(long filmActorId) {
        this.filmActorId = filmActorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActor filmActor = (FilmActor) o;
        return filmActorId == filmActor.filmActorId &&
                Objects.equals(actorId, filmActor.actorId) &&
                Objects.equals(filmId, filmActor.filmId) &&
                Objects.equals(lastUpdate, filmActor.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, filmId, lastUpdate, filmActorId);
    }

    @ManyToOne
    @JoinColumn(name = "film_id", referencedColumnName = "film_id", nullable = false)
    public Film getFilmByFilmId() {
        return filmByFilmId;
    }

    public void setFilmByFilmId(Film filmByFilmId) {
        this.filmByFilmId = filmByFilmId;
    }
}
