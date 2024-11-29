package com.ty.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dto.Person;

public class PersonDao {
	
	public Person savePerson(Person person) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	 et.begin();
	 em.persist(person);
	 et.commit();
	 return person;

}
	public Person validatePerson(String email,String password) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
	Query query	=  em.createQuery("select p from Person p where p.email=?1 And p.password=?2");
	
	query.setParameter(1, email);
	query.setParameter(2, password);
	   List<Person>  p = query.getResultList();
	   if(p.size()>0)
	   {
		  Person persons =  p.get(0);
		  return persons;
	   }
	   else{
		   return null;
	   }
	   
		
		
	}
}