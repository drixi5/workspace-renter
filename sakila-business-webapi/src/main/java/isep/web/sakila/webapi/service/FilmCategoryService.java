package isep.web.sakila.webapi.service;

import java.util.List;

import isep.web.sakila.webapi.model.FilmCategoryWO;

public interface FilmCategoryService {

	List<FilmCategoryWO> findAllFilmCategories(int id);

}
