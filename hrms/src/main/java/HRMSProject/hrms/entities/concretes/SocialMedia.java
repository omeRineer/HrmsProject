package HRMSProject.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="social_medias")
public class SocialMedia {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="social_media_name")
	private String socialMediaName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "socialMedia")
	private List<JobSeekerSocialAccount> jobSeekerSocialAccounts;
	
}
