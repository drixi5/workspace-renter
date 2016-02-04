package isep.web.sakila.dao.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import isep.web.sakila.jpa.entities.Film;
import isep.web.sakila.jpa.entities.FilmActor;

public interface FilmActorRepository extends CrudRepository<FilmActor, Integer> {

	public List<FilmActor> findByFilm(Film film);
}
