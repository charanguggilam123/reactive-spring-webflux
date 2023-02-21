package com.gsc.practice.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.gsc.practice.domain.Review;

import reactor.core.publisher.Flux;

@Repository
public interface ReviewRepo extends ReactiveMongoRepository<Review, String> {
	
	Flux<Review> findByMovieInfoId(String movieInfoId);

}
