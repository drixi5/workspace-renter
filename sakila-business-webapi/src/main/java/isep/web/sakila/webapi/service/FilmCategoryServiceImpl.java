package isep.web.sakila.webapi.service;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isep.web.sakila.dao.repositories.FilmCategoryRepository;
import isep.web.sakila.dao.repositories.FilmRepository;
import isep.web.sakila.jpa.entities.Film;
import isep.web.sakila.jpa.entities.FilmCategory;
import isep.web.sakila.webapi.model.FilmCategoryWO;

@Service("filmCategoryService")
@Transactional
public class FilmCategoryServiceImpl implements FilmCategoryService {

	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private FilmCategoryRepository filmCategoryRepository;

	private static final Log log = LogFactory.getLog(CustomerServiceImpl.class);

	@Override
	public List<FilmCategoryWO> findAllFilmCategories(int id) {

		List<FilmCategoryWO> filmCategories = new LinkedList<FilmCategoryWO>();
		Film film = filmRepository.findOne(id);
		for (FilmCategory filmCategory : filmCategoryRepository.findByFilm(film))

		{
			filmCategories.add(new FilmCategoryWO(filmCategory));
			log.debug("Adding " + filmCategory);
		}

		return filmCategories;
	}

}
