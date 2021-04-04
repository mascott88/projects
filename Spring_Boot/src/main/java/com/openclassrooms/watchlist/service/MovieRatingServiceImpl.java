package com.openclassrooms.watchlist.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.ObjectNode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MovieRatingServiceImpl implements MovieRatingService {

	String apiUrl = "http://www.omdbapi.com/?apikey=3606d870&t=";
	Logger logger = LoggerFactory.getLogger(MovieRatingServiceImpl.class);

	@Override
	public String getMovieRating(String title) {

		try {
			RestTemplate template = new RestTemplate();

			ResponseEntity<ObjectNode> response = template.getForEntity(apiUrl + title, ObjectNode.class);

			ObjectNode jsonObject = response.getBody();

			return jsonObject.path("imdbRating").asText();
		} catch (Exception e) {
			logger.warn("Something went wront while calling OMDb API" + e.getMessage());
			return null;
		}
	}
}
