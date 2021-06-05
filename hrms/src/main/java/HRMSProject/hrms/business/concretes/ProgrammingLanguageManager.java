package HRMSProject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMSProject.hrms.business.abstracts.ProgrammingLanguageService;
import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.hrms.core.utilities.results.SuccessResult;
import HRMSProject.hrms.dataAccess.abstracts.ProgrammingLanguageDao;
import HRMSProject.hrms.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	
	private ProgrammingLanguageDao programmingLanguageDao;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageDao programmingLanguageDao) {
		super();
		this.programmingLanguageDao = programmingLanguageDao;
	}

	@Override
	public DataResult<List<ProgrammingLanguage>> getAll() {
		
		return new SuccessDataResult<List<ProgrammingLanguage>>(programmingLanguageDao.findAll());
	}

	@Override
	public DataResult<ProgrammingLanguage> getById(int id) {
		
		return new SuccessDataResult<ProgrammingLanguage>(programmingLanguageDao.findById(id).get());
	}

	@Override
	public Result add(ProgrammingLanguage programmingLanguage) {
		programmingLanguageDao.save(programmingLanguage);
		return new SuccessResult();
	}

	@Override
	public Result delete(int programmingLanguageId) {
		programmingLanguageDao.deleteById(programmingLanguageId);
		return new SuccessResult();
	}

	@Override
	public Result update(ProgrammingLanguage programmingLanguage) {
		programmingLanguageDao.save(programmingLanguage);
		return new SuccessResult();
	}

}
