package com.xworkz.vaccine.service;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.xworkz.otp.OtpGenerator;
import com.xworkz.vaccine.dao.OtpDAO;
import com.xworkz.vaccine.dao.OtpDAOImpl;
import com.xworkz.vaccine.dto.OTPdto;
import com.xworkz.vaccine.entity.OtpEntity;

@Service
public class EmailServiceImpl implements EmailService {
	private static final Logger logger = Logger.getLogger(EmailServiceImpl.class.getName());
	@Autowired
	private OtpDAO otpDAO;

	@Autowired
	private JavaMailSender javaMailSender;

	public EmailServiceImpl() {
		logger.info(this.getClass().getSimpleName() + " bean created");
	}

	SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

//	@Override
//	public boolean generateOTP(String emailId) {
//		boolean flag = false;
//		try {
//			simpleMailMessage.setTo(emailId);
//			simpleMailMessage.setFrom("lakkappabj007@outlook.com");
//			simpleMailMessage.setSubject("OTP Generate");
//			simpleMailMessage.setText(OtpCreate.generateOTP(6));
//			logger.info(simpleMailMessage.getText() + " is created");
//			this.javaMailSender.send(simpleMailMessage);
//			logger.info("mail sent successfully");
//			flag = true;
//			return flag;
//		} catch (Exception e) {
//			logger.error(e.getMessage().getClass());
//			e.printStackTrace();
//		}
//		return flag;
//	}

//	@Override
//	public void saveOtp(String otp) {
//		// TODO Auto-generated method stub
//		logger.info("entering saveOtp()");
//		this.otpDAO.saveOtp(simpleMailMessage.getText());
//	}

	@Override
	public boolean validateEmail(OTPdto otPdto) {
		boolean flag = false;
		if (!otPdto.getEmailId().isEmpty() && otPdto.getEmailId() != null) {
			logger.info("email_Id is valid");
			flag = true;
		} else {
			flag = false;
			logger.error(" email_id is invalid");
			return flag;
		}
		return flag;
	}

	@Override
	public boolean generateOTP(OTPdto otPdto) {
		boolean flag = false;
		try {
			simpleMailMessage.setTo(otPdto.getEmailId());
			simpleMailMessage.setFrom("lakkappabj007@outlook.com");
			simpleMailMessage.setSubject("OTP Generate");
			simpleMailMessage.setText(OtpGenerator.generateOTP(6));
			logger.info(simpleMailMessage.getText() + " OTP is created");
			this.javaMailSender.send(simpleMailMessage);
			logger.info("mail sent successfully");
			flag = true;
			return flag;
		} catch (Exception e) {
			logger.error(e.getMessage().getClass());
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public boolean saveOtpAndEmail(OTPdto otPdto) {
		logger.info(otPdto);
		logger.info("entering saveOtpAndEmail()");
		boolean isSaveOtpAndEmail = false;
		otPdto.setOtp(simpleMailMessage.getText());
		OtpEntity otpEntity = new OtpEntity();
		BeanUtils.copyProperties(otPdto, otpEntity);
		logger.info("all otPdto properties copied to otpEntity-> " + otpEntity);
		isSaveOtpAndEmail = this.otpDAO.saveOtp(otpEntity);
		return isSaveOtpAndEmail;
	}

	/*
	@Override
	public OTPdto verifyOTP(String userOTP) {
		OTPdto otPdto = null;
		try {
			if (userOTP != null && !userOTP.isEmpty()) {
				logger.info("Validating.....");
				// flag = true;
				OtpEntity otpEntity = this.otpDAO.verifYOTP(userOTP);
				if (otpEntity != null) {
					otPdto = new OTPdto();
					BeanUtils.copyProperties(otpEntity, otPdto);
					logger.info("all otpEntity properties copied to OTPdto");
					logger.info(" OTP is " + otPdto.getOtp());
					if (userOTP.equals(otPdto.getOtp()) && otPdto.getOtp()!=null) {
						logger.info("otp is Verified");
					} else {
						logger.info("otp is not Verified");
					}
				} else {
					logger.info("verifYOTP is null...cannot copying");
				}
			} else {
				logger.error("otp is not valid");
			}
		} catch (Exception e) {
			logger.error(e.getMessage().getClass());
			e.printStackTrace();
		}
		//logger.info(otPdto + "---->");
		return otPdto;
	}
	*/
	@Override
	public boolean validateUserOTP(String userOTP) {
		boolean flag=false;
		if (userOTP != null && !userOTP.isEmpty()) {
			logger.info("Validating.....");
			logger.info("userOTP is valid");
			flag=true;
		}else {
			flag=false;
			logger.error("userOTP is null/empty");
		}
		return flag;
	}
	
	@Override
	public OTPdto verifyOTP(String userOTP) {
		OTPdto otPdto=null;
		OtpEntity otpEntity=null;
		try {
			otpEntity = this.otpDAO.verifYOTP(userOTP);
			logger.info(otpEntity);
			if (otpEntity != null) {
				otPdto = new OTPdto();
				BeanUtils.copyProperties(otpEntity, otPdto);
				logger.info("all otpEntity properties copied to OTPdto");
				logger.info(otPdto);
				logger.info(" OTP is " + otPdto.getOtp());
				/*
				 * if (userOTP.equals(otPdto.getOtp()) && otPdto.getOtp()!=null) {
				 * 		logger.info("otp is Verified"); 
				 * } else { 
				 * 		logger.info("otp is not Verified");
				 * }
				 */
			} else {
				logger.error("OTP is NULL");
			}
		} catch (Exception e) {
			logger.error(e.getMessage().getClass());
			e.printStackTrace();
		}

		return otPdto;
	}

	
}
