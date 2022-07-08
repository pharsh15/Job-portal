package JobPortal;

import java.util.ArrayList;
import java.util.Scanner;

import JobPortal.Data;



public class Hr extends JobPortalUser{
	
	
//	private Data D;
//	public void setData(Data D) 
//	{
//		this.D = D;
//	}
	private String i;
	private Data D;
	
	
	public String getI() {
		return i;
	}


	public void setI(String i) {
		this.i = i;
	}


	public Data getD() {
		return D;
	}


	public void setD(Data d) {
		D = d;
	}


	public Hr(String i, Data D) {
		super(i,D);
		this.i=i;
		this.D=D;
	}
	

	@Override
	public void welcome() {
		// TODO Auto-generated method stub
		String selection ="";
		Scanner input = new Scanner(System.in);
		
		while(!selection.equals("x"))
		{
			System.out.println();
			System.out.println("Welcome to HR JobPortal");
			System.out.println("v:post new jobs");
			System.out.println("r:To review received applications");
			System.out.println("z:To view the posted jobs and select a candidate");
			System.out.println("x: leave Jobportal");
			selection=input.nextLine();
			if(selection.equals("v"))
			{
				addNewJobs();
			}
			else if(selection.equals("r")) 
			{
				received_application();
			}
			else if(selection.equals("z"))
			{
				job_candidate();
			}
		}
		
	}
	
	public void addNewJobs()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the Job title");
		String title=input.nextLine();
		String status ="open";
		
		super.getD().addNewJobs(title, status);
		
		
	}
	
	public void received_application()
	{
		System.out.println("Following applications are received");
//		st="Received";
//		getD().ArrayList<String> received_application(String st);
		
		ArrayList<Object[]> received = getD().received_application();
		for(int i=0; i<received.size(); i++)
		{
			System.out.println(i+1 + " "+ received.get(i)[0] +" "+ received.get(i)[1] );
		}
		
		//int val = Integer.parseInt(received.get(0)[0].toString());
		
	}
	
	public void job_candidate()
	{
		String st="open";
		
		System.out.println("Following applications");
		ArrayList<String> candidate = super.getD().job_application(st);
		for(int i=0; i<candidate.size(); i++)
		{
			System.out.println(i+1 +""+ candidate.get(i));
		}
		
		Scanner input = new Scanner(System.in);
		String sel = input.nextLine();
		
		String title = candidate.get(Integer.parseInt(sel) - 1);
		
		ArrayList<String> applicants = getD().get_candidates(title);
		
		
		for(int i=0; i<applicants.size(); i++)
		{
			System.out.println( i+1 +" "+ applicants.get(i));
		}
		String option = input.nextLine();
		
		
		String candidat = applicants.get(Integer.parseInt(option) - 1);
		ArrayList<Integer>getid = super.getD().get_id(candidat);
		
		int new_id = getid.get(0);
		System.out.println(new_id);
		String new_status ="Selected";
		super.getD().update_selection(new_id,new_status);
		
		
		String rejected_status ="Rejected";
		super.getD().update_rejection(rejected_status,title);
		
		int new_id1 =1;
		
		super.getD().update_new(new_id1);
		
		
	

//		ArrayList<String>getid = super.getD().get_id(candidat,new_status);
//		
//		int new_id =(Integer.parseInt(getid));
//		
		
		return;
		
	}	
	

	

}
