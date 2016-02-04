package isep.web.sakila.webapi.service;

import java.util.List;

import isep.web.sakila.webapi.model.FilmActorWO;

public interface FilmActorService {

	List<FilmActorWO> findAllFilmActors(int id);

}
