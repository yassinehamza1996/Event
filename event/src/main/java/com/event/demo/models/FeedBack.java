package com.event.demo.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FeedBack {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int feedbackId ;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="comment")
	private String comment;

	public FeedBack() {} 
	
	public FeedBack(int feedbackId, int rating, String comment) {
		super();
		this.rating = rating;
		this.comment = comment;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comment, feedbackId, rating);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FeedBack other = (FeedBack) obj;
		return Objects.equals(comment, other.comment) && feedbackId == other.feedbackId && rating == other.rating;
	}
	
	
	
}
