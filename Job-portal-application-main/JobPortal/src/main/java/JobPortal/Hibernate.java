package JobPortal;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import JobPortal.Data;

public class Hibernate implements Data{
	protected SessionFactory sessionfactory;
	
	public void setup()
	{
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); 
		
		try
		{
			sessionfactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	
	public void exit()
	{
		 sessionfactory.close();
	}
	
	public  void addNewJobs(String title, String status) {
		// TODO Auto-generated method stub
		setup();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		job j = new job(title,status);
		session.save(j);
		session.getTransaction().commit();
		
	
	}
	
	public ArrayList<Object[]> received_application() 
	{
		setup();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		String st ="Received";
		String hql="Select a.job_title, a.username from application a where a.status = :status";
		Query query = session.createQuery(hql);
		query.setParameter("status", st);
		ArrayList<Object[]> application = (ArrayList<Object[]>)query.getResultList();
		session.getTransaction().commit();
		session.close();
		exit();
		return application;
		
	}
	
	public ArrayList<String> job_application(String st)
	{
		setup();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		String hql="Select j.job_title from job j where j.status = :status";
		Query query = session.createQuery(hql);
		query.setParameter("status", st);
		ArrayList<String> jobapplication = (ArrayList<String>)query.list();
		session.getTransaction().commit();
		session.close();
		exit();
		return jobapplication;
	}

	public ArrayList<String> search_jobs(String status)
	{
		setup();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		String hql="Select j.job_title from job j where j.status = :status";
		Query query = session.createQuery(hql);
		query.setParameter("status", status);
		ArrayList<String> jobs = (ArrayList<String>)query.list();
		session.getTransaction().commit();
		session.close();
		exit();
		return jobs;
		
		
		
	}

	public void apply_jobs(String job, String i, String st) {
		
		// TODO Auto-generated method stub
		setup();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		application a = new application(0,job,i,st);
		session.save(a);
		session.getTransaction().commit();
		session.close();
		exit();
		
		
	}
	public ArrayList<String> get_candidates(String title) 
	{
		setup();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		String hql="Select a.username from application a where a.job_title = :title and a.status='Received'";
		Query query = session.createQuery(hql);
		query.setParameter("title", title);
		
		ArrayList<String> candidates = (ArrayList<String>)query.list();
		session.getTransaction().commit();
		session.close();
		exit();
		return candidates;
	}
	public ArrayList<Integer> get_id(String candidat) 
	{
		setup();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		
		String hql="Select a.id from application a where a.username = :username";
		Query query = session.createQuery(hql);
		query.setParameter("username", candidat);
		ArrayList<Integer> getid = (ArrayList<Integer>)query.getResultList();
		
		
//		application a =session.load(application.class,g); 
//		a.setStatus(new_status);
//		session.update(a);
				
		session.getTransaction().commit();
		session.close();
		exit();
		
		return getid;		
		
	}
	
	public void update_selection(int new_id,String new_status) 
	{
		setup();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		
//		application a =session.load(application.class,new_id); 
//		a.setStatus(new_status);
//		session.update(a);
		String hql="UPDATE application set status=:status where id =:id";
		Query query = session.createQuery(hql);
		query.setParameter("status", new_status);
		query.setParameter("id", new_id);
		query.executeUpdate();
		
		session.getTransaction().commit();
		session.close();
		exit();
		
		
		
	}
	
	public void update_rejection(String rejected_status,String title) 
	{
		setup();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		
		String hql="UPDATE application set status=:status where job_title =:job_title and status ='Received'";
		Query query = session.createQuery(hql);
		query.setParameter("status", rejected_status);
		query.setParameter("job_title", title);
		query.executeUpdate();
		
		session.getTransaction().commit();
		session.close();
		exit();
		
		
		
	}
	
	public void update_new(int new_id1) 
	{
		setup();
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		
		application a = session.get(application.class,new_id1);
		a.setStatus("Selected");
		session.update(a);
		
		session.getTransaction().commit();
		session.close();
		exit();
		
		}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
	
