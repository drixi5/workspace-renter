package isep.web.sakila.webapi.service;

import isep.web.sakila.jpa.entities.Address;
import isep.web.sakila.webapi.model.AddressWO;
import isep.web.sakila.webapi.model.CityWO;

public interface AddressService {

	AddressWO findById(int id);

	Address newAddress(AddressWO addressWO);

	void updateAddress(AddressWO addressWO, CityWO cityWO);

}
