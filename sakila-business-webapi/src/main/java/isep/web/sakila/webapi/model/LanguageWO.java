package isep.web.sakila.webapi.model;

import isep.web.sakila.jpa.entities.Language;

public class LanguageWO {

	private static final long	serialVersionUID	= -1377067679473844279L;

	protected int							language_id;
	protected String					name;

	public LanguageWO()
	{
		super();
	}

	public LanguageWO(int language_id, String name)
	{
		super();
		this.language_id = language_id;
		this.name = name;
	}

	public LanguageWO(final Language language)
	{
		super();
		this.language_id = language.getLanguageId();
		this.name = language.getName();
	}

	public String getName()
	{
		return name;
	}

	public int getLanguageId()
	{
		return language_id;
	}

	public void setName(String Name)
	{
		this.name = Name;
	}

	public void setLanguageId(int language_id)
	{
		this.language_id = language_id;
	}

	@Override
	public String toString()
	{
		return "Language [id=" + this.language_id + ", Nane=" + this.name + "]";
	}
}
