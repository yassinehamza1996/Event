package com.event.demo.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class History {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	
	@Column(name = "historyDate")
	private Date historyDate;

	@Column(name = "description")
	private String description;
	
	@Column(name = "username")
	private String username;

	public History(int id, Date historyDate, String description, String username) {
		super();
		this.historyDate = historyDate;
		this.description = description;
		this.username = username;
	}
	
	public History() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getHistoryDate() {
		return historyDate;
	}

	public void setHistoryDate(Date historyDate) {
		this.historyDate = historyDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "History [id=" + id + ", historyDate=" + historyDate + ", description=" + description + ", username="
				+ username + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, historyDate, id, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		History other = (History) obj;
		return Objects.equals(description, other.description) && Objects.equals(historyDate, other.historyDate)
				&& id == other.id && Objects.equals(username, other.username);
	}
	
	
	
	
}
