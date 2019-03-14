package com.application.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "joke")
public class Joke
{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idjoke", columnDefinition = "serial")
	private Long idJoke;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "likes")
	private int likes;
	
	@Column(name = "dislikes")
	private int dislikes;
	
	@Column(name = "razlika")
	private int razlika;
	
	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;
	
	public Joke()
	{
		
	}

	public Long getIdJoke()
	{
		return idJoke;
	}

	public void setIdJoke(Long idJoke)
	{
		this.idJoke = idJoke;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public int getLikes()
	{
		return likes;
	}

	public void setLikes(int likes)
	{
		this.likes = likes;
	}
	
	public void incrementLikes()
	{
		this.likes = this.likes + 1;
	}

	public int getDislikes()
	{
		return dislikes;
	}

	public void setDislikes(int dislikes)
	{
		this.dislikes = dislikes;
	}
	
	public void incrementDislikes()
	{
		this.dislikes = this.dislikes + 1;
	}
	
	public void calculateRazlika()
	{
		this.razlika = Math.abs(this.likes - this.dislikes);
	}

	public void setRazlika(int razlika)
	{
		this.razlika = razlika;
	}
	
	public int getRazlika()
	{
		return razlika;
	}

	public Category getCategory()
	{
		return category;
	}

	public void setCategory(Category category)
	{
		this.category = category;
	}
}
