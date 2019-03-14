package com.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.application.entities.Joke;

public interface JokeRepository extends JpaRepository<Joke, Long>
{

}
