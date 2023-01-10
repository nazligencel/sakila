package com.uniyaz.category;

import com.uniyaz.category.dao.CategoryDao;
import com.uniyaz.category.domain.Category;
import com.uniyaz.category.queryfilterdto.CategoryQueryFilterDto;
import com.uniyaz.category.service.CategoryService;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class CategoryServiceTest {
    @Test
    public void findAllTest() {

         CategoryService categoryService= new CategoryService();
        List<Category> categories = categoryService.findAll();
        for (Category category : categories) {
            System.out.println(category);
        }

    }
    @Test
    public void insertTest(){
        CategoryService categoryService = new CategoryService();
        Category category = new Category();
        Date date = new Date();
        category.setLastUpdate(date);
        category.setCategoryName("New Categorya");
        categoryService.save(category);
    }

    @Test
    public void deleteTest(){
        CategoryService categoryService = new CategoryService();
        Category category = new Category();
        category.setId((long) 9);
        categoryService.delete(category);
    }

    @Test
    public void findByName(){
        String name="Action";
        CategoryService categoryService= new CategoryService();
        List<Category> category = categoryService.findAllByName(name);
        for (Category categories : category) {
            System.out.println(categories);
        }
    }

    @Test
    public void findAllQueryFilterDto(){
        CategoryQueryFilterDto categoryQueryFilterDto= new CategoryQueryFilterDto();
        CategoryDao categoryDao = new CategoryDao();

        categoryQueryFilterDto.setCategory("Action");

        List<Category> category= categoryDao.findAllByQueryFilterDto(categoryQueryFilterDto);
        for (Category categories : category) {
            System.out.println(categories);
        }
    }
}
