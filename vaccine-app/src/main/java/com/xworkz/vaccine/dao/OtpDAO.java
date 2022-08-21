package com.xworkz.vaccine.dao;

import com.xworkz.vaccine.entity.OtpEntity;

public interface OtpDAO {

	//boolean saveOtp(String text);

	boolean saveOtp(OtpEntity otpEntity);
	
	OtpEntity verifYOTP(String userOTP);
	

}
