package com.springmicroservice.ratingsdataservice.resouce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmicroservice.ratingsdataservice.model.Rating;
import com.springmicroservice.ratingsdataservice.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataService {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		
		return new Rating(movieId,4);
	}
	
	@RequestMapping("users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		
		List<Rating> ratings = Arrays.asList(
				new Rating("1234", 4),
				new Rating("4545",5)); 
		UserRating userRating = new UserRating();
		userRating.setRating(ratings);
		return userRating;
	}
}
