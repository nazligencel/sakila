package com.uniyaz.tum;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "nicer_but_slower_film_list", schema = "sakila", catalog = "")
public class NicerButSlowerFilmList {
    private Object fid;
    private String title;
    private String description;
    private String category;
    private BigDecimal price;
    private Object length;
    private Object rating;
    private String actors;

    @Basic
    @Column(name = "FID")
    public Object getFid() {
        return fid;
    }

    public void setFid(Object fid) {
        this.fid = fid;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "length")
    public Object getLength() {
        return length;
    }

    public void setLength(Object length) {
        this.length = length;
    }

    @Basic
    @Column(name = "rating")
    public Object getRating() {
        return rating;
    }

    public void setRating(Object rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "actors")
    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NicerButSlowerFilmList that = (NicerButSlowerFilmList) o;
        return Objects.equals(fid, that.fid) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(category, that.category) &&
                Objects.equals(price, that.price) &&
                Objects.equals(length, that.length) &&
                Objects.equals(rating, that.rating) &&
                Objects.equals(actors, that.actors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fid, title, description, category, price, length, rating, actors);
    }
}
