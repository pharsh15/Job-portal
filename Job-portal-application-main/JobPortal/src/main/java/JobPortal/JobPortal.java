package JobPortal;

import java.util.Scanner;

import JobPortal.Data;
import JobPortal.Hibernate;
import JobPortal.Hr;

 
public class JobPortal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		String selection = "";
		Data D = new Hibernate();
		
		while(!selection.equals("x"))  //while not x, keep displaying the menu
		{
			//display the menu
			System.out.println();
            System.out.println("Please make your selection");
            System.out.println("L: login");
            System.out.println("X: Leave");
            System.out.println();
            
           //get the selection from the user
            //In this program, please use nextLine() for getting all input. 
			selection = input.nextLine();
			System.out.println();
			
			if(selection.equals("L"))
			{
				System.out.println("Please enter your id: ");
				String id = input.nextLine();
				
				if(id.equals("hr"))
				{
					//this is a hr login, continue with your source code for hr operations, no password needed
					//you may create a hr object to continue
					Hr h = new Hr(id,D);
					h.welcome();
					 
					
				}
				else
				{
					//this is a user login, continue with your source code for applicant operations, no password needed
					//you may create an applicant object to continue
					 Applicant a = new Applicant(id,D);
					 a.welcome();
				}
			}
		}
			 
	}

	

}
