package com.springmicroservice.movieinfoservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmicroservice.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResources {

	@RequestMapping("/{movieId}")
	public Movie getInfo(@PathVariable("movieId") String movieId) {
		
		return new Movie(movieId, "Avengers");
	}
}
