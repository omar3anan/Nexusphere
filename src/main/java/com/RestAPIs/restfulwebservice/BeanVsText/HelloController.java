package com.RestAPIs.restfulwebservice.BeanVsText;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	private MessageSource messageSource; //message source is used for internationalization
	public HelloController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	@GetMapping(path="/hello-text")
	public String helloText() { 
		return "Hello as Normal Text";
		
	}
	@GetMapping(path="/hello-bean/{namex}")
	public HelloJsonBean helloBean(@PathVariable String namex) {
		return new HelloJsonBean(String.format( "hello as JSON, %s", namex));
		
	} 
	@GetMapping(path="/hello-world-Internationalized")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale()); 
		//return "Good Morning";
		
	}
	

}
