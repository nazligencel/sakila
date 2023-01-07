package com.uniyaz.tum;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "film_text", schema = "sakila", catalog = "")
public class FilmText {
    private short filmId;
    private String title;
    private String description;

    @Id
    @Column(name = "film_id")
    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmText filmText = (FilmText) o;
        return filmId == filmText.filmId &&
                Objects.equals(title, filmText.title) &&
                Objects.equals(description, filmText.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, title, description);
    }
}
