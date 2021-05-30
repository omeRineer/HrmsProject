package HRMSProject.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HRMSProject.hrms.business.abstracts.CityService;
import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.ErrorResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.core.utilities.results.SuccessResult;
import HRMSProject.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/city")
public class CityController {
	
	private CityService cityService;
	
	@Autowired
	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<City>> getAll(){
		DataResult<List<City>> result=cityService.getAll();
		return result;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody City city) {
		Result result=cityService.add(city);
		if (result.isSuccess()) {
			return new SuccessResult(result.getMessage());
		}
		return new ErrorResult("Şehir eklenemedi");
	}
}
