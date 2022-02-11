package com.event.demo.models;


import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;



@Entity
@Table
public class Evenement {

	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
		
	@Id
	@Column(name="eventCode")
	private int eventCode;
	
	@Column(name = "startDate")
	private Date startDate;

	@Column(name = "endDate")
	private Date endDate;

	@Column(name = "logo")
	@Lob
	private byte[] logo;


	@Column(name = "title")
	private String title;

	@Column(name="latitude")
	private double latitude;
	
	@Column(name="longitude")
	private double longitude;
	
	@Column(name="status")
	private String status;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="superUser")
    @OnDelete(action = OnDeleteAction.CASCADE)
	private SuperUser superUser;
	
	
	
	public int getEventCode() {
		return eventCode;
	}

	public void setEventCode(int eventCode) {
		this.eventCode = eventCode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public SuperUser getAdmin() {
		return superUser;
	}

	public void setSuperUser(SuperUser superUser) {
		this.superUser = superUser;
	}

	@Override
	public String toString() {
		return "Evenement [id=" + id + ", eventCode=" + eventCode + ", startDate=" + startDate + ", endDate="
				+ endDate + ", logo=" + Arrays.toString(logo)  + ", title=" + title + ", latitude="
				+ latitude + ", longitude=" + longitude + ", status=" + status + "]";
	}

	public Evenement() {}
	
	public Evenement(int eventCode, Date startDate, Date endDate, byte[] logo, String title,
			double latitude, double longitude, String status) {
		super();
		this.eventCode = eventCode;
		this.startDate = startDate;
		this.endDate = endDate;
		this.logo = logo;

		this.title = title;
		this.latitude = latitude;
		this.longitude = longitude;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int geteventCode() {
		return eventCode;
	}

	public void seteventCode(int eventCode) {
		this.eventCode = eventCode;
	}

	public Date getstartDate() {
		return startDate;
	}

	public void setstartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getendDate() {
		return endDate;
	}

	public void setendDate(Date endDate) {
		this.endDate = endDate;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(logo);
		result = prime * result + Objects.hash(endDate, eventCode, id, latitude, longitude, startDate, status, title);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evenement other = (Evenement) obj;
		return Objects.equals(endDate, other.endDate) && Objects.equals(eventCode, other.eventCode) && id == other.id
				&& Double.doubleToLongBits(latitude) == Double.doubleToLongBits(other.latitude)
				&& Arrays.equals(logo, other.logo)
				&& Double.doubleToLongBits(longitude) == Double.doubleToLongBits(other.longitude)
				&& Objects.equals(startDate, other.startDate) && Objects.equals(status, other.status)
				&& Objects.equals(title, other.title);
	}
	
	

}

