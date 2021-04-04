package com.openclassrooms.watchlist.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.openclassrooms.watchlist.validation.BadMovie;
import com.openclassrooms.watchlist.validation.GoodMovie;
import com.openclassrooms.watchlist.validation.Priority;
import com.openclassrooms.watchlist.validation.Rating;

@GoodMovie
@BadMovie
public class WatchlistItem {

	private Integer id;

	private String response;

	@NotBlank(message = "Please enter the title")
	private String title;

	@Rating
	private String rating;

	private String year;

	private String length;

	@Priority
	private String priority;

	@Size(max = 50, message = "Comment should be maximum 50 characters")
	private String comment;

	public static int index = 0;

	public WatchlistItem() {
		this.id = index++;
	}

	public WatchlistItem(String title, String rating, String priority, String comment, String year, String length,
			String response) {
		super();
		this.id = index++;
		this.response = response;
		this.title = title;
		this.length = length;
		this.rating = rating;
		this.priority = priority;
		this.year = year;
		this.comment = comment;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getYear() {
		return year;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority.toUpperCase();
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}