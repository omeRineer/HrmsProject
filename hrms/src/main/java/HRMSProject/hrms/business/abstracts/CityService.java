package HRMSProject.hrms.business.abstracts;

import java.util.List;

import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.entities.concretes.City;

public interface CityService {
	DataResult<List<City>> getAll();
	Result add(City city);
	Result delete(int id);
	Result update(City city);
}
