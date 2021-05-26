package HRMSProject.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HRMSProject.hrms.business.abstracts.JobPositionService;
import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.ErrorResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.hrms.core.utilities.results.SuccessResult;
import HRMSProject.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {
	
	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	
	@Transactional
	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll(){
		
		return new SuccessDataResult<List<JobPosition>>(jobPositionService.getAll().getData());
		
	}
	
	@Transactional
	@GetMapping("/getbyid/{id}")
	public DataResult<JobPosition> getById(@PathVariable int id) {
		
		return new SuccessDataResult<JobPosition>(jobPositionService.getById(id).getData());
		
	}
	
	@Transactional
	@PostMapping("/add")
	public Result add(@RequestBody JobPosition jobPosition){
		
		Result result=jobPositionService.add(jobPosition);
		
		if (result.isSuccess()) {
			return new SuccessResult(result.getMessage());
		}
		return new ErrorResult(result.getMessage());
		
	}
	
	@Transactional
	@PostMapping("/delete/{id}")
	public Result delete(int id) {
		
		Result result=jobPositionService.delete(id);
		
		if (result.isSuccess()) {
			return new SuccessResult(result.getMessage());
		}
		return new ErrorResult(result.getMessage());
		
	}
	
	@Transactional
	@PostMapping("/update")
	public Result update(@RequestBody JobPosition jobPosition) {
		
		Result result=jobPositionService.update(jobPosition);
		
		if (result.isSuccess()) {
			return new SuccessResult(result.getMessage());
		}
		return new ErrorResult(result.getMessage());
		
	}

}
