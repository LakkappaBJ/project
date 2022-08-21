package com.xworkz.vaccine.dto;

/**
 * @author Lakkappa 
 *
 */
public class OTPdto {
	private String otp;
	private String emailId;

	public OTPdto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OTPdto(String otp, String emailId) {
		super();
		this.otp = otp;
		this.emailId = emailId;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "OTPdto [otp=" + otp + ", emailId=" + emailId + "]";
	}

}
