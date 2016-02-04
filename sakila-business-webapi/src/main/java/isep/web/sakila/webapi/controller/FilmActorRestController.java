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

import isep.web.sakila.webapi.model.FilmActorWO;
import isep.web.sakila.webapi.service.FilmActorService;

@RestController
public class FilmActorRestController {

	@Autowired
	FilmActorService filmActorService;

	private static final Log log = LogFactory.getLog(CustomerRestController.class);

	@RequestMapping(value = "/filmActor/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FilmActorWO>> listAllFilms(@PathVariable("id") int id) {

		List<FilmActorWO> filmActors = filmActorService.findAllFilmActors(id);
		if (filmActors.isEmpty()) {
			return new ResponseEntity<List<FilmActorWO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<FilmActorWO>>(filmActors, HttpStatus.OK);
	}

}
