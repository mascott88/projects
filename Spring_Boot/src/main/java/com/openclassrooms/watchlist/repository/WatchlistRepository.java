package com.openclassrooms.watchlist.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.openclassrooms.watchlist.domain.WatchlistItem;

@Service
public class WatchlistRepository {
	private List<WatchlistItem> watchlistItems = new ArrayList<WatchlistItem>();
	private static int index = 1;

	public List<WatchlistItem> getList() {
		return watchlistItems;
	}

	public void addItem(WatchlistItem watchlistItem) {
		watchlistItem.setId(index++);
		watchlistItems.add(watchlistItem);
	}

	public WatchlistItem findById(Integer id) {
		for (WatchlistItem watchlistItem : watchlistItems) {
			if (watchlistItem.getId().equals(id)) {
				return watchlistItem;
			}
		}
		return null;
	}

	public WatchlistItem findByTitle(String title) {
		for (WatchlistItem watchlistItem : watchlistItems) {
			if (watchlistItem.getTitle().equalsIgnoreCase(title)) {
				return watchlistItem;
			}
		}
		return null;
	}

	public void removeWatchlistItemById(Integer id) {
		for (Iterator<WatchlistItem> x = watchlistItems.iterator(); x.hasNext();) {
			WatchlistItem integer = x.next();
			if (integer.getId() == id) {
				x.remove();
			}
		}
	}
}