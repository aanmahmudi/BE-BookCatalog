package com.latihan.catalog.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
public class ApplicationProperties {
	
	private String welcomeText;
	
	private String timezone;
	
	private String currency;
	
	private String testProduction;
	
	public String getWelcomeText() {
		return welcomeText;
	}

	public void setWelcomeText(String welcomeText) {
		this.welcomeText = welcomeText;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String getTestProduction() {
		return testProduction;
	}

	public void setTestProduction(String testProduction) {
		this.testProduction = testProduction;
	}


}
