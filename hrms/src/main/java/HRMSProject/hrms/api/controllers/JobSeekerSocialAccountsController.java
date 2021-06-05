package HRMSProject.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HRMSProject.hrms.business.abstracts.JobSeekerSocialAccountService;
import HRMSProject.hrms.entities.concretes.JobSeekerSocialAccount;

@RestController
@RequestMapping("/api/jobseekersocialaccount")
public class JobSeekerSocialAccountsController {

	private JobSeekerSocialAccountService jobSeekerSocialAccountService;

	@Autowired
	public JobSeekerSocialAccountsController(JobSeekerSocialAccountService jobSeekerSocialAccountService) {
		super();
		this.jobSeekerSocialAccountService = jobSeekerSocialAccountService;
	}
	
	@Transactional
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(jobSeekerSocialAccountService.getAll());
	}
	
	@Transactional
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getById(@PathVariable int id){
		return ResponseEntity.ok(jobSeekerSocialAccountService.getById(id));
	}
	
	@Transactional
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody JobSeekerSocialAccount jobSeekerSocialAccount){
		return ResponseEntity.ok(jobSeekerSocialAccountService.add(jobSeekerSocialAccount));
	}
	
	@Transactional
	@PostMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		return ResponseEntity.ok(jobSeekerSocialAccountService.delete(id));
	}
	
	@Transactional
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody JobSeekerSocialAccount jobSeekerSocialAccount){
		return ResponseEntity.ok(jobSeekerSocialAccountService.update(jobSeekerSocialAccount));
	}
}
