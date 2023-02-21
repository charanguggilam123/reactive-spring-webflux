package com.gsc.practice.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.gsc.practice.domain.MovieInfo;

@Repository
public interface MoviesInfoRepo extends ReactiveMongoRepository<MovieInfo, String> {

}
