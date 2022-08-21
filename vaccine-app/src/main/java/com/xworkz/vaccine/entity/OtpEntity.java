package com.xworkz.vaccine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name = "OtpEntity.Verify", query = "from OtpEntity where otp=:otpValue ")
@Entity
@Table(name = "otpsave")
public class OtpEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "EMAILID")
	private String emailId;

	@Column(name = "OTP")
	private String otp;

	public OtpEntity() {
		System.out.println(this.getClass().getSimpleName() + " bean created");
	}

	public OtpEntity(String emailId, String otp) {
		super();
		this.emailId = emailId;
		this.otp = otp;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "OtpEntity [emailId=" + emailId + ", otp=" + otp + "]";
	}

}
