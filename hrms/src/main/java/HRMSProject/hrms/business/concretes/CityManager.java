package HRMSProject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMSProject.hrms.business.abstracts.CityService;
import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.hrms.core.utilities.results.SuccessResult;
import HRMSProject.hrms.dataAccess.abstracts.CityDao;
import HRMSProject.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService {

	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(cityDao.findAll());
	}

	@Override
	public Result add(City city) {
		cityDao.save(city);
		return new SuccessResult("Şehir eklendi");
	}

	@Override
	public Result delete(int id) {
		cityDao.deleteById(id);
		return new SuccessResult("Şehir silindi");
	}

	@Override
	public Result update(City city) {
		cityDao.save(city);
		return new SuccessResult("Şehir güncellendi");
	}

}
