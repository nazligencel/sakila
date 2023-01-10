package com.uniyaz.filmactor;

import com.uniyaz.filmactor.domain.FilmActor;
import com.uniyaz.filmactor.service.FilmActorService;
import org.junit.Test;

import java.util.List;

public class FilmActorServiceTest {

    @Test
    public void findAllTest() {

        FilmActorService filmActorService = new FilmActorService();
        List<FilmActor> filmActorList = filmActorService.findAll();
        for (FilmActor filmActor : filmActorList) {
            System.out.println(filmActor);
        }
    }
}