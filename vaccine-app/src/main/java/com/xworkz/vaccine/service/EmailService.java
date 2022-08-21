package com.xworkz.vaccine.service;

import com.xworkz.vaccine.dto.OTPdto;

public interface EmailService {

	//boolean validateEmail(String emailId);
	//boolean generateOTP(String emailId);
	//void saveOtp(String otp);
	OTPdto verifyOTP(String userOTP);
	boolean validateUserOTP(String userOTP);
	
	
	boolean generateOTP(OTPdto otPdto);
	boolean saveOtpAndEmail(OTPdto otPdto);
	boolean validateEmail(OTPdto otPdto);
	
}
