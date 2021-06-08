package HRMSProject.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import HRMSProject.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name="job_seekers")
@PrimaryKeyJoinColumn(name="id")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker extends User{
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="nationality_id")
	private String nationalityId;

	@Column(name="birthday_date")
	private int birthdayDate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobExperince> jobExperinces;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerLanguage> jobSeekerLanguages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerSchool> jobSeekerSchools;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerProgrammingLanguage> jobSeekerProgrammingLanguages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerSocialAccount> jobSeekerSocialAccounts;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<CurriculumVitae> curriculumVitaes;
	
	@OneToOne(mappedBy = "jobSeeker")
	@PrimaryKeyJoinColumn
	private JobSeekerImage jobSeekerImage;

}
