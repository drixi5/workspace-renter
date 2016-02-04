package isep.web.sakila.webapi.model;

import java.util.Date;

import isep.web.sakila.jpa.entities.Rental;

public class RentalWO extends WebObject {

	private static final long serialVersionUID = -1377067679473844279L;

	protected int rentalId;
	protected Date rentalDate;
	protected Date returnDate;
	protected int customerId;
	protected String customerFirstName;
	protected String customerLastName;
	protected int inventoryId;
	protected String inventoryFilmTitle;
	protected int staffId;

	public RentalWO() {
		super();
	}

	public RentalWO(int rentalId, Date rentalDate, Date returnDate, int customerId, String customerFirstName,
			String customerLastName, int inventoryId, String inventoryFilmTitle, int staffId) {
		this.rentalId = rentalId;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
		this.customerId = customerId;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.inventoryId = inventoryId;
		this.inventoryFilmTitle = inventoryFilmTitle;
		this.staffId = staffId;
	}

	public RentalWO(final Rental rental) {
		this.rentalId = rental.getRentalId();
		this.rentalDate = rental.getRentalDate();
		this.returnDate = rental.getReturnDate();
		this.customerId = rental.getCustomer().getCustomerId();
		this.customerFirstName = rental.getCustomer().getFirstName();
		this.customerLastName = rental.getCustomer().getLastName();
		this.inventoryId = rental.getInventory().getInventoryId();
		this.inventoryFilmTitle = rental.getInventory().getFilm().getTitle();
		this.staffId = rental.getStaff().getStaffId();
	}

	public int getRentalId() {
		return rentalId;
	}

	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getInventoryFilmTitle() {
		return inventoryFilmTitle;
	}

	public void setInventoryFilmTitle(String inventoryFilmTitle) {
		this.inventoryFilmTitle = inventoryFilmTitle;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

}
