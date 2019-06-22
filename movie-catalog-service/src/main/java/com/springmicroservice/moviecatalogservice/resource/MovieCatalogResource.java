package com.springmicroservice.moviecatalogservice.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.springmicroservice.moviecatalogservice.model.CatalogItem;
import com.springmicroservice.moviecatalogservice.model.Movie;
import com.springmicroservice.moviecatalogservice.model.Rating;
import com.springmicroservice.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	RestTemplate restTemplate;
	
	/*@Autowired
	WebClient.Builder webClient;
	*/
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
//		RestTemplate restTemplate = new RestTemplate();
		/*
		List<Rating> ratings = Arrays.asList(
				new Rating("101",1),
				new Rating("102",4),
				new Rating("103",5)
				);
		*/
		
UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/"+userId, UserRating.class);
		
//		UserRating userRating  = webClient.build().get().uri("ratings-data-service/users/"+userId).retrieve().bodyToMono(UserRating.class).block();
		
		System.out.println("Size of UserRating: "+userRating.getRating().size());
		
		/*return ratings.stream().map(rating ->
		Movie movie = restTemplate.getForObject("localhost:8081/movies/"+rating.getMovieId(), Movie.class);
		new CatalogItem(movie.getName(),"End Game", String.valueOf(rating.getRating()));
		).collect(Collectors.toList());
		*/
		
		List<Rating> ratings = userRating.getRating();

		List<CatalogItem> catalogItems = new ArrayList<>();
		Movie movie = null;
		for(Rating rating:ratings) {
		System.out.println("Movie id is"+rating.getMovieId());
		movie = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
		
//		movie = webClient.build().get().uri("http://movie-info-service/movies/"+rating.getMovieId()).retrieve().bodyToMono(Movie.class).block();
		
		CatalogItem catalogItem = new CatalogItem(movie.getName(),"End Game", String.valueOf(rating.getRating()));
		catalogItems.add(catalogItem);
		}
		return catalogItems;
	}
	
}
