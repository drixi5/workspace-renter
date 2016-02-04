package isep.web.sakila.webapi.service;

import java.util.List;

import isep.web.sakila.webapi.model.FilmWO;

public interface FilmService {

	List<FilmWO> findAllFilms();

	FilmWO findById(int id);

	void saveFilm(FilmWO filmWO);

}
