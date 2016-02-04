package isep.web.sakila.webapi.service;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isep.web.sakila.dao.repositories.CountryRepository;
import isep.web.sakila.jpa.entities.Country;
import isep.web.sakila.webapi.model.CountryWO;

@Service("countryService")
@Transactional
public class CountryServiceImpl implements CountryService
{
	@Autowired
	private CountryRepository		CountryRepository;

	private static final Log	log	= LogFactory.getLog(CountryServiceImpl.class);

	public List<CountryWO> findAllCountries()
	{
		List<CountryWO> Countries = new LinkedList<CountryWO>();

		for (Country Country : CountryRepository.findAll())
		{
			Countries.add(new CountryWO(Country));
			log.debug("Adding " + Country);
		}

		return Countries;
	}

	public CountryWO findById(int id)
	{
		log.debug(String.format("Looking for user by Id %s", id));
		Country Country = CountryRepository.findOne(id);

		if (Country != null)
		{
			return new CountryWO(Country);
		}
		return null;
	}

	public void saveCountry(CountryWO CountryWO)
	{
		Country Country = new Country();
		Country.setCountry(CountryWO.getCountry());
		Country.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		CountryRepository.save(Country);
	}

	public void updateCountry(CountryWO CountryWO)
	{
		Country Country2update = CountryRepository.findOne(CountryWO.getCountryId());
		Country2update.setCountry(CountryWO.getCountry());
		Country2update.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		CountryRepository.save(Country2update);
	}

	@Override
	public void deleteCountryById(int id)
	{
		CountryRepository.delete(id);
	}

}
