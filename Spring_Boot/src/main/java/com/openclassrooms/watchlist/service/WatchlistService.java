package com.openclassrooms.watchlist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.openclassrooms.watchlist.domain.WatchlistItem;
import com.openclassrooms.watchlist.exception.DuplicateTitleException;
import com.openclassrooms.watchlist.exception.MovieNotFoundException;
import com.openclassrooms.watchlist.repository.WatchlistRepository;

@Service
public class WatchlistService {

	WatchlistRepository watchlistRepository = new WatchlistRepository();
	private MovieDirectoryService movieDirectoryService = new MovieDirectoryServiceImpl();

	public List<WatchlistItem> getWatchlistItems() {

		List<WatchlistItem> watchlistItems = watchlistRepository.getList();
		for (WatchlistItem watchlistItem : watchlistItems) {
			String rating = movieDirectoryService.getMovieRating(watchlistItem.getTitle());
			if (rating != null) {
				watchlistItem.setRating(rating);
			}
			String year = movieDirectoryService.getMovieYear(watchlistItem.getTitle());
			if (year != null) {
				watchlistItem.setYear(year);
			}
			String length = movieDirectoryService.getMovieLength(watchlistItem.getTitle());
			if (length != null) {
				watchlistItem.setLength(length);
			}
			String response = movieDirectoryService.getMovieResponse(watchlistItem.getTitle());
			if (response != null) {
				watchlistItem.setResponse(response);
			}
		}
		return watchlistItems;
	}

	public int getWatchlistItemsSize() {
		return watchlistRepository.getList().size();
	}

	public WatchlistItem findWatchlistItemById(Integer id) {
		return watchlistRepository.findById(id);
	}

	public void removeWatchlistItem(WatchlistItem watchlistItem) {
		watchlistRepository.removeWatchlistItemById(watchlistItem.getId());
	}

	public void addOrUpdateWatchlistItem(WatchlistItem watchlistItem)
			throws DuplicateTitleException, MovieNotFoundException {

		WatchlistItem existingItem = findWatchlistItemById(watchlistItem.getId());
		watchlistItem.setResponse(movieDirectoryService.getMovieResponse(watchlistItem.getTitle()));

		if (existingItem == null) {
			if (watchlistRepository.findByTitle(watchlistItem.getTitle()) != null) {
				throw new DuplicateTitleException();
			}
			if (!watchlistItem.getResponse().equals(null) && watchlistItem.getResponse().equals("Movie not found!")) {
				throw new MovieNotFoundException();
			} else {
				watchlistRepository.addItem(watchlistItem);
			}
		} else {
			if (watchlistItem.getResponse().equals("Movie not found!")) {
				throw new MovieNotFoundException();
			}
			existingItem.setComment(watchlistItem.getComment());
			existingItem.setPriority(watchlistItem.getPriority());
			existingItem.setRating(watchlistItem.getRating());
			existingItem.setTitle(watchlistItem.getTitle());
			existingItem.setYear(watchlistItem.getYear());
			existingItem.setResponse(watchlistItem.getResponse());
		}
	}
}