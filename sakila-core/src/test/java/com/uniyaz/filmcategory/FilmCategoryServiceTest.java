package com.uniyaz.filmcategory;

import com.uniyaz.filmcategory.dao.FilmCategoryDao;
import com.uniyaz.filmcategory.domain.FilmCategory;
import com.uniyaz.filmcategory.service.FilmCategoryService;
import org.junit.Test;

import java.util.List;

public class FilmCategoryServiceTest {
    @Test
    public void findAllTest() {

        FilmCategoryService filmCategoryService=new FilmCategoryService();
        List<FilmCategory> filmCategoryList = filmCategoryService.findAll();
        for (FilmCategory filmCategory : filmCategoryList) {
            System.out.println(filmCategory);
        }

    }
    @Test
    public void findAllByCategoryName () {

        FilmCategoryDao filmCategoryDao = new FilmCategoryDao();
        String name= "Drama";
        List<FilmCategory> filmCategories =filmCategoryDao.findByFileName(name);
        for (FilmCategory filmCategory : filmCategories) {
            System.out.println(filmCategory);
        }
    }


}
