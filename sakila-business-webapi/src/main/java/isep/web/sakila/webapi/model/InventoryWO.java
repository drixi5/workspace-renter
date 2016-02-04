package isep.web.sakila.webapi.model;

import java.util.Date;

import isep.web.sakila.jpa.entities.Inventory;

public class InventoryWO extends WebObject {

	private static final long serialVersionUID = -1377067679473844279L;

	protected int filmId;
	protected int inventoryId;
	protected String title;
	protected Date releaseYear;

	public InventoryWO() {
		super();
	}

	public InventoryWO(int filmId, int inventoryId, String title, String description, int length, Date releaseYear,
			String language1) {
		super();
		this.filmId = filmId;
		this.inventoryId = inventoryId;
		this.title = title;
		this.releaseYear = releaseYear;
	}

	public InventoryWO(final Inventory inventory) {
		super();
		this.inventoryId = inventory.getInventoryId();
		this.filmId = inventory.getFilm().getFilmId();
		this.title = inventory.getFilm().getTitle();
		this.releaseYear = inventory.getFilm().getReleaseYear();
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

}
