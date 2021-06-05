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

import HRMSProject.hrms.business.abstracts.JobSeekerSchoolService;
import HRMSProject.hrms.entities.concretes.JobSeekerSchool;

@RestController
@RequestMapping("/api/jobseekerschool")
public class JobSeekerSchoolsController {
	
	private JobSeekerSchoolService jobSeekerSchoolService;

	@Autowired
	public JobSeekerSchoolsController(JobSeekerSchoolService jobSeekerSchoolService) {
		super();
		this.jobSeekerSchoolService = jobSeekerSchoolService;
	}
	
	@Transactional
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(jobSeekerSchoolService.getAll());
	}
	
	@Transactional
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getById(@PathVariable int id){
		return ResponseEntity.ok(jobSeekerSchoolService.getById(id));
	}
	
	@Transactional
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody JobSeekerSchool jobSeekerSchool){
		return ResponseEntity.ok(jobSeekerSchoolService.add(jobSeekerSchool));
	}
	
	@Transactional
	@PostMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		return ResponseEntity.ok(jobSeekerSchoolService.delete(id));
	}
	
	@Transactional
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody JobSeekerSchool jobSeekerSchool){
		return ResponseEntity.ok(jobSeekerSchoolService.update(jobSeekerSchool));
	}
}
