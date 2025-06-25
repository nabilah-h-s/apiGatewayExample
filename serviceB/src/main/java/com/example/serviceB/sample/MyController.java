package com.example.serviceB.sample;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:49030")
@RestController
public class MyController {
	
	@GetMapping("/home")
	public ResponseEntity<?> getHomeInfo(){
		return ResponseEntity.ok("Hello from ServiceB");
	}

}
