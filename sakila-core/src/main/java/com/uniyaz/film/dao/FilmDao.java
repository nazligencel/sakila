package com.uniyaz.film.dao;


import com.uniyaz.common.dao.BaseDao;
import com.uniyaz.film.domain.Film;


public class FilmDao extends BaseDao<Film> {

    public FilmDao() {
        super(Film.class);
    }

}