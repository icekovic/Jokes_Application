package com.application.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category
{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idcategory", columnDefinition = "serial")
	private Long idCategory;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<Joke> jokes;
	
	public Category()
	{
		
	}

	public Long getIdCategory()
	{
		return idCategory;
	}

	public void setIdCategory(Long idCategory)
	{
		this.idCategory = idCategory;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Joke> getJokes()
	{
		return jokes;
	}

	public void setJokes(List<Joke> jokes)
	{
		this.jokes = jokes;
	}
}
