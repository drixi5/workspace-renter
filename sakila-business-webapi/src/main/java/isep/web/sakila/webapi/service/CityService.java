package isep.web.sakila.webapi.service;

import java.util.HashMap;
import java.util.List;

import isep.web.sakila.webapi.model.CityWO;

public interface CityService {

	List<CityWO> findAllCities();

	CityWO findById(int id);

	// Country newCountry(CityWO CityWO);

	/*HashMap<String, String> selectCity(List<CityWO> cities);*/

	void saveCity(CityWO CityWO);

	void updateCity(CityWO CityWO);

	void deleteCityById(int id);

}

