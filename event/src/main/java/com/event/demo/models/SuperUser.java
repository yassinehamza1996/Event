package com.event.demo.models;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SuperUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	

	@Column(name="cin")
	private long cin;
	
	@Column(name = "inscriptionDate")
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date inscriptionDate;

	@NotBlank(message="Please enter your first name")
	@Column(name = "firstname")
	private String firstname;
	
	@NotBlank(message="please enter your last name")
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "email",unique=true,nullable=false)	
	@Email
	private String email;
	
	@Column(name = "phoneNumber")
	@Positive
	
	private long phoneNumber;
	
	@JsonIgnore
	@OneToMany(mappedBy="superUser", cascade = {
	        CascadeType.ALL
	    })
	private Set<Evenement> events;
	
	
	public Set<Evenement> getEvents() {
		return events;
	}

	public void setEvents(Set<Evenement> events) {
		this.events = events;
	}

	public SuperUser() {}
	
	public SuperUser(long cin, Date inscriptionDate, String firstname, String lastname, String email,
			long phoneNumber) {
		super();
		this.cin = cin;
		this.inscriptionDate = inscriptionDate;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCin() {
		return cin;
	}

	public void setCin(long cin) {
		this.cin = cin;
	}

	public Date getInscriptionDate() {
		return inscriptionDate;
	}

	public void setInscriptionDate(Date inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Administrator [id=" + id + ", cin=" + cin + ", inscriptionDate=" + inscriptionDate + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cin, email, firstname, id, inscriptionDate, lastname, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuperUser other = (SuperUser) obj;
		return cin == other.cin && Objects.equals(email, other.email) && Objects.equals(firstname, other.firstname)
				&& id == other.id && Objects.equals(inscriptionDate, other.inscriptionDate)
				&& Objects.equals(lastname, other.lastname) && phoneNumber == other.phoneNumber;
	}
	
	
}
