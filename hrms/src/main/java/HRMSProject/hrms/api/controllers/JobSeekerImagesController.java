package HRMSProject.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import HRMSProject.hrms.business.abstracts.JobSeekerImageService;
import HRMSProject.hrms.entities.concretes.JobSeekerImage;

@RestController
@RequestMapping("/api/jobseekerimage")
public class JobSeekerImagesController {
	
	private JobSeekerImageService jobSeekerImageService;
	
	@Autowired
	public JobSeekerImagesController(JobSeekerImageService jobSeekerImageService) {
		super();
		this.jobSeekerImageService = jobSeekerImageService;
	}
	
	@Transactional
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(jobSeekerImageService.getAll());
	}
	
	@Transactional
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getById(@PathVariable int id){
		return ResponseEntity.ok(jobSeekerImageService.getById(id));
	}
	
	@Transactional
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestParam(value = "file") MultipartFile file,@RequestParam(value = "id") int id){
		return ResponseEntity.ok(jobSeekerImageService.add(file,id));
	}
	
	@Transactional
	@PostMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		return ResponseEntity.ok(jobSeekerImageService.delete(id));
	}
	
	@Transactional
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody JobSeekerImage jobSeekerImage){
		return ResponseEntity.ok(jobSeekerImageService.update(jobSeekerImage));
	}
}
