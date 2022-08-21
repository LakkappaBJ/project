package com.xworkz.vaccine.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.vaccine.dto.OTPdto;
import com.xworkz.vaccine.service.EmailService;

@RequestMapping("/")
@Controller
public class SignInController {
	private static final Logger logger = Logger.getLogger(SignInController.class.getName());
	
	@Autowired
	private EmailService emailService;

	public SignInController() {
		logger.info(this.getClass().getSimpleName() + " bean created");
	}

	@RequestMapping(value = "/onGetOTPSave.vaccine", method = RequestMethod.POST)
	public String onGetOTPSave(@ModelAttribute OTPdto otPdto, Model model) {
		logger.info("onGetOTPSave() invoked & email-Id is " + otPdto.getEmailId());
		boolean isValidateEmail = this.emailService.validateEmail(otPdto);
		if (isValidateEmail) {
			boolean isGenerateOTP = this.emailService.generateOTP(otPdto);
			if (isGenerateOTP) {
				logger.info("otp transfer from controller to service");
				boolean isSaveOtpAndEmail = this.emailService.saveOtpAndEmail(otPdto);
				//logger.info(isSaveOtpAndEmail);
				model.addAttribute("message","OTP sent to mail");
				model.addAttribute("mailId", otPdto.getEmailId());
			} else {
				logger.info("Email and OTP not saved");
			}
		} else {
			logger.error("EMAILID IS NOT VALID");
			model.addAttribute("ErrMsg", "Email Id is invalid");
		}
		return "VerifyOTPPage";
	}
	
	@RequestMapping(value = "/verifyOTP.vaccine", method = RequestMethod.POST)
	public String verifyOTP(@RequestParam String userOTP, Model model) {
		logger.info("verifyOTP() invoked & otp is " + userOTP);
		boolean isValidateUserOTP = this.emailService.validateUserOTP(userOTP);
		if (isValidateUserOTP) {
			logger.info("valid UserOTP");
			OTPdto otPdto = this.emailService.verifyOTP(userOTP);
			if (otPdto != null) {
				logger.info("OTP verified");
				model.addAttribute("mailId", otPdto.getEmailId());
				model.addAttribute("SuccessMsg", "OTP verified successfully");
			} else {
				logger.error("OTP not verified......Entering wrong OTP!!!!");
				model.addAttribute("ErrMsg", "Entering wrong OTP.....OTP not verified!!!");
			}
		} else {
			logger.error("Invalid userOTP");
			model.addAttribute("ErrMsg","OTP is NULL/empty..please enter valid OTP");
		}
		return "VerifyOTPPage";
	}

}
