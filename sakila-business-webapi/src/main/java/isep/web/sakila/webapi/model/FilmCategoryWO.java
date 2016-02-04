package isep.web.sakila.webapi.model;

import isep.web.sakila.jpa.entities.FilmCategory;

public class FilmCategoryWO extends WebObject {

	private static final long serialVersionUID = -1377067679473844279L;

	protected int filmId;
	protected int categoryId;
	protected String category;

	public FilmCategoryWO() {
		super();
	}

	public FilmCategoryWO(int filmId, int categoryId, String category) {
		super();
		this.filmId = filmId;
		this.categoryId = categoryId;
		this.category = category;

	}

	public FilmCategoryWO(final FilmCategory filmCategory) {
		super();
		this.filmId = filmCategory.getFilm().getFilmId();
		this.categoryId = filmCategory.getCategory().getCategoryId();
		this.category = filmCategory.getCategory().getName();
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
