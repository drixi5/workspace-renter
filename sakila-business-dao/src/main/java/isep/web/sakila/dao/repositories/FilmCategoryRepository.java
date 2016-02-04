package isep.web.sakila.dao.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import isep.web.sakila.jpa.entities.Film;
import isep.web.sakila.jpa.entities.FilmCategory;

public interface FilmCategoryRepository extends CrudRepository<FilmCategory, Integer> {

	public List<FilmCategory> findByFilm(Film film);

}
