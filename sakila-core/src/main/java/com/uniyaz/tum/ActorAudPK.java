package com.uniyaz.tum;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ActorAudPK implements Serializable {
    private long actorId;
    private int rev;

    @Column(name = "actor_id")
    @Id
    public long getActorId() {
        return actorId;
    }

    public void setActorId(long actorId) {
        this.actorId = actorId;
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
        ActorAudPK that = (ActorAudPK) o;
        return actorId == that.actorId &&
                rev == that.rev;
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, rev);
    }
}
