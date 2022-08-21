package com.xworkz.vaccine.dao;


import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vaccine.entity.OtpEntity;

@Repository
public class OtpDAOImpl implements OtpDAO {

	private static final Logger logger = Logger.getLogger(OtpDAOImpl.class.getName());
	public OtpDAOImpl() {
		logger.info(this.getClass().getSimpleName() + " bean created");
	}
	@Autowired
	private SessionFactory sessionFactory;
	
	
//	@Override
//	public boolean saveOtp(String otp) {
//		boolean isOTPSaved=false;
//		logger.info("DAO Entering & otp is "+otp);
//		try(Session session=sessionFactory.openSession();){
//			logger.info("session is created");
//			Transaction transaction = session.beginTransaction();
//			OtpEntity otpEntity = new OtpEntity(otp);
//			logger.info("otp is storing "+otpEntity);
//			session.save(otpEntity);
//			transaction.commit();
//			logger.info("OTP is Stored in db successfully");
//			isOTPSaved=true;
//		}
//		return isOTPSaved;
//	}

	@Override
	public boolean saveOtp(OtpEntity otpEntity) {
		logger.info(otpEntity);
		boolean isOTPSaved = false;
		logger.info("DAO Entering & otp is "+otpEntity.getOtp());
		try (Session session = sessionFactory.openSession();) {
			logger.info("session is created");
			Transaction transaction = session.beginTransaction();
			logger.info("otp is storing.. " + otpEntity);
			session.save(otpEntity);
			transaction.commit();
			logger.info("OTP is Stored in db successfully");
			isOTPSaved = true;
		}
		return isOTPSaved;
	}

	@Override
	public OtpEntity verifYOTP(String userOTP) {
		logger.info("DAO Entering");
		OtpEntity OtpEntity=null;
		//boolean isDataVerify = false;
		try (Session session = sessionFactory.openSession();) {
			logger.info("session created");
			Query query = session.getNamedQuery("OtpEntity.Verify"); 
			query.setParameter("otpValue", userOTP);
			OtpEntity =(OtpEntity) query.uniqueResult();
			logger.info(OtpEntity);
		}
		catch (Exception e) {
			logger.error("OtpEntity is null");
			logger.error(e.getStackTrace());
		}
		return OtpEntity;
	}
}
