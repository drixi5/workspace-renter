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

import isep.web.sakila.webapi.model.CityWO;
import isep.web.sakila.webapi.service.CityService;

@RestController
public class CityRestController {

	@Autowired
	CityService CityService;

	private static final Log log = LogFactory.getLog(CityRestController.class);

	@RequestMapping(value = "/city/", method = RequestMethod.GET)
	public ResponseEntity<List<CityWO>> listAllcities() {


		List<CityWO> cities = CityService.findAllCities();
		if (cities.isEmpty()) {
			return new ResponseEntity<List<CityWO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CityWO>>(cities, HttpStatus.OK);
	}

	@RequestMapping(value = "/city/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CityWO> getcity(@PathVariable("id") int id) {
		System.out.println("Fetching city with id " + id);
		CityWO CityWO = CityService.findById(id);
		if (CityWO == null) {
			System.out.println("city with id " + id + " not found");
			return new ResponseEntity<CityWO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CityWO>(CityWO, HttpStatus.OK);
	}

	// -------------------Create a City----------------------------------

	@RequestMapping(value = "/city/", method = RequestMethod.POST)
	public ResponseEntity<Void> createcity(@RequestBody CityWO CityWO, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating city " + CityWO.getCity());

		CityService.saveCity(CityWO);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/actor/{id}").buildAndExpand(CityWO.getCityId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	// -------------------Update a City----------------------------------
	@RequestMapping(value = "/city/update/", method = RequestMethod.POST)
	public ResponseEntity<CityWO> updatecity(@RequestBody CityWO CityWO, UriComponentsBuilder ucBuilder) {
		log.error(String.format("Updating city %s ", CityWO.getCityId()));
		CityWO currentcity = CityService.findById(CityWO.getCityId());

		if (currentcity == null) {
			System.out.println("city with id " + CityWO.getCityId() + " not found");
			return new ResponseEntity<CityWO>(HttpStatus.NOT_FOUND);
		}

		currentcity.setCity(CityWO.getCity());
		CityService.updateCity(currentcity);

		return new ResponseEntity<CityWO>(currentcity, HttpStatus.OK);
	}
	// -------------------Delete a Actor----------------------------------
	@RequestMapping(value = "/city/delete/{id}", method = RequestMethod.GET)
	public ResponseEntity<CityWO> deletecity(@PathVariable("id") int id) {

		System.out.println("Fetching & Deleting city with id " + id);

		CityWO staffWO = CityService.findById(id);
		if (staffWO == null) {
			System.out.println("Unable to delete. city with id " + id + " not found");
			return new ResponseEntity<CityWO>(HttpStatus.NOT_FOUND);
		}

		CityService.deleteCityById(id);
		return new ResponseEntity<CityWO>(HttpStatus.NO_CONTENT);
	}
}
