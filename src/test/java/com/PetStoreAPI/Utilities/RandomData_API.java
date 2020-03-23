package com.PetStoreAPI.Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomData_API {

	public static String username() {
		String generatedusername = RandomStringUtils.randomNumeric(2);
		return ("sahilgirdhar"+generatedusername);
	}
	
	public static String firstname() {
		String generatedfirstname = RandomStringUtils.randomNumeric(2);
		return("sahil"+generatedfirstname);
	}
	
	public static String lastname() {
		String generatedlastname = RandomStringUtils.randomNumeric(2);
		return("girdhar"+generatedlastname);
	}
	
	public static String email() {
		String generatedemail = RandomStringUtils.randomNumeric(2);
		return("girdhar.sahil"+generatedemail+"@gmail.com");
	}
	
	public static String password() {
		String generatedpassword = RandomStringUtils.randomNumeric(2);
		return("Welcome"+generatedpassword);
	}
	
	public static String phone() {
		String generatedphone = RandomStringUtils.randomNumeric(10);
		return(generatedphone);
	}
	
}
