package isep.web.sakila.webapi.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import isep.web.sakila.webapi.model.FilmCategoryWO;
import isep.web.sakila.webapi.service.FilmCategoryService;

@RestController
public class FilmCategoryRestController {

	@Autowired
	FilmCategoryService filmCategoryService;

	private static final Log log = LogFactory.getLog(CustomerRestController.class);

	@RequestMapping(value = "/filmCategory/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FilmCategoryWO>> listAllFilms(@PathVariable("id") int id) {

		List<FilmCategoryWO> filmCategories = filmCategoryService.findAllFilmCategories(id);
		if (filmCategories.isEmpty()) {
			return new ResponseEntity<List<FilmCategoryWO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<FilmCategoryWO>>(filmCategories, HttpStatus.OK);
	}

}
