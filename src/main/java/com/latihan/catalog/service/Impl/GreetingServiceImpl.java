package com.latihan.catalog.service.Impl;

import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.latihan.catalog.config.ApplicationProperties;
import com.latihan.catalog.config.CloudProperties;
import com.latihan.catalog.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService{
	
	Logger log = LoggerFactory.getLogger(GreetingServiceImpl.class);
	
	private ApplicationProperties appProperties;
	
	private CloudProperties cloudProperties;
	

	public GreetingServiceImpl(ApplicationProperties appProperties, CloudProperties cloudProperties) {
		super();
		this.appProperties = appProperties;
		this.cloudProperties = cloudProperties;
	}

	@Override
	public String sayGreeting() {
		log.trace("this is log TRACE");
		log.debug("this is log DEBUG");
		log.info("this is log INFO");
		log.warn("this is log WARN");
		log.error("this is log ERROR");
		System.out.println(cloudProperties.getApiKey());
		TimeZone timezone = TimeZone.getTimeZone(appProperties.getTimezone());
		return appProperties.getWelcomeText()+", our timezone :"+timezone.getDisplayName()+
				", our currency properties:"+appProperties.getCurrency();
		
	}

	@Override
	public String sayProd() {
		System.out.println(cloudProperties.getApiKey());
		TimeZone timezone = TimeZone.getTimeZone(appProperties.getTimezone());
		return appProperties.getTestProduction()+", our timezone :"+timezone.getDisplayName()+
				", our currency properties:"+appProperties.getCurrency();
	}
	

}
