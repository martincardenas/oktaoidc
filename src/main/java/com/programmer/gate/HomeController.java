package com.programmer.gate;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {
	
	@Value("${security.oauth2.client.accessTokenUri}")
	private String tokeUri;
	
	
	@Value("${security.oauth2.client.preEstablishedRedirectUri}")
	private String redirUri;
	
	
	@Value("${security.oauth2.client.clientId}")
	private String client_id;
	
	@Value("${security.oauth2.client.clientSecret}")
	private String client_secret;
	
	
	
	
	@RequestMapping("/")
	public String login() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getPrincipal());
		return "/index";
	}
	
	@RequestMapping("/callback")
	public String callback(@RequestParam("code") String code) {
		System.out.println("redirecting to home page, code recieved: "+ code);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getDetails());
	
		System.out.println("Authorization Code------" + code);

		
		ResponseEntity<String> response = null;
		RestTemplate restTemplate = new RestTemplate();

		// According OAuth documentation we need to send the client id and secret key in the header for authentication
		String credentials = "javainuse:secret";
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		//headers.add("Authorization", "Basic " + encodedCredentials);
		
		headers.add("Content-Type", "application/x-www-form-urlencoded");

		HttpEntity<String> request = new HttpEntity<String>(headers);

		String access_token_url = tokeUri;
		
		access_token_url += "?code=" + code;
		access_token_url += "&client_id="+ client_id;
		access_token_url += "&client_secret="+ client_secret;
		
		access_token_url += "&grant_type=authorization_code";
		access_token_url += "&redirect_uri="+ redirUri; //localhost:8090/showEmployees";
		
		System.out.println("URI: " + access_token_url);

		response = restTemplate.exchange(access_token_url, HttpMethod.POST, request, String.class);

		System.out.println("Access Token Response ---------" + response.getBody());
		
		return "/home";
	}
	
	
	@RequestMapping("/logout")
	public String logoutPage () {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	    	
	    }
	    return "/index";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
	
	
	
	
	
 
}