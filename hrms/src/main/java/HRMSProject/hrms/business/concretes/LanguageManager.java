package HRMSProject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMSProject.hrms.business.abstracts.LanguageService;
import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.hrms.core.utilities.results.SuccessResult;
import HRMSProject.hrms.dataAccess.abstracts.LanguageDao;
import HRMSProject.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	
	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<List<Language>> getAll() {
		
		return new SuccessDataResult<List<Language>>(languageDao.findAll());
	}

	@Override
	public DataResult<Language> getById(int id) {
		
		return new SuccessDataResult<Language>(languageDao.findById(id).get());
	}

	@Override
	public Result add(Language language) {
		languageDao.save(language);
		return new SuccessResult();
	}

	@Override
	public Result delete(int languageId) {
		languageDao.deleteById(languageId);
		return new SuccessResult();
	}

	@Override
	public Result update(Language language) {
		languageDao.save(language);
		return new SuccessResult();
	}
}
