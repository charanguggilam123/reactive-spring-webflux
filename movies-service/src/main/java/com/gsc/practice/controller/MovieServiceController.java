package com.gsc.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsc.practice.client.MoviesInfoClient;
import com.gsc.practice.client.ReviewsClient;
import com.gsc.practice.domain.Movie;
import com.gsc.practice.domain.MovieInfo;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/movies")
public class MovieServiceController {

	@Autowired
	private MoviesInfoClient moviesService;

	@Autowired
	private ReviewsClient reviewsService;

	@PostMapping
	Mono<Movie> addMovies(@RequestBody @Valid MovieInfo info) {

		return Mono.empty();

	}

	@GetMapping("/{id}")
	public Mono<Movie> retrieveMovieById(@PathVariable("id") String movieId) {

		return moviesService.fetchMovieDetail(movieId).flatMap(movieInfo -> {
			System.out.println(movieInfo.toString());
			return reviewsService.fetchReviewsOfMovie(movieId).collectList().flatMap(reviews -> {
				return Mono.just(new Movie(movieInfo,reviews));
			});

		});
//	        		moviesInfoRestClient.retrieveMovieInfo(movieId)
//	                .flatMap(movieInfo -> {
//	                    var reviewsListMono = reviewsRestClient.retrieveReviews(movieId)
//	                            .collectList();
//
//	                    return reviewsListMono.map(reviews -> new Movie(movieInfo, reviews));
//	                });

	}

}
