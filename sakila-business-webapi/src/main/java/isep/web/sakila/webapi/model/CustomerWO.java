package isep.web.sakila.webapi.model;

import java.util.Date;

import isep.web.sakila.jpa.entities.Customer;

//A voir pour retirer Adress et Store !!!! 

public class CustomerWO extends WebObject {

	private static final long serialVersionUID = -1377067679473844279L;

	protected int customerId;
	protected String lastName;
	protected String firstName;
	protected String email;
	protected String address;
	protected String address2;
	protected String district;
	protected String phone;
	protected String postalCode;
	protected String city;
	protected String country;
	protected int storeId;

	public CustomerWO() {
		super();
	}

	public CustomerWO(int customerId, Date createDate, String lastName, String firstName, String email, String address,
			String address2, String district, String phone, String postalCode, String city, String country, int store) {

		super();
		this.customerId = customerId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.address = address;
		this.address2 = address2;
		this.district = district;
		this.phone = phone;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
		this.storeId = store;

	}

	public CustomerWO(final Customer customer) {

		super();
		this.customerId = customer.getCustomerId();
		this.lastName = customer.getLastName();
		this.firstName = customer.getFirstName();
		this.email = customer.getEmail();
		this.address = customer.getAddress().getAddress();
		this.address2 = customer.getAddress().getAddress2();
		this.district = customer.getAddress().getDistrict();
		this.phone = customer.getAddress().getPhone();
		this.postalCode = customer.getAddress().getPostalCode();
		this.city = customer.getAddress().getCity().getCity();
		this.country = customer.getAddress().getCity().getCountry().getCountry();
		this.storeId = customer.getStore().getStoreId();
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getStore() {
		return storeId;
	}

	public void setStore(int store) {
		this.storeId = store;
	}

}
