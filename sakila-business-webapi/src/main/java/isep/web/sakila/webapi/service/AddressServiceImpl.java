package isep.web.sakila.webapi.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isep.web.sakila.dao.repositories.AddressRepository;
import isep.web.sakila.dao.repositories.CityRepository;
import isep.web.sakila.jpa.entities.Address;
import isep.web.sakila.jpa.entities.City;
import isep.web.sakila.webapi.model.AddressWO;
import isep.web.sakila.webapi.model.CityWO;

@Service("addressService")
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private CityRepository cityRepository;

	private static final Log log = LogFactory.getLog(AddressServiceImpl.class);

	@Override
	public AddressWO findById(int id) {
		log.debug(String.format("Looking for user by Id %s", id));
		Address address = addressRepository.findOne(id);

		if (address != null) {
			return new AddressWO(address);
		}
		return null;
	}

	// public void newAddress(AddressWO addressWO, CityWO cityWO) {
	@Override
	public Address newAddress(AddressWO addressWO) {
		Address address = new Address();
		// City city = cityRepository.findOne(cityWO.getCityId());
		address.setAddress(addressWO.getAddress());
		address.setAddress2(addressWO.getAddress2());
		address.setDistrict(addressWO.getDistrict());
		address.setPhone(addressWO.getPhone());
		address.setPostalCode(addressWO.getPostalCode());
		// address.setCity(city);
		// addressRepository.save(address);

		return address;
	}

	@Override
	public void updateAddress(AddressWO addressWO, CityWO cityWO) {
		Address address2update = addressRepository.findOne(addressWO.getAddressId());
		City city = cityRepository.findOne(cityWO.getCityId());
		address2update.setAddress(addressWO.getAddress());
		address2update.setAddress2(addressWO.getAddress2());
		address2update.setDistrict(addressWO.getDistrict());
		address2update.setPhone(addressWO.getPhone());
		address2update.setPostalCode(addressWO.getPostalCode());
		address2update.setCity(city);
		addressRepository.save(address2update);

	}
}
