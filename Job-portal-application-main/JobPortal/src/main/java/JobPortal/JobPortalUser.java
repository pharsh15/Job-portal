package JobPortal;

import JobPortal.Data;

public abstract class JobPortalUser {

	private String i;
	private Data D;
	
	public JobPortalUser(String i, Data D) 
	{
		this.i=i;
		this.D=D;
	}

	public Data getD() {
		return D;
	}

	public void setD(Data D) {
		this.D = D;
	}
	
	public abstract void welcome();
	


}
