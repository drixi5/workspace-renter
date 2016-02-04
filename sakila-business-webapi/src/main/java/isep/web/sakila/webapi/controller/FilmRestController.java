package isep.web.sakila.webapi.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import isep.web.sakila.webapi.model.FilmWO;
import isep.web.sakila.webapi.service.FilmService;

@RestController
public class FilmRestController {

	@Autowired
	FilmService filmService;

	private static final Log log = LogFactory.getLog(CustomerRestController.class);

	@RequestMapping(value = "/film/", method = RequestMethod.GET)
	public ResponseEntity<List<FilmWO>> listAllFilms() {

		List<FilmWO> films = filmService.findAllFilms();
		if (films.isEmpty()) {
			return new ResponseEntity<List<FilmWO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<FilmWO>>(films, HttpStatus.OK);
	}

}
