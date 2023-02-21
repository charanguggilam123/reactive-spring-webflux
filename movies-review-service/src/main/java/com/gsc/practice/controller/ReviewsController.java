package com.gsc.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsc.practice.domain.Review;
import com.gsc.practice.exception.NoReviewsFoundException;
import com.gsc.practice.service.ReviewService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/reviews")
public class ReviewsController {
	
	@Autowired
	private ReviewService reviewService;
	
	@PostMapping
	public Mono<Review> addReview(@RequestBody Review review){
		System.out.println("*****8");
//		return Mono.empty();
		return reviewService.addReview(review);
		
	}
	
	
	@GetMapping("/{id}")
	public Flux<Review> getReviews(@PathVariable("id") String movieId){
		
		return reviewService.getReviews(movieId).switchIfEmpty(Mono.error(new NoReviewsFoundException(movieId)));
		
	}

}
