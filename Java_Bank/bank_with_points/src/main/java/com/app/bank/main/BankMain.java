package com.app.bank.main;

import com.app.bank.exception.BusinessException;
import com.app.bank.service.LogService;
import com.app.bank.service.SystemAccess;
import com.app.bank.service.impl.SystemAccessImpl;

import org.apache.log4j.PropertyConfigurator;

public class BankMain {

	public static SystemAccess systemservice = new SystemAccessImpl();
	public static LogService logservice = new LogService();

	public static void main(String[] args) {

		PropertyConfigurator.configure(
				"C:\\Users\\MAS\\Documents\\Programming\\java\\git_uploads\\bank_with_points\\src\\main\\resources\\log4j.properties");
		try {
			systemservice.ROCBANKMAIN();
		} catch (BusinessException e) {
			logservice.WarnLogService(e.getMessage());
		}    
	}
}
