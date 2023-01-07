package com.uniyaz.filmcategory.service;

import com.uniyaz.filmactor.dao.FilmActorDao;
import com.uniyaz.filmcategory.dao.FilmCategoryDao;
import com.uniyaz.filmcategory.domain.FilmCategory;

import java.util.List;

public class FilmCategoryService {
    public List<FilmCategory> findAll() {
        FilmCategoryDao filmCategoryDao=new FilmCategoryDao();
        return filmCategoryDao.findAll();
    }

    public FilmCategory save(FilmCategory filmCategory) {
        FilmCategoryDao filmCategoryDao=new FilmCategoryDao();
        return filmCategoryDao.save(filmCategory);
    }

    public void delete(FilmCategory filmCategory) {
        FilmCategoryDao filmCategoryDao=new FilmCategoryDao();
        filmCategoryDao.delete(filmCategory);
    }
}
