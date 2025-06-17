package com.example.serviceA.sample;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@GetMapping("/home")
	public ResponseEntity<?> getHomeInfo(){
		return ResponseEntity.ok("Hello from ServiceA");
	}

}
