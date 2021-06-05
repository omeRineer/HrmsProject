package HRMSProject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMSProject.hrms.business.abstracts.CurriculumVitaeService;
import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.hrms.core.utilities.results.SuccessResult;
import HRMSProject.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import HRMSProject.hrms.entities.concretes.CurriculumVitae;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

	private CurriculumVitaeDao curriculumVitaeDao;
	
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		
		return new SuccessDataResult<List<CurriculumVitae>>(curriculumVitaeDao.findAll());
	}

	@Override
	public DataResult<CurriculumVitae> getById(int id) {
		
		return new SuccessDataResult<CurriculumVitae>(curriculumVitaeDao.findById(id).get());
	}

	@Override
	public Result add(CurriculumVitae curriculumVitae) {
		curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult();
	}

	@Override
	public Result delete(int curriculumVitaeId) {
		curriculumVitaeDao.deleteById(curriculumVitaeId);
		return new SuccessResult();
	}

	@Override
	public Result update(CurriculumVitae curriculumVitae) {
		curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult();
	}

}
