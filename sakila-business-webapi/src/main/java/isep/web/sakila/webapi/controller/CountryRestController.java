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

import isep.web.sakila.webapi.model.CountryWO;
import isep.web.sakila.webapi.service.CountryService;

@RestController
public class CountryRestController {

	@Autowired
	CountryService CountryService;

	private static final Log log = LogFactory.getLog(CountryRestController.class);

	@RequestMapping(value = "/country/", method = RequestMethod.GET)
	public ResponseEntity<List<CountryWO>> listAllcities() {


		List<CountryWO> cities = CountryService.findAllCountries();
		if (cities.isEmpty()) {
			return new ResponseEntity<List<CountryWO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CountryWO>>(cities, HttpStatus.OK);
	}

	@RequestMapping(value = "/country/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CountryWO> getcountry(@PathVariable("id") int id) {
		System.out.println("Fetching country with id " + id);
		CountryWO CountryWO = CountryService.findById(id);
		if (CountryWO == null) {
			System.out.println("country with id " + id + " not found");
			return new ResponseEntity<CountryWO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CountryWO>(CountryWO, HttpStatus.OK);
	}

	// -------------------Create a country----------------------------------

	@RequestMapping(value = "/country/", method = RequestMethod.POST)
	public ResponseEntity<Void> createcountry(@RequestBody CountryWO CountryWO, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating country " + CountryWO.getCountry());

		CountryService.saveCountry(CountryWO);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/actor/{id}").buildAndExpand(CountryWO.getCountryId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	// -------------------Update a country----------------------------------
	@RequestMapping(value = "/country/update/", method = RequestMethod.POST)
	public ResponseEntity<CountryWO> updatecountry(@RequestBody CountryWO CountryWO, UriComponentsBuilder ucBuilder) {
		log.error(String.format("Updating country %s ", CountryWO.getCountryId()));
		CountryWO currentcountry = CountryService.findById(CountryWO.getCountryId());

		if (currentcountry == null) {
			System.out.println("country with id " + CountryWO.getCountryId() + " not found");
			return new ResponseEntity<CountryWO>(HttpStatus.NOT_FOUND);
		}

		currentcountry.setCountry(CountryWO.getCountry());
		CountryService.updateCountry(currentcountry);

		return new ResponseEntity<CountryWO>(currentcountry, HttpStatus.OK);
	}
	// -------------------Delete a Actor----------------------------------
	@RequestMapping(value = "/country/delete/{id}", method = RequestMethod.GET)
	public ResponseEntity<CountryWO> deletecountry(@PathVariable("id") int id) {

		System.out.println("Fetching & Deleting country with id " + id);

		CountryWO staffWO = CountryService.findById(id);
		if (staffWO == null) {
			System.out.println("Unable to delete. country with id " + id + " not found");
			return new ResponseEntity<CountryWO>(HttpStatus.NOT_FOUND);
		}

		CountryService.deleteCountryById(id);
		return new ResponseEntity<CountryWO>(HttpStatus.NO_CONTENT);
	}
}
