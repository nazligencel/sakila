package com.uniyaz.tum;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "actor_aud", schema = "sakila", catalog = "")
@IdClass(ActorAudPK.class)
public class ActorAud {
    private long actorId;
    private int rev;
    private Byte revtype;
    private String firstName;
    private String lastName;
    private Timestamp lastUpdate;

    @Id
    @Column(name = "actor_id")
    public long getActorId() {
        return actorId;
    }

    public void setActorId(long actorId) {
        this.actorId = actorId;
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
        ActorAud actorAud = (ActorAud) o;
        return actorId == actorAud.actorId &&
                rev == actorAud.rev &&
                Objects.equals(revtype, actorAud.revtype) &&
                Objects.equals(firstName, actorAud.firstName) &&
                Objects.equals(lastName, actorAud.lastName) &&
                Objects.equals(lastUpdate, actorAud.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, rev, revtype, firstName, lastName, lastUpdate);
    }
}
