package com.event.demo.models;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.event.demo.enumerations.InscriptionStatus;
import com.event.demo.enumerations.PresenceStatus;

@Entity
public class Guest {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Id
	@Column(name="cin")
	private long cin;
	
	@Column(name = "inscriptionDate")
	private Date inscriptionDate;

	@Column(name = "firstname")
	private String firstname;


	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phoneNumber")
	private long phoneNumber;
	
	@Column(name = "QrCode")
	@Lob
	private byte[] QrCode;
	
	@Column(name = "inscriptionStatus")
	private InscriptionStatus inscriptionStatus;
	
	@Column(name = "presenceStatus")
	private PresenceStatus presenceStatus;
	
	@Column(name="securityCode")
	public String securityCode;

	public Guest() {}
	
	public Guest(long cin, Date inscriptionDate, String firstname, String lastname, String email, long phoneNumber,
			byte[] qrCode, InscriptionStatus inscriptionStatus, PresenceStatus presenceStatus, String securityCode) {
		super();
		this.cin = cin;
		this.inscriptionDate = inscriptionDate;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		QrCode = qrCode;
		this.inscriptionStatus = inscriptionStatus;
		this.presenceStatus = presenceStatus;
		this.securityCode = securityCode;
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

	public byte[] getQrCode() {
		return QrCode;
	}

	public void setQrCode(byte[] qrCode) {
		QrCode = qrCode;
	}

	public InscriptionStatus getInscriptionStatus() {
		return inscriptionStatus;
	}

	public void setInscriptionStatus(InscriptionStatus inscriptionStatus) {
		this.inscriptionStatus = inscriptionStatus;
	}

	public PresenceStatus getPresenceStatus() {
		return presenceStatus;
	}

	public void setPresenceStatus(PresenceStatus presenceStatus) {
		this.presenceStatus = presenceStatus;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	@Override
	public String toString() {
		return "Guest [id=" + id + ", cin=" + cin + ", inscriptionDate=" + inscriptionDate + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + ", phoneNumber=" + phoneNumber + ", QrCode="
				+ Arrays.toString(QrCode) + ", inscriptionStatus=" + inscriptionStatus + ", presenceStatus="
				+ presenceStatus + ", securityCode=" + securityCode + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(QrCode);
		result = prime * result + Objects.hash(cin, email, firstname, id, inscriptionDate, inscriptionStatus, lastname,
				phoneNumber, presenceStatus, securityCode);
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
		Guest other = (Guest) obj;
		return Arrays.equals(QrCode, other.QrCode) && cin == other.cin && Objects.equals(email, other.email)
				&& Objects.equals(firstname, other.firstname) && id == other.id
				&& Objects.equals(inscriptionDate, other.inscriptionDate)
				&& inscriptionStatus == other.inscriptionStatus && Objects.equals(lastname, other.lastname)
				&& phoneNumber == other.phoneNumber && presenceStatus == other.presenceStatus
				&& Objects.equals(securityCode, other.securityCode);
	}
	
	
	
}
