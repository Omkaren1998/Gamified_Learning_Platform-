package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.LandingPage;
import com.example.demo.Service.LandingPageService;

@RestController
@CrossOrigin(origins = "http://localhost:5174")
public class LandingPageController {

	@Autowired
	LandingPageService landingPageService;
	
	public LandingPageController(LandingPageService landingPageService) {
		this.landingPageService=landingPageService;
	}
	
//	@PreAuthorize("hasRole('USER')")
	@GetMapping("/getLandingpage/{empIdOrEmail}")
    public LandingPage getLandingPagebyempIdOrEmail(@PathVariable("empIdOrEmail") String empIdOrEmail) {
        return landingPageService.getLandingPagebyempIdOrEmail(empIdOrEmail);
    }

}
