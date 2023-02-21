package com.gsc.practice.domain;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Document
public class MovieInfo {

	@Id
	private String movieInfoId;
	
	@NotBlank(message = "movie name must be present")
	private String name;
	
	@NotNull(message = "Year should be present")
	@Positive(message = "movieInfo.year must be a Positive Value")
	private Integer year;

	@NotEmpty(message = "movie cast cannot be empty.")
	private List<@NotBlank(message = "movieInfo.cast must be present") String> cast;
	
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

}
