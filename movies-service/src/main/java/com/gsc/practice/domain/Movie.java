package com.gsc.practice.domain;


import java.util.List;


public class Movie {

    private MovieInfo movieInfo;
    private List<Review> reviewsList;
	public MovieInfo getMovieInfo() {
		return movieInfo;
	}
	public void setMovieInfo(MovieInfo movieInfo) {
		this.movieInfo = movieInfo;
	}
	public List<Review> getReviewList() {
		return reviewsList;
	}
	public void setReviewList(List<Review> reviewsList) {
		this.reviewsList = reviewsList;
	}
	public Movie(MovieInfo movieInfo, List<Review> reviewsList) {
		super();
		this.movieInfo = movieInfo;
		this.reviewsList = reviewsList;
	}
    
	public Movie() {
		super();
	}
    
}
