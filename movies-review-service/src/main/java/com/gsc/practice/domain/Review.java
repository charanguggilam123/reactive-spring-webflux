package com.gsc.practice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


@Document
public class Review {
	
	@Id
    private String reviewId;
	
    @NotNull(message = "rating.movieInfoId : must not be null")
    private String movieInfoId;
    
    private String comment;
    
    @Min(value = 0L, message = "rating.negative : please pass a non-negative value")
    private Double rating;
    
	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	public String getMovieInfoId() {
		return movieInfoId;
	}
	public void setMovieInfoId(String movieInfoId) {
		this.movieInfoId = movieInfoId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Review(String reviewId, @NotNull(message = "rating.movieInfoId : must not be null") String movieInfoId,
			String comment,
			@Min(value = 0, message = "rating.negative : please pass a non-negative value") Double rating) {
		super();
		this.reviewId = reviewId;
		this.movieInfoId = movieInfoId;
		this.comment = comment;
		this.rating = rating;
	}
    
	public Review() {
		
	}
    

}
