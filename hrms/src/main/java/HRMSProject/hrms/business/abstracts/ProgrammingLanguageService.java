package HRMSProject.hrms.business.abstracts;

import java.util.List;

import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	DataResult<List<ProgrammingLanguage>> getAll();
	DataResult<ProgrammingLanguage> getById(int id);
	Result add(ProgrammingLanguage programmingLanguage);
	Result delete(int programmingLanguageId);
	Result update(ProgrammingLanguage programmingLanguage);
}
