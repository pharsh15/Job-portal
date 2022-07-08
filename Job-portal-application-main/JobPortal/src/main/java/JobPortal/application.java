package JobPortal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="application")

public class application {
	
	@Id
	@Column(name="Id")
	private int Id;
	
	
	@Column(name="job_title")
	private String job_title;
	
	
	@Column(name="username")
	private String username;
	
	
	@Column(name="status")
	private String status;


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getJob_title() {
		return job_title;
	}


	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}



	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public application(int id, String job_title,String username, String status) {
		super();
		this.Id = id;
		this.job_title = job_title;
		this.username = username;
		this.status = status;
	}
	public application() 
	{
		
	}


	
	
	
	

}
