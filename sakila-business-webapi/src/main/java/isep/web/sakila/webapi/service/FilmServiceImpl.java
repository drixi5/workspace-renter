package isep.web.sakila.webapi.service;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isep.web.sakila.dao.repositories.ActorRepository;
import isep.web.sakila.dao.repositories.FilmRepository;
import isep.web.sakila.dao.repositories.LanguageRepository;
import isep.web.sakila.jpa.entities.Actor;
import isep.web.sakila.jpa.entities.Film;
import isep.web.sakila.jpa.entities.FilmActor;
import isep.web.sakila.jpa.entities.FilmCategory;
import isep.web.sakila.jpa.entities.Language;
import isep.web.sakila.webapi.model.FilmWO;

@Service("filmService")
@Transactional
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private LanguageRepository languageRepository;

	@Autowired
	private ActorRepository actorRepository;

	private static final Log log = LogFactory.getLog(CustomerServiceImpl.class);

	@Override
	public List<FilmWO> findAllFilms() {

		List<FilmWO> films = new LinkedList<FilmWO>();

		for (Film film : filmRepository.findAll())

		{
			films.add(new FilmWO(film));
			log.debug("Adding " + film);
		}

		return films;
	}

	@Override
	public FilmWO findById(int id) {
		log.debug(String.format("Looking for user by Id %s", id));
		Film film = filmRepository.findOne(id);

		if (film != null) {
			return new FilmWO(film);
		}
		return null;
	}

	@Override
	public void saveFilm(FilmWO filmWO) {
		Film film = new Film();
		FilmActor filmActor = new FilmActor();
		FilmCategory filmCategory = new FilmCategory();
		Language language1 = null;
		Language language2 = null;
		Actor actor = null;

		film.setDescription(filmWO.getDescription());
		film.setLength(filmWO.getLength());
		film.setReleaseYear(film.getReleaseYear());
		film.setRentalDuration(filmWO.getRentalDuration());
		film.setRentalRate(filmWO.getRentalRate());
		film.setReplacementCost(filmWO.getReplacementCost());
		film.setSpecialFeatures(filmWO.getSpecialFeatures());
		film.setTitle(filmWO.getTitle());

		language1 = languageRepository.findByName(filmWO.getLanguage1());
		language2 = languageRepository.findByName(filmWO.getLanguage2());
		film.setLanguage1(language1);
		film.setLanguage1(language2);

		filmRepository.save(film);

	}

}
