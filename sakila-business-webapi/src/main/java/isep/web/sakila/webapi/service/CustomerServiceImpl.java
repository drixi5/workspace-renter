package isep.web.sakila.webapi.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isep.web.sakila.dao.repositories.AddressRepository;
import isep.web.sakila.dao.repositories.CityRepository;
import isep.web.sakila.dao.repositories.CountryRepository;
import isep.web.sakila.dao.repositories.CustomerRepository;
import isep.web.sakila.dao.repositories.StoreRepository;
import isep.web.sakila.jpa.entities.Address;
import isep.web.sakila.jpa.entities.City;
import isep.web.sakila.jpa.entities.Country;
import isep.web.sakila.jpa.entities.Customer;
import isep.web.sakila.jpa.entities.Store;
import isep.web.sakila.webapi.model.CustomerWO;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private StoreRepository storeRepository;

	AddressService addressService;
	CityService cityService;
	CountryService countryService;

	private static final Log log = LogFactory.getLog(CustomerServiceImpl.class);

	@Override
	public List<CustomerWO> findAllCustomers() {

		List<CustomerWO> customers = new LinkedList<CustomerWO>();

		for (Customer customer : customerRepository.findAll())

		{
			customers.add(new CustomerWO(customer));
			log.debug("Adding " + customer);
		}

		return customers;
	}

	@Override
	public CustomerWO findById(int id) {
		log.debug(String.format("Looking for user by Id %s", id));
		Customer customer = customerRepository.findOne(id);

		if (customer != null) {
			return new CustomerWO(customer);
		}
		return null;
	}

	/*
	 * @Override public Customer newCustomer(CustomerWO customerWO) { Customer
	 * customer = new Customer();
	 * customer.setLastName(customerWO.getLastName());
	 * customer.setFirstName(customerWO.getFirstName());
	 * customer.setLastUpdate(new Timestamp(System.currentTimeMillis()));
	 * customer.setCreateDate(new Date(System.currentTimeMillis())); //
	 * customer.setStore(customerWO.getStore());
	 * customer.setEmail(customerWO.getEmail()); return customer;
	 * 
	 * }
	 */

	private boolean estUnEntier(String chaine) {
		try {
			Integer.parseInt(chaine);
		} catch (NumberFormatException e) {
			return false;

		}
		return true;
	}

	@Override
	public void saveCustomer(CustomerWO customerWO) {
		Customer customer = new Customer();
		Address address = new Address();
		City city = null;
		Country country = null;
		Store store = null;

		boolean boolcountry = estUnEntier(customerWO.getCountry());
		boolean boolcity = estUnEntier(customerWO.getCity());

		if (boolcity) {
			city = cityRepository.findOne(Integer.parseInt(customerWO.getCity()));
			log.debug("find city " + city);
		}
		if (null == city) {

			if (boolcountry) {
				country = countryRepository.findOne(Integer.parseInt(customerWO.getCountry()));
			}

			if (null == country) {
				country = new Country();
				country.setCountry(customerWO.getCountry());
				country.setLastUpdate(new Timestamp(System.currentTimeMillis()));
			}

			city = new City();
			city.setCity(customerWO.getCity());
			city.setLastUpdate(new Timestamp(System.currentTimeMillis()));
			city.setCountry(country);
		}

		address.setAddress(customerWO.getAddress());
		address.setAddress2(customerWO.getAddress2());
		address.setDistrict(customerWO.getDistrict());
		address.setPhone(customerWO.getPhone());
		address.setPostalCode(customerWO.getPostalCode());
		address.setCity(city);

		customer.setLastName(customerWO.getLastName());
		customer.setFirstName(customerWO.getFirstName());
		customer.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		customer.setCreateDate(new Date(System.currentTimeMillis()));
		// customer.setStore(customerWO.getStore());
		customer.setEmail(customerWO.getEmail());
		customer.setAddress(address);

		store = storeRepository.findOne(customerWO.getStore());
		customer.setStore(store);

		customerRepository.save(customer);
	}

	@Override
	public void updateCustomer(CustomerWO customerWO) {
		Customer customer2update = customerRepository.findOne(customerWO.getCustomerId());
		Address address2update = addressRepository.findOne(customer2update.getAddress().getAddressId());

		City city = null;
		Country country = null;

		boolean boolcountry = estUnEntier(customerWO.getCountry());
		boolean boolcity = estUnEntier(customerWO.getCity());

		if (boolcity) {
			city = cityRepository.findOne(Integer.parseInt(customerWO.getCity()));

		}
		if (null == city) {

			if (boolcountry) {
				country = countryRepository.findOne(Integer.parseInt(customerWO.getCountry()));
			}

			if (null == country) {
				country = new Country();
				country.setCountry(customerWO.getCountry());
				country.setLastUpdate(new Timestamp(System.currentTimeMillis()));
			}

			city = new City();
			city.setCity(customerWO.getCity());
			city.setLastUpdate(new Timestamp(System.currentTimeMillis()));
			city.setCountry(country);
		}

		address2update.setAddress(customerWO.getAddress());
		address2update.setAddress2(customerWO.getAddress2());
		address2update.setDistrict(customerWO.getDistrict());
		address2update.setPhone(customerWO.getPhone());
		address2update.setPostalCode(customerWO.getPostalCode());
		address2update.setCity(city);
		customer2update.setLastName(customerWO.getLastName());
		customer2update.setFirstName(customerWO.getFirstName());
		customer2update.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		// customer2update.setStore(customerWO.getStore());
		customer2update.setEmail(customerWO.getEmail());
		customer2update.setAddress(address2update);

		customerRepository.save(customer2update);
	}

}
