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

import HRMSProject.hrms.business.abstracts.JobSeekerProgrammingLanguageService;
import HRMSProject.hrms.entities.concretes.JobSeekerProgrammingLanguage;

@RestController
@RequestMapping("/api/jobseekerprogramminglanguage")
public class JobSeekerProgrammingLanguagesController {

	private JobSeekerProgrammingLanguageService jobSeekerProgrammingLanguageService;

	@Autowired
	public JobSeekerProgrammingLanguagesController(
			JobSeekerProgrammingLanguageService jobSeekerProgrammingLanguageService) {
		super();
		this.jobSeekerProgrammingLanguageService = jobSeekerProgrammingLanguageService;
	}
	
	@Transactional
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(jobSeekerProgrammingLanguageService.getAll());
	}
	
	@Transactional
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getById(@PathVariable int id){
		return ResponseEntity.ok(jobSeekerProgrammingLanguageService.getById(id));
	}
	
	@Transactional
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody JobSeekerProgrammingLanguage jobSeekerProgrammingLanguage){
		return ResponseEntity.ok(jobSeekerProgrammingLanguageService.add(jobSeekerProgrammingLanguage));
	}
	
	@Transactional
	@PostMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		return ResponseEntity.ok(jobSeekerProgrammingLanguageService.delete(id));
	}
	
	@Transactional
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody JobSeekerProgrammingLanguage jobSeekerProgrammingLanguage){
		return ResponseEntity.ok(jobSeekerProgrammingLanguageService.update(jobSeekerProgrammingLanguage));
	}
	
}
