package isep.web.sakila.webapi.service;

import java.util.HashMap;
import java.util.List;

import isep.web.sakila.webapi.model.CountryWO;

public interface CountryService {

	List<CountryWO> findAllCountries();

	CountryWO findById(int id);

	// Country newCountry(CountryWO countryWO);

	/*HashMap<String, String> selectCountry(List<CountryWO> countries);*/

	void saveCountry(CountryWO countryWO);

	void updateCountry(CountryWO countryWO);

	void deleteCountryById(int id);

}
