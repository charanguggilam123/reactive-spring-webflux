package com.gsc.practice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gsc.practice.domain.MovieInfo;
import com.gsc.practice.exception.MoviesInfoClientException;
import com.gsc.practice.exception.MoviesInfoServerException;

import reactor.core.publisher.Mono;

@Service
public class MoviesInfoClient {

	private static final String MOVIES_INFO_BASE_PATH = "http://localhost:8081/v1/movies";

	@Autowired
	private WebClient webClient;

	public Mono<MovieInfo> fetchMovieDetail(String movieId) {

		String url=MOVIES_INFO_BASE_PATH+"/{id}";
		return webClient.get().uri(url,movieId)
				.retrieve()
				.onStatus(HttpStatusCode::is4xxClientError, response->{
					return Mono.error(new MoviesInfoClientException(
                            "There is no MovieInfo Available for the passed in Id : " + movieId,
                            response.statusCode().value()));
					
				})
				.onStatus(HttpStatusCode::is5xxServerError, response->{
					return response.bodyToMono(ObjectNode.class)
                            .flatMap(responseMessage -> Mono.error(new MoviesInfoServerException(
                                    "Server Exception in MoviesInfoService " + responseMessage)));
					
				}).bodyToMono(MovieInfo.class);
	}

}
