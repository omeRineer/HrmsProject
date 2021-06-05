package HRMSProject.hrms.business.abstracts;

import java.util.List;

import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeService {
	DataResult<List<CurriculumVitae>> getAll();
	DataResult<CurriculumVitae> getById(int id);
	Result add(CurriculumVitae curriculumVitae);
	Result delete(int curriculumVitaeId);
	Result update(CurriculumVitae curriculumVitae);
}
