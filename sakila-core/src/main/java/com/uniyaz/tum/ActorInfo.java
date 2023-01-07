package com.uniyaz.tum;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "actor_info", schema = "sakila", catalog = "")
public class ActorInfo {
    private Object actorId;
    private String firstName;
    private String lastName;
    private String filmInfo;

    @Basic
    @Column(name = "actor_id")
    public Object getActorId() {
        return actorId;
    }

    public void setActorId(Object actorId) {
        this.actorId = actorId;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "film_info")
    public String getFilmInfo() {
        return filmInfo;
    }

    public void setFilmInfo(String filmInfo) {
        this.filmInfo = filmInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorInfo actorInfo = (ActorInfo) o;
        return Objects.equals(actorId, actorInfo.actorId) &&
                Objects.equals(firstName, actorInfo.firstName) &&
                Objects.equals(lastName, actorInfo.lastName) &&
                Objects.equals(filmInfo, actorInfo.filmInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, firstName, lastName, filmInfo);
    }
}
