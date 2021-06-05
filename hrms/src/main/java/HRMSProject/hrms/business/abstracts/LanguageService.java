package HRMSProject.hrms.business.abstracts;

import java.util.List;

import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.entities.concretes.Language;
public interface LanguageService {
	DataResult<List<Language>> getAll();
	DataResult<Language> getById(int id);
	Result add(Language language);
	Result delete(int languageId);
	Result update(Language language);
}
