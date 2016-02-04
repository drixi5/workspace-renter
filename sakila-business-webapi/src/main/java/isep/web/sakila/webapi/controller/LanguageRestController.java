package isep.web.sakila.webapi.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import isep.web.sakila.webapi.model.LanguageWO;
import isep.web.sakila.webapi.service.LanguageService;

@RestController
public class LanguageRestController {

	@Autowired
	LanguageService LanguageService;

	private static final Log log = LogFactory.getLog(LanguageRestController.class);

	@RequestMapping(value = "/language/", method = RequestMethod.GET)
	public ResponseEntity<List<LanguageWO>> listAllcategories() {


		List<LanguageWO> categories = LanguageService.findAllLanguages();
		if (categories.isEmpty()) {
			return new ResponseEntity<List<LanguageWO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<LanguageWO>>(categories, HttpStatus.OK);
	}

	@RequestMapping(value = "/language/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LanguageWO> getLanguage(@PathVariable("id") int id) {
		System.out.println("Fetching Language with id " + id);
		LanguageWO LanguageWO = LanguageService.findById(id);
		if (LanguageWO == null) {
			System.out.println("Language with id " + id + " not found");
			return new ResponseEntity<LanguageWO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<LanguageWO>(LanguageWO, HttpStatus.OK);
	}

	// -------------------Create a Language----------------------------------

	@RequestMapping(value = "/language/", method = RequestMethod.POST)
	public ResponseEntity<Void> createLanguage(@RequestBody LanguageWO LanguageWO, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Language " + LanguageWO.getName());

		LanguageService.saveLanguage(LanguageWO);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/actor/{id}").buildAndExpand(LanguageWO.getLanguageId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	// -------------------Update a Language----------------------------------
	@RequestMapping(value = "/language/update/", method = RequestMethod.POST)
	public ResponseEntity<LanguageWO> updateLanguage(@RequestBody LanguageWO LanguageWO, UriComponentsBuilder ucBuilder) {
		log.error(String.format("Updating Language %s ", LanguageWO.getLanguageId()));
		LanguageWO currentLanguage = LanguageService.findById(LanguageWO.getLanguageId());

		if (currentLanguage == null) {
			System.out.println("Language with id " + LanguageWO.getLanguageId() + " not found");
			return new ResponseEntity<LanguageWO>(HttpStatus.NOT_FOUND);
		}

		currentLanguage.setName(LanguageWO.getName());
		LanguageService.updateLanguage(currentLanguage);

		return new ResponseEntity<LanguageWO>(currentLanguage, HttpStatus.OK);
	}
	// -------------------Delete a Language----------------------------------
	@RequestMapping(value = "/language/delete/{id}", method = RequestMethod.GET)
	public ResponseEntity<LanguageWO> deleteLanguage(@PathVariable("id") int id) {

		System.out.println("Fetching & Deleting Language with id " + id);

		LanguageWO staffWO = LanguageService.findById(id);
		if (staffWO == null) {
			System.out.println("Unable to delete. Language with id " + id + " not found");
			return new ResponseEntity<LanguageWO>(HttpStatus.NOT_FOUND);
		}

		LanguageService.deleteLanguageById(id);
		return new ResponseEntity<LanguageWO>(HttpStatus.NO_CONTENT);
	}
}
