package HRMSProject.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HRMSProject.hrms.business.abstracts.JobPostingService;
import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.ErrorResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.hrms.core.utilities.results.SuccessResult;
import HRMSProject.hrms.entities.concretes.JobPosting;

@RestController
@RequestMapping("/api/jobposting")
public class JobPostingController {
	
	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosting>> getAll(){
		DataResult<List<JobPosting>> result=jobPostingService.getAll();
		return new SuccessDataResult<List<JobPosting>>(result.getData(),result.getMessage());
	}
	
	
	@GetMapping("/getbytruestatus") 
	public DataResult<List<JobPosting>> getByTrueStatus(){
		  
	    DataResult<List<JobPosting>> result=jobPostingService.getByTrueStatus(); 
	    return new SuccessDataResult<List<JobPosting>>(result.getData()); 
	}
	
	@GetMapping("/getorderbydate")
	public DataResult<List<JobPosting>> getOrderByDate(){
		
		DataResult<List<JobPosting>> result=jobPostingService.getAllByOrderAsc(); 
		return new SuccessDataResult<List<JobPosting>>(result.getData());
	}
	
	@GetMapping("/getbyemployerid") 
	public DataResult<List<JobPosting>> getByEmployer(int employerId){
		  
	    DataResult<List<JobPosting>> result=jobPostingService.getByEmployer(employerId); 
	    return new SuccessDataResult<List<JobPosting>>(result.getData()); 
	}
	 
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting) {
		Result result=jobPostingService.add(jobPosting);
		if (result.isSuccess()) {
			return new SuccessResult(result.getMessage());
		}
		return new ErrorResult("İş ilanı eklenemedi");
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody JobPosting jobPosting) {
		Result result=jobPostingService.update(jobPosting);
		if (result.isSuccess()) {
			return new SuccessResult(result.getMessage());
		}
		return new ErrorResult("İş ilanı eklenemedi");
	}
	
	@PostMapping("/jobpostingclosed")
	public Result setClosedPosting(int jobPostingId) {
		Result result=jobPostingService.setClosedPosting(jobPostingId);
		if (result.isSuccess()) {
			return new SuccessResult(result.getMessage());
		}
		return new ErrorResult(result.getMessage());
	}
	
	
}
