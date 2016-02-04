package isep.web.sakila.webapi.model;

import java.math.BigDecimal;
import java.util.Date;

import isep.web.sakila.jpa.entities.Film;

public class FilmWO extends WebObject {

	private static final long serialVersionUID = -1377067679473844279L;

	protected int filmId;
	protected String description;
	protected int length;
	protected Date releaseYear;
	protected byte rentalDuration;
	protected BigDecimal rentalRate;
	protected BigDecimal replacementCost;
	protected String specialFeatures;
	protected String title;
	protected String language1;
	protected String language2;

	public FilmWO() {
		super();
	}

	public FilmWO(int filmId, String description, int length, Date releaseYear, byte rentalDuration,
			BigDecimal rentalRate, BigDecimal replacementCost, String specialFeatures, String title, String language1,
			String language2)

	{
		super();
		this.filmId = filmId;
		this.description = description;
		this.length = length;
		this.releaseYear = releaseYear;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.replacementCost = replacementCost;
		this.specialFeatures = specialFeatures;
		this.title = title;
		this.language1 = language1;
		this.language2 = language2;

	}

	public FilmWO(final Film film) {

		super();
		this.filmId = film.getFilmId();
		this.description = film.getDescription();
		this.length = film.getLength();
		this.releaseYear = film.getReleaseYear();
		this.rentalDuration = film.getRentalDuration();
		this.rentalRate = film.getRentalRate();
		this.replacementCost = film.getReplacementCost();
		this.title = film.getTitle();
		this.language1 = film.getLanguage1().getName();
		if (film.getLanguage2() != null) {
			this.language2 = film.getLanguage2().getName();
		}

	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Date getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

	public byte getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(byte rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public BigDecimal getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(BigDecimal rentalRate) {
		this.rentalRate = rentalRate;
	}

	public BigDecimal getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(BigDecimal replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLanguage1() {
		return language1;
	}

	public void setLanguage1(String language1) {
		this.language1 = language1;
	}

	public String getLanguage2() {
		return language2;
	}

	public void setLanguage2(String language2) {
		this.language2 = language2;
	}

}
