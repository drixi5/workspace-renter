package isep.web.sakila.webapi.model;

import java.util.Date;

import isep.web.sakila.jpa.entities.Staff;

public class StaffWO extends WebObject {

	private static final long serialVersionUID = -1377067679473844279L;

	protected int staffId;
	protected String lastName;
	protected String firstName;
	protected String email;
	protected String username;
	protected int storeId;

	public StaffWO() {
		super();
	}

	public StaffWO(int staffId, Date createDate, String lastName, String firstName, String email, String username,
			int storeId) {

		super();
		this.staffId = staffId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.username = username;
		this.storeId = storeId;

	}

	public StaffWO(final Staff staff) {

		super();
		this.staffId = staff.getStaffId();
		this.lastName = staff.getLastName();
		this.firstName = staff.getFirstName();
		this.email = staff.getEmail();
		this.username = staff.getUsername();
		this.storeId = staff.getStore().getStoreId();
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

}
