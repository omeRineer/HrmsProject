package HRMSProject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMSProject.hrms.business.abstracts.SchoolService;
import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.hrms.core.utilities.results.SuccessResult;
import HRMSProject.hrms.dataAccess.abstracts.SchoolDao;
import HRMSProject.hrms.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService {

	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	
	@Override
	public DataResult<List<School>> getAll() {
		
		return new SuccessDataResult<List<School>>(schoolDao.findAll());
	}
	
	@Override
	public DataResult<School> getById(int id) {

		return new SuccessDataResult<School>(schoolDao.findById(id).get());
	}

	@Override
	public Result add(School school) {
		schoolDao.save(school);
		return new SuccessResult();
	}

	@Override
	public Result delete(int schoolId) {
		schoolDao.deleteById(schoolId);
		return new SuccessResult();
	}

	@Override
	public Result update(School school) {
		schoolDao.save(school);
		return new SuccessResult();
	}

}
