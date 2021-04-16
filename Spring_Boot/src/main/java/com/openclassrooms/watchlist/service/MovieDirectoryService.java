package com.openclassrooms.watchlist.service;

public interface MovieDirectoryService {

	String getMovieRating(String title);

	String getMovieYear(String title);
	
	String getMovieLength(String title);

	String getMovieResponse(String title);
}