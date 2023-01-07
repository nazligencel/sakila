package com.uniyaz.tum;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Inventory {
    private Object inventoryId;
    private Timestamp lastUpdate;
    private Film filmByFilmId;

    @Id
    @Column(name = "inventory_id")
    public Object getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Object inventoryId) {
        this.inventoryId = inventoryId;
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
        Inventory inventory = (Inventory) o;
        return Objects.equals(inventoryId, inventory.inventoryId) &&
                Objects.equals(lastUpdate, inventory.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryId, lastUpdate);
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
