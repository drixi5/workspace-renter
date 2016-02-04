package isep.web.sakila.webapi.service;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isep.web.sakila.dao.repositories.CityRepository;
import isep.web.sakila.jpa.entities.City;
import isep.web.sakila.webapi.model.CityWO;

@Service("CityService")
@Transactional
public class CityServiceImpl implements CityService
{
	@Autowired
	private CityRepository		CityRepository;

	private static final Log	log	= LogFactory.getLog(CityServiceImpl.class);

	public List<CityWO> findAllCities()
	{
		List<CityWO> Cities = new LinkedList<CityWO>();

		for (City City : CityRepository.findAll())
		{
			Cities.add(new CityWO(City));
			log.debug("Adding " + City);
		}

		return Cities;
	}

	public CityWO findById(int id)
	{
		log.debug(String.format("Looking for user by Id %s", id));
		City City = CityRepository.findOne(id);

		if (City != null)
		{
			return new CityWO(City);
		}
		return null;
	}

	public void saveCity(CityWO CityWO)
	{
		City City = new City();
		City.setCity(CityWO.getCity());
		City.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		CityRepository.save(City);
	}

	public void updateCity(CityWO CityWO)
	{
		City City2update = CityRepository.findOne(CityWO.getCityId());
		City2update.setCity(CityWO.getCity());
		City2update.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		CityRepository.save(City2update);
	}

	@Override
	public void deleteCityById(int id)
	{
		CityRepository.delete(id);
	}

}
