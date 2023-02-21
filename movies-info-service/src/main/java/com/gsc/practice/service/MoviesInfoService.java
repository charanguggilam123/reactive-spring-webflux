package com.gsc.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsc.practice.domain.MovieInfo;
import com.gsc.practice.exception.DBException;
import com.gsc.practice.repo.MoviesInfoRepo;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MoviesInfoService {

	@Autowired
	private MoviesInfoRepo repo;

	public Mono<MovieInfo> addMovie(@Valid MovieInfo info) {
		return repo.save(info);
	}

	public Flux<MovieInfo> getMovies() {
		return repo.findAll();
	}

	public Mono<MovieInfo> getMovieInfoById(String id) {
		return repo.findById(id).switchIfEmpty(Mono.error(new DBException("no entity exists with provided id")));
	}

}
