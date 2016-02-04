package isep.web.sakila.webapi.model;

import isep.web.sakila.jpa.entities.FilmActor;

public class FilmActorWO extends WebObject {

	private static final long serialVersionUID = -1377067679473844279L;

	protected int filmId;
	protected int actorId;
	protected String actorFirstName;
	protected String actorLastName;

	public FilmActorWO() {
		super();
	}

	public FilmActorWO(int filmId, int actorId, String actorFirstName, String actorLastName) {
		super();
		this.filmId = filmId;
		this.actorId = actorId;
		this.actorFirstName = actorFirstName;
		this.actorLastName = actorLastName;

	}

	public FilmActorWO(final FilmActor filmActor) {
		super();
		this.filmId = filmActor.getFilm().getFilmId();
		this.actorId = filmActor.getActor().getActorId();
		this.actorFirstName = filmActor.getActor().getFirstName();
		this.actorLastName = filmActor.getActor().getLastName();
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getActorFirstName() {
		return actorFirstName;
	}

	public void setActorFirstName(String actorFirstName) {
		this.actorFirstName = actorFirstName;
	}

	public String getActorLastName() {
		return actorLastName;
	}

	public void setActorLastName(String actorLastName) {
		this.actorLastName = actorLastName;
	}

}
