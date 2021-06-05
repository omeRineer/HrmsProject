package HRMSProject.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="job_seeker_social_accounts")
public class JobSeekerSocialAccount {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="account_url")
	private String accountUrl;
	
	@ManyToOne
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
	@ManyToOne
	@JoinColumn(name="social_account_id")
	private SocialMedia socialMedia;
	
	
}
