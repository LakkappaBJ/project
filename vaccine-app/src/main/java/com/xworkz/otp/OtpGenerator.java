package com.xworkz.otp;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;


@Component
public class OtpGenerator {

	private static final Logger logger = Logger.getLogger(OtpGenerator.class.getName());
	
	public static String getOtp="";
	public static String generateOTP(int otpLength) {
		String numbers="1234567890";
		Random random = new Random();
		for (int i = 0; i < otpLength; i++) {
			getOtp=getOtp+numbers.charAt(random.nextInt(numbers.length()));
		}
		logger.info("OTP Generated at OtpGenerator class "+getOtp);
		return getOtp;
	}
}
