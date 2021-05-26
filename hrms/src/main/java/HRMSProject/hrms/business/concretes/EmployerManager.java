package HRMSProject.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import HRMSProject.hrms.business.abstracts.EmployerService;
import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.hrms.core.utilities.results.SuccessResult;
import HRMSProject.hrms.dataAccess.abstracts.EmployerDao;
import HRMSProject.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(employerDao.findAll());
	}

	@Override
	public DataResult<Employer> getById(int id) {
		
		return new SuccessDataResult<Employer>(employerDao.findById(id).get());
	}

	@Override
	public Result add(Employer employer) {
		employerDao.save(employer);
		return new SuccessResult("İş veren eklendi");
	}

	@Override
	public Result delete(int id) {
		employerDao.deleteById(id);
		return new SuccessResult("İş veren silindi");
	}

	@Override
	public Result update(Employer employer) {
		employerDao.save(employer);
		return new SuccessResult("İş veren güncellendi");
	}

}
