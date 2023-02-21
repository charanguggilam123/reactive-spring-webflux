package com.gsc.practice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gsc.practice.domain.Review;
import com.gsc.practice.exception.ReviewsClientException;
import com.gsc.practice.exception.ReviewsServerException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReviewsClient {
	
	private static final String REVIEWS_SERVICE_BASE_PATH="http://localhost:8082/v1/reviews";
	
	@Autowired
	private WebClient webClient;
	
	
	public Flux<Review> fetchReviewsOfMovie(String movieId){
		String url=REVIEWS_SERVICE_BASE_PATH+"/{id}";
		return webClient.get().uri(url,movieId)
				.retrieve()
				.onStatus(HttpStatusCode::is4xxClientError, clientResponse->{
					 if(clientResponse.statusCode().equals(HttpStatus.NOT_FOUND)){
	                        return Mono.empty();
	                    }

	                    return clientResponse.bodyToMono(String.class)
	                            .flatMap(responseMessage -> Mono.error(new ReviewsClientException(
	                                    responseMessage)));
					
				})
				.onStatus(HttpStatusCode::is5xxServerError, response->{
					return response.bodyToMono(ObjectNode.class)
                            .flatMap(responseMessage -> Mono.error(new ReviewsServerException(
                                    "Server Exception in MoviesInfoService " + responseMessage)));
					
				})
				.bodyToFlux(Review.class);
	}

}
