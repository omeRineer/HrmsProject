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

import HRMSProject.hrms.business.abstracts.JobExperinceService;
import HRMSProject.hrms.entities.concretes.JobExperince;

@RestController
@RequestMapping("/api/jobexperince")
public class JobExperincesController {

	private JobExperinceService experinceService;

	@Autowired
	public JobExperincesController(JobExperinceService experinceService) {
		super();
		this.experinceService = experinceService;
	}
	
	@Transactional
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(experinceService.getAll());
	}
	
	@Transactional
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getById(@PathVariable int id){
		return ResponseEntity.ok(experinceService.getById(id));
	}
	
	@Transactional
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody JobExperince jobExperince){
		return ResponseEntity.ok(experinceService.add(jobExperince));
	}
	
	@Transactional
	@PostMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		return ResponseEntity.ok(experinceService.delete(id));
	}
	
	@Transactional
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody JobExperince jobExperince){
		return ResponseEntity.ok(experinceService.update(jobExperince));
	}
	
	
}
