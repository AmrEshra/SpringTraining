package com.springboot.demo.mySpringbootApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	
	@Value("${server.port}")
	private String serverPort;
	
	@Value("${info.app.version}")
	private String version;
	
	@GetMapping("/")
	public String Hello() {
		return "Hello World , server port = " + serverPort;
	}
	
	@GetMapping("/work")
	public String Work() {
		return "I'm working @ version " + version;
	}

}
