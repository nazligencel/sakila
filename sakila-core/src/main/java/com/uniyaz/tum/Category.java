package com.uniyaz.tum;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Category {
    private Object categoryId;
    private String name;
    private Timestamp lastUpdate;

    @Id
    @Column(name = "category_id")
    public Object getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Object categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Category category = (Category) o;
        return Objects.equals(categoryId, category.categoryId) &&
                Objects.equals(name, category.name) &&
                Objects.equals(lastUpdate, category.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, name, lastUpdate);
    }
}
