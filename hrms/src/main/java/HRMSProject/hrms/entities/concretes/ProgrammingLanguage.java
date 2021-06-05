package HRMSProject.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="programming_languages")
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguage {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	@Column(name="id")
	private int id;
	
	@Column(name="programming_language_name")
	private String programmingLanguageName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "programmingLanguage")
	private List<JobSeekerProgrammingLanguage> jobSeekerProgrammingLanguages;
}
