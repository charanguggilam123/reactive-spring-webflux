package com.gsc.practice.domain;

import java.time.LocalDate;
import java.util.List;

public class MovieInfo {
	private String movieInfoId;

	private String name;

	private Integer year;

	private List<String> cast;
	private LocalDate releaseDate;

	public String getMovieInfoId() {
		return movieInfoId;
	}



	public void setMovieInfoId(String movieInfoId) {
		this.movieInfoId = movieInfoId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getYear() {
		return year;
	}



	public void setYear(Integer year) {
		this.year = year;
	}



	public List<String> getCast() {
		return cast;
	}



	public void setCast(List<String> cast) {
		this.cast = cast;
	}



	public LocalDate getReleaseDate() {
		return releaseDate;
	}



	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}



	@Override
	public String toString() {
		return "MovieInfo [movieInfoId=" + movieInfoId + ", name=" + name + ", year=" + year + ", cast=" + cast
				+ ", release_date=" + releaseDate + "]";
	}

}
