package JobPortal;

import java.util.ArrayList;
import java.util.Scanner;

public class Applicant extends JobPortalUser {
	
	private String i;
	private Data D;
	public Applicant(String i, Data D) {
		super(i, D);
		this.i = i;
		D = D;
	}
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
	
	@Override
	public void welcome() 
	{
		String selection ="";
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("Welcome to JobPortal");
		System.out.println("v:Search new jobs");
		System.out.println("x:To exit");
		
		selection=input.nextLine();
		
		while(!selection.equals("x")) 
		{
			if(selection.equals("v")) 
			{
				String status ="open";
				super.getD().search_jobs(status);
				
				ArrayList<String> searched = super.getD().search_jobs(status);
				for(int i=0; i<searched.size(); i++)
				{
					System.out.printf("%d: %s\n", i+1, searched.get(i));
				}
				System.out.println("Select the job you want to apply");
				String sel = input.nextLine();
				String st = "Received";
				String job = searched.get(Integer.parseInt(sel) - 1);
				super.getD().apply_jobs(job,i,st);
				return;
				
			}
		}
		
	}
}
