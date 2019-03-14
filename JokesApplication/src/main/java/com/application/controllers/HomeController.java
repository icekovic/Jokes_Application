package com.application.controllers;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.application.dao.CategoryRepository;
import com.application.dao.JokeRepository;
import com.application.entities.Category;
import com.application.entities.Joke;

@Controller
public class HomeController
{
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private JokeRepository jokeRepository;
	
	private List<Category> categories;
	private Joke likedDislikedJoke;
	
	@GetMapping(value = "/")
	public String home(Model model)
	{
		categories = categoryRepository.findAll();		
		model.addAttribute("categories", categories);	
		
		return "home";
	}
	
	@GetMapping(value = "/like")
	public String like()
	{
		return "home";
	}
	
	@PostMapping(value = "/like")
	public String like(HttpServletRequest request, Model model)
	{
		Long idJoke = Long.parseLong(request.getParameter("idJoke"));
		likedDislikedJoke = GetJokeById(idJoke);
		likedDislikedJoke.incrementLikes();
		likedDislikedJoke.calculateRazlika();
		jokeRepository.save(likedDislikedJoke);
		categories = categoryRepository.findAll();
		model.addAttribute("categories", categories);
		
		return "home";
	}
	
	@GetMapping(value = "/dislike")
	public String dislike()
	{
		return "home";
	}
	
	@PostMapping(value = "/dislike")
	public String dislike(HttpServletRequest request, Model model)
	{
		Long idJoke = Long.parseLong(request.getParameter("idJoke"));
		likedDislikedJoke = GetJokeById(idJoke);
		likedDislikedJoke.incrementDislikes();
		likedDislikedJoke.calculateRazlika();
		jokeRepository.save(likedDislikedJoke);
		categories = categoryRepository.findAll();
		model.addAttribute("categories", categories);
		
		return "home";
	}
	
	@GetMapping(value = "/new")
	public String newJoke(Model model)
	{		
		return "newJoke";
	}
	
	@PostMapping(value = "/new")
	public String newJoke(HttpServletRequest request, Model model)
	{
		categories = categoryRepository.findAll();		
		model.addAttribute("categories", categories);
		
		return "newJoke";
	}
	
	@GetMapping(value = "/create-new")
	public String createNewJoke()
	{
		return "home";
	}
	
	@PostMapping(value = "/create-new")
	public String createNewJoke(HttpServletRequest request, Model model)
	{
		String selectedCategory = request.getParameter("category");
		String content = request.getParameter("content");
		
		categories = categoryRepository.findAll();
		CreateNewJoke(selectedCategory, content);
		
		model.addAttribute("categories", categories);
		return "home";
	}

	private Joke GetJokeById(Long idJoke)
	{
		Optional<Joke> optionalJoke = jokeRepository.findById(idJoke);
		Joke joke = optionalJoke.get();
		
		return joke;
	}
	
	private Category GetCategoryByName(String selectedCategory)
	{
		Optional<Category> category = categoryRepository.findByName(selectedCategory);
		Category cat = category.get();
		
		return cat;
	}
	
	private void CreateNewJoke(String selectedCategory, String content)
	{
		Category category = GetCategoryByName(selectedCategory);
		
		Joke newJoke = new Joke();
		newJoke.setContent(content);
		newJoke.setLikes(0);
		newJoke.setDislikes(0);
		newJoke.setRazlika(0);
		newJoke.setCategory(category);
		
		jokeRepository.save(newJoke);
	}
}
