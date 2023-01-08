package com.uniyaz.inventory.domain;

import com.uniyaz.common.domain.BaseEntity;
import com.uniyaz.film.domain.Film;
import com.uniyaz.store.domain.Store;
import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
public class Inventory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "film_id")
    @ForeignKey(name = "fk_inventory_film")
    private Film film;

    @Column(name = "store_id")
    private Long storeId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date lastUpdate;


    @Override
    public Long getId() {
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", film=" + film +
                ", storeId=" + storeId +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
