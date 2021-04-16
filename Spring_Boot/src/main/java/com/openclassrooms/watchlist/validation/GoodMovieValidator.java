package com.openclassrooms.watchlist.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.openclassrooms.watchlist.domain.WatchlistItem;

public class GoodMovieValidator implements ConstraintValidator<GoodMovie, WatchlistItem> {

	@Override
	public boolean isValid(WatchlistItem value, ConstraintValidatorContext context) {

		try {
			Double.valueOf(value.getRating());
		} catch (NumberFormatException e) {
			return true;
		}
		return !(Double.valueOf(value.getRating()) >= 8 && "L".equals(value.getPriority()));
	}
}