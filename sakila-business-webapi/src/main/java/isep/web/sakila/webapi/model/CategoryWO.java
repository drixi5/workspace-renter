package isep.web.sakila.webapi.model;

import isep.web.sakila.jpa.entities.Category;
import isep.web.sakila.jpa.entities.Language;

public class CategoryWO {
	
	private static final long	serialVersionUID	= -1377067679473844279L;

	protected int							categoryId;
	protected String					name;

	public CategoryWO()
	{
		super();
	}
	
	public CategoryWO(int categoryId, String name)
	{
		super();
		this.categoryId = categoryId;
		this.name = name;
	}

	public CategoryWO(final Category category)
	{
		super();
		this.categoryId = category.getCategoryId();
		this.name = category.getName();
	}

	public String getName()
	{
		return name;
	}

	public int getCategoryId()
	{
		return categoryId;
	}

	public void setName(String Name)
	{
		this.name = Name;
	}

	public void setCategoryId(int categoryId)
	{
		this.categoryId = categoryId;
	}

	@Override
	public String toString()
	{
		return "Language [id=" + this.categoryId + ", Nane=" + this.name + "]";
	}
}
