package isep.web.sakila.webapi.service;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isep.web.sakila.dao.repositories.FilmActorRepository;
import isep.web.sakila.dao.repositories.FilmRepository;
import isep.web.sakila.jpa.entities.Film;
import isep.web.sakila.jpa.entities.FilmActor;
import isep.web.sakila.webapi.model.FilmActorWO;

@Service("filmActorService")
@Transactional
public class FilmActorServiceImpl implements FilmActorService {

	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private FilmActorRepository filmActorRepository;

	private static final Log log = LogFactory.getLog(CustomerServiceImpl.class);

	@Override
	public List<FilmActorWO> findAllFilmActors(int id) {

		List<FilmActorWO> filmActors = new LinkedList<FilmActorWO>();
		Film film = filmRepository.findOne(id);
		for (FilmActor filmActor : filmActorRepository.findByFilm(film))

		{
			filmActors.add(new FilmActorWO(filmActor));
			log.debug("Adding " + filmActor);
		}

		return filmActors;
	}

}
