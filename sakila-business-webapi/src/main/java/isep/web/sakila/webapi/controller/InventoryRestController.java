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

import isep.web.sakila.webapi.model.ActorWO;
import isep.web.sakila.webapi.model.InventoryWO;
import isep.web.sakila.webapi.service.InventoryService;

@RestController
public class InventoryRestController {

	@Autowired
	InventoryService inventoryService;

	private static final Log log = LogFactory.getLog(CustomerRestController.class);

	@RequestMapping(value = "/inventoryStore/{storeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<InventoryWO>> listAllFilmInventory(@PathVariable("storeId") int id) {
		System.out.println("Fetching Store with id " + id);
		List<InventoryWO> inventory = inventoryService.findAllFilmInventory(id);
		if (inventory.isEmpty()) {
			return new ResponseEntity<List<InventoryWO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<InventoryWO>>(inventory, HttpStatus.OK);
	}

	@RequestMapping(value = "/inventory/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InventoryWO> getInventory(@PathVariable("id") int id) {
		System.out.println("Fetching Inventory with id " + id);
		InventoryWO inventoryWO = inventoryService.findById(id);
		if (inventoryWO == null) {
			System.out.println("Inventory with id " + id + " not found");
			return new ResponseEntity<InventoryWO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<InventoryWO>(inventoryWO, HttpStatus.OK);
	}

	@RequestMapping(value = "/inventoryStore/{storeId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createActor(@PathVariable("storeId") int storeId, @RequestBody InventoryWO inventoryWO,
			UriComponentsBuilder ucBuilder) {
		System.out.println("Fetching Store with id " + storeId);
		System.out.println("Creating InventoryId " + inventoryWO.getInventoryId());

		inventoryService.saveInventory(inventoryWO, storeId);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/inventory/{id}").buildAndExpand(inventoryWO.getInventoryId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/inventoryStore/delete/{id}", method = RequestMethod.GET)
	public ResponseEntity<ActorWO> deleteActor(@PathVariable("id") int id) {

		System.out.println("Fetching & Deleting inventory with id " + id);

		InventoryWO inventoryWO = inventoryService.findById(id);
		if (inventoryWO == null) {
			System.out.println("Unable to delete. inventory with id " + id + " not found");
			return new ResponseEntity<ActorWO>(HttpStatus.NOT_FOUND);
		}

		inventoryService.deleteInventoryById(id);
		return new ResponseEntity<ActorWO>(HttpStatus.NO_CONTENT);
	}
}
