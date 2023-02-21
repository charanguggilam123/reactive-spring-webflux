package com.gsc.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsc.practice.domain.MovieInfo;
import com.gsc.practice.exception.DBException;
import com.gsc.practice.service.MoviesInfoService;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/movies")
public class MoviesController {
	
	@Autowired
	private MoviesInfoService moviesService;
	
	@PostMapping
	Mono<MovieInfo> addMovies(@RequestBody @Valid MovieInfo info){
		
		return moviesService.addMovie(info);
		
	}
	
	@GetMapping
	Flux<MovieInfo> getMovies(){
		
		return moviesService.getMovies();
		
	}
	
	@GetMapping("/{id}")
	Mono<MovieInfo> getMoviesByiD(@PathVariable String id){
		
		return moviesService.getMovieInfoById(id);
		
	}
	

	

}
