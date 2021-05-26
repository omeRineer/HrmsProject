package HRMSProject.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import HRMSProject.hrms.business.abstracts.JobSeekerService;
import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.ErrorResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.hrms.core.utilities.results.SuccessResult;
import HRMSProject.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekerController {
	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekerController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@Transactional
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll() {

		return new SuccessDataResult<List<JobSeeker>>(jobSeekerService.getAll().getData());
		
	}
	
	@Transactional
	@GetMapping("/getbyid/{id}")
	public DataResult<JobSeeker> getById(@PathVariable int id) {
		
		return new SuccessDataResult<JobSeeker>(jobSeekerService.getById(id).getData());
		
	}
	
	@Transactional
	@PostMapping("/add")
	public Result add(@RequestBody JobSeeker jobSeeker) {
		
		Result result=jobSeekerService.add(jobSeeker);
		
		if (result.isSuccess()) {
			return new SuccessResult(result.getMessage());
		}
		return new ErrorResult(result.getMessage());
	}
	
	@Transactional
	@PostMapping("/delete")
	public Result delete(int id) {
		
		Result result=jobSeekerService.delete(id);
		
		if (result.isSuccess()) {
			return new SuccessResult(result.getMessage());
		}
		return new ErrorResult(result.getMessage());
	}
	
	@Transactional
	@PostMapping("/update")
	public Result update(@RequestBody JobSeeker jobSeeker) {
		
		Result result=jobSeekerService.update(jobSeeker);
		
		if (result.isSuccess()) {
			return new SuccessResult(result.getMessage());
		}
		return new ErrorResult(result.getMessage());
	}
}
