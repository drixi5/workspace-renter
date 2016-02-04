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

import isep.web.sakila.webapi.model.CustomerWO;
import isep.web.sakila.webapi.service.CustomerService;

@RestController
public class CustomerRestController {

	@Autowired
	CustomerService customerService;
	// @Autowired
	// CityService cityService;
	// @Autowired
	// CountryService countryService;

	private static final Log log = LogFactory.getLog(CustomerRestController.class);

	@RequestMapping(value = "/customer/", method = RequestMethod.GET)
	public ResponseEntity<List<CustomerWO>> listAllCustomers() {

		List<CustomerWO> customers = customerService.findAllCustomers();
		if (customers.isEmpty()) {
			return new ResponseEntity<List<CustomerWO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CustomerWO>>(customers, HttpStatus.OK);
	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerWO> getCustomer(@PathVariable("id") int id) {
		System.out.println("Fetching Customer with id " + id);
		CustomerWO customerWO = customerService.findById(id);
		if (customerWO == null) {
			System.out.println("Customer with id " + id + " not found");
			return new ResponseEntity<CustomerWO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CustomerWO>(customerWO, HttpStatus.OK);
	}

	@RequestMapping(value = "/customer/", method = RequestMethod.POST)
	public ResponseEntity<Void> createCustomer(@RequestBody CustomerWO customerWO, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Customer lastname" + customerWO.getLastName());
		System.out.println("Creating Customer firstname" + customerWO.getFirstName());
		System.out.println("Creating Customer email" + customerWO.getEmail());
		System.out.println("Creating address " + customerWO.getAddress());
		System.out.println("Creating address2 " + customerWO.getAddress2());
		System.out.println("Creating district " + customerWO.getDistrict());
		System.out.println("Creating phone " + customerWO.getPhone());
		System.out.println("Creating postalCode " + customerWO.getPostalCode());
		System.out.println("Creating city " + customerWO.getCity());
		System.out.println("Creating country " + customerWO.getCountry());
		System.out.println("Creating store " + customerWO.getStore());

		customerService.saveCustomer(customerWO);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/customer/{id}").buildAndExpand(customerWO.getCustomerId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/customer/update/", method = RequestMethod.POST)
	public ResponseEntity<CustomerWO> updateCustomer(@RequestBody CustomerWO customerWO,
			UriComponentsBuilder ucBuilder) {
		log.error(String.format("Updating Customer %s ", customerWO.getCustomerId()));
		CustomerWO currentCustomer = customerService.findById(customerWO.getCustomerId());

		if (currentCustomer == null) {
			System.out.println("Customer with id " + customerWO.getCustomerId() + " not found");
			return new ResponseEntity<CustomerWO>(HttpStatus.NOT_FOUND);
		}

		currentCustomer.setLastName(customerWO.getLastName());
		currentCustomer.setFirstName(customerWO.getFirstName());
		currentCustomer.setEmail(customerWO.getEmail());
		currentCustomer.setAddress(customerWO.getAddress());
		currentCustomer.setAddress2(customerWO.getAddress2());
		currentCustomer.setDistrict(customerWO.getDistrict());
		currentCustomer.setPhone(customerWO.getPhone());
		currentCustomer.setPostalCode(customerWO.getPostalCode());
		currentCustomer.setCity(customerWO.getCity());
		currentCustomer.setCountry(customerWO.getCountry());

		customerService.updateCustomer(currentCustomer);

		return new ResponseEntity<CustomerWO>(currentCustomer, HttpStatus.OK);
	}

}
