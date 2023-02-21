package com.gsc.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsc.practice.domain.Review;
import com.gsc.practice.repo.ReviewRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepo repo;

	public Flux<Review> getReviews(String movieId) {
		
		return repo.findByMovieInfoId(movieId);

	}

	public Mono<Review> addReview(Review review) {

		return repo.save(review);

	}

}
