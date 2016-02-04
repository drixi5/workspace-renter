package isep.web.sakila.webapi.model;

import isep.web.sakila.jpa.entities.Address;

public class AddressWO extends WebObject {

	private static final long serialVersionUID = -1377067679473844279L;

	protected int addressId;
	protected String address;
	protected String address2;
	protected String district;
	protected String phone;
	protected String postalCode;

	public AddressWO() {
		super();
	}

	public AddressWO(int addressId, String address, String address2, String district, String phone, String postalCode) {
		super();
		this.addressId = addressId;
		this.address = address;
		this.address2 = address2;
		this.district = district;
		this.phone = phone;
		this.postalCode = postalCode;
	}

	public AddressWO(final Address address) {
		super();
		this.addressId = address.getAddressId();
		this.address = address.getAddress();
		this.address2 = address.getAddress2();
		this.district = address.getDistrict();
		this.phone = address.getPhone();
		this.postalCode = address.getPostalCode();
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
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

}
