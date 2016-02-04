package isep.web.sakila.webapi.model;

import isep.web.sakila.jpa.entities.City;

public class CityWO extends WebObject {

	private static final long serialVersionUID = -1377067679473844279L;

	protected int cityId;
	protected String city;

	public CityWO() {
		super();
	}

	public CityWO(int cityId, String city) {

		super();
		this.cityId = cityId;
		this.city = city;

	}

	public CityWO(final City city) {

		super();
		this.cityId = city.getCityId();
		this.city = city.getCity();
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
