package JobPortal;

import java.util.ArrayList;

public interface Data {
	
	void addNewJobs(String title,String status);
	ArrayList<Object[]> received_application();
	ArrayList<String> job_application(String st);
	ArrayList<String> search_jobs(String status);
	void apply_jobs(String job,String i,String st);
	ArrayList<String>get_candidates(String title);
	ArrayList<Integer> get_id(String candidat);
	void update_selection(int new_id, String new_status);
	void update_rejection(String rejected_status, String title);
	void update_new(int new_id1);
	
	

}
