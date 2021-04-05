package com.openclassrooms.watchlist.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.openclassrooms.watchlist.service.MovieDirectoryService;

@Component
public class HealthCheck implements HealthIndicator {

	@Autowired
	MovieDirectoryService movieDirectoryService;

	@Override
	public Health health() {

		if (movieDirectoryService.getMovieRating("Up") == null) {
			return Health.down().withDetail("Cause", "OMDb API is not available").build();
		}

		return Health.up().build();
	}
}