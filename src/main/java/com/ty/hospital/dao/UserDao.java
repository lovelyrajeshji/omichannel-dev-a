package com.ty.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dto.User;

public class UserDao {
	
	public User saveUser(User user)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		et.begin();
		em.persist(user);
		et.commit();
		return user;
	}
	public User getUserById(int id)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		
		 User u = em.find(User.class, id);
		 return u;
	}
	public List<User> getAllUser()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
	     
		Query query = em.createQuery("select u from User u");
		           
		 List<User>  user = query.getResultList();
		 return user;
    }
	public boolean deleteUser(int id)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		 User u = em.find(User.class, id);
		 if(u!=null)
		 {
			 et.begin();
			 em.remove(u);
			 et.commit();
			 return true;
		 }
		 else {
			 return false;
		 }
		 
	}
	public User updateUser(User user)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(user);
		et.commit();
		return user;
	}
	public User userValidate(String email,String password) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Query query = em.createNamedQuery("select * from User u where u.email=?1,u.password=?2");
		      query.setParameter(1, email);
		      query.setParameter(2, password);
		 List<User> u = query.getResultList();
		 if(u.size()>0)
		 {
			 User u1 = u.get(0);
			 return u1;
		 }
		 else {
			 return null;
		 }
	}
}
