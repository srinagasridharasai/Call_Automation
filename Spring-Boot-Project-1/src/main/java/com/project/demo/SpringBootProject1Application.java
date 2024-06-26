package com.project.demo;

import java.net.URI;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.CallCreator;
import com.twilio.type.PhoneNumber;

@SpringBootApplication
public class SpringBootProject1Application implements ApplicationRunner{
	
	private final static String ACCOUNT_SID = "Account id";
	private final static String AUTH_ID = "auth id";
	private final static String FROM_NUMBER = "from";
	private final static String TO_NUMBER = "to";
	
	static {
		Twilio.init(ACCOUNT_SID, AUTH_ID);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProject1Application.class, args);
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// URI uri = getClass().getResource("/Text.xml").toURI();
		//String ngrokUrl = 
		Call call = Call.creator(new PhoneNumber(TO_NUMBER), new PhoneNumber(FROM_NUMBER) , new URI("server")).create();
		System.out.println("Call initiated: "+call.getSid());
	}

}
