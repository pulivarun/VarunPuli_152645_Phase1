package com.cg.WalletApplication.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.WalletApplication.Exception.BankException;
import com.cg.WalletApplication.Exception.IBankException;
import com.cg.WalletApplication.bean.Customer;
import com.cg.WalletApplication.dao.IWalletDao;
import com.cg.WalletApplication.dao.WalletDaoImpl;

public class WalletServiceImpl implements IWalletService {
	static IWalletDao iWalletDao = new WalletDaoImpl();
	public static TreeMap<String, Customer> customerDetails = null;
	static {
		customerDetails = iWalletDao.getDetails();

	}

	public void checkName(String name) throws BankException {
		Pattern pattern = Pattern.compile("[a-zA-Z]{1,}");
		Matcher matcher = pattern.matcher(name);
		if (!(matcher.matches())) {
			throw new BankException(IBankException.nameException);
		}
	}

	public void checkMobileNumber(String mobileNumber) throws BankException {

		Pattern pattern = Pattern.compile("[7-9]{1}[0-9]{9}");
		Matcher matcher = pattern.matcher(mobileNumber);
		if (!(matcher.matches())) {
			throw new BankException(IBankException.mobileNumberException);
		}
	}

	public void checkPassword(String password) throws BankException {
		Pattern pattern = Pattern.compile(".*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*" + "");
		Matcher matcher = pattern.matcher(password);
		if (!(matcher.matches())) {
			throw new BankException(IBankException.passwordException);
		}

	}

	public void checkEmail(String emailId) throws BankException {
		Pattern pattern = Pattern.compile("[a-z]{1}[a-z0-9._]{1,}@[a-zA-Z0-9]{1,}.com");
		Matcher matcher = pattern.matcher(emailId);
		if (!(matcher.matches())) {
			throw new BankException(IBankException.emailIdException);
		}

	}

	public String addCustomer(Customer customer) throws BankException {
		String result = null;
	
     return result;
	}

	public Customer showBalance(String mobileNum, String password) throws BankException {
		Customer result = null;

	
		
		return result;
	}

	public Customer check(String mobileNum, String password) throws BankException {
		Customer result = null;
	
		return result;
	}

	public void deposit(Customer customer, BigDecimal amount) {

		customer.getWallet().setBalance(customer.getWallet().getBalance().add(amount));
		customer.getTransactions().put(LocalDateTime.now(), "Credited " + amount);

	}

	public boolean withDraw(Customer customer, BigDecimal amount) throws BankException {
		boolean result = false;
		
			
		return result;
	}

	public boolean isFound(String receiverMobile) throws BankException {
		boolean result = false;
		
		return result;
	}

	public boolean transfer(String senderMobile, String receiverMobile, BigDecimal amount) throws  BankException, InterruptedException {
		boolean result = false;
		
		return result;
	}
	public boolean checkEnteredAmount(BigDecimal amount) throws BankException {
		boolean result = false;
		Pattern pattern = Pattern.compile("[0-9]+[.]{0,1}[0-9]+");
		Matcher matcher = pattern.matcher(amount.toString());
		if(matcher.matches())
			result = true;
		else
			throw new BankException(IBankException.invalidAmount);
		return result;
	}
}
