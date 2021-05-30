package HRMSProject.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HRMSProject.hrms.business.abstracts.AuthService;
import HRMSProject.hrms.core.utilities.results.ErrorResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.core.utilities.results.SuccessResult;
import HRMSProject.hrms.entities.concretes.Employer;
import HRMSProject.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@Transactional
	@PostMapping("/registerforjobseeker")
	public Result registerForJobSeeker(@RequestBody JobSeeker jobSeeker) {
		
		Result result=authService.registerForJobSeeker(jobSeeker);
		if (result.isSuccess()) {
			return new SuccessResult(result.getMessage());
		}
		return new ErrorResult(result.getMessage());
		
	}
	
	@Transactional
	@PostMapping("/registerforemployer")
	public Result registerForEmployer(@RequestBody Employer employer) {
		
		Result result=authService.registerForEmployer(employer);
		if (result.isSuccess()) {
			return new SuccessResult(result.getMessage());
		}
		return new ErrorResult(result.getMessage());
	}

}
